package com.tiny.java;

/**
 * @author tiny.wang
 */
public class Exception1 {
    public static void main(String[] args) {
        new Exception1().recursiveException(0);
    }

    private void recursiveException(int index) {
        try {
            System.out.println(5 % 0);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("------------------");
            recursiveException(--index);
        }

    }
}
