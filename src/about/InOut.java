package about;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class InOut {

	public static void main(String[] args) {
		Path path = Paths.get("myTextFile.txt");
		String content = "HELLO";
		try {
			Files.write(path, content.getBytes(), StandardOpenOption.CREATE);
		} catch (Exception e) {
			System.out.format("Sorry, something wentwrong:%n%s", e);
			// TODO Auto-generated method stub
		}
	}

	public void Create(String filename) throws IOException {
		File f = new File(filename);
		if (!f.exists()) {
			f.createNewFile();
			System.out.println("" + filename + " has been created");
		}
	}

}

class Terminal {

	void SystemOutFormat() {

		/*
		 * %n		new line
		 * %d		decimal integer
		 * %2.4f	float, ie 02.0002
		 * %s		String
		 * %c		char
		 * %f		float
		 */

		double d = 2.0;
		int i = 1;

System.out.format("%n%25.3f%n%2d%n",d,i );
		
		
		System.out.format("0x%2x%n",(int)'R' );
		
		
		
		System.out.println("abc"+(2*3));
		System.exit(-1);	// exit

	}
	
class Input{
	
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public String input;
    
    public void read() {
        
        try {
            input = br.readLine();
        } catch (IOException ioe) {
            System.out.println("IO error");
        }
    }
}

	
}
