package com.sigar.think.c09;

/**
 * Copyright (c) 2018 yusijia0501@126.com. All rights reserved.
 * Created by yusijia0501@126.com on 2018/4/29.
 */
class MyException extends Exception{
    public MyException(){}

    public MyException(String msg){
        super(msg);
    }
}

public class FullConstructors {
    public static void f() throws MyException{
        System.err.println("Throwing MyException from f()");
        throw new MyException();
    }

    public static void g() throws MyException{
        System.err.println("Throwing MyException from g()");
        throw new MyException("Originated in g()");
    }

    public static void main(String[] args){
        try{
            f();
        }catch (MyException e){
            e.printStackTrace();
        }

        try{
            g();
        }catch (MyException e){
            e.printStackTrace();
        }
    }
}
