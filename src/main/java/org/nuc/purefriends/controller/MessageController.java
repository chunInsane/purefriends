package org.nuc.purefriends.controller;

import org.apache.commons.lang3.StringUtils;
import org.nuc.purefriends.exception.UserException;
import org.nuc.purefriends.model.Message;
import org.nuc.purefriends.model.User;
import org.nuc.purefriends.service.IMessageService;
import org.nuc.purefriends.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zhangliang on 15/11/14.
 */
@Controller
@RequestMapping( value="/msg")
public class MessageController {

    @Autowired
    private IMessageService messageService;

    @Autowired
    private IUserService userService;

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public IUserService getUserService() {

        return userService;
    }

    public void setMessageService(IMessageService messageService) {
        this.messageService = messageService;
    }

    public IMessageService getMessageService() {

        return messageService;
    }

    /**
     * set message status readed
     * @param msgId
     * @return
     */
    @RequestMapping( value = "/changeMsgStatus/{msgId}")
    public @ResponseBody String changeMsgStatus(@PathVariable Long msgId) {
        messageService.changeMsgStatus( msgId);
        return "";
    }

    @RequestMapping( value = "/unread/{userId}")
    public String unreadMsg(@PathVariable Long userId, Model model) {
        List<Message> messages = messageService.getAllUnReadMsg( userId);
        model.addAttribute("messages", messages);
        return "msg/unread";
    }

    @RequestMapping( value = "/readed/{userId}")
    public String readedMsg(@PathVariable Long userId, Model model) {
        List<Message> messages = messageService.getAllReadedMsg(userId);
        model.addAttribute( "messages", messages);
        return "msg/readed";
    }

    @RequestMapping( value = "/sended/{userId}")
    public String sended(@PathVariable Long userId, Model model) {
        List<Message> messages = messageService.getAllSendMsg(userId);
        model.addAttribute( "messages", messages);
        return "msg/sended";
    }

    @RequestMapping( value = "/sendMsg/{fromId}/{toId}")
    public String sendMsg(@PathVariable Long fromId, @PathVariable Long toId, Model model) {
        User toUser = null;
        if (toId != null && toId > 0)
            toUser = userService.loadByUserId( toId);
        model.addAttribute( "toUser", toUser);
        return "msg/sendMsg";
    }

    @RequestMapping( value = "/toSendMsg/{userId}")
    public String toSendMsg(@PathVariable Long userId, HttpServletRequest request, Model model) {
        String email = request.getParameter("email");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        if (userId == null || userId < 1 || StringUtils.isBlank(email))
            throw new UserException("Arguments is illegal!");
        User toUser = userService.loadUserByEmail(email);
        if (toUser == null)
            throw new UserException("this user isn't exist!");
        User fromUser = userService.loadByUserId( userId);
        Message message = new Message();
        message.setContent( content);
        message.setFromUserId( fromUser.getId());
        message.setFromUserName( fromUser.getNickname());
        message.setToUserId( toUser.getId());
        message.setToUserName( toUser.getNickname());
        message.setTitle( title);
        messageService.addMsg( message);
        model.addAttribute( "tip", "消息已经成功发送!");
        return "user/tip";
    }
}
