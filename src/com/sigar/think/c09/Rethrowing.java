package com.sigar.think.c09;

/**
 * Copyright (c) 2018 yusijia0501@126.com. All rights reserved.
 * Created by yusijia0501@126.com on 2018/4/29.
 */
public class Rethrowing {
    public static void f() throws Exception{
        System.out.println("Originating the exception in f()");
        throw new Exception("thrown from f()");
    }

    public static void g() throws Throwable{
        try {
            f();
        }catch (Exception e){
            System.err.println("Inside g(), e.printStackTrace()");
            e.printStackTrace();
//            throw e;
            throw e.fillInStackTrace();
        }
    }

    public static void main(String[] args) throws Throwable{
        try{
            g();
        }catch (Exception e){
            System.err.println("Caught in main, e.printStackTrace()");
            e.printStackTrace();
        }
    }
}
