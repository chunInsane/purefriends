package org.nuc.purefriends.controller;

import org.apache.commons.lang3.StringUtils;
import org.nuc.purefriends.exception.UserException;
import org.nuc.purefriends.model.*;
import org.nuc.purefriends.service.*;
import org.nuc.purefriends.util.MailUtil;
import org.nuc.purefriends.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangliang on 15/11/12.
 */

@Controller
@RequestMapping( value="/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ITempUserService tempUserService;

    @Autowired
    private IMessageService messageService;

    @Autowired
    private IFriendService friendService;

    @Autowired
    private INotificationService notificationService;

    @RequestMapping( value="/login", method = RequestMethod.GET)
    public String login() {
        return "user/login";
    }

    @RequestMapping( value = "/toLogin", method = RequestMethod.POST)
    public String login(String email, String password, HttpSession session) {
        if (StringUtils.isBlank(email) || StringUtils.isBlank(password))
            throw new UserException("email and password can't be null!");
        User tu = userService.login(email, password);
        if (tu == null)
            throw new UserException("email or password is mistake!");
        session.setAttribute("loginUser", tu);
        return "redirect:/user/home/" + tu.getId();
    }

    @RequestMapping( value = "/toRegister", method = RequestMethod.POST)
    public String toRegister(String email, String password, Model model) {
        if (StringUtils.isBlank( email) || StringUtils.isBlank( password))
            throw new UserException("email or password can't be null!");

        User tu = userService.loadUserByEmail(email);
        if (tu != null) {
            model.addAttribute("tip", email + ",该邮箱已经注册使用过了!");
            return "user/tip";
        }
        //create temp user entity
        TempUser tempUser = new TempUser();
        tempUser.setEmail(email);
        tempUser.setPassword(password);
        tempUser.setKey(StringUtil.generateKey(30));
        tempUser.setCreateTime(new Timestamp(System.currentTimeMillis()));

        tempUserService.deleteTempUserByEmail(email);
        tempUserService.addTempUser(tempUser);

        //send active email
        sendActiveMail(tempUser);
        model.addAttribute("tip", "请注意查收邮箱的激活邮件!");
        return "user/tip";
    }

    private void sendActiveMail(TempUser tempUser) {
        MailObject object = new MailObject();
        object.setHostname("smtp.163.com");
        MailObject.MailAuthentication authentication = new MailObject.MailAuthentication();
        authentication.setUsername("feelwelltop@163.com");
        authentication.setPassword("vcnoasotxcvqbpww");
        object.setMailAuthentication(authentication);
        object.setCcAddresses("842469848@qq.com");
        String activeUrl = "http://localhost:8888/user/activeUser?tid=" + tempUser.getId() + "&key=" + tempUser.getKey();
        object.setSubject("PureFriends账户激活");
        object.setToAddresses(tempUser.getEmail());
        object.setBody("请将 " + activeUrl + " 激活链接复制到浏览器中,激活PureFriends账户");
        MailUtil.mailTo(object);
    }

    /**
     * active account
     * @return
     */
    @RequestMapping( value = "/activeUser")
    public String activeUser(String tid, String key, Model model) {
        if (StringUtils.isBlank(tid) || StringUtils.isBlank(key))
            throw new UserException("tid or password can't be null!");

        Long tempUserId = Long.parseLong(tid.trim());
        TempUser tempUser = tempUserService.loadTempUserById( tempUserId);
        if (tempUser == null) {
            model.addAttribute( "tip", "账户激活出现错误!");
        } else {
            if (tempUser.getKey() == null || !tempUser.getKey().equals(key)) {
                model.addAttribute("tip", "sorry, 该链接为无效链接!");
            } else {
                tempUserService.deleteTempUserByEmail(tempUser.getEmail());
                Timestamp now = new Timestamp(System.currentTimeMillis());
                long timeDiff = now.getTime() - tempUser.getCreateTime().getTime();
                if (timeDiff > TimeUnit.HOURS.toMillis(6L)) {
                    model.addAttribute("tip", "激活链接已失效，请尝试重新注册!");
                } else {
                    User newUser = new User();
                    String[] strs = tempUser.getEmail().split("@");
                    newUser.setEmail(tempUser.getEmail());
                    newUser.setPassword(tempUser.getPassword());
                    newUser.setNickname("用户" + strs[0]);
                    userService.addUser(newUser);
                    model.addAttribute("tip", tempUser.getEmail() + ",用户注册成功!");
                }
            }
        }
        return "user/tip";
    }

    @RequestMapping( value = "/home/{userId}")
    public String home(@PathVariable Long userId, Model model) {
        Long unreadMsgCount = messageService.getUnReadMsgCount(userId);
        Long unreadNotificationCount = notificationService.getUnReadNotificationCount( userId);
        List<User> friends = userService.getAllFriends(userId);
        model.addAttribute( "unreadMsgCount", unreadMsgCount);
        model.addAttribute( "unreadNotificationCount", unreadNotificationCount);
        model.addAttribute( "friends", friends);
        return "user/home";
    }

    @RequestMapping( value = "/showInfo/{userId}")
    public String showInfo(@PathVariable Long userId, Model model) {
        Long friendCount = userService.getFriendsCount(userId);
        model.addAttribute( "friendCount", friendCount);
        return "user/showInfo";
    }

    @RequestMapping( value = "/updateInfo/{userId}", method = RequestMethod.GET)
    public String updateInfo(@PathVariable Long userId, Model model) {
        model.addAttribute("user", userService.loadByUserId(userId));
        return "user/updateInfo";
    }

    @RequestMapping( value = "/toUpdateInfo/{userId}", method = RequestMethod.POST)
    public String toUpdateInfo(@PathVariable Long userId, User user, HttpSession session) {
        userService.updateUser( user);
        User newUser = userService.loadByUserId( userId);
        //flush session loginUser value
        session.setAttribute("loginUser", newUser);
        return "redirect:/user/showInfo/" + userId;
    }

    @RequestMapping( value = "/searchUser")
    public String searchUser(HttpServletRequest request, Model model) {
        String keyword = request.getParameter( "keyword");
        List<User> result = null;
        if (StringUtils.isBlank(keyword))
            result = new ArrayList<>();
        else {
            result = userService.getByKeyword( keyword);
        }
        model.addAttribute("resultUsers", result);
        return "user/searchUser";
    }

    @RequestMapping( value = "/showOtherInfo/{userId}")
    public String showOtherInfo(@PathVariable Long userId, Model model) {
        User user = userService.loadByUserId(userId);
        model.addAttribute( "user", user);
        return "user/showOtherInfo";
    }

    @RequestMapping( value = "/deleteFriend/{fromId}/{toId}")
    public String deleteFriend(@PathVariable Long fromId, @PathVariable Long toId, Model model) {
        if ( fromId == null || fromId < 1 || toId == null || toId < 1)
            throw new UserException( "the argument is illegal!");
        friendService.deleteFriend( fromId, toId);
        friendService.deleteFriend( toId, fromId);
        model.addAttribute( "tip", "删除好友成功!");
        return "user/tip";
    }

    @RequestMapping( value="/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/user/login";
    }

}
