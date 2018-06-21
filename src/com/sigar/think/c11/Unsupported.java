package com.sigar.think.c11;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * Sometimes methods defied in the Collection interface don't work.
 */
public class Unsupported {
    static List a = Arrays.asList("one two three four five six seven eight".split(" "));
    static List a2 = a.subList(3, 6);

    public static void main(String[] args){
        System.out.println(a);
        System.out.println(a2);
        System.out.println("a.contains(" + a.get(0) + ") = " + a.contains(a.get(0)));
        System.out.println("a.containsAll(a2)" + a.containsAll(a2));
        System.out.println("a.isEmpty() = " + a.isEmpty());
        System.out.println("a.indexOf( " + a.get(5) + ") = " + a.indexOf(a.get(5)));
        // Traverse backwards（向后倒退）:
        ListIterator lit = a.listIterator(a.size());
        while (lit.hasPrevious()){
            System.out.println(lit.previous() + " ");
        }
        System.out.println();
        // Set the elements to different values:
        for(int i=0; i<a.size(); i++){
            a.set(i, "47");
        }
        System.out.println(a);
        // Compiles, but won't run:
        lit.add("X");
        a.add("eleven");
        a.addAll(a2);
        a.retainAll(a2);
        a.remove(a.get(0));
        a.removeAll(a2);
    }
}
