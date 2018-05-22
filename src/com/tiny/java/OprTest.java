package com.tiny.java;

import org.junit.Test;

/**
 * @author tiny.wang
 */
public class OprTest {
    @Test
    public void test0() {
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

    static class Child extends Parent implements Unity{

    }
}
