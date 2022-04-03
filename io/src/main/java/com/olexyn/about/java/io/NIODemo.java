package com.olexyn.about.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class NIODemo {
    
    public static final Path resources = Paths.get(System.getProperty("user.dir") + "/io/src/main/resources");
    
    static Path path1;
    static Path path2;
    static Path path3;
    static Path path4;

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
    
    static void resolve() {
        Path path1 = Paths.get("/foo/../bar");  // path with symbols
        Path path2 = Paths.get("baz");
        Path result = path1.resolve(path2); // /foo/../bar/baz
        
        path1 = Paths.get("/foo");
        path2 = Paths.get("bar"); // absolute path
        result = path1.resolve(path2); // /bar -> path1 is ignored because path2 is absolute

    }
    
    static void normalize() {
        path1 = Paths.get("E:\\data");
        path2 = Paths.get("E:\\user\\home");
        path3 = path1.relativize(path2); // ../user/home
        path4 = path1.resolve(path3); // E:\data\..\\user\home
        path4 = path4.normalize(); // E:\\user\home
        
    }
    
    static void exists() throws IOException {
        // calls toAbsolutePath()
        // calls normalize()
        // throws error if files does not exist
        // only path method to support NOFOLLOW_LINKS
        path2 = path1.toRealPath(LinkOption.NOFOLLOW_LINKS);
        // let wd be /horse/schedule
        // and sym link: /zebra/food.source -> /horse/food.txt
        path1 = Paths.get("/zebra/food.source").toRealPath(); // horse/food.txt
        path1 = Paths.get(".././food.txt").toRealPath(); // horse/food.txt
        path1 = Paths.get(".").toRealPath(); // fetch current working dir
        
    }

    /**
     * Files (nio.2 API) not to be confused with File (legacy java.io API).
     */
    static void files() throws IOException {
        Files.exists(path3);
        
        // 1. checks .equals() , if false -> 2.
        // 2. checks if files are the same -> IOException if one file does not exist
        //    this checks for same content, attributes, and location
        path1 = Paths.get("foo/bar.txt");
        path2 = Paths.get("baz/bar.txt");
        Files.isSameFile(path1,path2); // -> false, different location

    }
    
    static void create() throws IOException {
        // legacy
        new File("").mkdir();
        new File("").mkdirs(); // also creates parent dirs if needed.
        // nio2
        Files.createDirectory(path1); // throws IOEx
        Files.createDirectories(path1); // throws IOEx
        // copy is shallow, if used on dir, does not copy contents
        Files.copy(path1, path2); // throws IOEx
        Files.copy(path1, path2, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
        // 
        try (
            InputStream is = new FileInputStream(path1.toFile());
            OutputStream out = new FileOutputStream(path2.toFile() )) {
            Files.copy(is, path3);
            Files.copy(is, path3, StandardCopyOption.COPY_ATTRIBUTES);
            Files.copy(path3, out); // does not support options, since target not a file
        }
        
        // ATMOIC_MOVE will throw AtomicMoveNotSupportedException in not supported
        Files.move(path1, path3, StandardCopyOption.ATOMIC_MOVE);
        // DirectoryNotEmptyException if moving non-empty directory across drives
        Files.delete(path3);
        boolean b = Files.deleteIfExists(path2);
    }
    
    static void readWrite() {
        try (BufferedReader reader = Files.newBufferedReader(path2, Charset.defaultCharset())) {
            String currentLine = null;
            while((currentLine = reader.readLine()) != null)
                System.out.println(currentLine);
        } catch (IOException e) {
            
        }

        try (BufferedWriter writer = Files.newBufferedWriter(path2, Charset.defaultCharset())) {
            writer.write("");
        } catch (IOException e) {

        }
        
        try {
            final List<String> lines = Files.readAllLines(path2); // might cause OutOfMemoryError
        } catch (IOException e)  {
            
        }
    }
}
