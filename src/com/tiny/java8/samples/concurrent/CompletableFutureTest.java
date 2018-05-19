package com.tiny.java8.samples.concurrent;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

/**
 * @author tiny.wang
 */
public class CompletableFutureTest {

    /**
     * about accept
     */
    @Test
    public void test0() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(this::supply);
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> System.out.println(supply()));
        CompletableFuture.supplyAsync(this::supply).thenAccept(System.out::println);
        CompletableFuture.supplyAsync(this::supply).thenAcceptAsync(System.out::println);
        CompletableFuture.supplyAsync(this::supply).thenAcceptAsync(System.out::println, new ForkJoinPool());
        CompletableFuture.supplyAsync(this::supply).thenAcceptBoth(future1, (s1, s2) -> System.out.println(combine(s1, s2)));
        CompletableFuture.supplyAsync(this::supply).thenAcceptBothAsync(future1, (s1, s2) -> System.out.println(combine(s1, s2)));
        CompletableFuture.supplyAsync(this::supply).thenAcceptBothAsync(future2, (s1, s2) -> System.out.println(combine(s1, s2)), new ForkJoinPool());
        // either, can't make sure whether current CompletableFuture is completed, so can't name it with 'then' prefix.
        CompletableFuture.supplyAsync(this::supply).acceptEither(future1, System.out::println);
        CompletableFuture.supplyAsync(this::supply).acceptEitherAsync(future1, System.out::println);
        CompletableFuture.supplyAsync(this::supply).acceptEitherAsync(future1, System.out::println, new ForkJoinPool());
    }

    /**
     * about apply
     */
    @Test
    public void test1() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(this::supply);
        CompletableFuture.supplyAsync(this::supply).thenApply(s -> supply());
        CompletableFuture.supplyAsync(this::supply).thenApplyAsync(s -> supply());
        CompletableFuture.supplyAsync(this::supply).thenApplyAsync(s -> supply(), new ForkJoinPool());
        // either,just like accept either, but why have extra word 'to', shouldn't the naming be consistent;
        CompletableFuture.supplyAsync(this::supply).applyToEither(future1, s -> supply());
        CompletableFuture.supplyAsync(this::supply).applyToEitherAsync(future1, s -> supply());
        CompletableFuture.supplyAsync(this::supply).applyToEitherAsync(future1, s -> supply(), new ForkJoinPool());
    }

    /**
     * complete, cancel
     */
    @Test
    public void test2() {
        CompletableFuture.supplyAsync(this::supply).complete("complete");
        CompletableFuture.supplyAsync(this::supply).cancel(true);
    }

    /**
     * about run
     */
    @Test
    public void test3() {
        CompletableFuture.supplyAsync(this::supply).thenRun(this::supply);
        CompletableFuture.supplyAsync(this::supply).thenRunAsync(this::supply);
        CompletableFuture.supplyAsync(this::supply).thenRunAsync(this::supply, new ForkJoinPool());
    }

    /**
     * TODO
     * about exception
     */
    @Test
    public void test4() {
        CompletableFuture.supplyAsync(this::supply).completeExceptionally(new InterruptedException());
        CompletableFuture.supplyAsync(this::supply).exceptionally(ex -> ex.toString());
    }

    private String supply() {
        return Thread.currentThread().getName() + "-supply";
    }

    private String combine(Object o1, Object o2) {
        return o1 + ", " + o2;
    }

    ;
}
