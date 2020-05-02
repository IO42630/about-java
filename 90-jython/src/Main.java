import org.python.util.PythonInterpreter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String... args){
        final String dir = System.getProperty("user.dir");
        String data=null;

        try {
            File myObj = new File(dir+"/90-jython/src/script.py");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                 data = myReader.nextLine();

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try(PythonInterpreter pyInterp = new PythonInterpreter()) {
            assert data != null;
            pyInterp.exec(data);
        }

    }
}
