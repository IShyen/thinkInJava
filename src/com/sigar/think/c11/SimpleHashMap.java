package com.sigar.think.c11;

import com.sigar.think.bruceeckel.util.Collections2;

import java.util.*;

/**
 * A demonstration hashed map.
 * 示范怎么制作一个HashMap
 */
public class SimpleHashMap extends AbstractMap {
    // Choose a prime number for the hash table size, to achieve a uniform distribution:
    // 选择一个素数作为哈希表的大小，以达到均匀分布的目地。
    private static final int SZ = 3;

    // 散列表
    private LinkedList[] bucket = new LinkedList[SZ];

    @Override
    public Object put(Object key, Object value){
        Object result = null;
        int index = key.hashCode() % SZ;
        if(index < 0){
            index = -index;
        }
        if(bucket[index] == null){
            bucket[index] = new LinkedList();
        }

        LinkedList pairs = bucket[index];
        MPair pair = new MPair(key,value);
        ListIterator it = pairs.listIterator();

        boolean found = false;
        while (it.hasNext()){
            Object iPair = it.next();
            if(iPair.equals(pair)){
                result = ((MPair)iPair).getValue();
                it.set(pair);
                found = true;
                break;
            }
        }

        if(!found){
            bucket[index].add(pair);
        }

        return result;
    }

    @Override
    public Object get(Object key){
        int index = key.hashCode() % SZ;
        if(index<0){
            index = -index;
        }
        LinkedList pairs = bucket[index];
        MPair match = new MPair(key, null);
        ListIterator it = pairs.listIterator();
        while(it.hasNext()){
            Object iPair = it.next();
            if(iPair.equals(match)){
                return ((MPair)iPair).getValue();
            }
        }
        return null;
    }

    public Set entrySet(){
        Set entries = new HashSet();
        for(int i=0; i<bucket.length; i++){
            if(bucket[i] == null){
                continue;
            }
            Iterator it = bucket[i].iterator();
            while(it.hasNext()){
                entries.add(it.next());
            }
        }
        return entries;
    }

    public static void main(String[] args){
        SimpleHashMap m = new SimpleHashMap();
        m.put("China", "Beijing");
        m.put("China", "Shanghai");
        m.put("China", "Hangzhou");
        m.put("China", "Nanjing");
        m.put("China", "Suzhou");
        m.put("America", "WS.dc");
        m.put("England", "London");
        m.put("Japan", "Tokoy");
        m.put("Russia", "Mosco");

        m.get("China");
//        Collections2.fill(m, Collections2.geography, 25);
//        System.out.println(m);
    }
}
