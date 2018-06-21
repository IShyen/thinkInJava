package com.sigar.think.c11;

import java.util.Map;

/**
 * A new type of Map.Entry.
 */
public class MPair implements Map.Entry, Comparable{
    private Object key, value;

    public MPair(Object k, Object v){
        key = k;
        value = v;
    }

    @Override
    public Object getKey(){
        return key;
    }

    @Override
    public Object getValue(){
        return value;
    }

    @Override
    public Object setValue(Object v){
        Object result = value;
        value = v;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return key.equals(((MPair)obj).key);
    }

    @Override
    public int compareTo(Object rv){
        return ((Comparable)key).compareTo(((MPair)rv).key);
    }
}
