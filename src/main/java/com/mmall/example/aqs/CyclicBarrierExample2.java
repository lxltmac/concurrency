package com.mmall.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2018/5/24.
 */
@Slf4j
public class CyclicBarrierExample2 {


    private static CyclicBarrier barrier = new CyclicBarrier(5,()->{
        log.info("callback is running");
    });

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            executorService.execute(()->{
                try{
                    race(threadNum);
                }catch (Exception e){
                    log.error("execption",e);
                }
            });
        }
        executorService.shutdown();
    }

    private static void race(int threadNum) throws Exception {
        Thread.sleep(1000);
        log.info("{} is ready",threadNum);
        barrier.await();
        log.info("{} continue",threadNum);
    }
}
