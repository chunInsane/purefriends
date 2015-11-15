package org.nuc.purefriends.service;

import org.nuc.purefriends.dao.UserMapper;
import org.nuc.purefriends.exception.UserException;
import org.nuc.purefriends.model.User;
import org.nuc.purefriends.util.EncodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by zhangliang on 15/11/12.
 */
@Service
public class UserService implements IUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger( UserService.class);

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserMapper getUserMapper() {

        return userMapper;
    }

    @Override
    public User addUser(User user) {
        //先检查该邮箱是否注册使用过
        User tu = userMapper.loadUserByEmail( user.getEmail());
        if (tu != null) {
            throw new UserException("该邮箱已经注册使用～～!");
        }
        String encodePwd = null;
        try {
            encodePwd = EncodeUtil.encodeByMD5( user.getEmail(), user.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            LOGGER.error( e.getMessage(), e);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            LOGGER.error( e.getMessage(), e);
        }
        user.setPassword( encodePwd);
        userMapper.addUser(user);
        return user;
    }

    @Override
    public void deleteByUserId(Long userId) {
        userMapper.deleteUserById(userId);
    }

    @Override
    public void updateUser(User user) {
        User tu = userMapper.getUserById( user.getId());
        tu.setNickname( user.getNickname());
        tu.setArea( user.getArea());
        tu.setEducation( user.getEducation());
        tu.setGender( user.getGender());
        tu.setHeight( user.getHeight());
        tu.setHobby( user.getHobby());
        tu.setInfo( user.getInfo());
        userMapper.updateUser( tu);
    }

    @Override
    public User login(String email, String password) {
        User tu = userMapper.loadUserByEmail( email);
        if (tu == null)
            return null;
        String encodePwd = null;
        try {
            encodePwd = EncodeUtil.encodeByMD5( email, password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (encodePwd != null && encodePwd.equals(tu.getPassword()))
            return tu;
        else
            return null;
    }

    @Override
    public User loadByUserId(Long userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public User loadUserByEmail(String email) {
        return userMapper.loadUserByEmail( email);
    }

    @Override
    public List<User> getBy(User user) {
        return userMapper.getBy( user);
    }

    @Override
    public List<User> getByPhone(String phone) {
        return userMapper.getByPhone( phone);
    }

    @Override
    public List<User> getByKeyword(String keyword) {
        return userMapper.getByKeyword( keyword);
    }

    @Override
    public List<User> getAllFriends(Long userId) {
        return userMapper.getAllFriends( userId);
    }

    @Override
    public Long getFriendsCount(Long userId) {
        return userMapper.getFriendsCount(userId);
    }

}
