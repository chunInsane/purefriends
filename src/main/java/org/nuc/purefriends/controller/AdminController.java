package org.nuc.purefriends.controller;

import org.apache.commons.lang3.StringUtils;
import org.nuc.purefriends.exception.UserException;
import org.nuc.purefriends.model.Admin;
import org.nuc.purefriends.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by zhangliang on 15/11/12.
 */
@Controller
@RequestMapping( value="/admin")
public class AdminController {

    private IAdminService adminService;

    @Autowired
    public void setAdminService(IAdminService adminService) {
        this.adminService = adminService;
    }

    public IAdminService getAdminService() {

        return adminService;
    }

    @RequestMapping( value = "/home/{adminId}")
    public String home(@PathVariable Long adminId, Model model) {
        Admin admin = adminService.loadAdminById( adminId);
        model.addAttribute("admin", admin);
        return "admin/home";
    }

    @RequestMapping( value = "/list")
    public String listAdmin(Model model) {
        List<Admin> admins = adminService.getAllAdmin();
        model.addAttribute(admins);
        return "admin/list";
    }

    @RequestMapping( value = "/add", method = RequestMethod.GET)
    public String addAdmin(Model model) {
        model.addAttribute("admin", new Admin());
        return "admin/add";
    }

    @RequestMapping( value = "/toAdd", method = RequestMethod.POST)
    public String addAdmin(Admin admin, Model model) {
        adminService.addAdmin(admin);
        return "redirect:/admin/list";
    }

    @RequestMapping( value = "/delete/{adminId}")
    public String deleteAdmin(@PathVariable Long adminId) {
        adminService.deleteAdmin(adminId);
        return "redirect:/admin/list";
    }

    @RequestMapping( value = "/show/{adminId}")
    public String showAdmin(@PathVariable Long adminId, Model model) {
        if (adminId == null || adminId <= 0)
            throw new UserException("admin id is illegal!");
        Admin tadmin = adminService.loadAdminById( adminId);
        model.addAttribute( "admin", tadmin);
        return "admin/show";
    }

    @RequestMapping( value="/login", method = RequestMethod.GET)
    public String login() {
        return "admin/login";
    }

    @RequestMapping( value="/login", method = RequestMethod.POST)
    public String login(String username, String password, HttpSession session) {
        if (StringUtils.isBlank( username) || StringUtils.isBlank(( password))) {
            throw new UserException("username and password can't be null!");
        }
        Admin tadmin = adminService.login( username, password);
        if (tadmin == null)
            throw new UserException("username or password is mistake!");
        session.setAttribute("adminName", tadmin.getNickname());
        return "redirect:/admin/home/" + tadmin.getId();
    }

    @RequestMapping( value="/logout")
    public String logout( HttpSession session) {
        session.invalidate();
        return "redirect:/admin/login";
    }

}
