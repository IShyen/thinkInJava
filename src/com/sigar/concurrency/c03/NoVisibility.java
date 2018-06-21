package com.sigar.concurrency.c03;

/**
 * Copyright (c) 2017 yusijia0501@126.com. All rights reserved.
 * Created by yusijia0501@126.com on 2017/4/9.
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;


    private static class ReaderThread extends Thread{
        public void run(){
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }
    }

    public static void main(String[] args){
        for(int i=0; i<100; i++){
            new ReaderThread().start();
            number = 42;
            ready = true;

            number = 0;
            ready = false;
        }
    }
}
