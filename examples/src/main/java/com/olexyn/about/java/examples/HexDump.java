package com.olexyn.about.java.examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 * @author ivo
 */
public class HexDump {

    public static void main(String[] args) throws IOException {
        
        int perLine = 16;
        int lines = 400;
        
        // Do we have at least one argument?
        if (args.length<1) {
            System.out.println("Give at least a file as an argument!");
            System.exit(-1);   // Abort with error
        }
        
        Path p = Paths.get(args[0]);
        // Does this file exist?
        if (Files.exists(p)) {
            // Read all bytes 
            byte[] bytes = Files.readAllBytes(p);
            // space to build the lines
            StringBuilder hex = new StringBuilder();
            StringBuilder ascii = new StringBuilder();
            // Produce the output
            for (int b=0; b<bytes.length && b<perLine*lines; b++) {
                hex.append(String.format("%02x ",bytes[b]));
                if (bytes[b]>=32 && bytes[b]<127) {
                    ascii.append((char)bytes[b]);
                } else {
                    ascii.append('.');
                }
                if (b%4==3) {
                    hex.append(" ");
                    ascii.append(" ");
                }
                if (b%perLine==(perLine-1) || b == bytes.length-1 || b==perLine*lines-1) {
                    System.out.format("0x%04x | %s| %s |%n",b-perLine+1,hex,ascii);
                    hex.delete(0, hex.length());
                    ascii.delete(0, ascii.length());
                }
            }
        } else { // File does not exist
            System.out.format("Cannot find file %s!%n",p);
        }        
    }
}
