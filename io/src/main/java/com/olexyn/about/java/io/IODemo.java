package com.olexyn.about.java.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class IODemo {

    static String s;
    static Boolean b;
    static Long l;



    public static void main(String... args) throws IOException {
        s = System.getProperty("file.separator");
        s = File.separator; // equivalent
        utilityMethods();
        DemoByteArrayStream.readUsage();
    }


    static void utilityMethods() {
        File parent = new File(File.separator + "home/user/tmp");
        b = parent.exists();
        File child = new File(parent, "test");
        File isNull = null;
        File test = new File(isNull, "/home/user/tmp"); // just calls tmp
        int br = 0;

        s = child.getName();
        s = child.getAbsolutePath();
        b = child.isDirectory();    // true
        b = child.isFile();         // false
        l = child.length();         // number of bytes in file
        l = child.lastModified();
        b = child.delete();         // true if success
        b = child.mkdir();          // true if success
        File subDir = new File(child, "sub/dir");
        b = subDir.mkdir();         // true if succes, creates intermiediary dirs
        s = subDir.getParent();     // path of "sub"
        File[] files = child.getParentFile().listFiles(); // lists files of tmp
    }



    static void ioStreams() throws IOException {
        InputStream foo = new ObjectInputStream(new BufferedInputStream(new FileInputStream("")));
        if (foo.markSupported()) {
            foo.mark(23);
            foo.reset();
        }
        BufferedReader asd = new BufferedReader(new FileReader(""));
        BufferedWriter dfa = new BufferedWriter(new FileWriter(""));
        PrintWriter gg = null;
        PrintStream asdff = null;


        FileInputStream fileInputStream = new FileInputStream("");
        FileOutputStream fileOutputStream = new FileOutputStream(new File(""));
        fileInputStream.read();
        fileInputStream.read(new byte[]{1, 0});
        fileOutputStream.write(1);
        byte bt = 0;
        fileOutputStream.write(new byte[]{1, 0});


    }

    static class DemoByteArrayStream {

        public static void copy() throws IOException {
            byte[] source = new byte[]{0, 1, 0};
            byte[] buffer = new byte[2];
            try (InputStream in = new ByteArrayInputStream(source);
                OutputStream destination = new ByteArrayOutputStream()) {
                int bytesPresent;
                while ((bytesPresent = in.read(buffer)) != -1) {
                    destination.write(buffer, 0, bytesPresent); // from OutputStream
                    destination.write(buffer); // equiv to .write(buffer, 0, buffer.length
                    // thus might write additional 0s if the last buffer frame overshoots the source
                }
            }
        }

        public static void readUsage() throws IOException {
            byte[] source = new byte[]{0, 1, 0};
            byte[] zeroBytesBuffer = new byte[0];
            byte[] oneBytesBuffer = new byte[1];
            byte[] twoBytesBuffer = new byte[2];
            byte[] threeBytesBuffer = new byte[3];
            try (InputStream in = new ByteArrayInputStream(source);
                OutputStream destination = new ByteArrayOutputStream()) {
                in.markSupported(); // true
                in.mark(100);
                int bytesPresent;
                bytesPresent = in.read(threeBytesBuffer); // 3
                bytesPresent = in.read(oneBytesBuffer); // -1
                in.reset();
                bytesPresent = in.read(oneBytesBuffer); // 1
                bytesPresent = in.read(threeBytesBuffer); // 2
                bytesPresent = in.read(twoBytesBuffer); // -1
                in.reset();
                bytesPresent = in.read(zeroBytesBuffer); // 0

                destination.write(zeroBytesBuffer, 0, bytesPresent);
            }
        }
    }


    static class DemoFileStream {

        public static void copy(File source, File destination) throws IOException {
            try (InputStream in = new FileInputStream(source);
                OutputStream out = new FileOutputStream(destination)) {
                int b;
                while ((b = in.read()) != -1) {
                    out.write(b);
                }
            }
        }

    }



    static class DemoBufferedFileStream {

        public static void copy(File source, File destination) throws IOException {
            try (InputStream in = new FileInputStream(source);
                OutputStream out = new BufferedOutputStream(new FileOutputStream(destination))) {
                byte[] buffer = new byte[1024];
                int bytesPresent;
                while ((bytesPresent = in.read(buffer)) != -1) {
                    out.write(bytesPresent);
                    out.flush();
                }
            }
        }

    }







        static class DemoBufferedFileRW {

            public static List<String> read(File source) throws IOException {
                List<String> data = new ArrayList<>();
                try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
                    String stringToRead;
                    while((stringToRead = reader.readLine()) != null) {
                        data.add(stringToRead);
                    }
                }
                return data;
            }

            public static void write(List<String> data, File destination) throws IOException {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
                    for(String stringToWrite: data) {
                        writer.write(stringToWrite); // from Writer
                        writer.newLine(); // from BufferedWriter
                    }
                }
            }
        }


}
