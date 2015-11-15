package org.nuc.purefriends.service;

import org.nuc.purefriends.model.User;

import java.util.List;

/**
 * Created by zhangliang on 15/11/12.
 */
public interface IUserService {

    public User addUser(User user);

    public void deleteByUserId(Long userId);

    public void updateUser(User user);

    public User login(String email, String password);

    public User loadByUserId(Long userId);

    public User loadUserByEmail(String email);

    public List<User> getBy(User user);

    public List<User> getByPhone(String phone);

    public List<User> getByKeyword(String keyword);

    public List<User> getAllFriends(Long userId);

    public Long getFriendsCount(Long userId);
}
