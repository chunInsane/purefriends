package org.nuc.purefriends.service;

import org.nuc.purefriends.dao.AdminMapper;
import org.nuc.purefriends.exception.UserException;
import org.nuc.purefriends.model.Admin;
import org.nuc.purefriends.util.EncodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by zhangliang on 15/11/12.
 */

@Service
public class AdminService implements IAdminService {


    private AdminMapper adminMapper;

    @Autowired
    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    public AdminMapper getAdminMapper() {

        return adminMapper;
    }

    @Override
    public Admin addAdmin(Admin admin) {
        Admin ta = adminMapper.loadByUsername(admin.getUsername());
        if (ta != null)
            throw new UserException("该用户名已经存在！");
        String encodePwd = null;
        try {
            encodePwd = EncodeUtil.encodeByMD5( admin.getUsername(), admin.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        admin.setPassword(encodePwd);
        adminMapper.addAdmin( admin);
        return admin;
    }

    @Override
    public Admin loadAdminById(Long adminId) {
        return adminMapper.loadById(adminId);
    }

    @Override
    public void updateAdmin(Admin admin) {
        Admin tadmin = adminMapper.loadById( admin.getId());
        tadmin.setNickname( admin.getNickname());
        adminMapper.updateAdmin( tadmin);
    }

    @Override
    public void deleteAdmin(Long adminId) {
        adminMapper.deleteAdmin( adminId);
    }

    @Override
    public List<Admin> getAllAdmin() {
        return adminMapper.getAllAdmin();
    }

    @Override
    public Admin login(String username, String password) {
        Admin tadmin = adminMapper.loadByUsername( username);
        if (tadmin == null)
            return null;
        String encodePwd = null;
        try {
            encodePwd = EncodeUtil.encodeByMD5( username, password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (encodePwd != null && encodePwd.equals(tadmin.getPassword()))
            return tadmin;
        return null;
    }

}
