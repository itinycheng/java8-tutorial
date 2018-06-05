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
    public void test6() {
        Stream.of(1, 2, 3, 4).peek(System.out::println)
                .limit(4)
                .filter(i -> i % 3 == 0)
                .limit(1)
                .forEach(System.out::println);
    }

    @Test
    public void test4() {
        Stream.of(1, 2, 3, 4).map(i -> i % (i - 3)).forEach(System.out::println);
    }

    @Test
    public void test5() throws InterruptedException {
        Stream.of(1, 2, 3, 4).parallel().map(i -> i % (i - 3)).forEach(System.out::println);
        Thread.sleep(1000L);
    }

    /**
     * position of limit case diff result
     */
    @Test
    public void test7() {
        Stream.generate(Math::random)
                .parallel()
                .sorted()
                .limit(100)
                .forEach(d -> System.out.println(Thread.currentThread() + "," + d));
    }

    /**
     * exec model change, not from start to end;
     * split into two stages by sorted
     */
    @Test
    public void test8() {
        Stream.of(1, 4, 2, 3, 9)
                .limit(100)
                .peek(System.out::println)
                .sorted()
                .forEach(i -> System.out.println(Thread.currentThread() + ", " + i));
    }

    /**
     * diff with fun of sorted
     */
    @Test
    public void test9() {
        Stream.of(1, 4, 2, 3, 9, 1)
                .peek(System.out::println)
                .distinct()
                .forEach(i -> System.out.println("step2, " + i));
    }
}
