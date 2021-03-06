package com.mmall.example.concurrent;

import com.mmall.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2018/5/23.
 */
@Slf4j
@NotThreadSafe
public class CopyOnWriteArrayListExample {
    private static List<Integer> list = new CopyOnWriteArrayList<>();
    //请求总数
    public static int clientTotal = 5000;
    //同时并发执行的线程数
    public static int threadTotal = 200;

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
        log.info("size:{}",list.size());
    }

    private static void update(int i){
        list.add(i);
    }
}
