package com.sigar.think.c13;

/**
 * Copyright (c) 2017 yusijia0501@126.com. All rights reserved.
 * Created by yusijia0501@126.com on 2017/3/12.
 */
public class SimpleThread extends Thread{
    private int countDown = 5;
    private static int threadCount = 0;

    public SimpleThread(){
        super("" + ++threadCount);
//        setDaemon(true);
        start();
    }

    public String toString(){
        return "#" + getName() + "：" + countDown;
    }

    public void run(){
        while (true){
            System.out.println(this);
            if(--countDown == 0){
                return;
            }
        }
    }

    public static void main(String[] args){
        for(int i=0; i<5; i++){
            new SimpleThread();
        }
    }
}
