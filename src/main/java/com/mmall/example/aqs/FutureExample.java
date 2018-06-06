package com.mmall.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2018/5/25.
 */
@Slf4j
public class FutureExample{
    static class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        log.info("do someting in callable");
        Thread.sleep(5000);
        return "Done";
    }
}
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new MyCallable());//用future接收callable的结果
        log.info("do something in main");
        Thread.sleep(1000);
        String result = future.get();
        log.info("result:{}",result);
    }
}

