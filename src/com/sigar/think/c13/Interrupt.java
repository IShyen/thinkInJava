package com.sigar.think.c13;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Copyright (c) 2017 yusijia0501@126.com. All rights reserved.
 * Created by yusijia0501@126.com on 2017/3/26.
 * Using interrupt() to break out of a blocked thread.
 */
class Blocked extends Thread{
    public Blocked(){
        System.out.println("Starting Blocked.");
        start();
    }

    public void run(){
        try {
            synchronized (this){
                wait(); // Blocks
            }
        }catch(InterruptedException e){
            System.out.println("Interrupted");
        }
        System.out.println("Exiting run()");
    }
}

public class Interrupt {
    static Blocked blocked = new Blocked();
    public static void main(String[] args){
        new Timer(true).schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Preparing to interrupt");
                blocked.interrupt();
                blocked = null;
            }
        }, 2000);
    }
}
