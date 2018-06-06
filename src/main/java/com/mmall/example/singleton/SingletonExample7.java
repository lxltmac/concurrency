package com.mmall.example.singleton;

import com.mmall.annoations.Recommend;
import com.mmall.annoations.ThreadSafe;

/**
 * 枚举模式最安全
 * Created by Administrator on 2018/5/22.
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {
    //私有构造函数
    private SingletonExample7(){}

    public static SingletonExample7 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum  Singleton{
        INSTANCE;

        private SingletonExample7 singletonExample7;
        //JVM保证这个方法只被调用一次
        Singleton(){
            singletonExample7 = new SingletonExample7();
        }

        public SingletonExample7 getInstance(){
            return singletonExample7;
        }
    }
}
