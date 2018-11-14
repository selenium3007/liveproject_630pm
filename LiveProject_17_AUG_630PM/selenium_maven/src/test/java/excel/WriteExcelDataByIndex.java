package excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcelDataByIndex {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook w;
	public XSSFSheet s;
	public XSSFRow row;
	public XSSFCell cell;

	@Test
	public void f() throws Exception{
		fi = new FileInputStream("D:\\LiveProject_17_AUG_630PM\\testdata\\login.xlsx");
		w = new XSSFWorkbook(fi);
		s = w.getSheet("Sheet1");
		row=null;
		cell=null;
		row=s.getRow(6);
		if(row==null)
			row=s.createRow(6);
		cell=row.getCell(3);
		if(cell==null)
			cell=row.createCell(3);
		cell.setCellValue("FAILED");
		fo=new FileOutputStream("D:\\LiveProject_17_AUG_630PM\\testdata\\login.xlsx");
		w.write(fo);
		fo.close();
	}
}










