package com.sigar.think.c11;

/**
 * 仓鼠
 */
public class Hamster {
    private int hamsterNumber;

    public Hamster(int hamsterNumber){
        this.hamsterNumber = hamsterNumber;
    }

    public String toString(){
        return "This is Hamster # " + hamsterNumber;
    }
}
