package com.lockedme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockedMeClass {
	static final String folderpath = "G:\\Phase1project\\Lockmefiles";

	public static void main(String[] args) {
		// Variable declaration
		int proceed = 1;
		do {
			Scanner obj = new Scanner(System.in);
			int ch;

			// menu
			displayMenu();
			System.out.println("Enter your coice :");
			ch = Integer.parseInt(obj.nextLine());
			switch (ch) {
			case 1:
				getAllFiles();
				break;
			case 2:
				createFile();
				break;
			case 3:
				deleteFile();
				break;
			case 4:
				serachFile();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Option");
				break;
			}

		} while (proceed > 0);

	}

	/**
	 * For displaying menu
	 */
	public static void displayMenu() {
		System.out.println("************************************");
		System.out.println("\t\tLockme.com");
		System.out.println("************************************");
		System.out.println("1. Display all files");
		System.out.println("2. Creating a new file");
		System.out.println("3. Delete a file");
		System.out.println("4. Search a file");
		System.out.println("5. Exit");
		System.out.println("************************************");
	}

	/**
	 * For getting file name method
	 */
	public static void getAllFiles() {
		// Get file names
		List<String> fileNames = Filemanager.GetAllFiles(folderpath);
		for (String files : fileNames) {
			System.out.println(files);
		}
	}

	/**
	 * For creating file method
	 */
	public static void createFile() {
		// variable declaration
		Scanner obj = new Scanner(System.in);
		String filename;
		int linesCount;
		List<String> content = new ArrayList<String>();
		// read file name from user
		System.out.println("Enter file name :");
		filename = obj.nextLine();
		// Read number of lines from user
		System.out.println("Enter how many lines in file :");
		linesCount = Integer.parseInt(obj.nextLine());

		// Read lines from user
		for (int i = 1; i <= linesCount; i++) {
			System.out.println("Enter line " + i + ":");
			content.add(obj.nextLine());
		}
		// save the content into the file
		boolean isSaved = Filemanager.writeContentToFile(folderpath, filename, content);
		if (isSaved)
			System.out.println("File and data saved successfully");
		else
			System.out.println("Some error occurs. Please contact admin@saurav.co");
		// close scanner object
//		obj.close();
	}

	/**
	 * For deleting file method
	 */
	public static void deleteFile() {

		Scanner obj = new Scanner(System.in);
		String filename;
		System.out.println("Enter file name :");
		filename = obj.nextLine();
		boolean isDelete = Filemanager.deleteFile(folderpath, filename);
		if (isDelete)
			System.out.println("File deleted successfully");
		else
			System.out.println("File is not found. Please contact admin@saurav.co");
//		obj.close();
	}

	/**
	 * For searching file method
	 */
	public static void serachFile() {
		Scanner obj = new Scanner(System.in);
		String filename;
		System.out.println("Enter file name for search:");
		filename = obj.nextLine();
		boolean isDelete = Filemanager.searchFile(folderpath, filename);
		if (isDelete)
			System.out.println("File present in folder");
		else
			System.out.println("File is not found. Please contact admin@saurav.co");
//		obj.close();
	}

}
