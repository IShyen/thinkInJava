package com.sigar.think.c11;

import com.sigar.think.bruceeckel.util.Collections2;

import java.util.Iterator;
import java.util.TreeMap;

public class SortedMapDemo {
    public static void main(String[] args){
        TreeMap sortedMap = new TreeMap();
        Collections2.fill(sortedMap, SimplePairGenerator.gen, 10);
        Object low = sortedMap.firstKey();
        Object high = sortedMap.lastKey();
        System.out.println("low: " + low);
        System.out.println("high: " + high);
        Iterator it = sortedMap.keySet().iterator();
        for(int i =0; i<=6; i++){
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
        System.out.println(sortedMap.subMap(low, high));
        System.out.println(sortedMap.headMap(high));
        System.out.println(sortedMap.tailMap(low));
    }
}
