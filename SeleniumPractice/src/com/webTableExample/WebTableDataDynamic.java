package com.webTableExample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebTableDataDynamic extends BaseTest {
	public void CapturingWebTableData() throws IOException
	{
		FileInputStream cityNameFile = new FileInputStream("C:\\Users\\swathi\\Desktop\\SeleniumPractice\\WebTableData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(cityNameFile);
		XSSFSheet cityNameSheet = workBook.getSheet("TestData"); 
		By webTableProperty = By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr");
		
		List<WebElement>WebtableRow = driver.findElements(webTableProperty);
		int WebTableRowCount = WebtableRow.size();
		System.out.println(WebTableRowCount);
		By webTableRowOfCellProperty = By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td");
		List<WebElement>WebtableRowOfCell = driver.findElements(webTableRowOfCellProperty);
		int WebTableRowOfCellCount = WebtableRowOfCell.size();
		System.out.println(WebTableRowOfCellCount);
		String xpathexpression1Cell = "/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[";
				String xpathexpression2Cell = "]/td[";
				String xpathexpression3Cell	= "]";
		///html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[1]
		for(int rowIndex=1;rowIndex<=WebTableRowCount;rowIndex++)
		{
			for(int rowofCellIndex = 1;rowofCellIndex<=WebTableRowOfCellCount;rowofCellIndex++)
			{
				
			By cityNameProperty = By.xpath(xpathexpression1Cell+rowIndex+xpathexpression2Cell+rowofCellIndex+xpathexpression3Cell);
			WebElement cityName = driver.findElement(cityNameProperty);
			String webTableData = cityName.getText();
			System.out.print(webTableData + " |");
			//Row CityNameRow = cityNameSheet.createRow(rowIndex);
			Row newRow = cityNameSheet.getRow(rowIndex-1);
						
			Cell newRowOfCell=newRow.createCell(rowofCellIndex-1);
			//System.out.println("exceuted");
			newRowOfCell.setCellValue(webTableData); 
		
			}
			System.out.println();
			}
		FileOutputStream WebTableDataResult = new FileOutputStream("C:\\Users\\swathi\\Desktop\\SeleniumPractice\\WebTableData.xlsx");
		workBook.write(WebTableDataResult); 
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebTableDataDynamic WebTableDynamic = new WebTableDataDynamic();
		WebTableDynamic.applicationLaunch();
		WebTableDynamic.CapturingWebTableData();
		WebTableDynamic.applicationClose();
	}

}
