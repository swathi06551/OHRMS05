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
import org.openqa.selenium.interactions.Actions;

public class AddEmployeePage_Validations_UsingExcelFile {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				WebDriver driver;
			    String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
			    
			    //Automating the browser
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\swathi\\Desktop\\SeleniumPractice\\DriverFiles/chromedriver.exe");
				driver = new ChromeDriver();
				
			   //Navigating to the application URL address
				driver.get(applicationUrlAddress);
			     FileInputStream testDataFile = new FileInputStream("C:\\Users\\swathi\\Desktop\\SeleniumPractice\\AddEmployee.xlsx");
			 	
			 	//Identify the WorkBook of the file
			 	XSSFWorkbook workBook = new XSSFWorkbook(testDataFile);
			 	
			 	//Identify a particular sheet in the WorkBook
			 	XSSFSheet TestDataSheet = workBook.getSheet("TestData");
			 	
			 	
		     
			
		  //Login Panel Text Validation
			
			Row testDataSheetRow = TestDataSheet.getRow(1);
			
			//Identify the row of cell in a row
			Cell testDataSheetRowOfCell = testDataSheetRow.getCell(0);
			
			//Get the data from a Row of cell
			String ExpectedloginPanelText = testDataSheetRowOfCell.getStringCellValue();
			
			System.out.println("Expected Login Panel Text from Excel sheet is "+ExpectedloginPanelText);
			
			
			By LoginPanelProperty = By.id("logInPanelHeading");
			
			
		   WebElement LoginPanelText = driver.findElement(LoginPanelProperty);
			String ActualLoginPanelText = LoginPanelText.getText();
			
			System.out.println("Actual login panel text is " + ActualLoginPanelText);
			
			Row testDataSheetRow1 = TestDataSheet.getRow(1);
			
			Cell testDataSheetRowOfCell1= testDataSheetRow1.createCell(1);
			
			testDataSheetRowOfCell1.setCellValue(ActualLoginPanelText);
			
			if(ActualLoginPanelText.equals(ExpectedloginPanelText))
			{
				System.out.println("Successfully navigated to Login Panel page :- Pass");
				Row testDataSheetRow1Result = TestDataSheet.getRow(1);
				
				Cell testDataSheetRowOfCell2Result= testDataSheetRow1Result.createCell(2);
				
				testDataSheetRowOfCell2Result.setCellValue("Pass");
			
			}
			else {
		          Row testDataSheetRow1Result = TestDataSheet.getRow(1);
				
				Cell testDataSheetRowOfCell2Result= testDataSheetRow1Result.createCell(2);
				
				testDataSheetRowOfCell2Result.setCellValue("Fail");
				}
			
			//Login Page Title Validation
			
			Row testDataSheetRowTitleExpected = TestDataSheet.getRow(1);
		    Cell testDataSheetRowOfCellTitle = testDataSheetRowTitleExpected.getCell(3);
			
			
			String ExpectedloginPageTitle = testDataSheetRowOfCellTitle.getStringCellValue();
			
			
			System.out.println("Expected Login Page Title from Excel sheet is "+ExpectedloginPageTitle);
			
			String ActualPageTitle = driver.getTitle();
			System.out.println("Actual Page Title is " +ActualPageTitle);
		    Row testDataSheetRowTitleActual = TestDataSheet.getRow(1);
			
			Cell testDataSheetRowOfCell4= testDataSheetRowTitleActual.createCell(4);
			
			testDataSheetRowOfCell4.setCellValue(ActualPageTitle);
			if(ActualPageTitle.equals(ExpectedloginPageTitle))
			{
			  System.out.println("Expected and actual page title matched :-Pass");
			  Row testDataSheetRow1Result = TestDataSheet.getRow(1);
				
				Cell testDataSheetRowOfCell5Result= testDataSheetRow1Result.createCell(5);
				
				testDataSheetRowOfCell5Result.setCellValue("Pass");
			
			}
			else
			{
				System.out.println("Expected and actual page title not matched :-Fail");
		       Row testDataSheetRow1Result = TestDataSheet.getRow(1);
				
				Cell testDataSheetRowOfCell5Result= testDataSheetRow1Result.createCell(5);
				
				testDataSheetRowOfCell5Result.setCellValue("Fail");
			}
			
