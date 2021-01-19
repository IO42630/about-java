package com.olexyn.about.java.io;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIODemo {
    
    public static final Path resources = Paths.get(System.getProperty("user.dir") + "/io/src/main/resources");

    public static void main(String... args){
        // pathNames();
        // rootTraversal();
        conversions();
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
    
    static void rootTraversal() {
        Path path = Paths.get(resources.toString(), "foo.txt");

        Path foo = path.getFileName(); // foo.txt
        Path fooRoot = path.getFileName().getRoot(); // always null as this is a relative path
        Path root = path.getRoot();    // C:\
        
        while((path = path.getParent()) != null) {
            int br = 0;                // C:\Users\iol -> C:\Users -> C:\ -> break
        }
    }
    
    static void conversions() {
        resources.getFileName().isAbsolute(); // false
        resources.getFileName().toAbsolutePath().isAbsolute(); // true
        
        Path originalRes = resources;
        Path newRes = resources.subpath(0, resources.getNameCount());
        
        boolean b = originalRes.toString().equals(resources.getRoot().toString() + newRes); // true
        // subpath ignores root
        
        // resources.subpath(0, resources.getNameCount() + 1); // R-Exception
        //resources.subpath(1,1); // R-Exception
        int br = 0;
    }
    
    static void relativize() {
        // returns path of param as relative path as if viewed from current file
        Path currentPath = resources.getParent();
        Path otherPath = resources;
        Path otherRelativeToCurrent = currentPath.relativize(otherPath);
        
        // relativize requires both Paths to be either absolute or relative, else R-Exception
        // in windows also requires same root if absolute
    }
}
