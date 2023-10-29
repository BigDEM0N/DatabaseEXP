package com.example.databaseexp3backend.controller;

import com.example.databaseexp3backend.pojo.Admin;
import com.example.databaseexp3backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.swing.text.html.HTML;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admin/login")
    public String loginpage(){
        return "adminLogin";
    }

    @PostMapping("/admin/login")
    public String login(@RequestBody Admin admin){
        if(adminService.checklogin(admin)){
            return "redirect:/admin/homepage";
        }
        else{
            return "error";
        }
    }

    @GetMapping("/admin/getall")
    public List<Admin>getall() {
        List<Admin> list = adminService.getall();
        return list;
    }

}
