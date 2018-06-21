package com.sigar.think.c13;

/**
 * Copyright (c) 2017 yusijia0501@126.com. All rights reserved.
 * Created by yusijia0501@126.com on 2017/3/12.
 */
public class SimpleDaemons extends Thread {
    public SimpleDaemons(){
        setDaemon(true);
        start();
    }

    public void run(){
        while (true){
            try{
                sleep(1000);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.println(this);
        }
    }

    public static void main(String[] args){
        for (int i=0; i<10; i++){
            new SimpleDaemons();
        }
    }
}
