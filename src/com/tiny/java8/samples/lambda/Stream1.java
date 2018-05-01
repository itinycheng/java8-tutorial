package com.tiny.java8.samples.lambda;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author tiny.wang
 */
public class Stream1 {
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4).forEach(System.out::println);
        Stream.of(Arrays.asList(1, 2, 3, 4)).forEach(System.out::println);
        Stream.builder().add(1).add(2).add(3).add(4).build().forEach(System.out::println);
        Stream.concat(Stream.of(1, 2, 3, 4), Stream.of(1, 2, 3, 4)).forEach(System.out::println);
        Stream.empty().forEach(System.out::println);
        // unbounded
        Stream.iterate(1, i -> i * 2).forEach(System.out::println);
        Stream.generate(Math::random).forEach(System.out::println);
        // unreached
        System.exit(1);
    }
}
