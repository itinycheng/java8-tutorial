package com.tiny.java8.samples.concurrent;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;

/**
 * @author tiny.wang
 */
public class CompletableFutureTest {
    @Test
    public void test0() {
        CompletableFuture.supplyAsync(this::supply);
    }

    private String supply() {
        return "supply";
    }
}
