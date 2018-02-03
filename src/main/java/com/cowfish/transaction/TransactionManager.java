package com.cowfish.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

/**
 * @classDesc： 功能描述：（手动事务）
 * @author：王武
 * @createTime 2018/2/3
 * @verson: v1.0
 * @copyright: 上海江豚教育科技有限公司
 * @qq:834667820
 */
@Component
public class TransactionManager {
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;
    /**
    * classDesc: 功能描述：(开启事务)
    * @Author:王武
    * @Date:2018/2/3 12:48
    * @param:
    * @param:
    * @return:
    */
    public TransactionStatus begin() {
        // 获取到事物状态
        return dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
    }
/**
* classDesc: 功能描述：(开启事务)
* @Author:王武
* @Date:2018/2/3 12:46
* @param:
* @param:
* @return:
*/
    public void commit(TransactionStatus transactionStatus) {
        dataSourceTransactionManager.commit(transactionStatus); // 数据会提交到数据库中...

    }



/**
* classDesc: 功能描述：(发生异常数据库回滚)
* @Author:王武
* @Date:2018/2/3 12:46
* @param: transactionStatus
* @param:
* @return:
*/
    public void rollback(TransactionStatus transactionStatus) {

        dataSourceTransactionManager.rollback(transactionStatus);
    }
}
