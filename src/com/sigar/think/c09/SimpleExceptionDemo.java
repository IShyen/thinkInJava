package com.sigar.think.c09;

/**
 * Inheriting your own exceptions.
 */
class SimpleException extends Exception{}

public class SimpleExceptionDemo{
    public void f() throws SimpleException{
        System.out.println("Throw Simple Exception from f()");
        throw new SimpleException();
    }

    public static void main(String[] args){
        SimpleExceptionDemo sed = new SimpleExceptionDemo();
        try{
            sed.f();
        }catch (SimpleException e){
            System.err.println("Caught it!");
        }
    }

}
