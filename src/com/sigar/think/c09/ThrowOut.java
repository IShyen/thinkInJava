package com.sigar.think.c09;

/**
 * Copyright (c) 2018 yusijia0501@126.com. All rights reserved.
 * Created by yusijia0501@126.com on 2018/4/29.
 */
public class ThrowOut {
    public static void main(String[] args) throws Throwable{
        try{
            throw new Throwable();
        }catch (Exception e){
            System.err.println("Caught in main()");
        }
    }
}
