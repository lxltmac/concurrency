package com.mmall.example.threadLocal;

/**
 * Created by Administrator on 2018/5/22.
 */
public class RequestHolder {
    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long id){
        requestHolder.set(id);
    }

    public static Long getId() {
        return requestHolder.get();
    }

    public static void remove(){
        requestHolder.remove();
    }
}
