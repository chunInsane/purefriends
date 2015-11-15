package org.nuc.purefriends.service;

import org.nuc.purefriends.model.TempUser;

/**
 * Created by zhangliang on 15/11/13.
 */
public interface ITempUserService {

    public TempUser addTempUser(TempUser tempUser);

    public TempUser loadTempUserById(Long tempUserId);

    public TempUser loadTempUserByEmailAndKey(String email, String key);

    public void deleteTempUserById(Long tempUserId);

    public void deleteTempUserByEmail(String email);
}
