package com.tiny.java8.samples.lambda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * IntStream
 *
 * @author tiny.wang
 */
public class IntStream0 {

    public static void main(String[] args) {
        String main = Arrays.stream(new int[][]{new int[]{1, 7, 6, 2}, new int[]{3, 6, 5, 8, 4}})
                // flatMap Stream<Integer> to IntStream, related function[flatMap]
                .flatMapToInt(Arrays::stream)
                // filter
                .filter(i -> i % 2 == 0).peek(i -> System.out.println("filter-" + i))
                // add 1, & print
                .map(i -> i + 1).peek(i -> System.out.println("map-" + i))
                // transform to non IntStream, related function[mapToLong, mapToDouble]
                .mapToObj(i -> i + "")
                .mapToInt(Integer::parseInt)
                // distinct & print
                .distinct().peek(str -> System.out.println("distinct-" + str))
                // sort
                .sorted().peek(str -> System.out.println("sorted-" + str))
                .limit(3).peek(str -> System.out.println("limit-" + str))
                .skip(1).peek(str -> System.out.println("skip-" + str))
                // action function[count, forEach, forEachOrdered,toArray, sum, min, max, average,reduce,
                // allMatch, anyMatch, noneMatch,findFirst, findAny, summaryStatistics]
                .collect(() -> "tes",
                        (str, i) -> System.out.println(str + i),
                        (s, s2) -> System.out.println(s + s2));
        System.out.println("main=" + main);

        // summaryStatistics[getMin, getMax etc..]
        IntSummaryStatistics statistics = Arrays.stream(new int[]{1, 2, 3}).filter(i -> i % 2 == 0).summaryStatistics();
        System.out.println("max=" + statistics.getMax() + ",average=" + statistics.getAverage());

        // reduce,find any element as begin
        OptionalInt reduce = Arrays.stream(new int[]{1, 2, 3}).reduce((left, right) -> left + right);
        reduce.ifPresent(i -> System.out.println("reduce=" + i));

        // terminal operator
        boolean allMatch = Arrays.stream(new int[]{1, 2, 3}).allMatch(i -> i % 2 == 0);
        System.out.println("allMatch=" + allMatch);

        // terminal operator
        boolean anyMatch = Arrays.stream(new int[]{1, 2, 3}).anyMatch(i -> i % 2 == 0);
        System.out.println("anyMatch=" + anyMatch);

        // terminal operator
        boolean noneMatch = Arrays.stream(new int[]{1, 3}).noneMatch(i -> i % 2 == 0);
        System.out.println("noneMatch=" + noneMatch);

        // terminal operator, seems can't reverse order
        OptionalInt findFirst = Arrays.stream(new int[]{1, 0, 3}).sorted().findFirst();
        findFirst.ifPresent(i -> System.out.println("findFirst=" + i));

        // terminal operator, maximal performance in parallel operations, but result is unpredictable
        OptionalInt findAny = Arrays.stream(new int[]{1, 0, 4, 3}).parallel().findAny();
        findAny.ifPresent(i -> System.out.println("findAny=" + i));

        // asDoubleStream asLongStream
        Arrays.stream(new int[]{1, 3, 2, 4}).asLongStream().boxed().mapToInt(Long::intValue).forEach(System.out::println);

        // sequential against with parallel
        // maybe useful when receive a stream that you don't know it's parallel or sequential
        Arrays.stream(new int[]{6, 7, 1, 3, 2, 4})
                .parallel().peek(i -> System.out.println("parallel=" + i))
                .sequential().peek(i -> System.out.println("sequential=" + i)).forEach(i -> {
        });

        // method override tip
        Arrays.stream(new int[]{1, 4, 2, 7}).iterator().forEachRemaining((int i) -> System.out.println("iterator=" + i));

        // TODO spliterator, detailed usage
        Arrays.stream(new int[]{1, 4, 2, 7}).spliterator().tryAdvance((int i) -> System.out.println("spliterator=" + i));

        // generate IntStream
        java.util.stream.IntStream.builder().add(1).add(2).build().forEach(i -> System.out.println("builder=" + i));
        java.util.stream.IntStream.generate(() -> ((int) Math.random())).limit(2).forEach(i -> System.out.println("generate=" + i));
        java.util.stream.IntStream.iterate(1, i -> i + 1).limit(2).forEach(i -> System.out.println("iterate=" + i));
        java.util.stream.IntStream.of(1, 2, 3).forEach(i -> System.out.println("of=" + i));
        java.util.stream.IntStream.range(1, 3).forEach(i -> System.out.println("range=" + i));
        java.util.stream.IntStream.rangeClosed(1, 3).forEach(i -> System.out.println("rangeClosed=" + i));
        java.util.stream.IntStream.concat(Arrays.stream(new int[]{1, 2}), Arrays.stream(new int[]{1, 3})).forEach(i -> System.out.println("concat=" + i));
        // empty
        java.util.stream.IntStream.empty().forEach(System.out::println);

    }
}
