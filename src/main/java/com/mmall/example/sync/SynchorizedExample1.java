package com.mmall.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018/5/21.
 */
@Slf4j
public class SynchorizedExample1 {
    public void test1(int j) {
        //修饰一个代码块
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} - {}",j, i);
            }
        }
    }
    //修饰一个方法
    public synchronized void test2(int j){
        for (int i = 0; i < 10; i++) {
            log.info("test2 {} - {}",j,i);
        }
    }

    public static void main(String[] args) {
        SynchorizedExample1 synchorizedExample1 = new SynchorizedExample1();
        SynchorizedExample1 synchorizedExample2 = new SynchorizedExample1();//使用线程池可以开启两个线程
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            synchorizedExample1.test2(1);
        });
        executorService.execute(() -> {
            synchorizedExample2.test2(2);
        });
    }
}
