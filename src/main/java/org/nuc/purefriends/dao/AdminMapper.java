package org.nuc.purefriends.dao;

import org.nuc.purefriends.model.Admin;

import java.util.List;

/**
 * Created by zhangliang on 15/11/12.
 */
public interface AdminMapper {

    public Admin loadByUsername(String username);

    public Admin loadById(Long adminId);

    public void updateAdmin(Admin admin);

    public void deleteAdmin(Long adminId);

    public Long addAdmin(Admin admin);

    public List<Admin> getAllAdmin();
}
