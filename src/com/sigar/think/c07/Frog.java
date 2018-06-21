package com.sigar.think.c07;//: c07:Frog.java
// Testing finalize with inheritance.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

import com.sigar.think.bruceeckel.simpletest.Test;

class DoBaseFinalization {
  public static boolean flag = false;
}

/**
 * 特征
 */
class Characteristic {
  String s;
  Characteristic(String c) {
    s = c;
    System.out.println("Creating Characteristic " + s);
  }
  protected void finalize() {
    System.out.println("finalizing Characteristic " + s);
  }
}

/**
 * 生物
 */
class LivingCreature {
  Characteristic p = new Characteristic("is alive");

  LivingCreature() {
    System.out.println("LivingCreature()");
  }

  protected void finalize() throws Throwable {
    System.out.println("LivingCreature finalize");
    // Call base-class version LAST!
    if(DoBaseFinalization.flag)
      super.finalize();
  }
}

/**
 * 动物
 */
class Animal extends LivingCreature {
  Characteristic p = new Characteristic("has heart");

  Animal() {
    System.out.println("Animal()");
  }

  protected void finalize() throws Throwable {
    System.out.println("Animal finalize");
    if(DoBaseFinalization.flag)
      super.finalize();
  }
}

/**
 * 两栖动物
 */
class Amphibian extends Animal {
  Characteristic p = new Characteristic("can live in water");

  Amphibian() {
    System.out.println("Amphibian()");
  }

  protected void finalize() throws Throwable {
    System.out.println("Amphibian finalize");
    if(DoBaseFinalization.flag)
      super.finalize();
  }
}

/**
 * 青蛙
 */
public class Frog extends Amphibian {
  static Test monitor = new Test();

  Frog() {
    System.out.println("Frog()");
  }

  protected void finalize() throws Throwable {
    System.out.println("Frog finalize");
    if(DoBaseFinalization.flag)
      super.finalize();
  }

  public static void main(String[] args) {
    if(args.length != 0 && args[0].equals("finalize")){
      DoBaseFinalization.flag = true;
    }else{
      System.out.println("Not finalizing bases");
    }

    new Frog(); // Instantly becomes garbage
    System.out.println("Bye!");

    // Force finalizers to be called:
    System.gc();

    monitor.expect(new String[] {
      "Not finalizing bases",
      "Creating Characteristic is alive",
      "LivingCreature()",
      "Creating Characteristic has heart",
      "Animal()",
      "Creating Characteristic can live in water",
      "Amphibian()",
      "Frog()",
      "Bye!",
      "Frog finalize",
      "finalizing Characteristic is alive",
      "finalizing Characteristic has heart",
      "finalizing Characteristic can live in water"
      }, Test.IGNORE_ORDER + Test.DELAY_SHORT);
  }
} ///:~
