package com.cowfish.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @classDesc： 功能描述：（）
 * @author：王武
 * @createTime 2018/2/3
 * @verson: v1.0
 * @copyright: 上海江豚教育科技有限公司
 * @qq:834667820
 */
@Repository
public class LogsDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add(){
        String sql="INSERT INTO logs(info) VALUES(?);";
        jdbcTemplate.update(sql,System.currentTimeMillis());
        System.out.println("插入数据成功!.......");
    }
}
