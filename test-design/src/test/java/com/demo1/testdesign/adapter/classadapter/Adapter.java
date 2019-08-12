package com.demo1.testdesign.adapter.classadapter;

public class Adapter extends Adaptee implements Target{
    @Override
    public void method2() {
        System.out.println("method 2");
    }
}
