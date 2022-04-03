package com.olexyn.about.java.other.sub.routines;


import java.io.BufferedReader;
import java.io.File;
import java.util.Map;


/**
 *
 * copy of core (main) with all the currently unused snippets
 *
 */
public class Snippets {
	Tools tools;
	Execute x;
	Routines routines;
	Map<Integer, File> filepool;
	String srcdir = "/home/user/sorted/Informatik";
	String destdir = "/home/user/sorted/Informatik";
	String[] keywords = { "Prüfung" };


	Snippets() {
		tools = new Tools();
		x = new Execute();
		routines = new Routines();
		filepool = routines.loadPool("/home/user/asdf", "file");
	}


	public Map<Integer, File> deleteSmallFiles() {
		// DELETE ALL FILES SMALLER THEN 100KB
		for (int i = 0; i < filepool.size(); i++) {
			String path = filepool.get("" + i).getAbsolutePath();
			BufferedReader br = x.execute(new String[] { "du", "-s", path }).output;
			if (Integer.parseInt(tools.brStringBuilder(br).toString().split("/")[0].trim()) <= 100) {
				x.execute(new String[] { "rm", path });
			}
		}
		// END
		return filepool;
	}


	public Map<Integer, File> deleteSmald() {
		Map<Integer, File> filepool = routines.loadPool("/home/user/asdf", "file");
		// delete file from pool if pdftotext shows an error
		for (int i = 1; i < filepool.size(); i++) {
			File file = new File("" + filepool.get("" + i));
			print(file.getPath() + " before br");
			BufferedReader br = x.execute(new String[] { "pdftotext", "-f", "0", "-l", "0", file.getPath(), "-" }).error;
			StringBuilder sb = tools.brStringBuilder(br, 10);
			print(file.getPath() + " after br");
			print(sb.toString());
			if (sb.length() > 10 && sb.substring(0, sb.indexOf("rr")).equals("Syntax E")) {
				print("Error: " + tools.getFilename(file));
				x.execute(new String[] { "rm", file.getPath() });
			}
		}
		return filepool;
	}


	/**
	 * quick & dirty console output for testing
	 *
	 * @param o
	 */
	public static void print(Object o) {
		System.out.println(o);
	}


	public static void moveFilePoolToDirectory(Map<String, File> filepool, String srcdir) {
		Execute x = new Execute();
		for (int i = 0; i < filepool.size(); i++) {
			File file = filepool.get("" + i);
			String filename = file.getName();
			x.execute(new String[] { "mv", file.getPath(), srcdir + filename });
		}
	}
}
