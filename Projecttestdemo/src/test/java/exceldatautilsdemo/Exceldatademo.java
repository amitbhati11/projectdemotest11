package exceldatautilsdemo;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldatademo {

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	public Exceldatademo(String xlpath,String sheetname) throws IOException {
		workbook=new XSSFWorkbook(xlpath);
		sheet=workbook.getSheet(sheetname);
	}
	
	public int getrowdata() throws IOException {
	int rowno=	sheet.getPhysicalNumberOfRows();
		return  rowno;
	}
	public int  getcoldata() throws IOException {
	int colno=sheet.getRow(0).getPhysicalNumberOfCells();
	return colno;
		
	}
	
	public String getcelldata(int rownum,int colnum) throws IOException {
		DataFormatter formatf=new DataFormatter();
		
	//	String value=sheet.getRow(rownum).getCell(colnum).getStringCellValue();
		
	String value=	formatf.formatCellValue(sheet.getRow(rownum).getCell(colnum));

	 
	return value;
	
	
}
}