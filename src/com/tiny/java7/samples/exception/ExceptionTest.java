package com.tiny.java7.samples.exception;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author tiny.wang
 */
public class ExceptionTest {

    @Test
    public void test0() {
        long start = System.currentTimeMillis();
        final int cycle = 100_000;
        for (int i = 0; i < cycle; i++) {
            new RuntimeException("dd");
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    @Test
    public void test1() {
        long start = System.currentTimeMillis();
        final int cycle = 100_000;
        for (int i = 0; i < cycle; i++) {
            new HashMap<String, String>(1);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
