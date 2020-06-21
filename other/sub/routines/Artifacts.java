package sub.routines;

import java.io.File;

public class Artifacts {

    static sub.routines.Tools tools = new sub.routines.Tools();

    public MFile getMFile(File file){
        return new MFile(file);
    }



    public class MFile {
        public File file;
        public String md5;


        MFile(File file) {
            this.file = file;
            this.md5 = tools.getMd5(file.getPath());
        }
    }
}
