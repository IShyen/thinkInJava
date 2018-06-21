//: c07:Sandwich.java
// Order of constructor calls.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
package com.sigar.think.c07;

import com.sigar.think.bruceeckel.simpletest.Test;

class Meal {
  Meal() { System.out.println("Meal()"); }
}

class Bread {
  Bread() { System.out.println("Bread()"); }
}

class Cheese {
  Cheese() { System.out.println("Cheese()"); }
}

class Lettuce {
  Lettuce() { System.out.println("Lettuce()"); }
}

class Lunch extends Meal {
  Lunch() { System.out.println("Lunch()");}
}

class PortableLunch extends Lunch {
  PortableLunch() {
    System.out.println("PortableLunch()");
  }
}

public class Sandwich extends PortableLunch {
  static Test monitor = new Test();
  Bread b = new Bread();
  Cheese c = new Cheese();
  Lettuce l = new Lettuce();

  Sandwich() { 
    System.out.println("Sandwich()");
  }

  public static void main(String[] args) {
    new Sandwich();
    monitor.expect(new String[] {
      "Meal()",
      "Lunch()",
      "PortableLunch()",
      "Bread()",
      "Cheese()",
      "Lettuce()",
      "Sandwich()"
    });
  }
} ///:~