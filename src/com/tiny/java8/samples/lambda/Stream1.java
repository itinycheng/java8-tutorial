package com.tiny.java8.samples.lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author tiny.wang
 */
public class Stream1 {
    public static void main(String[] args) {
        Double collect = Stream.of(1, 2, 3, 4).collect(Collectors.averagingInt(i -> i + 1));
        Double collect2 = Stream.of(1, 2, 3, 4).collect(Collectors.averagingDouble(value -> value + 1));
        Double collect3 = Stream.of(1, 2, 3, 4).collect(Collectors.averagingLong(value -> value + 1));
        Integer collect4 = Stream.of(1, 2, 3, 4).collect(Collectors.collectingAndThen(Collectors.averagingInt(value -> value), Double::intValue));
        Long collect5 = Stream.of(1, 2, 3, 4).map(i -> Arrays.asList(i, 0)).flatMap(Collection::stream).collect(Collectors.counting());
        Long collect6 = Stream.of(1, 2, 3, 4).collect(Collectors.filtering(t -> t < 0, Collectors.counting()));
        Integer collect7 = Stream.of(1, 2, 3, 4).map(i -> Arrays.asList(i)).collect(Collectors.flatMapping(Collection::stream, Collectors.summingInt(value -> value + 1)));
        Map<Integer, List<Integer>> collect8 = Stream.of(1, 2, 3, 4).collect(Collectors.groupingBy(o -> o % 3));
        ConcurrentMap<Boolean, List<Integer>> collect9 = Stream.of(1, 2, 3, 4).collect(Collectors.groupingByConcurrent(o -> o % 2 == 0));
        String collect10 = Stream.of(1, 2, 3, 4).map(String::valueOf).collect(Collectors.joining(","));
        String collect11 = Stream.of(1, 2, 3, 4).map(String::valueOf).collect(Collectors.joining());
        Integer collect12 = Stream.of(1, 2, 3, 4).collect(Collectors.mapping(o -> o + 1, Collectors.summingInt(value -> value)));
        Optional<Integer> collect13 = Stream.of(1, 2, 3, 4).collect(Collectors.maxBy(Integer::compare));
        Optional<Integer> collect14 = Stream.of(1, 2, 3, 4).collect(Collectors.minBy(Integer::compare));
        Map<Boolean, List<Integer>> collect15 = Stream.of(1, 2, 3, 4).collect(Collectors.partitioningBy(o -> o % 2 == 0));
        Optional<Integer> collect16 = Stream.of(1, 2, 3, 4).collect(Collectors.reducing((o1, o2) -> o1 * o2));
        Integer collect17 = Stream.of(1, 2, 3, 4).collect(Collectors.summingInt(value -> value + 1));
        IntSummaryStatistics collect1 = Stream.of(1, 2, 3, 4).collect(Collectors.summarizingInt(i -> i + 1));
        List<Integer> collect18 = Stream.of(1, 2, 3, 4).collect(Collectors.toList());
        List<Integer> collect21 = Stream.of(1, 2, 3, 4).collect(Collectors.toUnmodifiableList());
        Set<Integer> collect20 = Stream.of(1, 2, 3, 4).collect(Collectors.toSet());
        Set<Integer> collect22 = Stream.of(1, 2, 3, 4).collect(Collectors.toUnmodifiableSet());
        Map<Integer, String> collect19 = Stream.of(1, 2, 3, 4).collect(Collectors.toMap(o -> o, String::valueOf));
        Map<Integer, String> collect23 = Stream.of(1, 2, 3, 4).collect(Collectors.toUnmodifiableMap(o -> o, String::valueOf));
        HashSet<Integer> collect24 = Stream.of(1, 2, 3, 4).collect(Collectors.toCollection(HashSet::new));
        System.exit(1);
    }
}
