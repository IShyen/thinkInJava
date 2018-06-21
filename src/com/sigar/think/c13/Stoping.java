package com.sigar.think.c13;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Copyright (c) 2017 yusijia0501@126.com. All rights reserved.
 * Created by yusijia0501@126.com on 2017/3/25.
 * The save way to stop a thread.
 */
class CanStop extends Thread{
    //Must be volatile:
    private volatile boolean stop = false;
    private int counter = 0;

    public void run(){
        while (!stop && counter < 1000000000){
            System.out.println(counter++);
        }
        if(stop){
            System.out.println("Detected stop");
        }
    }

    public void requestStop(){
        stop = true;
    }
}
public class Stoping {
    public static void main(String[] args){
        final CanStop stopable = new CanStop();
        stopable.start();

        new Timer(true).schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Requesting stop");
                stopable.requestStop();
            }
        }, 500, 1000);
    }
}
