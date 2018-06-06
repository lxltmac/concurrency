package com.mmall.example.singleton;

import com.mmall.annoations.ThreadSafe;

/**
 * 饿汉模式
 * Created by Administrator on 2018/5/22.
 */
@ThreadSafe
public class SingletonExample2 {
    //私有构造函数
    private SingletonExample2(){}
    //单例对象
    private static SingletonExample2 instance = new SingletonExample2();
    //静态工厂方法
    public static SingletonExample2 getInstance(){
        return instance;
    }
}
