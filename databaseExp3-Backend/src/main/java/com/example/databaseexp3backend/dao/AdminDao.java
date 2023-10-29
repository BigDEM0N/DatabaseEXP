package com.example.databaseexp3backend.dao;


import com.alibaba.druid.pool.DruidDataSource;
import com.example.databaseexp3backend.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AdminDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Admin> getAdmin(String adminName){
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/exp3");
//        druidDataSource.setUsername("root");
//        druidDataSource.setPassword("123456");
//        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(druidDataSource);
        List<Admin> lists = jdbcTemplate.query("select * from admin where a_username=" + adminName, new RowMapper<Admin>() {
            @Override
            public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
                Admin admin = new Admin();
                admin.setAdminId(rs.getInt("a_id"));
                admin.setAdminName(rs.getString("a_username"));
                admin.setAdminPassword(rs.getString("a_password"));
                return admin;
            }
        });
        return lists;
    }
    public List<Admin> getall(){
        List<Admin> lists = jdbcTemplate.query("select * from admin", new RowMapper<Admin>() {
            @Override
            public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
                Admin admin = new Admin();
                admin.setAdminId(rs.getInt("a_id"));
                admin.setAdminName(rs.getString("a_username"));
                admin.setAdminPassword(rs.getString("a_password"));
                return admin;
            }
        });
        return lists;
    }
}
