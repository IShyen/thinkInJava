package com.sigar.think.c11;

import java.util.ArrayList;
import java.util.List;

/**
 * 仓鼠迷宫
 */
public class HamsterMaze {
    public static void main(String[] args){
        List list = new ArrayList();
        for(int i=0; i<3; i++){
            list.add(new Hamster(i));
        }

        Printer.printAll(list.iterator());
    }
}
