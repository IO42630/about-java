package sub_routines;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/** @author user
 * @meta general tools to be used with Core 
 * stringContains<p>
 * getMd5<p>
 * */
public class Tools {

	Execute x;

	public Tools() {
		x = new Execute();
	}

	/** Returns true if String string contains any character from String chars
	 * 
	 * @param string
	 * @param forbidden
	 * @return TRUE if STRING contains any CHAR from FORBIDDEN, else FALSE */
	public boolean stringContains(String string, String chars) {
		for (int i = 0; i < chars.length(); i++) {
			if (string.contains(String.valueOf(chars.charAt(i)))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return Md5 of File at @param path
	 */
	public String getMd5(String path) {
		// output of md5sum: "md5 filepath"
		BufferedReader md5reader = x.execute(new String[] { "md5sum", path }).output;
		String md5 = null;
		try {
			md5 = md5reader.readLine().split(" ")[0];
		} catch (IOException e) {
			e.printStackTrace();
		}
		return md5;
	}

	public File createFile(String path) {
		File file = new File(path);
		file.getParentFile().mkdirs();
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	/** @param br BufferedReader
	 * @return String of BufferedReader 
	 **/
	public StringBuilder brStringBuilder(BufferedReader br) {
		StringBuilder sb = new StringBuilder();
		String line;
		try {
			for(;(line = br.readLine()) != null;){
				sb.append(line + "\n");
				line =br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb;
	}

	/** Load first <b>linelimit</b> lines of <b>br</b> into <b>sb</b>.
	 * @param br BufferedReader
	 * @param int <b>linelimit</b> linelimit
	 * @return <b>sb</b> StringBuilder
	 **/
	public StringBuilder brStringBuilder(BufferedReader br, int linelimit) {
		StringBuilder sb = new StringBuilder();
		String line;
		try {
			for ( int i = 0; i < linelimit && (line = br.readLine()) != null; i++) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb;
	}

	
	/** @return name of <i>file</i> as <i>String</i>
	 **/
	public String getFilename(File file) {
		String[] slashSplit = file.getPath().split("/");
		return slashSplit[slashSplit.length - 1];
	}
	
	
	
	
}
