package com.tiny.java;

/**
 * @author tiny.wang
 */
public class InstanceOf0 {

    public static void main(String[] args) {
        Child child = new Child();
        Parent parent = new Parent();
        System.out.println(child instanceof Parent);
        System.out.println(child instanceof Child);
        System.out.println(child instanceof Unity);
        System.out.println(parent instanceof Child);
    }

    interface Unity {

    }

    static class Parent {

    }

    static class Child extends Parent implements Unity {

    }
}
