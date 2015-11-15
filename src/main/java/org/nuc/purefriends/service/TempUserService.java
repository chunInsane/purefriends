package org.nuc.purefriends.service;

import org.nuc.purefriends.dao.TempUserMapper;
import org.nuc.purefriends.model.TempUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangliang on 15/11/13.
 */

@Service
public class TempUserService implements ITempUserService {

    private TempUserMapper tempUserMapper;

    @Autowired
    public void setTempUserMapper(TempUserMapper tempUserMapper) {
        this.tempUserMapper = tempUserMapper;
    }

    public TempUserMapper getTempUserMapper() {

        return tempUserMapper;
    }

    @Override
    public TempUser addTempUser(TempUser tempUser) {
        tempUserMapper.addTempUser(tempUser);
        return tempUser;
    }

    @Override
    public TempUser loadTempUserById(Long tempUserId) {
        return tempUserMapper.loadTempUserById(tempUserId);
    }

    @Override
    public TempUser loadTempUserByEmailAndKey(String email, String key) {
        Map<String, String> args = new HashMap<>();
        args.put( "email", email);
        args.put( "key", key);
        return tempUserMapper.loadTempUserByEmailAndKey( args);
    }

    @Override
    public void deleteTempUserById(Long tempUserId) {
        tempUserMapper.deleteTempUserById( tempUserId);
    }

    @Override
    public void deleteTempUserByEmail(String email) {
        tempUserMapper.deleteTempUserByEmail( email);
    }
}
