package com.example.databaseexp3backend.service;

import com.example.databaseexp3backend.pojo.Admin;

import java.util.List;

public interface AdminService {
    public Boolean checklogin(Admin admin);
    public List<Admin> getall();
}
