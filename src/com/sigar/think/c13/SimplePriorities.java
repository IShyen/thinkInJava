package com.sigar.think.c13;

/**
 * Copyright (c) 2017 yusijia0501@126.com. All rights reserved.
 * Created by yusijia0501@126.com on 2017/3/12.
 */
public class SimplePriorities extends Thread {
    private int countDown = 5;
    private volatile double d = 0;

    public SimplePriorities(int priority){
        setPriority(priority);
        start();
    }

    public String toString(){
        return super.toString() + "：" + countDown;
    }

    public void run(){
        while (true){
            for (int i=0; i<100000; i++){
                d = d + (Math.PI + Math.E)/(double)i;
            }
            System.out.println(this);

            if(--countDown == 0){
                return;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        new SimplePriorities(Thread.MAX_PRIORITY);
        for(int i=0; i<5; i++){
            new SimplePriorities(Thread.MIN_PRIORITY);
        }
    }
}
