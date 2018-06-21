package com.sigar.think.c11;

import java.util.*;

// Things you can do with Sets.
public class Set1 {
    static void fill(Set s){
        s.addAll(Arrays.asList("one tow three four five six seven".split(" ")));
    }

    public static void test(Set s){
        // Strip qualifiers from class name:
        System.out.println(s.getClass().getName());
//        System.out.println(s.getClass().getName().replaceAll("\\w+\\.", ""));
        fill(s);
        fill(s);
        fill(s);
        System.out.println(s);

        // Add another set to this one:
        s.addAll(s);
        s.add("one");
        s.add("one");
        s.add("one");
        System.out.println(s);
        // Look something up:
        System.out.println("s.contains(\"one\"): " + s.contains("one"));
        System.out.println();
    }

    public static void main(String[] args){
        test(new HashSet());
        test(new TreeSet());
        test(new LinkedHashSet());
    }
}