			//Login Validation
		    Row testDataSheetRowUserName = TestDataSheet.getRow(1);
				
			Cell testDataSheetRowOfCell6 = testDataSheetRowUserName.getCell(6);
				
			String userNameTestData = testDataSheetRowOfCell6.getStringCellValue();
				
			System.out.println("Login User Name from Excel sheet is "+userNameTestData);
			
			 By UserNameProperty = By.id("txtUsername");
			 WebElement userName = driver.findElement(UserNameProperty);
			 userName.sendKeys(userNameTestData);
			 
			 Row testDataSheetRowPassWord = TestDataSheet.getRow(1);
				
				
				Cell testDataSheetRowOfCell7 = testDataSheetRowPassWord.getCell(7);
				
				
				String PassWordTestData = testDataSheetRowOfCell7.getStringCellValue();
				
				
				System.out.println("Login Password from Excel sheet is "+PassWordTestData);
			// String PasswordTestData = "Livetech@123";
			 By PasswordProperty = By.id("txtPassword");
			 WebElement password = driver.findElement(PasswordProperty);
			 password.sendKeys(PassWordTestData);
			 
			 By LoginButtonProperty = By.id("btnLogin");
			 WebElement LoginButton = driver.findElement(LoginButtonProperty);
			 LoginButton.click();
			 Row testDataSheetRowWelcomeText = TestDataSheet.getRow(1);
				
				
				Cell testDataSheetRowOfCell8 = testDataSheetRowWelcomeText.getCell(8);
				
				
				String ExpectedloginWelcomeText = testDataSheetRowOfCell8.getStringCellValue();
				
				
				System.out.println("Welcome Text from Excel sheet is "+ExpectedloginWelcomeText);	
				 By WelcomeAdminProperty = By.id("welcome");
				 WebElement WelcomeAdminText = driver.findElement(WelcomeAdminProperty);
				 String ActualWelcomeAdmin = WelcomeAdminText.getText();
				 
				 System.out.println("Actual Welcome Text message is " +ActualWelcomeAdmin);
				 Row testDataSheetRowWelcomeTextActual = TestDataSheet.getRow(1);
					
					Cell testDataSheetRowOfCell9= testDataSheetRowWelcomeTextActual.createCell(9);
					
					testDataSheetRowOfCell9.setCellValue(ActualWelcomeAdmin);
					if(ActualWelcomeAdmin.contains(ExpectedloginWelcomeText))
					 {
						 System.out.println("Welcome admin message displayed: - Pass");
						 Row testDataSheetRow1Result = TestDataSheet.getRow(1);
							
							Cell testDataSheetRowOfCell10Result= testDataSheetRow1Result.createCell(10);
							
							testDataSheetRowOfCell10Result.setCellValue("Pass");
					 }
					 else 
					 {
						 Row testDataSheetRow1Result = TestDataSheet.getRow(1);
							
							Cell testDataSheetRowOfCell10Result= testDataSheetRow1Result.createCell(10);
							
							testDataSheetRowOfCell10Result.setCellValue("Fail");
							
							System.out.println("Welcome admin message not displayed: - Fail");
					 }
					//Add Employee page with Full Name Validation
					By PIMProperty = By.id("menu_pim_viewPimModule");
					 WebElement PIMmodule = driver.findElement(PIMProperty);
					 Actions PIMactions = new Actions(driver);
					 PIMactions.moveToElement(PIMmodule).build().perform();
					 
