package com.hcj.spring.core.feature.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.text.SimpleDateFormat;

/**
 * Created by hcj on 2015/12/4.
 * 带事务回滚的普通的测试，测试数据-不会-写到数据库中
 */
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class TestTransactionSupport extends AbstractTransactionalJUnit4SpringContextTests {
    protected  long startTime;
    protected  long endTime;

    /**
     * record start  run time
     * @return
     */
    protected  long start(){
        this.startTime = System.currentTimeMillis();
        return  startTime;
    }

    /**
     * record end run time
     * and print the record
     * @return
     */
    protected  long end(){
        this.endTime = System.currentTimeMillis();
        this.log();
        return  endTime;
    }

    /**
     * print log
     */
    protected  void log(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String text = "\n开始时间 : " + simpleDateFormat.format(this.startTime)+ "\n结束时间 : " + simpleDateFormat.format(this.endTime) + "\n执行时间 : " + (this.endTime - this.startTime);
        logger.info(text);
    }
}
