package com.olexyn.about.java.other.sub.routines;

public class Backup {

	/*
	 *
	 *
	 *
	 *  1. calculate differences
	 *  	- load files in SRC and DST into a pool each
	 *  	- remove files that have identical md5 and path.
	 *
	 *
	 *  2.	update moved files
	 *  	- if same md5 but different path, move to new path, remove from pools
	 *
	 *
	 *  3. 	update changed files
	 *  	- if same path but different md5
	 *
	 *
	 *  4.	update created files
	 *
	 *
	 *  5.	delete old files
	 *  	- file with unique md5 and path is a single file.
	 *  	- if single file in DST older then X delete it.
	 *  	- if single file in DST newer then X keep it.
	 *
	 */
}
