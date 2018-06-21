package com.sigar.concurrency.c03;

/**
 * Copyright (c) 2017 yusijia0501@126.com. All rights reserved.
 * Created by yusijia0501@126.com on 2017/4/9.
 */
public class VolatileExample extends Thread{
    private static boolean flag = false;

    public void run() {
        while (!flag){};
    }

    public static void main (String[] args) throws Exception{
        new VolatileExample().start();
        Thread.sleep(100);
        flag = true;
    }
}
