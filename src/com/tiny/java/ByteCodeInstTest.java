package com.tiny.java;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * Instruction study
 *
 * @author tiny.wang
 */
public class ByteCodeInstTest {

    public static void main(String[] args) {
        Runnable r = () -> System.out.println(0);
        test();
    }

    public static void test() {
        System.out.println(1);
    }

    public void test0() {
        Stream.of(1, 2, 3)
                .filter(i -> i % 2 != 0)
                .reduce((i1, i2) -> i1 + i2)
                .orElse(0);
    }
}
