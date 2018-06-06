package com.mmall.example.singleton;

import com.mmall.annoations.ThreadSafe;

/**
 * 饿汉模式
 * Created by Administrator on 2018/5/22.
 */
@ThreadSafe
public class SingletonExample6 {
    //私有构造函数
    private SingletonExample6(){}
    //单例对象
    private static SingletonExample6 instance = null;
    static{
        instance = new SingletonExample6();
    }

    //静态工厂方法
    public static SingletonExample6 getInstance(){
        return instance;
    }
}