					 By AddEmployeeProperty = By.id("menu_pim_addEmployee");
					 WebElement AddEmployee = driver.findElement(AddEmployeeProperty);
					 AddEmployee.click();
					 Row testDataSheetRowFullName = TestDataSheet.getRow(1);
						
						
						Cell testDataSheetRowOfCell11 = testDataSheetRowFullName.getCell(11);
						
						
						String ExpectedAddEmployeePageFullNameFromExcel = testDataSheetRowOfCell11.getStringCellValue();
						
						
						System.out.println("Welcome Text from Excel sheet is "+ExpectedAddEmployeePageFullNameFromExcel);	
						By FullNameProperty = By.className("hasTopFieldHelp");
						 WebElement FullName = driver.findElement(FullNameProperty);
						 String ActualFullName = FullName.getText();
						 
						 System.out.println("Actual FullNametext is "+ActualFullName);
						 Row testDataSheetRowPersonalDetailsActual = TestDataSheet.getRow(1);
							
							Cell testDataSheetRowOfCell12= testDataSheetRowPersonalDetailsActual.createCell(12);
							
							testDataSheetRowOfCell12.setCellValue(ActualFullName);
						 
						 if(ActualFullName.equals(ExpectedAddEmployeePageFullNameFromExcel))
								 {
							 System.out.println("Page succefully navigated to Add Employee details Page :- Pass");
							 Row testDataSheetRow1Result = TestDataSheet.getRow(1);
								
								Cell testDataSheetRowOfCell13Result= testDataSheetRow1Result.createCell(13);
								
								testDataSheetRowOfCell13Result.setCellValue("Pass");
								 }
						 else 
						 {
							 System.out.println("Failed to navigate to Add Employee Details page :- Fail");
							 Row testDataSheetRow1Result = TestDataSheet.getRow(1);
								
								Cell testDataSheetRowOfCell13Result= testDataSheetRow1Result.createCell(13);
								
								testDataSheetRowOfCell13Result.setCellValue("Fail");
						 }
						 
						 //Add Employee Details
						Row testDataSheetRowFirstNameFromExcel = TestDataSheet.getRow(1);
							
							
							Cell testDataSheetRowOfCell14 = testDataSheetRowFirstNameFromExcel.getCell(14);
							
							
							String ExpectedFirstNameFromExcel = testDataSheetRowOfCell14.getStringCellValue();
							
							
							System.out.println("First Name from Excel sheet is "+ExpectedFirstNameFromExcel);
						 By FullNameTextboxProperty = By.id("firstName");
						  WebElement FullNameTextBox = driver.findElement(FullNameTextboxProperty);
						  FullNameTextBox.sendKeys(ExpectedFirstNameFromExcel);
						  
						  Row testDataSheetRowMiddleNameFromExcel = TestDataSheet.getRow(1);
							
							
							Cell testDataSheetRowOfCell15 = testDataSheetRowMiddleNameFromExcel.getCell(15);
							
							
							String ExpectedMiddleNameFromExcel = testDataSheetRowOfCell15.getStringCellValue();
							
							
							System.out.println("Middle Name from Excel sheet is "+ExpectedMiddleNameFromExcel);
						  //String MiddleNameValue = "Live";
						  By MiddleNameTextboxProperty = By.id("middleName");
						  WebElement MiddleNameTextBox = driver.findElement(MiddleNameTextboxProperty);
						  MiddleNameTextBox.sendKeys(ExpectedMiddleNameFromExcel);
						  
						  Row testDataSheetRowLastNameFromExcel = TestDataSheet.getRow(1);
							
							
							Cell testDataSheetRowOfCell16 = testDataSheetRowLastNameFromExcel.getCell(16);
							
							
							String ExpectedLastNameFromExcel = testDataSheetRowOfCell16.getStringCellValue();
							
							
							System.out.println("Last Name from Excel sheet is "+ExpectedLastNameFromExcel);
						 // String LastNameValue = "Tech";
						  By LastNameTextboxProperty = By.id("lastName");
						  WebElement LastNameTextBox = driver.findElement(LastNameTextboxProperty);
						  LastNameTextBox.sendKeys(ExpectedLastNameFromExcel);
						  
