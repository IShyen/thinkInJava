package com.sigar.think.c11;

import com.sigar.think.bruceeckel.util.Collections2;
import com.sigar.think.bruceeckel.util.CountryCapitals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Collection1 {
    public static void main(String[] args){
//        Collection c9 = new ArrayList();
//        c9.add("door");
//        c9.add("zppo");
//        c9.add("alert");
//        c9.add("more");
//        System.out.println(Collections.max(c9));
//        System.out.println(Collections.min(c9));

        Collection c = new ArrayList();
        Collections2.fill(c, Collections2.countries, 5);
        c.add("eleven");
        c.add("ten");
        System.out.println(c);

        // Make an array from the list:
        Object[] array = c.toArray();
        // Make a String array from the List:
        String[] str = (String[]) c.toArray(new String[1]);
        //Find max an min elements; this means different things depending on the way the Comparable interface is implemented:
        System.out.println("Collection.max(c) = " + Collections.max(c));
        System.out.println("Collection.min(c) = " + Collections.min(c));
        // Add a Collection to another  Collection
        Collection c2 = new ArrayList();
        Collections2.fill(c2, Collections2.countries, 5);
        c.add(c2);
        System.out.println(c);
        c.remove(CountryCapitals.pairs[0][0]);
        System.out.println(c);
        c.remove(CountryCapitals.pairs[0][1]);
        System.out.println(c);
        // Remove all components that are in the argument collection:
        c.remove(c2);
        System.out.println(c);
        c.addAll(c2);
        System.out.println(c);
        // Is an element in this Collection?
        String va1 = CountryCapitals.pairs[3][0];
        System.out.println("c.containsAll(c2) = " + c.contains(va1));
        Collection c3 = ((ArrayList) c).subList(3,5);
        System.out.println("c3:" + c3);
        // Keep all the elements that are in both c2 and c3(an intersection of sets):
        System.out.println("Before retailAll c2:" + c2);
        c2.retainAll(c3);
        System.out.println("After retailAll c2:" + c2);
        System.out.println(c);
        // Throw away all the elements in c2 that also appear in c3:
        c2.removeAll(c3);
        System.out.println("c.isEmpty() = " + c.isEmpty());
        c = new ArrayList();
        Collections2.fill(c, Collections2.countries, 5);
        System.out.println(c);
        c.clear(); // Remove all elements.
        System.out.println("After c.clear():");
        System.out.println(c);
    }
}
