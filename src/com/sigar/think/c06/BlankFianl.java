package com.sigar.think.c06;

/**
 * "Blank" final fields.
 */
class Poppet {
    private int i;

    Poppet(int ii){
        i = ii;
    }
}

public class BlankFianl{
    private final int i = 0;    // Initialized
    private final int j;        // Blank final
    private final Poppet p;     // Blank final reference

    // Blank final MUST be initialized in the constructor
    public BlankFianl(){
        j = 1;  // Initialized blank final.
        p = new Poppet(1);  // Initialized blank final reference.
    }

    public BlankFianl(int x){
        j = x;  // Initialized blank final.
        p = new Poppet(x);  // Initialized blank final reference.
    }

    public static void main(String[] args){
        new BlankFianl();
        new BlankFianl(47);
    }
}
