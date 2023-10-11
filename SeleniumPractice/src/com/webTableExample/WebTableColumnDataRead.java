package com.webTableExample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebTableColumnDataRead extends BaseTest {
	
	public void CapturingWebTableColumnData() throws IOException
	{
		FileInputStream cityNameFile = new FileInputStream("C:\\Users\\swathi\\Desktop\\SeleniumPractice\\WebTableData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(cityNameFile);
		XSSFSheet cityNameSheet = workBook.getSheet("TestData");
		
		
		///html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[1]
		for(int rowIndex=1;rowIndex<=36;rowIndex++)
		{
			By cityNameProperty = By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+rowIndex+"]/td[1]");
			WebElement cityName = driver.findElement(cityNameProperty);
			String cityNameText = cityName.getText();
			System.out.println(cityNameText);
			//Row CityNameRow = cityNameSheet.createRow(rowIndex);
			Row newRow = cityNameSheet.getRow(rowIndex);
			
			Cell newRowOfCell=newRow.createCell(0);
			newRowOfCell.setCellValue(cityNameText);
		}
		FileOutputStream WebTableDataResult = new FileOutputStream("C:\\Users\\swathi\\Desktop\\SeleniumPractice\\WebTableData.xlsx");
		workBook.write(WebTableDataResult);
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebTableColumnDataRead CaptureColumn = new WebTableColumnDataRead();
		CaptureColumn.applicationLaunch();
		CaptureColumn.CapturingWebTableColumnData();
		CaptureColumn.applicationClose();

	}

}
