package com.sigar.think.c11;

import java.util.Arrays;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo {
    public static void main(String[] args){
        SortedSet sortedSet = new TreeSet(Arrays.asList("one tow three four five six seven eight".split(" ")));
        System.out.println(sortedSet);
        Object low = sortedSet.first();
        Object high = sortedSet.last();
        System.out.println("low: " + low);
        System.out.println("high:" + high);

        Iterator it = sortedSet.iterator();
        for(int i=0; i<6; i++){
            if(i==3){
                low = it.next();
            }
            if(i==6){
                high = it.next();
            }else{
                it.next();
            }
        }

        System.out.println("low: " + low);
        System.out.println("high: " + high);
        System.out.println(sortedSet.subSet(low, high));
        System.out.println(sortedSet.headSet(high));
        System.out.println(sortedSet.tailSet(low));
    }
}
