package com.sigar.think.c13.restest;

/**
 * Copyright (c) 2017 yusijia0501@126.com. All rights reserved.
 * Created by yusijia0501@126.com on 2017/3/12.
 */
public class SerialNumberGenerator {
    public static volatile int serialNumber = 0;

    public synchronized static int nextSerialNumber(){
        return ++serialNumber;
    }
}
