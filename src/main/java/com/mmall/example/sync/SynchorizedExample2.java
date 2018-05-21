package com.mmall.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018/5/21.
 */
@Slf4j
public class SynchorizedExample2 {
    public static void test1(int j) {
        //修饰一个类（作用所有对象）
        synchronized (SynchorizedExample2.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} - {}",j, i);
            }
        }
    }
    //修饰一个静态方法（作用所有对象）
    public static synchronized void test2(int j){
        for (int i = 0; i < 10; i++) {
            log.info("test2 {} - {}",j,i);
        }
    }

    public static void main(String[] args) {
        SynchorizedExample2 synchorizedExample1 = new SynchorizedExample2();
        SynchorizedExample2 synchorizedExample2 = new SynchorizedExample2();//使用线程池可以开启两个线程
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            synchorizedExample1.test2(1);
        });
        executorService.execute(() -> {
            synchorizedExample2.test2(2);
        });
    }
}
