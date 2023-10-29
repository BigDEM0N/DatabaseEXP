package com.example.databaseexp3backend.service;

import com.example.databaseexp3backend.dao.AdminDao;
import com.example.databaseexp3backend.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminDao adminDao;

    @Override
    public Boolean checklogin(Admin admin) {
        List<Admin> lists = adminDao.getAdmin(admin.getAdminName());
        for(Admin target:lists){
            if(target.getAdminPassword().equals(admin.getAdminPassword())){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Admin> getall() {
        return adminDao.getall();
    }
}
