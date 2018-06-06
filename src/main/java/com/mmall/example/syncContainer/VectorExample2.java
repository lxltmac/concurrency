package com.mmall.example.syncContainer;

import com.mmall.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Vector;

/**
 * Created by Administrator on 2018/5/23.
 */
@Slf4j
@NotThreadSafe
public class VectorExample2 {
    private static Vector<Integer> vetor = new Vector<>();

    public static void main(String[] args) {
        while (true){
            for (int i = 0; i < vetor.size(); i++) {
                vetor.add(i);
            }
            Thread thread1 = new Thread() {
                public void run() {
                    for (int i = 0; i < vetor.size(); i++) {
                        vetor.remove(i);
                    }
                }
            };
            Thread thread2 = new Thread() {
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        vetor.get(i);
                    }
                }
            };
            thread1.start();
            thread2.start();
        }
    }
}
