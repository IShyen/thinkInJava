package com.sigar.think.c11;

import com.sigar.think.bruceeckel.util.Collections2;

import java.util.*;

/**
 * Things you can do with Lists
 */
public class List1 {
    public static List fill(List a){
        Collections2.countries.reset();
        Collections2.fill(a, Collections2.countries, 10);
        return a;
    }

    public static boolean b;
    public static Object o;
    public static int i;
    public static Iterator it;
    public static ListIterator lit;

    public static void basicTest(List a){
        a.add(1, "x");
        a.add("x");
        a.addAll(fill(new ArrayList()));
        a.addAll(3, fill(new ArrayList()));

        b = a.contains("1");
        b = a.containsAll(fill(new ArrayList()));

        o = a.get(1);
        i = a.indexOf("1");
        b = a.isEmpty();
        it = a.iterator();
        lit = a.listIterator();
        lit = a.listIterator(3);
        i = a.lastIndexOf("1");
        a.remove(1);
        a.remove("3");
        a.set(1,"y");

        a.retainAll(fill(new ArrayList()));

        a.removeAll(fill(new ArrayList()));

        i = a.size();
        a.clear();
    }

    public static void iterMotion(List a){
        ListIterator it = a.listIterator();
        b = it.hasNext();
        b = it.hasPrevious();
        o = it.next();
        i = it.nextIndex();
        o = it.previous();
        i = it.previousIndex();
    }

    public static void iterManipulation(List a){
        ListIterator it = a.listIterator();
        it.add("47");
        // Must move to an element after add():
        it.next();
        // Remove the element that was just produced:
        it.remove();
        // Must move to an element after remove():
        it.next();
        // Change the element that was just produced:
        it.set("47");
    }

    public static void testVisual(List a){
        System.out.println(a);
        List b = new ArrayList();
        fill(b);
        System.out.println("b = " );
        System.out.println(b);
        a.addAll(b);
        a.addAll(fill(new ArrayList()));
        System.out.println(a);
        // Insert, remove, and replace elements using a ListIterator:
        ListIterator x = a.listIterator(a.size()/2);
        x.add("one");
        System.out.println(a);
        System.out.println(x.next());
        x.remove();
        System.out.println(x.next());
        x.set("47");
        System.out.println(a);
        // Traverse the list backwards:
        x = a.listIterator(a.size());
        while (x.hasPrevious()){
            System.out.println(x.previous() + "");
        }
        System.out.println();
        System.out.println("testVisual finished.");
    }

    public static void testLinkedList(){
        LinkedList ll = new LinkedList();
        fill(ll);
        System.out.println(ll);
        // Treat it like a stack, pushing:
        ll.addFirst("one");
        ll.addLast("tow");
        System.out.println(ll);
        // Like "peeking" at the top of a stack:
        System.out.println(ll.getFirst());
        // Like "popping" a stack:
        System.out.println(ll.removeFirst());
        System.out.println(ll.removeFirst());
        // Treat it like a queue, pulling elements off the tail end:
        System.out.println(ll.removeLast());
        // With the above operations, it's a dequeue!
        System.out.println(ll);
    }

    public static void main(String[] args){
        // Make and fill a new list each time:
//        basicTest(fill(new LinkedList()));
//        basicTest(fill(new ArrayList()));
//        iterMotion(fill(new LinkedList()));
//        iterMotion(fill(new ArrayList()));
        iterManipulation(fill(new LinkedList()));
        iterManipulation(fill(new ArrayList()));
//        testVisual(fill(new LinkedList()));
//        testLinkedList();
    }
}
