package com.sigar.think.c11;

/**
 * 天气预报
 */
public class Prediction {
    private boolean shadow = Math.random() > 0.5;

    public String toString(){
        if (shadow){
            return "Six more weeks of Winter!";
        }else{
            return "Early Spring";
        }
    }

}
