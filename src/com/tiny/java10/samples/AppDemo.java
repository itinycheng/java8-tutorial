package com.tiny.java10.samples;

import java.util.HashMap;

/**
 * @author tiny.wang
 */
public class AppDemo {
    public static void main(String[] args) {
        var i = 7;
        var map = new HashMap<>(2);
        map.put(1, "");
        map.put("1", "");
        System.out.println(map);
        String[] b = {""};
        b[test()] += "a";
    }

    private static int test(){
        System.out.println("test");
        return 0;
    }

    public AppDemo tes(){
        return this;
    }
}
