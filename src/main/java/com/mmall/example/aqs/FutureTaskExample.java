package com.mmall.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2018/5/25.
 */
@Slf4j
public class FutureTaskExample {
    public static void main(String[] args) throws Exception {
        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("do someting in callable");
                Thread.sleep(5000);
                return "Done";
            }
        });
        new Thread(futureTask).start();
        log.info("do something in main");
        Thread.sleep(1000);
        String result = futureTask.get();
        log.info("result:{}",result);
    }
}

