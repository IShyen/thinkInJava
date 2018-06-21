package com.sigar.think.c07;//: c07:Transmogrify.java
// Dynamically changing the behavior of
// an object via composition.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

import com.sigar.think.bruceeckel.simpletest.Test;

abstract class Actor {
  abstract void act();
}

class HappyActor extends Actor {
  public void act() { 
    System.out.println("HappyActor"); 
  }
}

class SadActor extends Actor {
  public void act() { 
    System.out.println("SadActor");
  }
}

class Stage {
  Actor a = new HappyActor();
  void change() { a = new SadActor(); }
  void go() { a.act(); }
}

public class Transmogrify {
  static Test monitor = new Test();
  public static void main(String[] args) {
    Stage s = new Stage();
    s.go(); // Prints "HappyActor"
    s.change();
    s.go(); // Prints "SadActor"
    monitor.expect(new String[] {
      "HappyActor",
      "SadActor"
    });
  }
} ///:~