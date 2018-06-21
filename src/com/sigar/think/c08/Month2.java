//: c08:Month2.java
// A more robust enumeration system.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
package com.sigar.think.c08;
import com.sigar.think.bruceeckel.simpletest.*;

public final class Month2 {
  static Test monitor = new Test();
  private String name;
  private int order;
  private Month2(int ord, String nm) {
    order = ord;
    name = nm;
  }
  public String toString() { return name; }
  public final static Month2
    JAN = new Month2(1, "January"),
    FEB = new Month2(2, "February"),
    MAR = new Month2(3, "March"),
    APR = new Month2(4, "April"),
    MAY = new Month2(5, "May"),
    JUN = new Month2(6, "June"),
    JUL = new Month2(7, "July"),
    AUG = new Month2(8, "August"),
    SEP = new Month2(9, "September"),
    OCT = new Month2(10, "October"),
    NOV = new Month2(11, "November"),
    DEC = new Month2(12, "December");
  public final static Month2[] month =  {
    JAN, FEB, MAR, APR, MAY, JUN,
    JUL, AUG, SEP, OCT, NOV, DEC
  };
  public final static Month2 number(int ord) {
    return month[ord - 1];
  }
  public static void main(String[] args) {

    Month2 m = Month2.JAN;
    System.out.println(m);
    m = Month2.number(12);
    System.out.println(m);
    System.out.println(m == Month2.DEC);
    System.out.println(m.equals(Month2.DEC));

    monitor.expect(new String[] {
      "January",
      "December",
      "true",
      "true"
    });
  }
} ///:~