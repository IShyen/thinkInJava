package com.sigar.think.c09;

/**
 * Catching exception hierarchies
 */
class Annoyance extends Exception{}
class Sneeze extends Annoyance{}

public class Human {
    public static void main(String[] args){
        try {
            throw new Sneeze();
        }catch (Sneeze s){
            System.err.println("Caught Sneeze");
        }catch (Annoyance e){
            // 这个代码块会捕获Annoyance异常以及所有从它派生的异常
            System.err.println("Caught Annoyance");
        }
    }
}
