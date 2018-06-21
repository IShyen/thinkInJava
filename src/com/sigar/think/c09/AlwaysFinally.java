package com.sigar.think.c09;

/**
 * Finally is always executed.
 */
class FourException extends Exception{}

public class AlwaysFinally {
    public static void main(String[] args){
        System.err.println("Entering first try block");
        try{
            System.err.println("Entering second try block");
            try{
                throw new FourException();
            }finally {
                System.err.println("finally in 2nd try block");
            }
        }catch (FourException e){
            System.err.println("Caught fourException in 1st try block");
        }finally {
            System.err.println("finally in 1st try block");
        }
    }
}
