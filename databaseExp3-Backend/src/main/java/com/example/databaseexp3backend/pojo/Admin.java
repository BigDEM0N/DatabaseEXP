package com.example.databaseexp3backend.pojo;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class Admin {

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    private String adminName;
    private String adminPassword;
    private int adminId;
}
