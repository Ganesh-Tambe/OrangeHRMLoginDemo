package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LoginData {
	
	public static String[][] ExcelRead(String path) throws IOException
	{
		FileInputStream file=new FileInputStream(path);
		XSSFWorkbook w=new XSSFWorkbook(file);
		XSSFSheet sheet=w.getSheetAt(0);
		int rowc=sheet.getLastRowNum();
		int coloumnc=sheet.getRow(0).getLastCellNum();
		String data[][]=new String[rowc][coloumnc];
		DataFormatter df=new DataFormatter();
		
		
		for(int i=1;i<=rowc;i++)
		{
			Row row=sheet.getRow(i);
			for(int j=0;j<coloumnc;j++)
			{
				data[i-1][j]= df.formatCellValue(row.getCell(j));
				
			}
		}
		return data;
	}

}
