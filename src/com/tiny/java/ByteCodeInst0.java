package com.tiny.java;

import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Instruction study
 *
 * @author tiny.wang
 */
public class ByteCodeInst0 {

    private static String fd = null;

    public static void main(String[] args) {
        Runnable r = () -> System.out.println(0);
        Consumer<String> c = (a) -> System.out.println(a);
        test();
        test0();
        test1();
    }

    public static void test() {
        System.out.println(1);
    }

    public static void test0() {
        Stream.of(1, 2, 3)
                .filter(i -> i % 2 != 0)
                .reduce((i1, i2) -> i1 + i2)
                .orElse(0);
    }

    /**
     * try catch performance
     */
    public static void test1() {
        try {
            System.out.println(fd);
        } catch (Exception e) {
        }
    }
}
