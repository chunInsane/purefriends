package org.nuc.purefriends.dao;

import org.nuc.purefriends.model.Notification;
import java.util.List;

/**
 * Created by zhangliang on 15/11/12.
 */
public interface NotificationMapper {

    public List<Notification> getUnReadNotifications(Long userId);

    public Long getUnReadNotificationCount(Long userId);

    public List<Notification> getAllNotifications(Long userId);

    public Long getAllNotificationCount(Long userId);

    public Long addNotification(Notification notification);

    public void changeNotificationStatus(Long notificationId);

    public Notification loadNotificationById(Long notificationId);

}
