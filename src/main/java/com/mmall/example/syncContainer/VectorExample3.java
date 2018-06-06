package com.mmall.example.syncContainer;

import com.mmall.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Administrator on 2018/5/23.
 */
@Slf4j
@NotThreadSafe
public class VectorExample3 {
//java.util.ConcurrentModificationException
    private static void test1(Vector<Integer> v1){ //foreach
        for (Integer i: v1) {
            v1.remove(i);
        }
    }
//java.util.ConcurrentModificationException
    private static void test2(Vector<Integer> v1){ //iterator
        Iterator<Integer> iterator = v1.iterator();
        while(iterator.hasNext()){
            Integer i = iterator.next();
            if(i.equals(3)){
                v1.remove(i);
            }
        }
    }
    //正常的，成功
    private static void test3(Vector<Integer> v1){
        for (int i = 0; i < v1.size(); i++) {
            if(v1.get(i).equals(3)){
                v1.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        Vector<Integer> vetor = new Vector<>();
        vetor.add(1);
        vetor.add(2);
        vetor.add(3);
        test3(vetor);
    }
}
