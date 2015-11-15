package org.nuc.purefriends.service;

import org.nuc.purefriends.dao.NotificationMapper;
import org.nuc.purefriends.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangliang on 15/11/12.
 */
@Service
public class NotificationService implements INotificationService {

    private NotificationMapper notificationMapper;

    @Autowired
    public void setNotificationMapper(NotificationMapper notificationMapper) {
        this.notificationMapper = notificationMapper;
    }

    public NotificationMapper getNotificationMapper() {

        return notificationMapper;
    }

    @Override
    public List<Notification> getUnReadNotifications(Long userId) {
        return notificationMapper.getUnReadNotifications( userId);
    }

    @Override
    public Long getUnReadNotificationCount(Long userId) {
        return notificationMapper.getUnReadNotificationCount( userId);
    }

    @Override
    public List<Notification> getAllNotifications(Long userId) {
        return notificationMapper.getAllNotifications( userId);
    }

    @Override
    public Long getAllNotificationCount(Long userId) {
        return notificationMapper.getAllNotificationCount( userId);
    }

    @Override
    public Notification addNotification(Notification notification) {
        notificationMapper.addNotification(notification);
        return notification;
    }

    @Override
    public void changeNotificationStatus(Long notificationId) {
        notificationMapper.changeNotificationStatus( notificationId);
    }

    @Override
    public Notification loadNotificationById(Long notificationId) {
        return notificationMapper.loadNotificationById( notificationId);
    }
}
