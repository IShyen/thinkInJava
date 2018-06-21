package com.sigar.think.c11;

import java.util.WeakHashMap;

/**
 * Demonstrates（演示） WeakHashMap
 */
class Key{
    private String ident;

    public Key(String id){
        ident = id;
    }

    public String toString(){
        return ident;
    }

    public int hashCode(){
        return ident.hashCode();
    }

    public boolean equals(Object r){
        return (r instanceof Key) && ident.equals(((Key)r).ident);
    }

    public void finalize(){
        System.out.println("Finalizing Key " + ident);
    }
}

class Value{
    private String ident;

    public Value(String id){
        ident = id;
    }

    public String toString(){
        return ident;
    }

    public void finalize(){
        System.out.println("Finalizing Value " + ident);
    }

}

public class CanonicalMapping {
    public static void main(String[] args){
        int size = 10;
        // Or, choose size via the command line:
        if(args.length>0){
            size = Integer.parseInt(args[0]);
        }

        Key[] keys = new Key[size];
        WeakHashMap map = new WeakHashMap();
        for(int i=0; i<size; i++){
            Key k = new Key(Integer.toString(i));
            Value v = new Value(Integer.toString(i));
            if(i % 3 == 0){
                keys[i] = k;
            }
            map.put(k, v);
        }

        System.gc();
    }
}
