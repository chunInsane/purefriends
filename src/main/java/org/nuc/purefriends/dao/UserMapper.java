package org.nuc.purefriends.dao;

import org.nuc.purefriends.model.User;

import java.util.List;

/**
 * Created by zhangliang on 15/11/12.
 */
public interface UserMapper {

    public User getUserById(Long userId);

    public User loadUserByEmail(String email);

    public List<User> getAllFriends(Long userId);

    public Long getFriendsCount(Long userId);

    public List<User> getBy(User user);

    public List<User> getByKeyword(String keyword);

    public List<User> getByPhone(String phone);

    public void deleteUserById(Long userId);

    public void updateUser(User user);

    public Long addUser(User user);

}
