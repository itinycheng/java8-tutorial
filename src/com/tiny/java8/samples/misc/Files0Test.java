package com.tiny.java8.samples.misc;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

/**
 * walk file tree
 *
 * @author tiny.wang
 */
public class Files0Test {
    @Test
    public void test0() throws IOException {
        CommonFileVisitor visitor = new CommonFileVisitor();
        Files.walkFileTree(Paths.get("res"), visitor);
        StringJoiner joiner = new StringJoiner(",");
        for (String s : visitor.getNames()) {
            joiner.add(s);
        }
        String collect = joiner.toString();
        System.out.println(collect);
    }

    class CommonFileVisitor extends SimpleFileVisitor<Path> {

        private final List<String> names = new LinkedList<>();

        List<String> getNames() {
            return names;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            System.out.println("pre");
            names.add(String.valueOf(dir));
            return super.preVisitDirectory(dir, attrs);
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println("visit");
            names.add(String.valueOf(file));
            return super.visitFile(file, attrs);
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            System.out.println("failed");
            return super.visitFileFailed(file, exc);
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            System.out.println("post");
            return super.postVisitDirectory(dir, exc);
        }
    }
}
