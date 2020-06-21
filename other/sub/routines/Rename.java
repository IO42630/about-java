package sub.routines;



import java.io.BufferedReader;
import java.io.IOException;

/** @purpose tools for renaming of files
 * @author user */
public class Rename {

	String directory;
	Tools tools;
	Execute x;
	BufferedReader output;

	public Rename(String dir) {
		x = new Execute();
		tools = new Tools();
		this.directory = dir;
	}

	/** replace some "forbidden" characters with dashes <p>
	 *  find list directory contents
	 **/
	public void withDash() {
		try {
			output = x.execute( new String[]{ "find", directory }).output;
			String line;
			String forbidden = " ()#_[]【】%";
			while ((line = output.readLine()) != null) {
				if (tools.stringContains(line, forbidden)) {
					String oldline = line;
					for (int i = 0; i < line.length(); i++) {

						if (tools.stringContains(forbidden, "" + line.charAt(i))) {
							line = line.substring(0, i) + "-" + line.substring(i + 1);
						}
					}
					// linux "mv [OPTION] QUELLE ZIEL"
					x.execute(new String[] { "mv", oldline, line });
				}
			}
		} catch (IOException e2) {
			//e2.printStackTrace();
		}
	}




}
