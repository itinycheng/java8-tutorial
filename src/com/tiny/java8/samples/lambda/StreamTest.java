package com.tiny.java8.samples.lambda;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * @author tiny.wang
 */
public class StreamTest {

    /**
     * secondary stream never exec
     */
    @Test
    public void test0() {
        Stream.concat(Stream.iterate(1, i -> i), Stream.generate(Math::random))
                .forEach(System.out::println);
    }
}
