package org.nuc.purefriends.dao;

import org.nuc.purefriends.model.Friend;

import java.util.Map;

/**
 * Created by zhangliang on 15/11/13.
 */
public interface FriendMapper {

    public Long addFriend(Map<String, Long> args);

    public Friend loadFriend(Map<String, Long> args);

    public void deleteFriend(Map<String, Long> args);

}
