package com.tiny.java8.samples.concurrent;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;

/**
 * @author tiny.wang
 */
public class CompletableFuture1Test {

    /**
     * number of uncompleted CompletableFuture
     */
    @Test
    public void test0() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(this::supply);
        CompletableFuture<String> origin = CompletableFuture.supplyAsync(this::supply);
        origin.thenApplyAsync(s -> combine(s, "next"));
        origin.thenAccept(s -> combine(s, "next"));
        origin.thenCombineAsync(future, (s1, s2) -> combine(s1, s2));
        // sleep(1000);
        System.out.println("origin = " + origin.getNumberOfDependents());
    }

    /**
     */
    @Test
    public void test1() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(this::supply);
        // case 1
        future.thenApply(s -> supply()).thenAccept(this::print);
        future.thenApply(s -> exception()).thenAccept(this::print);
        // case 2
        future.completeExceptionally(new RuntimeException("exception"));
        future.thenAccept(this::print);
    }

    private String supply() {
        return Thread.currentThread().getName() + "-supply";
    }

    public String exception() {
        throw new RuntimeException("exception");
    }

    private String combine(Object... os) {
        String s = null;
        for (Object o : os) {
            s += o.toString() + ",";
        }
        sleep(1000);
        return s;
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(Math.max(0, millis));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void print(Object o) {
        System.out.println(o.toString());
    }
}
