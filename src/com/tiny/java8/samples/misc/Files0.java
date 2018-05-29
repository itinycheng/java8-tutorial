package com.tiny.java8.samples.misc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author tiny.wang
 */
public class Files0 {

    public static void main(String[] args) throws IOException {
        fileLine();
        listFile();
        newBufReader();
        newBUfWriter();
        findFile();
        walkFile();
        readAllLines();
        writeToFile();
        fileCopy();
        createDirAndFile();
        createLink();
        deleteFile();
        fileGet();
        other();
    }

    private static void fileGet() throws IOException {
        Path path = Paths.get("res/nashorn1.js");
        // windows un support
        // Set<PosixFilePermission> posixFilePermissions = Files.getPosixFilePermissions(path);
        // Object basic = Files.getAttribute(path, "basic");
        // BasicFileAttributes fileAttributeView = Files.getFileAttributeView(path, BasicFileAttributes.class);
        FileStore fileStore = Files.getFileStore(path);
        FileTime lastModifiedTime = Files.getLastModifiedTime(path);
        UserPrincipal owner = Files.getOwner(path);
        System.out.println("end");
    }

    private static void deleteFile() throws IOException {
        Path path = Paths.get("res/tmp/create1.js");
        if (Files.exists(path)) {
            Files.delete(Paths.get("res/tmp/create.js"));
            Files.delete(Paths.get("res/tmp"));
            Files.deleteIfExists(Paths.get("res/tmp"));
        }
    }

    private static void createLink() throws IOException {
        Files.createLink(Paths.get("res/link"), Paths.get("res/nashorn1.js"));
        // TODO symbol ?
        // Files.createSymbolicLink(Paths.get("res/symbol"), Paths.get("res/nashorn1.js"));
    }

    private static void createDirAndFile() throws IOException {
        Files.createDirectories(Paths.get("res/tmp"));
        Files.createFile(Paths.get("res/tmp/create.js"));
        // TODO temp mean what
        Files.createTempFile(Paths.get("res/tmp"), "tmp", "js");
        Files.createTempDirectory(Paths.get("res"), "tmp0");
    }

    private static void fileCopy() throws IOException {
        try (OutputStream outputStream = new FileOutputStream(Paths.get("res/output.js").toFile())) {
            Files.copy(Paths.get("res/nashorn2.js"), outputStream);
        }
    }

    private static void other() throws IOException {
        Path file = Paths.get("res/output.js");
        Path file1 = Paths.get("res/output.js");
        Files.isDirectory(file);
        Files.isExecutable(file);
        Files.isHidden(file);
        Files.isReadable(file);
        Files.isWritable(file);
        Files.isRegularFile(file);
        Files.isSameFile(file, file1);
        Files.isSymbolicLink(file);
        long size = Files.size(Paths.get("res/output.js"));
        System.out.println(size);
    }

    private static void writeToFile() throws IOException {
        List<String> list = readAllLines();
        list.add("alert('word')");
        Files.write(Paths.get("res/output.js"), list, Charset.forName("utf-8"));
    }

    private static List<String> readAllLines() throws IOException {
        List<String> list = Files.readAllLines(Paths.get("res/nashorn1.js"));
        list.forEach(System.out::println);
        return list;
    }

    private static void walkFile() throws IOException {
        try (Stream<Path> stream = Files.walk(Paths.get(""), 2)) {
            String collect = stream.map(String::valueOf)
                    .filter(s -> s.endsWith(".js"))
                    .sorted()
                    .collect(Collectors.joining(","));
            System.out.println(collect);
        }
    }

    private static void findFile() throws IOException {
        BiPredicate<Path, BasicFileAttributes> matcher = (path, attr) -> String.valueOf(path).endsWith(".js") && !attr.isDirectory();
        try (Stream<Path> stream = Files.find(Paths.get(""), 2, matcher)) {
            String collect = stream.sorted().map(String::valueOf).collect(Collectors.joining(","));
            System.out.println(collect);
        }
    }

    private static void newBUfWriter() throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("res/output.js"))) {
            writer.write("alert('Hello World');");
        }
    }

    private static void listFile() throws IOException {
        try (Stream<Path> stream = Files.list(Paths.get("res"))) {
            stream.limit(1).forEach(path -> System.out.println(path.toFile().getName()));
        }
    }

    private static void fileLine() throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get("res/nashorn1.js"))) {
            stream.limit(1).forEach(System.out::println);
        }
    }

    private static void newBufReader() throws IOException {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("res/nashorn1.js"))) {
            bufferedReader.lines().limit(1).forEach(System.out::println);
        }
    }
}
