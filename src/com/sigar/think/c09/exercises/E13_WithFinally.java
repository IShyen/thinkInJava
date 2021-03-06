package com.sigar.think.c09.exercises;

public class E13_WithFinally {
    static Switch sw = new Switch();

    static void f() throws OnOffException1, OnOffException2 {
        throw new RuntimeException("Inside try");
    }

    public static void main(String[] args) {
        try {
            try {
                sw.on();
                // Code that can throw exceptions...
                f();
            } catch(OnOffException1 e) {
                System.err.println("OnOffException1");
            } catch(OnOffException2 e) {
                System.err.println("OnOffException2");
            } finally {
                sw.off();
            }
        } catch(RuntimeException e) {
            System.out.println("Exception '" + e + "'. Did the switch get turned off?");
            System.out.println(sw);
        }
    }
}
