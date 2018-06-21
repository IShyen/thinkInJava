package com.sigar.think.c09;

/**
 * Copyright (c) 2018 yusijia0501@126.com. All rights reserved.
 * Created by yusijia0501@126.com on 2018/4/29.
 *
 * Rethrow a different object from the one that was caught.
 */
class OneException extends Exception{
    public OneException(String s){
        super(s);
    }
}

class TowException extends Exception{
    public TowException(String s){
        super(s);
    }
}

public class RethrowNew {
    public static void f() throws OneException{
        System.out.println("Originating the exception in f()");
        throw new OneException("thrown from f()");
    }

    public static void main (String[] args) throws TowException{
        try {
            f();
        }catch (OneException e){
            System.err.println("Caught in main, e.printStackTrace()");
            e.printStackTrace();
            throw new TowException("from main");
        }
    }
}
