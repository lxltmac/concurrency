package com.mmall.example.commonUnsafe;

import com.mmall.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Administrator on 2018/5/23.
 */
@Slf4j
@ThreadSafe
public class DateFormatExample3 {
    //请求总数
    public static int clientTotal = 5000;
    //同时并发执行的线程数
    public static int threadTotal = 200;

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyymmdd");

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            final int count = i;
            executorService.execute(() -> {
                try{
                    semaphore.acquire();//判断的线程是否被执行
                    update(count);
                    semaphore.release();//释放当前线程
                } catch (Exception e){
                    log.error("exection",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();//保证countDownLatch为0
        executorService.shutdown();
    }

    private static void update(int i){
        log.info("{},{}",i,DateTime.parse("20180208",dateTimeFormatter).toDate());
    }
}
