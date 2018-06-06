package com.mmall.example.singleton;

import com.mmall.annoations.ThreadSafe;

/**
 * 懒汉模式
 * Created by Administrator on 2018/5/22.
 */
@ThreadSafe
public class SingletonExample5 {
    //私有构造函数
    private SingletonExample5(){}

    //1、memory = allocate() 分配对象的内存空间
    //2、ctorInstance() 初始化对象
    //3、instance = memory 设置instance指向刚分配的内存

    //JVM和cpu发送指令重排

    //1、memory = allocate() 分配对象的内存空间
    //3、instance = memory 设置instance指向刚分配的内存
    //2、ctorInstance() 初始化对象

    //单例对象 volatie + 双重检测锁 -》 禁止指令重排
    private volatile static SingletonExample5 instance = null;
    //静态工厂方法
    public static SingletonExample5 getInstance(){
        if(instance == null){//双重检测锁
            synchronized (SingletonExample5.class){//同步锁
                if(instance == null){
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }
}
