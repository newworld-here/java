package com.lockedme;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Filemanager {
	/**
	 * This method will return all file name from folder
	 * 
	 * @param folderpath
	 * @return List<String>
	 */
	public static List<String> GetAllFiles(String folderpath) {
		// creating file objects
		File fl = new File(folderpath);
		// Getting all files into array
		File[] listOfFiles = fl.listFiles();
		// Declare a list to store file names
		List<String> fileNames = new ArrayList<String>();
		for (File files : listOfFiles) {
			fileNames.add(files.getName());
		}
		// return array list
		return fileNames;
	}

	/**
	 * This method will create or append content into the files
	 * 
	 * @param folderpath
	 * @param filename
	 * @param content
	 * @return boolean
	 */
	public static boolean writeContentToFile(String folderpath, String filename, List<String> content) {
		try {
			File fl = new File(folderpath, filename);
			FileWriter fw = new FileWriter(fl);
			for (String s : content) {
				fw.write(s + "\n");
			}
			fw.close();
			return true;
		} catch (Exception Ex) {
			return false;
		}
	}

	/**
	 * This method will delete file if it is exist
	 * 
	 * @param folderpath
	 * @param filename
	 * @return boolean
	 */
	public static boolean deleteFile(String folderpath, String filename) {
		File file = new File(folderpath + "\\" + filename);
		try {
			if (file.delete()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception Ex) {
			return false;
		}
	}

	/**
	 * This method will search file if it is exist
	 * 
	 * @param folderpath
	 * @param filename
	 * @return boolean
	 */
	public static boolean searchFile(String folderpath, String filename) {
		File file = new File(folderpath + "\\" + filename);
		try {
			if (file.exists()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception Ex) {
			return false;
		}
	}

}
