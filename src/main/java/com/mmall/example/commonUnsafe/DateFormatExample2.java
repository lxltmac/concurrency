package com.mmall.example.commonUnsafe;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Administrator on 2018/5/23.
 */
@Slf4j
public class DateFormatExample2 {
    //请求总数
    public static int clientTotal = 5000;
    //同时并发执行的线程数
    public static int threadTotal = 200;

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try{
                    semaphore.acquire();//判断的线程是否被执行
                    update();
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

    private static void update(){
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyymmdd");
            simpleDateFormat.parse("20180208");
        } catch (ParseException e) {
            log.error("parse Exception",e);
        }
    }
}
