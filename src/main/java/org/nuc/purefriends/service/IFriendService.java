package org.nuc.purefriends.service;

import org.nuc.purefriends.model.Friend;

/**
 * Created by zhangliang on 15/11/13.
 */
public interface IFriendService {

    public void addFriend(Long user1Id, Long user2Id);

    public Friend loadFriend(Long user1Id, Long user2Id);

    public void deleteFriend(Long user1Id, Long user2Id);

}
