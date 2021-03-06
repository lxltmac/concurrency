package com.mmall.example.syncContainer;

import com.google.common.collect.Sets;
import com.mmall.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Administrator on 2018/5/23.
 */
@Slf4j
@ThreadSafe
public class CollectionExample2 {
    private static Set<Integer> set = Collections.synchronizedSet(Sets.newHashSet());
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
        log.info("size:{}",set.size());
    }

    private static void update(int i){
        set.add(i);
    }
}
