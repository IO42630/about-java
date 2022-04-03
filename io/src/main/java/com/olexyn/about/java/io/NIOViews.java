package com.olexyn.about.java.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributes;

public class NIOViews {

    static Path path = Paths.get("");

    static void test() throws IOException {
        BasicFileAttributes basic = Files.readAttributes(path, BasicFileAttributes.class); // read-only view
        basic.creationTime();
        basic.lastAccessTime();

        PosixFileAttributes posix = Files.readAttributes(path, PosixFileAttributes.class);
        posix.permissions(); // bonus method not available in basic/ or
        posix.fileKey(); // unique id of file in system, or null if not supported

        DosFileAttributes dos = Files.readAttributes(path, DosFileAttributes.class);
        dos.isReadOnly();
        dos.fileKey();

        BasicFileAttributeView basicView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        basic = basicView.readAttributes();
        basicView.setTimes(FileTime.fromMillis(10L), null, null); // values with null are not modified
    }
}
