package com.sigar.think.c11;

import com.sigar.think.bruceeckel.util.Collections2;

import java.util.LinkedHashMap;

/**
 * what you can do with a LinkedHashMap
 */
public class LinkedHashMapDemo {
    public static void main(String[] args){
        LinkedHashMap linkedMap = new LinkedHashMap();
        Collections2.fill(linkedMap, SimplePairGenerator.gen, 10);
        System.out.println(linkedMap);
        // Least-recently used order:
        // 0.75f为负载因子
        // 如果负载因子是0.75，hashmap(16)最多可以存储12个元素，想存第16个就得扩容成32。
        // 如果负载因子是1，hashmap(16)最多可以存储16个元素。
        linkedMap = new LinkedHashMap(16, 0.75f, true);
        Collections2.fill(linkedMap, SimplePairGenerator.gen, 10);
        System.out.println(linkedMap);

        for(int i=0; i<7; i++){
            linkedMap.get(SimplePairGenerator.gen.items[i].key);
        }
        System.out.println(linkedMap);
        linkedMap.get(SimplePairGenerator.gen.items[0].key);
        System.out.println(linkedMap);
    }
}
