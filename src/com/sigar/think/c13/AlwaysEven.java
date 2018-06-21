package com.sigar.think.c13;

/**
 * Copyright (c) 2017 yusijia0501@126.com. All rights reserved.
 * Created by yusijia0501@126.com on 2017/3/12.
 */
public class AlwaysEven {
    private int i;

    public void next(){
        i++;
        i++;
    }

    public int getValue(){
        return i;
    }

    public static void main(String[] args){
        final AlwaysEven ae = new AlwaysEven();
        new Thread("Watcher"){
            public void run(){
                while (true){
                    int val = ae.getValue();
                    if(val % 2 != 0){
                        System.out.println(val);
                        System.exit(0);
                    }
                }
            }
        }.start();

        while (true)
            ae.next();
    }
}
