//: c08:controller:Event.java
// The common methods for any control event.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
package com.sigar.think.c08.controller;

public abstract class Event {
  private long eventTime;
  protected Long delayTime;

  public Event(long delayTime) {
    this.delayTime = delayTime;
  }

  public void start(){
    eventTime = System.currentTimeMillis() + delayTime;
  }

  public boolean ready() {
    return System.currentTimeMillis() >= eventTime;
  }

  public String description(){
    return "eventTime: " + eventTime + ", delayTime: " + delayTime;
  }

  abstract public void action();
} ///:~