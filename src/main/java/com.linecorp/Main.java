package com.linecorp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFDrawing;

public class Main {
	public static void main(String... args) {
		System.out.println("Hello IntelliJ!!");

		try {
			File file = new File("src/main/resource/xlsx/miraina20170410.xlsx");
			Workbook workbook = WorkbookFactory.create(file);
			List<Sheet> sheets = IntStream.range(0, workbook.getNumberOfSheets())
			                              .boxed()
			                              .map(index -> workbook.getSheetAt(index))
			                              .collect(Collectors.toList());

			sheets.forEach(sheet -> {
				System.out.println(sheet.getSheetName());
				System.out.println(sheet.getCellComments());
				System.out.println(sheet.getDefaultRowHeight());
				System.out.println(sheet.getDefaultColumnWidth());
				System.out.println(sheet.getLastRowNum());

				// System.out.print(((XSSFDrawing)sheet.getDrawingPatriarch()).getShapes().stream().map(shape -> shape.getDrawing()));
				// System.out.println(sheet.getColumn);
			});

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}



	}
}
