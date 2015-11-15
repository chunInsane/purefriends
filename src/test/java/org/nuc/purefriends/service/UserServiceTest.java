package org.nuc.purefriends.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuc.purefriends.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhangliang on 15/11/12.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:application.xml")
public class UserServiceTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setEmail("838505099@qq.com");
        user.setPassword("121212");
        user.setGender(1);
        user.setArea("山西省|太原市|尖草坪区");
        user.setMarriage(0);
        user.setHeight(180);
        user.setEducation("大学本科");
        user.setWage(9000);
        System.out.println(user.toString());
        User tu = userService.addUser( user);
        System.out.println( tu.toString());
    }

    @Test
    public void testLoadUserById() {
        User user = userService.loadByUserId(1L);
        System.out.println(user.toString());
    }

    @Test
    public void testLogin() {
        User user = userService.login( "chuninsane@163.com", "123456");
        if (user == null)
            System.out.println("null");
        else
            System.out.println(user.toString());
    }
}
