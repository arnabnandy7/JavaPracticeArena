package common.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class IncludeSqrExtractor {

	private static String[] columns = { "File Name", "File Path", "SQR Files" };

	public static ArrayList<ArrayList<String>> fList = new ArrayList<ArrayList<String>>();

	public static void main(String[] args) throws IOException {
		// Input file
		File fl = new File("C:\\Users\\781710\\Documents\\test\\");

		// Path validation and matching contents
		if (fl.exists() && fl.isDirectory()) {
			File arr[] = fl.listFiles();

			// Content Matcher
			RecursiveMatcher(arr);
		}

		// Create a Workbook
		Workbook workbook = new HSSFWorkbook(); // new HSSFWorkbook() for
												// generating `.xls` file

		// Create a Sheet
		Sheet sheet = workbook.createSheet("IncludeFiles");

		// Create a Font for styling header cells
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		// Create a Row
		Row headerRow = sheet.createRow(0);

		// Create cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}

		int rowNum = 1;
		for (int i = 0; i < fList.size(); i++) {
			Row row = sheet.createRow(rowNum++);
			ArrayList<String> temp = (ArrayList<String>) fList.get(i);
			row.createCell(0).setCellValue(temp.get(0));
			row.createCell(1).setCellValue(temp.get(1));
			row.createCell(2).setCellValue(temp.get(2));
		}

		// Resize all columns to fit the content size
		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}

		FileOutputStream fileOut = null;
		// Write the output to a file
		try {
			fileOut = new FileOutputStream(
					"C:\\Users\\781710\\Documents\\include-file.xls");
			workbook.write(fileOut);
		} catch (Exception e) {
			System.out.println(e);
		} finally {

			fileOut.close();

			// Closing the workbook
			workbook.close();
		}

		// Printing matches
		for (int i = 0; i < fList.size(); i++) {
			ArrayList<String> temp = (ArrayList<String>) fList.get(i);
			System.out.println(temp.get(0) + "\t" + temp.get(1) + "\t"
					+ temp.get(2));
		}

	}

	static void RecursiveMatcher(File[] arr) {
		ArrayList<String> tempList = new ArrayList<String>();
		for (File f : arr) {
			if (f.isFile()) {
				if (!findMatch(f.getAbsolutePath()).replaceFirst(",", "")
						.isEmpty()) {
					tempList = new ArrayList<String>();
					tempList.add(f.getName());
					tempList.add(f.getAbsolutePath());
					tempList.add(findMatch(f.getAbsolutePath()).replaceFirst(
							",", ""));

					fList.add(tempList);
				}
			} else if (f.isDirectory()) {
				RecursiveMatcher(f.listFiles());
			}
		}
	}

	static String findMatch(String fileName) {
		File file = new File(fileName);
		Scanner in = null;
		String sqrFiles = "";
		try {
			in = new Scanner(file);
			while (in.hasNext()) {
				String line = in.nextLine();
				if (line.contains("#include")) {
					sqrFiles = sqrFiles + ","
							+ line.replace("'", "").replace("#include ", "");
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
		return sqrFiles;
	}

}
