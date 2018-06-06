package com.mmall.example.singleton;

import com.mmall.annoations.NotRecommend;
import com.mmall.annoations.ThreadSafe;

/**
 * 懒汉模式
 * Created by Administrator on 2018/5/22.
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {
    //私有构造函数
    private SingletonExample3(){}
    //单例对象
    private static SingletonExample3 instance = null;
    //静态工厂方法
    public static synchronized SingletonExample3 getInstance(){
        if(instance == null){
            instance = new SingletonExample3();
        }
        return instance;
    }
}
