package com.tiny.java8.samples.concurrent;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * @author tiny.wang
 */
public class CompletableFuture0Test extends BasicOpr{

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
     * about run
     */
    @Test
    public void test2() {
        CompletableFuture.supplyAsync(this::supply).thenRun(this::supply);
        CompletableFuture.supplyAsync(this::supply).thenRunAsync(this::supply);
        CompletableFuture.supplyAsync(this::supply).thenRunAsync(this::supply, new ForkJoinPool());
    }

    /**
     * about runAfter
     */
    @Test
    public void test3() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(this::supply);
        CompletableFuture.supplyAsync(this::supply).runAfterBoth(future1, this::supply);
        CompletableFuture.supplyAsync(this::supply).runAfterBothAsync(future1, this::supply);
        CompletableFuture.supplyAsync(this::supply).runAfterBothAsync(future1, this::supply, new ForkJoinPool());
        CompletableFuture.supplyAsync(this::supply).runAfterEither(future1, this::supply);
        CompletableFuture.supplyAsync(this::supply).runAfterEitherAsync(future1, this::supply);
        CompletableFuture.supplyAsync(this::supply).runAfterEitherAsync(future1, this::supply, new ForkJoinPool());
    }

    /**
     * about combine
     */
    @Test
    public void test4() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(this::supply);
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> System.out.println(supply()));
        CompletableFuture.supplyAsync(this::supply).thenCombine(future2, this::combine);
        CompletableFuture.supplyAsync(this::supply).thenCombineAsync(future1, this::combine);
        CompletableFuture.supplyAsync(this::supply).thenCombineAsync(future1, this::combine, new ForkJoinPool());
    }

    /**
     * about compose
     */
    @Test
    public void test5() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(this::supply);
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> System.out.println(supply()));
        CompletableFuture.supplyAsync(this::supply).thenCompose(s -> future1);
        CompletableFuture.supplyAsync(this::supply).thenComposeAsync(s -> future2);
        CompletableFuture.supplyAsync(this::supply).thenComposeAsync(s -> future1, new ForkJoinPool());
    }

    /**
     * about handle
     */
    @Test
    public void test6() {
        CompletableFuture.supplyAsync(this::supply).handle(this::combine);
        CompletableFuture.supplyAsync(this::supply).handleAsync(this::combine);
        CompletableFuture.supplyAsync(this::supply).handleAsync(this::combine, new ForkJoinPool());
    }

    /**
     * about obtrude
     */
    @Test
    public void test7() {
        CompletableFuture.supplyAsync(this::supply).obtrudeException(new RuntimeException("obtrudeException"));
        CompletableFuture.supplyAsync(this::supply).obtrudeValue("obtrudeValue");
    }

    /**
     * about when
     */
    @Test
    public void test8() {
        CompletableFuture.supplyAsync(this::supply).whenComplete(this::combine);
        CompletableFuture.supplyAsync(this::supply).whenCompleteAsync(this::combine);
        CompletableFuture.supplyAsync(this::supply).whenCompleteAsync(this::combine, new ForkJoinPool());
    }

    /**
     * TODO
     * remain
     */
    @Test
    public void test9() throws Exception {
        CompletableFuture.supplyAsync(this::supply).isDone();
        CompletableFuture.supplyAsync(this::supply).isCancelled();
        CompletableFuture.supplyAsync(this::supply).isCompletedExceptionally();
        CompletableFuture.supplyAsync(this::supply).complete("te");
        CompletableFuture.supplyAsync(this::supply).cancel(true);
        CompletableFuture.supplyAsync(this::supply).get();
        CompletableFuture.supplyAsync(this::supply).get(1, TimeUnit.SECONDS);
        CompletableFuture.supplyAsync(this::supply).getNow(null);
        CompletableFuture.supplyAsync(this::supply).getNumberOfDependents();
        CompletableFuture.supplyAsync(this::supply).join();
        sleep(1000);
    }

    /**
     * TODO
     * about exception
     */
    @Test
    public void test10() {
        // true, may interrupt thread; false, thread execute completed normally
        boolean bool = CompletableFuture.supplyAsync(this::supply).thenRunAsync(() -> sleep(5_000)).completeExceptionally(new InterruptedException());
        System.out.println("bool = " + bool);
        CompletableFuture.supplyAsync(this::exception).exceptionally(ex -> {
            System.out.println(ex.toString());
            return "default";
        }).thenAccept(s -> System.out.println(s + "-q"));
        sleep(1000);
    }

}
