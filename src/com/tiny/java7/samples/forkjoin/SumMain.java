package com.tiny.java7.samples.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

/**
 * @author tiny.wang
 */
public class SumMain {

    public static void main(String[] args) {
        try {
            List<Long> list = new ArrayList<>();
            LongStream.range(1, 10_000).peek(System.out::println).forEach(list::add);
            ForkJoinPool pool = new ForkJoinPool();
            ForkJoinTask<Long> submit = pool.submit(new SumTask(0, list.size(), list));
            System.out.println(submit.get() + " - " + list.stream().mapToLong(Long::longValue).sum());
            pool.shutdown();
            pool.awaitTermination(10L, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * recursive task
     *
     * @author tiny.wang
     */
    static class SumTask extends RecursiveTask<Long> {

        private static final int THRESHOLD = 1_000;

        private int start;

        private int end;

        private List<Long> list;

        SumTask(int start, int end, List<Long> list) {
            Objects.requireNonNull(list);
            this.start = start;
            this.end = end;
            this.list = list;
        }

        /**
         * The main computation performed by this task.
         *
         * @return the result of the computation
         */
        @Override
        protected Long compute() {
            if (end - start < THRESHOLD) {
                return list.subList(start, end).stream()
                        .mapToLong(Long::longValue)
                        .sum();
            } else {
                int middle = (start + end) / 2;
                SumTask task1 = new SumTask(start, middle, list);
                SumTask task2 = new SumTask(middle, end, list);
                task1.fork();
                task2.fork();
                return task1.join() + task2.join();
            }
        }
    }
}
