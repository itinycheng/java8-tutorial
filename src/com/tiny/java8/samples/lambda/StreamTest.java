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

    @Test
    public void test1() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8).parallel().forEach(System.out::println);
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8).parallel().forEachOrdered(System.out::println);
    }

    @Test
    public void test2() {
        Stream.of(1, 2, 3, 4).peek(System.out::println).forEach(System.out::println);
    }

    @Test
    public void test3() {
        Stream.of(1, 2, 3, 4).peek(System.out::println)
                .limit(2)
                .forEach(System.out::println);
    }

    @Test
    public void test4(){
        Stream.of(1,2,3,4).map(i -> i % (i - 3)).forEach(System.out::println);
    }

    @Test
    public void test5() throws InterruptedException {
        Stream.of(1,2,3,4).parallel().map(i -> i % (i - 3)).forEach(System.out::println);
        Thread.sleep(1000L);
    }

}
