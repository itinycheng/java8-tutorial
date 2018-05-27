package com.tiny.java8.samples.misc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tiny.wang
 */
public class Annotation0 {

    public static void main(String[] args) throws NoSuchMethodException {
        @Ann1 Map<@Ann1 String, Object> map = new @Ann1 HashMap<>(1);
        Hit annotation = Person.class.getAnnotation(Hit.class);
        System.out.println(annotation);

        Hits annotation1 = Person.class.getAnnotation(Hits.class);
        System.out.println(annotation1);

        Hit[] annotationsByType = Person.class.getAnnotationsByType(Hit.class);
        System.out.println(annotationsByType.length);

        System.out.println("end");
    }

    private <T> void print(@Ann1 T obj) {
        System.out.println(obj);
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
    @interface Ann1 {
    }

    @Repeatable(Hits.class)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Hit {
        String value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface Hits {
        Hit[] value();
    }

    @Hit("one")
    @Hit("two")
    class Person<@Ann1 T> {
        public void work(@Ann1 T t) {
            System.out.println(t);
        }
    }

    class Coder<@Ann1 T> extends @Ann1 Person<@Ann1 T> {
        public @Ann1 T code(@Ann1 T t) throws @Ann1 Exception {
            return t;
        }
    }
}
