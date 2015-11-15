package org.nuc.purefriends.controller;

import org.nuc.purefriends.exception.UserException;
import org.nuc.purefriends.model.Friend;
import org.nuc.purefriends.model.Notification;
import org.nuc.purefriends.model.User;
import org.nuc.purefriends.service.IFriendService;
import org.nuc.purefriends.service.INotificationService;
import org.nuc.purefriends.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhangliang on 15/11/14.
 */
@Controller
@RequestMapping( value = "/notification")
public class NotificationController {

    private IFriendService friendService;

    private IUserService userService;

    private INotificationService notificationService;

    @Autowired
    public void setFriendService(IFriendService friendService) {
        this.friendService = friendService;
    }

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setNotificationService(INotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public IFriendService getFriendService() {

        return friendService;
    }

    public IUserService getUserService() {
        return userService;
    }

    public INotificationService getNotificationService() {
        return notificationService;
    }

    @RequestMapping( value = "/requestFriend/{fromId}/{toId}")
    public String requestFriend(@PathVariable Long fromId, @PathVariable Long toId, Model model) {
        if ( fromId == null || fromId < 1 || toId == null || toId < 1)
            throw new UserException("the argument is illegal!");
        Friend friend = friendService.loadFriend(fromId, toId);
        if (friend != null) {
            model.addAttribute( "tip", "该用户已是您的好友，请求添加不成功!");
        } else {
            Notification requestNotification = new Notification();
            User fromUser = userService.loadByUserId( fromId);
            User toUser = userService.loadByUserId( toId);
            requestNotification.generateAddRequestNotification(fromUser, toUser);
            notificationService.addNotification(requestNotification);
            model.addAttribute( "tip", "好友请求已发送!");
        }
        return "user/tip";
    }

    @RequestMapping( value = "/refuseRequest/{requestId}")
    public String refuseRequest(@PathVariable Long requestId, Model model) {
        if (requestId == null || requestId < 1)
            throw new UserException("the argument is illegal!");
        notificationService.changeNotificationStatus( requestId);
        Notification notification = notificationService.loadNotificationById(requestId);

        //generate refuse notification
        User fromUser = userService.loadByUserId(notification.getToId());
        User toUser = userService.loadByUserId( notification.getFromId());
        Notification refuseNotification = new Notification();
        refuseNotification.generateRefuseRequestNotification( fromUser, toUser);
        notificationService.addNotification( refuseNotification);
        model.addAttribute("tip", "拒绝请求已发送!");
        return "user/tip";
    }

    @RequestMapping( value = "/acceptRequest/{requestId}")
    public String successRequest(@PathVariable Long requestId, Model model) {
        if (requestId == null || requestId < 1)
            throw new UserException("the argument is illegal!");
        notificationService.changeNotificationStatus( requestId);
        Notification notification = notificationService.loadNotificationById(requestId);

        //generate accept notification
        User fromUser = userService.loadByUserId(notification.getToId());
        User toUser = userService.loadByUserId( notification.getFromId());

        //build friend relation
        Friend friend = friendService.loadFriend(fromUser.getId(), toUser.getId());
        if (friend == null) {
            friendService.addFriend(fromUser.getId(), toUser.getId());
            friendService.addFriend(toUser.getId(), fromUser.getId());
        }

        Notification acceptNotification = new Notification();
        acceptNotification.generateAddSuccessNotification(fromUser, toUser);
        notificationService.addNotification( acceptNotification);
        model.addAttribute("tip", "你们已经成为好友!……^__^");
        return "user/tip";
    }

    @RequestMapping( value = "/unread/{userId}")
    public String unreadNotification(@PathVariable Long userId, Model model) {
        List<Notification> notifications = notificationService.getUnReadNotifications( userId);
        model.addAttribute( "notifications", notifications);
        return "notification/unreadNotification";
    }

    @RequestMapping( value = "/changeStatus/{notificationId}")
    public @ResponseBody String changeStatus(@PathVariable Long notificationId) {
        if (notificationId == null || notificationId < 1)
            throw new UserException("the argument is illegal!");
        notificationService.changeNotificationStatus( notificationId);
        return "";
    }

}
