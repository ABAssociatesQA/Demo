package baseutils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	
	public String[][] readExcelData(String filePath,String sheetName) {
		FileInputStream fis=null;
		Workbook workbook=null;
		
		try {
			fis=new FileInputStream(filePath);
			workbook=new XSSFWorkbook(fis);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Expected file is not available");
		}
		
		Sheet sheet=workbook.getSheet(sheetName);
		int lastRowNum=sheet.getLastRowNum(); //0,1
		int lastCellNum=sheet.getRow(lastRowNum).getLastCellNum();// 7
		
		String[][] arr=new String[lastRowNum][lastCellNum];
		
		for(int i=1;i<=lastRowNum;i++) {
			for(int j=0;j<lastCellNum;j++) {
				arr[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		return arr;
		
	}

}
