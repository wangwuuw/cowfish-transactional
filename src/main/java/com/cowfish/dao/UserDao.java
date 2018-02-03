package com.cowfish.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
* classDesc: 功能描述：()
* @Author: 王武
* @Date:10:59 2018/2/3
* @version: v1.0
* @copyright:上海江豚教育科技有限公司
* QQ:834667820
*/
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void addUser(String name){
        String sql="INSERT INTO users(NAME,AGE) VALUES(?,?);";
        jdbcTemplate.update(sql,name,18);
        System.out.println("添加数据成功!.......");
    }
}
