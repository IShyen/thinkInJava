package com.sigar.think.c12;

import com.sigar.think.bruceeckel.util.AlphabeticComparator;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Displays directory listing using regular expressions.
 */
public class DirList {
    public static void main(String[] args){
        File path = new File(".");
        String[] list;
        if(args.length == 0){
            list = path.list();
        }else{
            list = path.list(new DirFilter(args[0]));
        }

        Arrays.sort(list, new AlphabeticComparator());
        for(int i=0; i<list.length; i++){
            System.out.println(list[i]);
        }
    }
}

class DirFilter implements FilenameFilter{
    private Pattern pattern;

    public DirFilter(String regex){
        pattern = Pattern.compile(regex);
    }

    public boolean accept(File dir, String name){
        // Strip path information, search for regex:
        return pattern.matcher(new File(name).getName()).matches();
    }
}
