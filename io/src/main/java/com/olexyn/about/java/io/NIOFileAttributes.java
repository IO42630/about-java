package com.olexyn.about.java.io;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;

public class NIOFileAttributes {

    static Path path = Paths.get("");
    static boolean b = false;
    static long l = 0L;

    static void test() {
        b = Files.isDirectory(path);
        b = Files.isRegularFile(path); // not dir/resource, and not sym-link to dir/resource
        b = Files.isSymbolicLink(path); // none of these throw Ex
        b = Files.isReadable(path);
        b = Files.isExecutable(path);
    }



    static void theseThrow() throws IOException {
        Files.isHidden(path);
        l = Files.size(path); // size of file in bytes
    }

    static void times() throws IOException {
        FileTime fileTime = null;
        fileTime = Files.getLastModifiedTime(path);
        l = fileTime.toMillis();
        l = System.currentTimeMillis();
        Files.setLastModifiedTime(path, FileTime.fromMillis(l));
    }

    static void owner() throws IOException {
        UserPrincipal user = Files.getOwner(path);

        UserPrincipal user2 = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("user");
    }

}
