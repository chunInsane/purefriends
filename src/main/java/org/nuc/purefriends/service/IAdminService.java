package org.nuc.purefriends.service;

import org.nuc.purefriends.model.Admin;

import java.util.List;

/**
 * Created by zhangliang on 15/11/12.
 */

public interface IAdminService {

    public Admin addAdmin(Admin admin);

    public Admin loadAdminById(Long adminId);

    public void updateAdmin(Admin admin);

    public void deleteAdmin(Long adminId);

    public List<Admin> getAllAdmin();

    public Admin login(String username, String password);
}
