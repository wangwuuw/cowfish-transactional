package com.cowfish.service;

import com.cowfish.dao.LogsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @classDesc： 功能描述：（往日志表插入数据）
 * @author：王武
 * @createTime 2018/2/3
 * @verson: v1.0
 * @copyright: 上海江豚教育科技有限公司
 * @qq:834667820
 */
@Service
public class LogService {
    @Autowired
    private LogsDao logsDao;
    @Transactional(propagation = Propagation.REQUIRED)
    public void addLog(){
        logsDao.add();
        int a = 1/0;
        System.out.println("插入日志成功....");
    }
}
