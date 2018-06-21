package com.sigar.other.maptest;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
    public static void main(String[] args){
//        int hashCode;
//        String testkey = "key_2";
//        String testkey2 = "key_2";
//
//        int h = testkey.hashCode();
//        int h2 = testkey2.hashCode();
//        int temp = h >>> 16;
//        int newHash = h ^ temp;
//        hashCode = newHash;
        int n = 17;
        n |= n >>> 1;
        System.out.println("n : " + n);
        n |= n >>> 2;
        System.out.println("n : " + n);
        n |= n >>> 4;
        System.out.println("n : " + n);
        n |= n >>> 8;
        System.out.println("n : " + n);
        n |= n >>> 16;
        System.out.println("n : " + n);

        HashMap<String, String> map = new HashMap<>();

        System.out.println(map.put("key_1", "value1"));
        System.out.println(map.put("key_1", "value2"));
        System.out.println(map.put("key_1", "value3"));
        System.out.println(map.put("key_1", "value4"));
        System.out.println(map.put("key_1", "value5"));

//        String value = map.get("key_1");
//        System.out.println("value: " + value);
    }
}
