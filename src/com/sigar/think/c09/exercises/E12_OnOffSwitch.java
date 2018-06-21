package com.sigar.think.c09.exercises;

class Switch {
    boolean state = false;

    boolean read() { return state; }
    void on() { state = true; }
    void off() { state = false; }

    public String toString() {
        return "Switch = " + (state ? "on" : "off");
    }
}

class OnOffException1 extends Exception {}
class OnOffException2 extends Exception {}


public class E12_OnOffSwitch {
    private static Switch sw = new Switch();

    public static void f() throws OnOffException1, OnOffException2 {
        throw new RuntimeException("Inside try");
    }

    /**
     * 程序的目的是要确保main()结束的时候开关必须是关闭的。
     * 所以使用finally来达到这个目标。
     */
    public static void main(String[] args){
        try{
            sw.on();
            // Code that can throw exceptions...
            f();
            sw.off();
        }catch (OnOffException1 e){
            System.err.println("OnOffException1");
        }catch (OnOffException2 e){
            System.err.println("OnOffException2");
        }finally {
            sw.off();
        }
    }
}