						  By ExpectedEmployeeIdProperty = By.id("employeeId");
						  WebElement ExpectedEmployeeId = driver.findElement(ExpectedEmployeeIdProperty);
						  String ExpectedEmployeeIdValue = ExpectedEmployeeId.getAttribute("value");
						  
						  System.out.println("employee Id is "+ExpectedEmployeeIdValue);
						  Row testDataSheetRowEmployeeId = TestDataSheet.getRow(1);
							
							Cell testDataSheetRowOfCell17= testDataSheetRowEmployeeId.createCell(17);
							
							testDataSheetRowOfCell17.setCellValue(ExpectedEmployeeIdValue);
							
							By SaveButtonProperty = By.id("btnSave");
							  WebElement SaveButton = driver.findElement(SaveButtonProperty);
							  SaveButton.click();
							  Row testDataSheetRowPersonalDetailsFullNameFromExcel = TestDataSheet.getRow(1);
								
								
								Cell testDataSheetRowOfCell18 = testDataSheetRowPersonalDetailsFullNameFromExcel.getCell(18);
								
								
								String ExpectedPersonalDetailsPageFullNameFromExcel = testDataSheetRowOfCell18.getStringCellValue();
								
								
								System.out.println("Personal Details page validation Text from Excel sheet is "+ExpectedPersonalDetailsPageFullNameFromExcel);
								By PersonalDetailsFullNameProperty = By.className("hasTopFieldHelp");
								 WebElement personalDetailsFullName = driver.findElement(PersonalDetailsFullNameProperty);
								 String ActualPersonalDetailsFullName = personalDetailsFullName.getText();
								 
								 System.out.println("Personal Details FullName text is "+ActualPersonalDetailsFullName);
								 Row testDataSheetPersonalDetailsActual = TestDataSheet.getRow(1);
									
									Cell testDataSheetRowOfCell19= testDataSheetPersonalDetailsActual.createCell(19);
									
									testDataSheetRowOfCell19.setCellValue(ActualPersonalDetailsFullName);
									 if(ActualPersonalDetailsFullName.equals(ExpectedPersonalDetailsPageFullNameFromExcel))
									  {
										  System.out.println("Page succefully navigated Personal Details Page :- Pass");
										  Row testDataSheetRow1Result = TestDataSheet.getRow(1);
											
											Cell testDataSheetRowOfCell20Result= testDataSheetRow1Result.createCell(20);
											
											testDataSheetRowOfCell20Result.setCellValue("Pass");
											 }
									  
									  else
									  {
										  System.out.println("Failed to navigate to the Personal Details Page :- Fail");
										  Row testDataSheetRow1Result = TestDataSheet.getRow(1);
											
											Cell testDataSheetRowOfCell20Result= testDataSheetRow1Result.createCell(20);
											
											testDataSheetRowOfCell20Result.setCellValue("Fail");
											 }
					//First Name Validation				 
									 By ActualFullnameProperty = By.id("personal_txtEmpFirstName");
						                WebElement ActualFirstNamePersonalDetailsPage = driver.findElement(ActualFullnameProperty);
						                String ActualFirstNameValue = ActualFirstNamePersonalDetailsPage.getAttribute("value");
						                
						                System.out.println("Actual First Name is "+ActualFirstNameValue);
						                
						                Row testDataSheetPersonalDetailsActualFullName = TestDataSheet.getRow(1);
										
										Cell testDataSheetRowOfCell21= testDataSheetPersonalDetailsActualFullName.createCell(21);
										
										testDataSheetRowOfCell21.setCellValue(ActualFirstNameValue);
										
