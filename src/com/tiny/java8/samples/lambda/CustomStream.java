package com.tiny.java8.samples.lambda;

import java.util.Objects;

/**
 * non-delayed computation
 *
 * @author tiny.wang
 */
public class CustomStream {
    public static void main(String[] args) {
        UdStream.of(1, 2, 3, 4).forEach(System.out::println);
        UdStream.generate(Math::random).forEach(System.out::println);
    }

    @FunctionalInterface
    interface SupplierFun<T> {

        T get();

    }

    /**
     * @author tiny.wang
     */
    @FunctionalInterface
    interface ConsumerFun<T> {

        /**
         * consume
         *
         * @param t stream item
         */
        void consume(T t);

        default ConsumerFun<T> andThen(ConsumerFun fun) {
            return t -> {
                consume(t);
                fun.consume(t);
            };
        }
    }

    /**
     * @author tiny.wang
     */
    static class UdStream<T> {

        private T[] objects;

        public static <T> UdStream<T> of(T... t) {
            Objects.requireNonNull(t);
            return UdStreamSupport.stream(t);
        }

        public static <T> UdStream<T> generate(SupplierFun<T> fun) {
            Objects.requireNonNull(fun);
            return UdStreamSupport.stream(fun);
        }

        public void forEach(ConsumerFun<T> fun) {
            Objects.requireNonNull(fun);
            for (T obj : objects) {
                fun.consume(obj);
            }
        }
    }

    /**
     * supporter of stream generate
     */
    static class UdStreamSupport {

        public static <T> UdStream<T> stream(T... t) {
            Objects.requireNonNull(t);
            UdStream<T> stream = new UdStream<>();
            stream.objects = t;
            return stream;
        }

        /**
         * no cycle
         */
        public static <T> UdStream<T> stream(SupplierFun<T> fun) {
            return UdStreamSupport.stream(fun.get());
        }
    }
}
