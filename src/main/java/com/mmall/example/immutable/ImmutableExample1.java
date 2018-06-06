package com.mmall.example.immutable;

import com.google.common.collect.Maps;
import com.mmall.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * Created by Administrator on 2018/5/22.
 */
@Slf4j
@NotThreadSafe
public class ImmutableExample1 {
    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer,Integer> map = Maps.newHashMap();
    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
    }

    public static void main(String[] args) {
//        map = Maps.newHashMap();//不允许指向新的对象，但是允许修改里面的值
        map.put(1,3);
        log.info("{}",map.get(1));
    }

    public void test(final int a){
//        a=1;
    }
}
