package com.example.utils;

import java.io.File;
import java.io.FilenameFilter;

public class FileFilter implements FilenameFilter {

	// only select certain files for processing
	public boolean accept(File dir, String name) {
		if (name.endsWith(".xml") && name.startsWith("File")) {
			return true;
		}
		return false;
	}
}
