package com.sigar.think.c10;

class Candy{
    static {
        System.out.println("Loading Candy");
    }
}

class Gum{
    static {
        System.out.println("Loading Gum");
    }
}

class Cookie{
    static {
        System.out.println("Loading Cookie");
    }
}

public class SweetShop {
    public static void main(String[] args){
        System.out.println("inside main");
        new Candy();
        System.out.println("after creating Candy");
        try {
            Class.forName("com.sigar.think.c10.Gum");
        }catch (ClassNotFoundException e){
            System.out.println("Could't find Gum.");
        }
        System.out.println("After Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("after creating Cookie");
    }
}
