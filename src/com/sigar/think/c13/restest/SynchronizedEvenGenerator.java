package com.sigar.think.c13.restest;

/**
 * Copyright (c) 2017 yusijia0501@126.com. All rights reserved.
 * Created by yusijia0501@126.com on 2017/3/12.
 */
public class SynchronizedEvenGenerator implements Invariant{
    private int i;

    public synchronized void next() {
        i++;
        i++;
    }

    public synchronized int getValue() {
        return i;
    }

    public InvariantState invariant() {
        int val = i; // Capture it in case it changes
        if(val % 2 == 0)
            return new InvariantOK();
        else
            return new InvariantFailure(new Integer(val));
    }

    public static void main(String args[]) {
        SynchronizedEvenGenerator gen = new SynchronizedEvenGenerator();
        new InvariantWatcher(gen);
        while(true)
            gen.next();
    }
}