						                if(ActualFirstNameValue.equals(ExpectedFirstNameFromExcel))
						                {
						                	System.out.println("Actual and Expected First names matched :-Pass");
						                	 Row testDataSheetRow1Result = TestDataSheet.getRow(1);
												
												Cell testDataSheetRowOfCell22Result= testDataSheetRow1Result.createCell(22);
												
												testDataSheetRowOfCell22Result.setCellValue("Pass");
						                }
						                else
						                {
						                	System.out.println("Actual and Expected names not matched :-Fail");
						                	 Row testDataSheetRow1Result = TestDataSheet.getRow(1);
												
												Cell testDataSheetRowOfCell22Result= testDataSheetRow1Result.createCell(22);
												
												testDataSheetRowOfCell22Result.setCellValue("Fail");
						                }
						                
						                //Middle Name Validation
						                By ActualMiddlenameProperty = By.id("personal_txtEmpMiddleName");
						                WebElement ActualMiddleNamePersonalDetailsPage = driver.findElement(ActualMiddlenameProperty);
						                String ActualMiddleNameValue = ActualMiddleNamePersonalDetailsPage.getAttribute("value");
						                
						                System.out.println("Actual Middle Name is "+ActualMiddleNameValue);
                                        Row testDataSheetPersonalDetailsActualMiddleName = TestDataSheet.getRow(1);
										
										Cell testDataSheetRowOfCell23= testDataSheetPersonalDetailsActualMiddleName.createCell(23);
										
										testDataSheetRowOfCell23.setCellValue(ActualMiddleNameValue);
										
						                
						                if(ActualMiddleNameValue.equals(ExpectedMiddleNameFromExcel))
						                {
						                	System.out.println("Actual and Expected Middle names matched :-Pass");
						                	Row testDataSheetRow1Result = TestDataSheet.getRow(1);
											
											Cell testDataSheetRowOfCell24Result= testDataSheetRow1Result.createCell(24);
											
											testDataSheetRowOfCell24Result.setCellValue("Pass");
						                }
						                else
						                {
						                	System.out.println("Actual and Expected Middle names not matched :-Fail");
                                            Row testDataSheetRow1Result = TestDataSheet.getRow(1);
											
											Cell testDataSheetRowOfCell24Result= testDataSheetRow1Result.createCell(24);
											
											testDataSheetRowOfCell24Result.setCellValue("Fail");
						                }
						                
						        //Last Name Validation
						                By LastnameProperty = By.id("personal_txtEmpLastName");
						                WebElement ActualLastNamePersonalDetailsPage = driver.findElement(LastnameProperty);
						                String ActualLastNameValue = ActualLastNamePersonalDetailsPage.getAttribute("value");
						                
						                System.out.println("Actual Middle Name is "+ActualLastNameValue);
                                        Row testDataSheetPersonalDetailsActualLastName = TestDataSheet.getRow(1);
										
										Cell testDataSheetRowOfCell25= testDataSheetPersonalDetailsActualLastName.createCell(25);
										
										testDataSheetRowOfCell25.setCellValue(ActualLastNameValue);
						                
						                if(ActualLastNameValue.equals(ExpectedLastNameFromExcel))
						                {
						                	System.out.println("Actual and Expected Last names matched :-Pass");
                                            Row testDataSheetRow1Result = TestDataSheet.getRow(1);
											
											Cell testDataSheetRowOfCell26Result= testDataSheetRow1Result.createCell(26);
											
											testDataSheetRowOfCell26Result.setCellValue("Pass");
						                }
						                else
						                {
						                	System.out.println("Actual and Expected Last names not matched :-Fail");
                                            Row testDataSheetRow1Result = TestDataSheet.getRow(1);
											
											Cell testDataSheetRowOfCell26Result= testDataSheetRow1Result.createCell(26);
											
											testDataSheetRowOfCell26Result.setCellValue("Fail");
						                }
						                //Employee Id Validation
						                By ExpectedPersonalDteatilsEmployeeIdProperty = By.id("personal_txtEmployeeId");
						  			  WebElement ActualEmployeeId = driver.findElement(ExpectedPersonalDteatilsEmployeeIdProperty);
						  			  String ActualEmployeeIdValue = ActualEmployeeId.getAttribute("value");
						  			System.out.println("Actual Employee id is " +ActualEmployeeIdValue);
						  			Row testDataSheetPersonalDetailsActualEmployeeId = TestDataSheet.getRow(1);
									
