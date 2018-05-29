package com.tiny.java8.samples.misc;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * TODO why not use zero-copy to replace stream
 *
 * @author tiny.wang
 */
public class Files1Test {
    @Test
    public void test0() throws IOException {
        try (FileOutputStream os = new FileOutputStream(Paths.get("res/tmp/create.js").toFile())) {
            Path path = Paths.get("res/nashorn1.js");
            int num = 10_000;
            long start = System.currentTimeMillis();
            for (int i = 0; i < num; i++) {
                Files.copy(path, os);
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }
    }

    @Test
    public void test1() throws IOException {
        try (FileOutputStream os = new FileOutputStream(Paths.get("res/tmp/create.js").toFile())) {
            Path path = Paths.get("res/nashorn1.js");
            File file = path.toFile();
            RandomAccessFile r = new RandomAccessFile(file, "r");
            FileChannel channel = r.getChannel();
            int num = 10_000;
            long start = System.currentTimeMillis();
            for (int i = 0; i < num; i++) {
                channel.transferTo(0, file.length(), os.getChannel());
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }
    }
}
