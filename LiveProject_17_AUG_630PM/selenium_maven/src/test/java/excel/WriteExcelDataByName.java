package excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcelDataByName {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook w;
	public XSSFSheet s;
	public XSSFRow row;
	public XSSFCell cell;

	@Test
	public void f() throws Exception {
		fi = new FileInputStream("D:\\LiveProject_17_AUG_630PM\\testdata\\login.xlsx");
		w = new XSSFWorkbook(fi);
		s = w.getSheet("Sheet1");
		row = null;
		cell = null;
		int colNum = -1;
		row = s.getRow(0);
		for (int i = 0; i < row.getLastCellNum(); i++) {
			System.out.println(row.getCell(i).getStringCellValue());
			if (row.getCell(i).getStringCellValue().equalsIgnoreCase("Results")) {
				colNum = i;
			}
		}
		row = s.getRow(6);
		if (row == null)
			row = s.createRow(6);
		cell = row.getCell(colNum);
		if (cell == null)
			cell = row.createCell(colNum);
		cell.setCellValue("BLOCKED");
		fo = new FileOutputStream("D:\\LiveProject_17_AUG_630PM\\testdata\\login.xlsx");
		w.write(fo);
		fo.close();
	}
}