									Cell testDataSheetRowOfCell27= testDataSheetPersonalDetailsActualEmployeeId.createCell(27);
									
									testDataSheetRowOfCell27.setCellValue(ActualEmployeeIdValue);
									if(ActualEmployeeIdValue.equals(ExpectedEmployeeIdValue))
									{
										System.out.println("Actual and Expected EmployeeId matched :-Pass");
                                        Row testDataSheetRow1Result = TestDataSheet.getRow(1);
										
										Cell testDataSheetRowOfCell28Result= testDataSheetRow1Result.createCell(28);
										
										testDataSheetRowOfCell28Result.setCellValue("Pass");
									}
									else
									{
										System.out.println("Actual and Expected EmployeeId not matched :-Fail");
                                        Row testDataSheetRow1Result = TestDataSheet.getRow(1);
										
										Cell testDataSheetRowOfCell28Result= testDataSheetRow1Result.createCell(28);
										
										testDataSheetRowOfCell28Result.setCellValue("Fail");
									}
				 By WelcomeAdminPropertyAfter = By.id("welcome");
				WebElement WelcomeAdminTextAfter = driver.findElement(WelcomeAdminPropertyAfter);                
				WelcomeAdminTextAfter.click();
					 Thread.sleep(5000);
					 
					  By logoutButtonPtoperty = By.linkText("Logout");
					  WebElement LogoutButton = driver.findElement(logoutButtonPtoperty);
					  LogoutButton.click();
					  
					  //Login Panel Validation After Logout
					  
					  Row testDataSheetRowLoginPanel = TestDataSheet.getRow(1);
						
						
						Cell testDataSheetRowOfCell29= testDataSheetRowLoginPanel.getCell(29);
						
						
						String ExpectedloginPanelTextAfterLogout = testDataSheetRowOfCell29.getStringCellValue();
						
						System.out.println("Expected Login Panel Text After Logout from Excel sheet is "+ExpectedloginPanelTextAfterLogout);
						
						
						By LoginPanelPropertyAfterLogout = By.id("logInPanelHeading");
						
						
					   WebElement LoginPanelTextAfterLogout = driver.findElement(LoginPanelPropertyAfterLogout);
						String ActualLoginPanelTextAfterLogout = LoginPanelTextAfterLogout.getText();
						
						System.out.println("Actual login panel text After Logout is " + ActualLoginPanelTextAfterLogout);
						
						Row testDataSheetRow1Actual = TestDataSheet.getRow(1);
						
						Cell testDataSheetRowOfCell30= testDataSheetRow1Actual.createCell(30);
						
						testDataSheetRowOfCell30.setCellValue(ActualLoginPanelTextAfterLogout);
						
						if(ActualLoginPanelText.equals(ExpectedloginPanelText))
						{
							System.out.println("Successfully navigated to Login Panel page :- Pass");
							Row testDataSheetRow1Result = TestDataSheet.getRow(1);
							
							Cell testDataSheetRowOfCell31Result= testDataSheetRow1Result.createCell(31);
							
							testDataSheetRowOfCell31Result.setCellValue("Pass");
										
						}
						else {
							System.out.println("Failed to navigated to Login Panel page :- Fail");
					          Row testDataSheetRow1Result = TestDataSheet.getRow(1);
							
							Cell testDataSheetRowOfCell31Result= testDataSheetRow1Result.createCell(31);
							
							testDataSheetRowOfCell31Result.setCellValue("Fail");
						}
						
						FileOutputStream excelActulaLoginPageText = new FileOutputStream("C:\\Users\\swathi\\Desktop\\SeleniumPractice\\AddEmployee.xlsx"); 
						workBook.write(excelActulaLoginPageText);
						
					  
						driver.quit();
	}

}
