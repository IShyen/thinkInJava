package com.sigar.think.c11;

import com.sigar.think.bruceeckel.util.AlphabeticComparator;
import com.sigar.think.bruceeckel.util.Arrays2;

import java.util.Arrays;

public class StringSorting {
    public static void main(String[] args){
        String[] sa = new String[30];
        Arrays2.fill(sa, new Arrays2.RandStringGenerator(5));
        System.out.println("Before sorting: " + Arrays.asList(sa));
        Arrays.sort(sa, new AlphabeticComparator());
        System.out.println("After sorting: " + Arrays.asList(sa));
    }
}
