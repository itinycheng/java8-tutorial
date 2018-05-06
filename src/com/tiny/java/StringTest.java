package com.tiny.java;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Set;

/**
 * @author tiny.wang
 */
public class StringTest {

    @Test
    public void test0() {
        System.out.println("testing");
        "abc".contains("bcd");
    }

    @Test
    public void test1() {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("1.2.3", 1);
        map.put("5.4.6", 1);
        map.put("4.6.5.e", 1);
        map.put("3.4.6.9", 1);
        map.put("2.3.e", 1);
        map.put("4.f", 1);
        map.put("8.7.g", 1);
        map.put("9.1.6.h", 1);
        Set<String> set = map.keySet();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            for (String s : set) {
                map.get(s);
                break;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    @Test
    public void test2() {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("2.2.4", 1);
        map.put("2.4.6", 1);
        map.put("2.2.5.e", 1);
        map.put("2.2.6.9", 1);
        map.put("2.2.e", 1);
        map.put("2.3.5", 1);
        map.put("2.3.7.g", 1);
        map.put("2.3.6.h", 1);
        Set<String> set = map.keySet();
        long start = System.currentTimeMillis();
        String str = "2.3.e";
        for (int i = 0; i < 10000; i++) {
            for (String s : set) {
                s.equals(str);
                break;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
