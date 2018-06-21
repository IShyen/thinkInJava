package com.sigar.think.c11;


import java.util.*;

public class Printer {
    static void printAll(Iterator e){
        while(e.hasNext()){
            System.out.println(e.next());
        }
    }

    Collection coll;
    ListIterator li;
    List list;
    AbstractList alist;
}
