package com.olexyn.about.java.io;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIODemo {

    public static void main(String... args){
        pathNames();
    }



    static void pathsDemo() throws URISyntaxException {

        // String examples
        Path path = Paths.get("foo/bar.png"); // relative path
        path = Paths.get("c:\\foo\\bar.png"); // absolute path win
        path = Paths.get("/foo/bar.png"); // absolute path linux

        // String... examples
        path = Paths.get("foo", "bar.png"); // inserts system specific separator
        path = Paths.get("c:", "foo", "bar.png"); // still need c:
        path = Paths.get("/", "foo", "bar.png"); // still need /

        // URI examples
        path = Paths.get(new URI("file:///foo/bar.png"));
        path = Paths.get(new URI("ftp://user:pwd@ftp.olexyn.com"));

        // reverse URI
        URI uri = path.toUri();

        // compatibility methods
        File file = path.toFile();
        path = file.toPath();

        path.toString();
        path.getNameCount();

    }



    static void pathNames() {
        Path path = Paths.get(System.getProperty("user.home") + "/docs");

        for(int i=0; i<path.getNameCount(); i++) {
            System.out.println(path.getName(i)); // index starts with 0
        }

        int foo = Paths.get("/").getNameCount(); // 0

        int br = 0;



    }
}
