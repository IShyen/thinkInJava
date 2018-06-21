package com.sigar.think.c09.exercises;

class ResumerException extends Exception {}

class Resumer {
    static int count = 3;
    void f() throws ResumerException {
        if(--count > 0)
            throw new ResumerException();
    }
}

public class E09_While {
    public static void main(String args[]) {
        Resumer r = new Resumer();
        while(true) {
            try {
                r.f();
            } catch(ResumerException e) {
                System.out.println("Caught " + e);
                continue;
            }
            System.out.println("Got through...");
            break;
        }
        System.out.println("Successful execution");
    }
} ///:~
