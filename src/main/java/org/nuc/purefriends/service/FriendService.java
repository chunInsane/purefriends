package org.nuc.purefriends.service;

import org.nuc.purefriends.dao.FriendMapper;
import org.nuc.purefriends.model.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangliang on 15/11/13.
 */
@Service
public class FriendService implements IFriendService {

    private FriendMapper friendMapper;

    @Autowired
    public void setFriendMapper(FriendMapper friendMapper) {
        this.friendMapper = friendMapper;
    }

    public FriendMapper getFriendMapper() {

        return friendMapper;
    }

    @Override
    public void addFriend(Long user1Id, Long user2Id) {
        Map<String, Long> args = new HashMap<>();
        args.put( "user1Id", user1Id);
        args.put( "user2Id", user2Id);
        friendMapper.addFriend( args);
    }

    @Override
    public Friend loadFriend(Long user1Id, Long user2Id) {
        Map<String, Long> args = new HashMap<>();
        args.put( "user1Id", user1Id);
        args.put( "user2Id", user2Id);
        return friendMapper.loadFriend( args);
    }

    @Override
    public void deleteFriend(Long user1Id, Long user2Id) {
        Map<String, Long> args = new HashMap<>();
        args.put( "user1Id", user1Id);
        args.put( "user2Id", user2Id);
        friendMapper.deleteFriend( args);
    }
}
