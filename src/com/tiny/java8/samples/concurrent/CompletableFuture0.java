package com.tiny.java8.samples.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

/**
 * @author tiny.wang
 */
public class CompletableFuture0 {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Object> future1 = CompletableFuture.supplyAsync(() -> sleep(1000));
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "async", new ForkJoinPool());
        CompletableFuture<String> future3 = CompletableFuture.completedFuture("completed");
        CompletableFuture<Void> future4 = CompletableFuture.runAsync(() -> System.out.println("sync"));
        CompletableFuture<Void> future5 = CompletableFuture.runAsync(() -> System.out.println("sync"), new ForkJoinPool());
        CompletableFuture.allOf(future1, future2, future3, future4, future5).thenRun(() -> System.out.println("allOf"));
        CompletableFuture.anyOf(future1, future2, future3, future4, future5).thenAccept(System.out::println);
        // waiting for 'allOf'
        sleep(1000);
    }

    private static Object sleep(long millis) {
        try {
            Thread.sleep(Math.max(0, millis));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Object();
    }
}
