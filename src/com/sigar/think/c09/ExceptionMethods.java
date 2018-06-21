package com.sigar.think.c09;

/**
 * Copyright (c) 2018 yusijia0501@126.com. All rights reserved.
 * Created by yusijia0501@126.com on 2018/4/29.
 */
public class ExceptionMethods {
    public static void main(String[] args){
        try {
            throw new Exception("My Exception");
        }catch (Exception e){
            System.err.println("Caught Exception");
            System.err.println("getMessage(): " + e.getMessage());
            System.err.println("getLocalizedMessage(): " + e.getLocalizedMessage());
            System.err.println("toString(): " + e.toString());
            System.err.println("printStackTrace(): ");
            e.printStackTrace();
        }
    }
}
