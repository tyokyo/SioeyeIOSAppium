package ckt.App.sample.d02;

import org.testng.annotations.Test;

import java.util.logging.Logger;

/**
 * Created by qiang.zhang on 2017/1/8.
 * TestNG多线程使用方法
 */
public class MultiThreadCase {
    Logger logger = Logger.getLogger(MultiThreadCase.class.getName());
    @Test(invocationCount = 50,threadPoolSize = 5)
    public void testMultiThreadTestCase(){
        logger.info(System.currentTimeMillis()+"-"+Thread.currentThread().getId());
    }
}
