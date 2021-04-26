package dp.Rc;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;   
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;  

public class DataProviderFromExcel {
  @Test(dataProvider="Dp")
  public void ExcelDataProviders(HashMap<String, String> dp) throws IOException {
	  System.out.println("Username = "+dp.get("username")+" Password = "+dp.get("password"));
}
  @DataProvider
  public Object[][] Dp() throws IOException {
	  String filename = "Data.xlsx";
	  File file = new File("C:\\Users\\TTN\\OneDrive\\Desktop\\Data.xlsx");
	  FileInputStream inputStream = new FileInputStream(file);
	  XSSFWorkbook wb = new XSSFWorkbook(inputStream);   
	  XSSFSheet sheet = wb.getSheetAt(0);
	  int rowCount = sheet.getLastRowNum();
	  int lastCellNum = sheet.getRow(0).getLastCellNum();
	  Object[][] obj = new Object[rowCount][1];
	  for (int i = 0; i < rowCount; i++) {
      	  Map<Object, Object> key_value = new HashMap<Object, Object>();
	        for (int j = 0; j < lastCellNum; j++) {
	        		key_value.put(sheet.getRow(0).getCell(j).getStringCellValue(),sheet.getRow(i+1).getCell(j).getStringCellValue()) ;  
	        }
				obj[i][0]=key_value;
	        }
	 return(obj);
  }
	    } 
  
