package sub_routines;



import java.io.File;
import java.io.IOException;


/** @author user */
public class FileCriteriaTest {
	Tools tools;
	Execute x;
	Write write;


	/** selection of <b>boolean</b> that flip if <b>file</b> matches certain
	 * <b>criteria</b>.<p> */
	public FileCriteriaTest() {
		tools = new Tools();
		x = new Execute();
		write = new Write();
	}


	/** converts "pdf" to "text". then "greps" with "keyword". if output is
	 * "null", "keyword" was not found. */
	public boolean pdfContainsKeyword(String path, String keyword) {
		// Runtime.exec() can'd "do" pipes, write a .sh to work around
		Execute.TwoBr twobr = x.execute(new String[] { Core.shell + "pipe.sh",
				"pdftotext -q " + path + " - ", "grep " + keyword });
		try {
			if (twobr.output.readLine() != null) {
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}


	public boolean filenameContains(String path, String keyword) {
		String filename = tools.getFilename(new File(path));
		return filename.contains(keyword);
	}
}
