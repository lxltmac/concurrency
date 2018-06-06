package com.mmall.example.publish;

import com.mmall.annoations.NotRecommend;
import com.mmall.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Administrator on 2018/5/22.
 */
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {
    private int thisCanBeEscape = 0;

    public Escape (){
        new InnerClass();
    }

    private class InnerClass{
        public InnerClass(){
            log.info("{}",Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
