package com.olexyn.about.java.other.sub.routines;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 */
public class Convert {
	String directory;
	Execute x;
	BufferedReader output;

	public Convert(String dir) {

		x = new Execute();
		this.directory = dir;
	}

	/**
	 * Converts any .mp4 or .wav extension to <i>mp3</i>
	 * @param remove <i>boolean</i>, remove original file if <i>true</i>
	 */
	public void toMp3(boolean remove) {
		try {
			// find -> BufferedReader
			output = x.execute(new String[] { "find", directory }).output;
			String line;
			while ((line = output.readLine()) != null) {
				// filter mp4 files
				String[] linesplit = line.split("\\.");
				//TODO add support for extensions
				if (linesplit[linesplit.length - 1].equals("mp4") || linesplit[linesplit.length - 1].equals("wav")) {
					// convert
					x.execute(new String[] {Core.shell + "mp3.sh", line });
					if (remove == true) {
						new Execute().execute(new String[] {"rm", line });
					}
				}
			}
		} catch (IOException e2) {
			// e2.printStackTrace();
		}
	}

}
