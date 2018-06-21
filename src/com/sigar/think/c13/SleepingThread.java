package com.sigar.think.c13;

/**
 * Copyright (c) 2017 yusijia0501@126.com. All rights reserved.
 * Created by yusijia0501@126.com on 2017/3/12.
 */
public class SleepingThread extends Thread{
    private int countDown = 5;
    private static int threadCount = 0;

    public SleepingThread(){
        super("" + ++threadCount);
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
//            try{
//                sleep(100);
//            }catch (InterruptedException e){
//                throw new RuntimeException(e);
//            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        for(int i=0; i<5; i++){
            new SleepingThread().join();
        }
    }
}
