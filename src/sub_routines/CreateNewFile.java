package sub_routines;

import java.io.File;
import java.io.IOException;

public class CreateNewFile {


    public void Create(String filename) throws IOException {
        File f = new File(filename);
        if (!f.exists()) {
            f.createNewFile();
            System.out.println(""+filename+" has been created");
        }
    }
}
