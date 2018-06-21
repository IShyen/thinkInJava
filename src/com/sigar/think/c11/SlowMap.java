package com.sigar.think.c11;

import com.sigar.think.bruceeckel.util.Collections2;

import java.util.*;

/**
 * A map implemented with ArrayList
 */
public class SlowMap extends AbstractMap {
    private List keys = new ArrayList();
    private List values = new ArrayList();

    @Override
    public Object put(Object key, Object value){
        Object result = get(key);
        if(!keys.contains(key)){
            keys.add(key);
            values.add(value);
        }else{
            values.set(keys.indexOf(key), value);
        }

        return result;
    }

    @Override
    public Object get(Object key){
        if(!keys.contains(key)){
            return null;
        }else{
            return values.get(keys.indexOf(key));
        }
    }

    @Override
    public Set entrySet(){
        Set entries = new HashSet();
        Iterator ki = keys.iterator();
        Iterator vi = values.iterator();

        while (ki.hasNext()){
            entries.add(new MPair(ki.next(), vi.next()));
        }
        return entries;
    }

    @Override
    public String toString(){
        StringBuffer s = new StringBuffer("{");
        Iterator ki = keys.iterator();
        Iterator vi = values.iterator();
        while (ki.hasNext()){
            s.append(ki.next() + "=" + vi.next());
            if(ki.hasNext()){
                s.append(",");
            }
        }
        s.append("}");
        return s.toString();
    }

    public static void main(String[] args){
        SlowMap m = new SlowMap();
        Collections2.fill(m, Collections2.geography, 15);
        Set entry = m.entrySet();
        System.out.println("map: "+m);
        System.out.println("entry: " + entry);
    }
}
