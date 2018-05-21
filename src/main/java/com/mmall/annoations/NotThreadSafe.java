package com.mmall.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用来标记线程不安全的类或写法
 * Created by Administrator on 2018/5/21.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface NotThreadSafe {
    String value() default "";
}