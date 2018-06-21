package com.sigar.think.c11;

import java.util.BitSet;

public class Bit2 {
    public static void main(String[] args){
        BitSet bitSet = new BitSet(10000);
        bitSet.set(67);
        bitSet.set(64);
        System.out.println(bitSet);
        System.out.println("size: " + bitSet.size() + ", length: " + bitSet.length());
    }
}
