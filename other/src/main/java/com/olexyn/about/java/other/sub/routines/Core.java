package com.olexyn.about.java.other.sub.routines;



import java.io.File;
import java.util.Map;

public class Core {

	public static String shell = "/home/user/ws/idea/Tasks/src/shell/";

	public static void main(String[] args) {





		System.out.println("loading pool ");
		Map<Integer, File> pool = new Routines().loadPool("/home/user/ws/", "file");

		new Write().textPool("pool", pool);

		System.out.println("calcualting md5");

		//Map<Integer, MFile> md5Pool = new Routines().md5Pool(pool);
		//new Write().textMd5Pool("md5Pool",md5Pool);
		System.out.println("asdf");


		System.out.println("sorting");
		//Map<Integer, MFile> qsMd5Pool = new QuicksortMd5().quicksortMd5(md5Pool);
		//new Write().textMd5Pool("qsMd5Pool",qsMd5Pool);

		System.out.println("finding doubles");
		//Map<Integer, MFile> doubles = new Routines().doubles(qsMd5Pool);
		//new Write().textMd5Pool("doubles",doubles);



		//System.out.println("deleting doubles");
		//for (int i=0;i<doubles.size();i++){
		//	new Execute().execute(new String[] { "rm", doubles.get(i).file.getAbsolutePath() });;
		//}



		//boolean pdf = new FileCriteriaTest().pdfContainsKeyword("/home/user/Dropbox/2018FS-ITPM/phase-2-plan-project.pdf", "WBxS"	);
		//System.out.println(""+pdf);

		//new Routines().deleteEmptyDir("/home/user/");



		//new Write().textFile("/home/user/demo.txt", new StringBuilder("test"));

		//new Rename("/media/time/conv").withDash();
		//new Convert("/media/time/conv").toMp3(false);



		//FileCriteriaTest fsur = new FileCriteriaTest();
		//boolean b = fsur.pdfContainsKeyword("/home/user/7219656.pdf", "Survey");
		//tools.print(""+b);
		//b = fsur.pdfContainsKeyword("/home/user/7219656.pdf", "asdf");
		//tools.print(""+b);
		//routines.sortByKeyword(srcdir, destdir, keywords, filepool);
		//routines.deleteEmptyDir(filepool);

	}
}
