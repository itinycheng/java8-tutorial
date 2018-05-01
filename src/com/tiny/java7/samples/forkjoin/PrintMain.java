package com.tiny.java7.samples.forkjoin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

/**
 * @author tiny.wang
 */
public class PrintMain {

    public static void main(String[] args) throws InterruptedException {
        List<Long> list = new ArrayList<>();
        LongStream.range(1, 10_000).forEach(list::add);
        ForkJoinPool pool = new ForkJoinPool();
        PrintAction action = new PrintAction(0, list.size(), list);
        pool.submit(action);
        System.out.println(
                action.isCompletedAbnormally() ? action.getException() : null);
        pool.shutdown();
        pool.awaitTermination(60, TimeUnit.SECONDS);
    }

    /**
     * recursive action
     *
     * @author tiny.wang
     */
    static class PrintAction extends RecursiveAction {

        private static final int THRESHOLD = 1_000;

        private int start;

        private int end;

        private List<Long> list;

        PrintAction(int start, int end, List<Long> list) {
            Objects.requireNonNull(list);
            this.start = start;
            this.end = end;
            this.list = list;
        }

        /**
         * code syntax test
         */
        public static void main(String[] args) {
            List<Long> lis;
            int len = ((lis = new PrintAction(1, 1, Arrays.asList(1L, 2L)).list) != null
                    ? lis.size() : 0);
            System.out.println(len);
        }

        /**
         * The main computation performed by this task.
         */
        @Override
        protected void compute() {
            if (end - start < THRESHOLD) {
                list.subList(start, end)
                        .forEach(item -> System.out.println(Thread.currentThread().getName() + "-" + item));
            } else {
                int middle = (start + end) / 2;
                PrintAction action1 = new PrintAction(start, middle, list);
                PrintAction action2 = new PrintAction(middle, end, list);
                action1.fork();
                action2.fork();
            }
        }
    }

}
