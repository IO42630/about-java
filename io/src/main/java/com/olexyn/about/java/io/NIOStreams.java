package com.olexyn.about.java.io;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIOStreams {

    static Path path = Paths.get("");

    static void test() throws IOException {
        Files.walk(path).filter(p -> p.toString().endsWith(".java")).forEach(System.out::println);
        // default depth is Integer.MAX_VALUE
        // can be specified
        Files.walk(path, 2); // does not follow sym-links
        Files.walk(path, 2, FileVisitOption.FOLLOW_LINKS); // will mark dirs as visited and FileSystemLoopException is revisit detected

        Files.find(
            path,
            2,
            (p,attribute) ->
                p.toString().endsWith(".java")
                && attribute.lastModifiedTime().toMillis() > 2L,
            FileVisitOption.FOLLOW_LINKS)
            .forEach(System.out::println);
    }
}
