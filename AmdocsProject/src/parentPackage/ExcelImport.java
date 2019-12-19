package parentPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;

import parentPackage.factory.MyConnectionFactory;
import parentPackage.model.original;

public class ExcelImport {

	public static List<original> excelImport() throws IOException, SQLException, ClassNotFoundException {

		final String FILE_NAME = "C://Users//AnubhavPatel//Downloads/Original.xls";

		@SuppressWarnings({ "deprecation", "rawtypes" })
		List<original> list = new ArrayList<original>();
		FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
		@SuppressWarnings("resource")
		Workbook workbook = new HSSFWorkbook(excelFile);
		org.apache.poi.ss.usermodel.Sheet datatypeSheet = workbook.getSheetAt(0);
		Iterator<org.apache.poi.ss.usermodel.Row> iterator = datatypeSheet.iterator();

		for (int i = 1; i < datatypeSheet.getPhysicalNumberOfRows(); i++) {
			original temp = new original();
			HSSFRow row = (HSSFRow) datatypeSheet.getRow(i);
			temp.setOriginal_id(i);
			temp.setMessage_code(row.getCell(0).getStringCellValue());
			temp.setBA(Integer.parseInt(row.getCell(1).getStringCellValue()));
			temp.setCycle((int) row.getCell(2).getNumericCellValue());
			temp.setMessage_is_valid(row.getCell(3).getStringCellValue());
			temp.setMessage_text(row.getCell(4).getStringCellValue());
			temp.setBA_Language(row.getCell(5).getStringCellValue());
			list.add(temp);
		}

		return list;
	}
}
