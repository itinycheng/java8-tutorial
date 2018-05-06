package com.tiny.java8.samples.lambda;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author tiny.wang
 */
public class Stream0 {
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4).forEach(System.out::println);
        Stream.of(Arrays.asList(1, 2, 3, 4)).forEach(System.out::println);
        Stream.builder().add(1).add(2).add(3).add(4).build().forEach(System.out::println);
        Stream.concat(Stream.of(1, 2, 3, 4), Stream.of(5, 6, 7, 8)).forEach(System.out::println);
        Stream.empty().forEach(System.out::println);
        // unbounded when without limit
        Stream.iterate(1, i -> i * 2).limit(4).forEach(System.out::println);
        Stream.generate(Math::random).limit(4).forEach(System.out::println);
        Arrays.stream(new int[]{5, 6, 7, 8}, 0, 2).forEach(System.out::println);
        // limit use test
        Stream.of(1, 2, 3, 4, 5, 6, 7).peek(System.out::println).filter(i -> i % 2 != 0).limit(2).forEach(System.out::println);
        System.exit(1);
    }
}
