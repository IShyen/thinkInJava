package com.sigar.think.c13.restest;//: c14:Timeout.java
// Set a time limit on the execution of a program
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

import java.util.Timer;
import java.util.TimerTask;

class Timeout extends Timer {

  public Timeout(int delay, final String msg) {
    super(true);
    schedule(new TimerTask() {
        @Override
        public void run() {
            System.out.println(msg);
            System.exit(0);
        }
    }, delay);

  }

} ///:~