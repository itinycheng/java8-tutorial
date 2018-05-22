package com.tiny.java8.samples.concurrent;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author tiny.wang
 */
public class CompletableFuture1Test extends BasicOpr {

    /**
     * number of uncompleted CompletableFuture
     */
    @Test
    public void test0() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(this::supply);
        CompletableFuture<String> origin = CompletableFuture.supplyAsync(this::supply);
        origin.thenApplyAsync(s -> combine(s, "next"));
        origin.thenAcceptAsync(s -> combine(s, "next"));
        origin.thenCombineAsync(future, this::combine);
        // sleep(1000);
        System.out.println("origin = " + origin.getNumberOfDependents());
    }

    /**
     * don't execute dependents where there appear an exception
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

    /**
     * handle & whenComplete is special: also execute when find exception
     */
    @Test
    public void test2() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(this::supply);
        // throw exception
        CompletableFuture<Void> cf1 = future.thenRun(this::exception);
        // no execute
        cf1.thenAccept(aVoid -> supply()).thenAccept(this::print);
        // execute
        cf1.whenComplete((aVoid, throwable) -> print(combine(aVoid, throwable)));
        cf1.handle((aVoid, throwable) -> combine(aVoid, throwable)).thenAccept(this::print);
        // other
        future.handle((s, throwable) -> combine(s, throwable)).thenAccept(this::print);
    }

    /**
     * DAG or DCG(mean:directly cycle graph;)
     */
    @Test
    public void test3() {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(this::supply);
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(this::supply);
        cf1.thenCombine(cf2, (s1, s2) -> combine(s1, s2)).thenAccept(this::print);
        cf2.thenCombine(cf1, (s1, s2) -> combine(s1, s2)).thenAccept(this::print);
    }

    /**
     * difference between get & join
     * get have checked exception
     * get can be interrupted
     */
    @Test
    public void test4() {
        // case 1
        String r1 = CompletableFuture.supplyAsync(this::supply).join();
        try {
            String r2 = CompletableFuture.supplyAsync(this::supply).get();
            System.out.println(r1.equals(r2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //TODO  case 2 unfinished
        try {
            print("---------------");
            CompletableFuture<Void> future1 = CompletableFuture.supplyAsync(this::supply).thenRunAsync(() -> sleep(90_000));
            CompletableFuture<Void> future2 = CompletableFuture.supplyAsync(this::supply).thenRunAsync(() -> sleep(90_000));
            CompletableFuture.runAsync(() -> {
                try {
                    print(future1.join());
                    print(future2.get());
                    // time out exception
                    print(future2.get(1, TimeUnit.SECONDS));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            // parameter of cancel never use
            future1.cancel(true);
            future2.cancel(true);
            print("end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
