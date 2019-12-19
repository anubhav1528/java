package parentPackage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import parentPackage.factory.MyConnectionFactory;
import parentPackage.model.original;

public class RunnerClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		List<original> list = new ArrayList<original>();
		ExcelImport excelImport = new ExcelImport();
		list = excelImport.excelImport();
		MyConnectionFactory factory = null;
		factory = MyConnectionFactory.createObject();
		Connection connection = factory.getConnection();
		PreparedStatement pStmt = null;
		String[] arraySplit;
		String newCode;
		String originalCode;
		ResultSet rs = null;
		try {
			try {
				pStmt = connection.prepareStatement("create table original (message_code varchar(255),ba int,cycle int"
						+ ",message_is_valid varchar(255),message_text clob,ba_language varchar(255))");
				pStmt.execute();
			} catch (Exception e) {
				// e.printStackTrace();
			}
			try {
				pStmt = connection
						.prepareStatement("create table lang_english (message_code varchar(255),ba int,cycle int"
								+ ",message_is_valid varchar(255),message_text clob)");
				pStmt.execute();
			} catch (Exception e) {
				// e.printStackTrace();
			}
			try {
				pStmt = connection
						.prepareStatement("create table lang_swedan (message_code varchar(255),ba int,cycle int"
								+ ",message_is_valid varchar(255),message_text clob)");
				pStmt.execute();
			} catch (Exception e) {
				// e.printStackTrace();
			}
			try {
				pStmt = connection
						.prepareStatement("create table lang_finland (message_code varchar(255),ba int,cycle int"
								+ ",message_is_valid varchar(255),message_text clob)");
				pStmt.execute();
			} catch (Exception e) {
				//e.printStackTrace();
			}
			for (int i = 0; i < list.size(); i++) {
				pStmt = connection.prepareStatement("insert into ORIGINAL values(?,?,?,?,?,?)");
				pStmt.setString(1, list.get(i).getMessage_code());
				pStmt.setInt(2, list.get(i).getBA());
				pStmt.setInt(3, list.get(i).getCycle());
				pStmt.setString(4, list.get(i).getMessage_is_valid());
				Reader reader = new StringReader(list.get(i).getMessage_text());
				pStmt.setCharacterStream(5, reader, list.get(i).getMessage_text().length());
				pStmt.setString(6, list.get(i).getBA_Language());
				pStmt.executeUpdate();
				String check = list.get(i).getBA_Language();
				if (check.equalsIgnoreCase("EN")) {
					originalCode = list.get(i).getMessage_code();
					arraySplit = originalCode.split("_");
					newCode = arraySplit[0] + "_" + arraySplit[2] + "_" + list.get(i).getBA_Language();
					pStmt = connection.prepareStatement("insert into lang_english values(?,?,?,?,?)");
					pStmt.setString(1, newCode);
					pStmt.setInt(2, list.get(i).getBA());
					pStmt.setInt(3, list.get(i).getCycle());
					pStmt.setString(4, list.get(i).getMessage_is_valid());
					Reader readerr = new StringReader(list.get(i).getMessage_text());
					pStmt.setCharacterStream(5, readerr, list.get(i).getMessage_text().length());
					pStmt.executeUpdate();

				}
				if (check.equalsIgnoreCase("FIN")) {
					originalCode = list.get(i).getMessage_code();
					arraySplit = originalCode.split("_");
					newCode = arraySplit[0] + "_" + arraySplit[2] + "_" + list.get(i).getBA_Language();
					pStmt = connection.prepareStatement("insert into lang_finland values(?,?,?,?,?)");
					pStmt.setString(1, newCode);
					pStmt.setInt(2, list.get(i).getBA());
					pStmt.setInt(3, list.get(i).getCycle());
					pStmt.setString(4, list.get(i).getMessage_is_valid());
					Reader readerr = new StringReader(list.get(i).getMessage_text());
					pStmt.setCharacterStream(5, readerr, list.get(i).getMessage_text().length());
					pStmt.executeUpdate();

				}
				if (check.equalsIgnoreCase("SWE")) {
					originalCode = list.get(i).getMessage_code();
					arraySplit = originalCode.split("_");
					newCode = arraySplit[0] + "_" + arraySplit[2] + "_" + list.get(i).getBA_Language();
					pStmt = connection.prepareStatement("insert into lang_swedan values(?,?,?,?,?)");
					pStmt.setString(1, newCode);
					pStmt.setInt(2, list.get(i).getBA());
					pStmt.setInt(3, list.get(i).getCycle());
					pStmt.setString(4, list.get(i).getMessage_is_valid());
					Reader readerr = new StringReader(list.get(i).getMessage_text());
					pStmt.setCharacterStream(5, readerr, list.get(i).getMessage_text().length());
					pStmt.executeUpdate();
	
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs = pStmt.executeQuery("Select * from lang_english");
			@SuppressWarnings("resource")
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("Sheet1");
			HSSFRow rowhead = sheet.createRow((short) 0);
			rowhead.createCell((short) 0).setCellValue("message_code");
			rowhead.createCell((short) 1).setCellValue("ba");
			rowhead.createCell((short) 2).setCellValue("cycle");
			rowhead.createCell((short) 3).setCellValue("message_is_valid");
			rowhead.createCell((short) 4).setCellValue("message_text");
			int j = 1;
			while (rs.next()) {
				HSSFRow row = sheet.createRow((short) j);
				row.createCell((short) 0).setCellValue(rs.getString(1));
				row.createCell((short) 1).setCellValue(rs.getInt(2));
				row.createCell((short) 2).setCellValue(rs.getInt(3));
				row.createCell((short) 3).setCellValue(rs.getString(4));
				row.createCell((short) 4).setCellValue(rs.getString(5));
				j++;
			}
			String yemi = "C://Users//AnubhavPatel//Downloads/lang_english.xls";
			FileOutputStream fileOut = new FileOutputStream(yemi);
			workbook.write(fileOut);
			fileOut.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			rs = pStmt.executeQuery("Select * from lang_finland");
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("Sheet1");
			HSSFRow rowhead = sheet.createRow((short) 0);
			rowhead.createCell((short) 0).setCellValue("message_code");
			rowhead.createCell((short) 1).setCellValue("ba");
			rowhead.createCell((short) 2).setCellValue("cycle");
			rowhead.createCell((short) 3).setCellValue("message_is_valid");
			rowhead.createCell((short) 4).setCellValue("message_text");
			int j = 1;
			while (rs.next()) {
				HSSFRow row = sheet.createRow((short) j);
				row.createCell((short) 0).setCellValue(rs.getString(1));
				row.createCell((short) 1).setCellValue(rs.getInt(2));
				row.createCell((short) 2).setCellValue(rs.getInt(3));
				row.createCell((short) 3).setCellValue(rs.getString(4));
				row.createCell((short) 4).setCellValue(rs.getString(5));
				j++;
			}
			String yemi = "C://Users//AnubhavPatel//Downloads/lang_finland.xls";
			FileOutputStream fileOut = new FileOutputStream(yemi);
			workbook.write(fileOut);
			fileOut.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			rs = pStmt.executeQuery("Select * from lang_swedan");
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("Sheet1");
			HSSFRow rowhead = sheet.createRow((short) 0);
			rowhead.createCell((short) 0).setCellValue("message_code");
			rowhead.createCell((short) 1).setCellValue("ba");
			rowhead.createCell((short) 2).setCellValue("cycle");
			rowhead.createCell((short) 3).setCellValue("message_is_valid");
			rowhead.createCell((short) 4).setCellValue("message_text");
			int j = 1;
			while (rs.next()) {
				HSSFRow row = sheet.createRow((short) j);
				row.createCell((short) 0).setCellValue(rs.getString(1));
				row.createCell((short) 1).setCellValue(rs.getInt(2));
				row.createCell((short) 2).setCellValue(rs.getInt(3));
				row.createCell((short) 3).setCellValue(rs.getString(4));
				row.createCell((short) 4).setCellValue(rs.getString(5));
				j++;
			}
			String yemi = "C://Users//AnubhavPatel//Downloads/lang_swedan.xls";
			FileOutputStream fileOut = new FileOutputStream(yemi);
			workbook.write(fileOut);
			fileOut.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		pStmt.close();
		rs.close();
		connection.close();

	}

}
