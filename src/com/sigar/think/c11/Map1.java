package com.sigar.think.c11;

import com.sigar.think.bruceeckel.util.Collections2;
import com.sigar.think.bruceeckel.util.CountryCapitals;

import java.util.*;

public class Map1 {
    private static Collections2.StringPairGenerator geo = Collections2.geography;
    private static Collections2.RandStringPairGenerator rsp = Collections2.rsp;

    // Producing a Set of the keys:
    public static void printKeys(Map map){
        System.out.print("Size = " + map.size() + ", ");
        System.out.print("Keys: ");
        System.out.println(map.keySet());
    }

    public static void test(Map map){
        System.out.println(map.getClass().getName());
        Collections2.fill(map, geo, 25);
        // Map has 'Set' behavior for keys:
        Collections2.fill(map, geo.reset(), 25);
        printKeys(map);
        // Producing a Collection of the values:
        System.out.print("Values:");
        System.out.println(map.values());
        System.out.println(map);

        String key = CountryCapitals.pairs[4][0];
        String value = CountryCapitals.pairs[4][1];
        System.out.println("map.containsKey(\"" + key + "\"): " + map.containsKey(key));
        System.out.println("map.get(\"" + key + "\"): " + map.get(key));
        System.out.println("map.containsValue(\"" + value + "\"): " + map.containsValue(value));

        Map map2 = new TreeMap();
        Collections2.fill(map2, rsp, 25);
        map.putAll(map2);
        printKeys(map);
        key = map.keySet().iterator().next().toString();
        System.out.println("First key in map: " + key);
        map.remove(key);
        printKeys(map);
        map.clear();
        System.out.println("map.isEmpty: " + map.isEmpty());
        Collections2.fill(map, geo.reset(), 25);
        // Operations on the Set change the Map:
        map.keySet().removeAll(map.keySet());
        System.out.println("map.isEmpty: " + map.isEmpty());

        System.out.println();
    }

    public static void main(String[] args){
        test(new HashMap());
        test(new TreeMap());
        test(new LinkedHashMap());
        test(new IdentityHashMap());
        test(new WeakHashMap());
    }
}
