package com.ExcelFileTestingPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleTestDataValidationSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver;
	    String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	    
	    //Automating the browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\swathi\\Desktop\\SeleniumPractice\\DriverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		
	   //Navigating to the application URL address
		driver.get(applicationUrlAddress);
	     FileInputStream testDataFile = new FileInputStream("C:\\Users\\swathi\\Desktop\\SeleniumPractice\\LogInSampleMultipleTestData.xlsx");
	 	
	 	//Identify the WorkBook of the file
	 	XSSFWorkbook workBook = new XSSFWorkbook(testDataFile);
	 	
	 	//Identify a particular sheet in the WorkBook
	 	XSSFSheet TestDataSheet = workBook.getSheet("TestData");
	 	
	 	//Identify a Row in the sheet
	 	

		//Login Validation
	    //Row testDataSheetRowUserName = TestDataSheet.getRow(1);
		int multipleTestDataSheetRowCount= TestDataSheet.getLastRowNum();
		
		
		for(int rowIndex = 1;rowIndex<=multipleTestDataSheetRowCount;rowIndex++)	
		{
			
			Row multipleTestDataSheetRow = TestDataSheet.getRow(rowIndex);
			int multipleTestDataSheetRowOfCellCount= multipleTestDataSheetRow.getLastCellNum();
		for(int rowOfCellIndex=0; rowOfCellIndex<=multipleTestDataSheetRowOfCellCount;rowOfCellIndex++)
		{
			
		
		Cell testDataSheetRowOfCell = multipleTestDataSheetRow.getCell(rowOfCellIndex);
			
		String userNameTestData = testDataSheetRowOfCell.getStringCellValue();
			
		System.out.println("Login User Name from Excel sheet is "+userNameTestData);
		
		 By UserNameProperty = By.id("txtUsername");
		 WebElement userName = driver.findElement(UserNameProperty);
		 userName.sendKeys(userNameTestData);
		
		// Row testDataSheetRowPassWord = TestDataSheet.getRow(1);
			
			Cell testDataSheetRowOfCellPassword = multipleTestDataSheetRow.getCell(rowOfCellIndex);
			
			
			String PassWordTestData = testDataSheetRowOfCellPassword.getStringCellValue();
			
			
			System.out.println("Login Password from Excel sheet is "+PassWordTestData);
		// String PasswordTestData = "Livetech@123";
		 By PasswordProperty = By.id("txtPassword");
		 WebElement password = driver.findElement(PasswordProperty);
		 password.sendKeys(PassWordTestData);
		 
		 By LoginButtonProperty = By.id("btnLogin");
		 WebElement LoginButton = driver.findElement(LoginButtonProperty);
		 LoginButton.click();
		 String loginValidation=driver.getCurrentUrl();
		 
		
		 System.out.println("Logib attempt successfull" +loginValidation);
		
		 if(loginValidation.equals(applicationUrlAddress))
		 {
			
				 System.out.println("Invalid Credentials :- Fail");
				 Cell testResult = multipleTestDataSheetRow.createCell(2);
				 testResult.setCellValue("Fail");
				 
			
		} 
		 
		 else
		 {
			 System.out.println("Valid Credentials :- Pass");
			 Cell testResult = multipleTestDataSheetRow.createCell(2);
			 testResult.setCellValue("Pass");
			 
		 }
		 FileOutputStream excelActulaLoginPageText = new FileOutputStream("C:\\Users\\swathi\\Desktop\\SeleniumPractice\\LogInSampleMultipleTestData.xlsx"); 
			workBook.write(excelActulaLoginPageText);
	}


			}
		}
		}
	

		
	
