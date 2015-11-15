package org.nuc.purefriends.dao;

import org.nuc.purefriends.model.TempUser;

import java.util.Map;

/**
 * Created by zhangliang on 15/11/13.
 */
public interface TempUserMapper {

    public void addTempUser(TempUser tempUser);

    public TempUser loadTempUserById(Long tempUserId);

    public TempUser loadTempUserByEmailAndKey(Map<String, String> args);

    public void deleteTempUserById(Long tempUserId);

    public void deleteTempUserByEmail(String email);
}
