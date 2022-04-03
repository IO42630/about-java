package com.olexyn.about.java.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SerializationDemo {

    static String dir = System.getProperty("user.dir") + "/io/src/main/java/com/olexyn/about/java/io/";

    public static List<Foo> getAnimals(File dataFile) throws IOException, ClassNotFoundException {
        List<Foo> foos = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
            while (true) {
                Object object = in.readObject();
                if (object instanceof Foo) { foos.add((Foo) object); }
            }
        } catch (EOFException e) {
            // File end reached
        }
        return foos;
    }


    public static void createAnimalsFile(List<Foo> foos, File dataFile)
        throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))) {
            for (Foo foo : foos) { out.writeObject(foo); }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("SERIALIZING ---");

        List<Foo> foos = new ArrayList<Foo>();
        foos.add(new Foo("Foo1", 1, 'A'));
        foos.add(new Foo("Foo2", 2, 'B'));
        File dataFile = new File(dir + "foo.data");
        createAnimalsFile(foos, dataFile);

        System.out.println("DESERIALIZING ---");
        System.out.println(getAnimals(dataFile));
        // [Foo [name=Foo1, number=0, letter=B], Foo [name=Foo2, number=0, letter=B]]
        // name is deserialized properly
        // number is set to default value as it is transient
        // letter is fetched from class, here it was last assigned B

    }

}

class Bar { Bar() { System.out.println("Bar()"); } }

class Skipped extends Bar implements Serializable { Skipped() { System.out.println("Skipped()"); } }

class Foo extends Skipped implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private transient int number;
    private static char letter;

    public Foo() { System.out.println("Foo()"); }

    public Foo(String name, int number, char letter) {
        this.name = name;
        this.number = number;
        this.letter = letter;
    }

    public String toString() {
        return "Foo [name=" + name + ", number=" + number + ", letter=" + letter + "]";
    }
}
