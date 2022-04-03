package com.olexyn.about.java.other.sub.routines;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Routines {
	Execute x = null;
	FileCriteriaTest search = null;
	Tools tools = new Tools();
	Write write = new Write();


	public Routines() {
		this.x = new Execute();
		this.search = new FileCriteriaTest();
		this.tools = new Tools();
	}


	/** @param srcdir
	 * @param destdir
	 * @param keywords
	 * @param filepool */
	public void sortByKeyword(String srcdir, String destdir, String[] keywords, Map<String, File> filepool) {
		for (int k = 0; k < keywords.length; k++) {
			x.execute(new String[] { "mkdir", destdir + "/" + keywords[k] });
			for (int i = 1; i < filepool.size(); i++) {
				System.out.println("keyword: " + keywords[k] + " file Nr. " + i);
				File file = new File("" + filepool.get("" + i));
				if (file.isFile()) {
					// boolean crit = search.pdfContainsKeyword(file.getPath(),
					// keywords[k]);
					boolean crit = search.filenameContains(file.getPath(), keywords[k]);
					if (crit) {
						x.execute(new String[] { "mv", file.getPath(), destdir + "/" + keywords[k] + "/" + tools.getFilename(file) });
						filepool.remove("" + i);
					}
				}
			}
		}
	}


	/** [1] Write output of <b>find srcdir</b> to <b>/tmp/find</b> <br>
	 * [2] Read <b>/tmp/find</b> into <b>List>String></b> <br>
	 * [3] Add <b>List>String></b> entries to <b>Map>String,File></b> , where
	 * <b>String</b> is an <b>int</b> key. <br>
	 *
	 * @param srcdir
	 * @param type
	 *            file OR directory
	 * @return filepool */
	public Map<Integer, File> loadPool(String srcdir, String type) {
		// [1]
		/* #!/bin/bash
		 * a=$1
		 * b=$2
		 * c=$3
		 * $a $b > $c */
		x.execute(new String[] { Core.shell + "toFile.sh", "find", srcdir, "/tmp/find" });
		// [2]
		List<String> lines = null;
		try {
			lines = Files.readAllLines(Paths.get("/tmp/find"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// [3]
		Map<Integer, File> filepool = new HashMap<Integer, File>();
		int j = 0;
		for (int i = 0; i < lines.size(); i++) {
			File file = new File(lines.get(i));
			if (type == "directory" && file.isDirectory() || type == "file" && file.isFile()) {
				filepool.put(j, file);
				j++;
			}
		}
		return filepool;
	}




	public Map<Integer, Artifacts.MFile> md5Pool(Map<Integer, File> pool) {
		Map<Integer, Artifacts.MFile> md5Pool = new HashMap<Integer, Artifacts.MFile>();
		for (int i = 0; i < pool.size(); i++) {
			md5Pool.put(i, new Artifacts().new MFile(pool.get(i)));
		}
		return md5Pool;
	}


	/** <b>WARNING</b>: will delete <b>srcdir</b> too, if it contains no files at
	 * all
	 *
	 * @param srcdir */
	public void deleteEmptyDir(String srcdir) {
		Map<Integer, File> filepool = loadPool(srcdir, "directory");
		boolean emptyDirFound = true;
		// iterate to delete trees of empty dirs
		while (emptyDirFound == true) {
			emptyDirFound = false;
			for (int i = 1; i < filepool.size(); i++) {
				File file = new File("" + filepool.get(i));
				if (file.isDirectory() && file.listFiles().length == 0) {
					x.execute(new String[] { "rm", "-d", file.getPath() });
					emptyDirFound = true;
				}
			}
		}
	}


	public Map<Integer, Artifacts.MFile> doubles(Map<Integer, Artifacts.MFile> md5Pool) {
		Map<Integer, Artifacts.MFile> doubles = new HashMap<Integer, Artifacts.MFile>();
		int d = 0;
		for (int i = 0; i < md5Pool.size() - 1; i++) {
			Artifacts.MFile iF = md5Pool.get(i);
			Artifacts.MFile jF = md5Pool.get(i + 1);
			if (iF.md5.equals(jF.md5)) {
				if (iF.file.lastModified() >= jF.file.lastModified()) {
					doubles.put(d, iF);
					d++;
				} else {
					doubles.put(d, jF);
					d++;
				}
			}
		}
		return doubles;
	}
}
