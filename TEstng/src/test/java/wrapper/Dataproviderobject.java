package wrapper;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Dataproviderobject {

	public static Object[][] getvalue(String Excelname) throws IOException{
		
		Object[][] data= null;
		//we dont know what kind of cele vlaue is ,so we used object
		String Filelocation = ".\\data\\"+Excelname+".xlsx";
		FileInputStream fis = new FileInputStream(Filelocation);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		//get row number
		int lastRowNum = sheet.getLastRowNum();
		//get last column num
		short lastcolumnnum = sheet.getRow(0).getLastCellNum();
		
		data = new Object[lastRowNum][lastcolumnnum];
		//lopp through rows
		for(int i=1;i<lastRowNum;i++) {
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<lastcolumnnum;j++) {
				//loop through clolumns
				Object cellvalue = null;
				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				switch (cellType) {
				case NUMERIC:
					long numeric = (long)cell.getNumericCellValue();
					String valueOfNumeric = String.valueOf(numeric);
					cellvalue = valueOfNumeric;
					break;
				case STRING:
					cellvalue = cell.getStringCellValue();
					break;
				case BOOLEAN:
					System.out.println(cell.getBooleanCellValue()+"\t");
					break;
				case ERROR:
					System.out.println("it is an empty row");
					break;
					default:
						System.out.println("Error in enterin data");
						break;
				
				}
				data[i-1][j] = cellvalue;
			}
		}
		fis.close();
		workbook.close();
		return data;
	}
}
