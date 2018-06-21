//: c07:music3:Music3.java
// An extensible program.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
package com.sigar.think.c07.practice;

//: c07:E03_MusicToString.java
//+M java E03_MusicToString
/****************** Exercise 16 *****************
 * Change Music3.java so that what() becomes the
 * root Object method toString(). Try printing
 * the Instrument objects using
 * System.out.println() (without any casting).
 ***********************************************/
class Instrument {
  public void play() {
    System.out.println("Instrument.play()");
  }
  public String toString() {
    return "Instrument";
  }
  public void adjust() {}
}

class Wind extends Instrument {
  public void play() {
    System.out.println("Wind.play()");
  }
  public String toString() {
    return "Wind";
  }
  public void adjust() {}
}

class Percussion extends Instrument {
  public void play() {
    System.out.println("Percussion.play()");
  }
  public String toString() {
    return "Percussion";
  }
  public void adjust() {}
}

class Stringed extends Instrument {
  public void play() {
    System.out.println("Stringed.play()");
  }
  public String toString() {
    return "Stringed";
  }
  public void adjust() {}
}

class Brass extends Wind {
  public void play() {
    System.out.println("Brass.play()");
  }
  public void adjust() {
    System.out.println("Brass.adjust()");
  }
}

class Woodwind extends Wind {
  public void play() {
    System.out.println("Woodwind.play()");
  }
  public String toString() {
    return "Woodwind";
  }
}

public class Music3 {
  static Instrument[] orchestra = {
          new Wind(),
          new Percussion(),
          new Stringed(),
          new Brass(),
          new Woodwind()
  };
  public static void printAll(Instrument[] orch){
    for(int i = 0; i < orch.length; i++)
      System.out.println(orch[i]);
  }
  public static void main(String args[]) {
    printAll(orchestra);
  }
}