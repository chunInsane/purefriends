package org.nuc.purefriends.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuc.purefriends.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhangliang on 15/11/13.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:application.xml")
public class AdminServiceTest {


    @Autowired
    private IAdminService adminService;

    @Test
    public void testAddAdmin() {
        Admin admin = new Admin();
        admin.setUsername( "superadmin");
        admin.setPassword("superadmin");
        admin.setNickname("超级管理员");
        adminService.addAdmin( admin);
    }
}
