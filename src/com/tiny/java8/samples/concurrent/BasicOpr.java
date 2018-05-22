package com.tiny.java8.samples.concurrent;

/**
 * @author tiny.wang
 */
public class BasicOpr {

    protected String supply() {
        return Thread.currentThread().getName() + "-supply";
    }

    protected String exception() {
        throw new RuntimeException("exception");
    }

    protected String combine(Object o1, Object o2) {
        return o1 + ", " + o2;
    }

    protected String sleep(long millis) {
        try {
            Thread.sleep(Math.max(0, millis));
            return "sleep:" + millis;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected <T> void print(T o) {
        System.out.println(o);
    }

    protected void interrupt() {
        Thread.currentThread().interrupt();
    }
}
