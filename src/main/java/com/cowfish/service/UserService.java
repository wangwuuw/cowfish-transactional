package com.cowfish.service;

import com.cowfish.dao.UserDao;
import com.cowfish.transaction.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @classDesc： 功能描述：（往用户表插入数据）
 * @author：王武
 * @createTime 2018/2/3
 * @verson: v1.0
 * @copyright: 上海江豚教育科技有限公司
 */
@Service
public class UserService {
    @Autowired
    private LogService logService;
    @Autowired
    private UserDao userDao;
    @Autowired
    TransactionManager transactionManager;
//    public void add() {
//        TransactionStatus transactionStatus = null;
//
//        try {
//            transactionStatus = transactionManager.begin();
//            logService.addLog();
////            int i = 1 / 0;
//            userDao.addUser("lisi-" + System.currentTimeMillis());
//
//
//            transactionManager.commit(transactionStatus);
//        } catch (Exception e) {
//            //我发现会不会滚都没事,只要没有commit,数据就不会插入
////            transactionManager.rollback(transactionStatus);
//        }
//    }
//加REQUIRES默认事务,如果父方法没事务,此方法就执行自己的事务
    //加REQUIRES_NEW注解的方法被其他方法调用不受其他方法的事务限制
//加SUPPORTS注解等于当前方法没有事务,但是被调用的方法有事务就用用它自己的事务
//MANDATORY注解等于当前方法调用的子方法没有事务就报异常
    //NOT_SUPPORTED注解等于该方法不受调用方法事务的影响跟REQUIRES_NEW有点相似,但是是以非事务运行,而REQUIRES_NEW是以事务运行
//NEVER注解表示:如何父方法有事务,那么就会报错
    @Transactional(propagation = Propagation.NESTED)
    public void add() {
            logService.addLog();//这里抛了异常,下面方法就不执行了
            userDao.addUser("lisi-" + System.currentTimeMillis());
//        int i = 1 / 0;
    }
    public static void main(String[] args) {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = (UserService) app.getBean("userService");
        userService.add();
    }
}
