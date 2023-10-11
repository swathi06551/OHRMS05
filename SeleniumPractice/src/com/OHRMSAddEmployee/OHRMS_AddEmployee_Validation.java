package com.OHRMSAddEmployee;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OHRMS_AddEmployee_Validation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
				WebDriver driver;
			     String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		      System.out.println("actual Current url address is" +applicationUrlAddress);
		    //Automating the browser
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\swathi\\Desktop\\SeleniumPractice\\DriverFiles/chromedriver.exe");
			driver = new ChromeDriver();
			
		    //Navigating to the application url address
			driver.get(applicationUrlAddress);
			
			//Validating the login web page
			String actual_CurrentUrlAddress=driver.getCurrentUrl();
			
			System.out.println("actual Current url address is  " +actual_CurrentUrlAddress);
			
			if(actual_CurrentUrlAddress.equals(applicationUrlAddress))
			{
			System.out.println("Actual and expected url addresses are same:-Pass");
			}
			else
				System.out.println("Actual and expected url addresses are not same:-Fail`");
			
			//Login to the application
			
			String ExpectedloginPanelText = "LOGIN Panel";
			//<div id="logInPanelHeading">LOGIN Panel</div>
			
			By LoginPanelProperty = By.id("logInPanelHeading");
			
			
		    WebElement ActualLoginPanelText = driver.findElement(LoginPanelProperty);
			String LoginPanelText = ActualLoginPanelText.getText();
			
			System.out.println("Actual login panel text is " + LoginPanelText);
			
			if(ActualLoginPanelText.equals(ExpectedloginPanelText))
			{
				System.out.println("Login panel message is correct:- Pass");
			}
			else
				System.out.println("Login panel message is not correct :- Fail");
			
			String UserNameTestData = "Admin";
			 By UserNameProperty = By.id("txtUsername");
			 WebElement userName = driver.findElement(UserNameProperty);
			 userName.sendKeys(UserNameTestData);
			 
			 String PasswordTestData = "Livetech@123";
			 By PasswordProperty = By.id("txtPassword");
			 WebElement password = driver.findElement(PasswordProperty);
			 password.sendKeys(PasswordTestData);
			 
			 By LoginButtonProperty = By.id("btnLogin");
			 WebElement LoginButton = driver.findElement(LoginButtonProperty);
			 LoginButton.click();
			 
			 //<a href="#" id="welcome" class="panelTrigger">Welcome Hyma</a>
			 
			 String ExpectedWelcomeAdmin = "Welcome Admin";
			 
			 System.out.println("Expected welcome message is " +ExpectedWelcomeAdmin);
			 By WelcomeAdminProperty = By.id("welcome");
			 WebElement WelcomeAdminText = driver.findElement(WelcomeAdminProperty);
			 String ActualWelcomeAdmin = WelcomeAdminText.getText();
			 
			 System.out.println("Actual Welcome Admin message is " +ActualWelcomeAdmin);
			 
			 if(ActualWelcomeAdmin.equals(ExpectedWelcomeAdmin))
			 {
				 System.out.println("Welcome admin message displayed: - Pass");
			 }
			 else
				 System.out.println("Welcome admin message not displayed: - Fail");
			 
			 By PIMProperty = By.id("menu_pim_viewPimModule");
			 WebElement PIMmodule = driver.findElement(PIMProperty);
			 Actions PIMactions = new Actions(driver);
			 PIMactions.moveToElement(PIMmodule).build().perform();
			 
			 By AddEmployeeProperty = By.id("menu_pim_addEmployee");
			 WebElement AddEmployee = driver.findElement(AddEmployeeProperty);
			 AddEmployee.click();
			 
			 String ExpectedText = "Full Name";
			 
			 System.out.println("Expected text is Full Name");
			 
			 By FullNameProperty = By.className("hasTopFieldHelp");
			 WebElement FullName = driver.findElement(FullNameProperty);
			 String ActualFullName = FullName.getText();
			 
			 System.out.println("Actual text is "+ActualFullName);
			 
			 if(ActualFullName.equals(ExpectedText))
					 {
				 System.out.println("Page succefully navigated to Add Employee details Page :- Pass");
					 }
			 else 
			 {
				 System.out.println("Failed to navigate to Add Employee Details page :- Fail");
			 }
			 
			  String FullNameValue = "Admin1";
			  By FullNameTextboxProperty = By.id("firstName");
			  WebElement FullNameTextBox = driver.findElement(FullNameTextboxProperty);
			  FullNameTextBox.sendKeys(FullNameValue);
			  
			  String MiddleNameValue = "Live";
			  By MiddleNameTextboxProperty = By.id("middleName");
			  WebElement MiddleNameTextBox = driver.findElement(MiddleNameTextboxProperty);
			  MiddleNameTextBox.sendKeys(MiddleNameValue);
			  
			  String LastNameValue = "Tech";
			  By LastNameTextboxProperty = By.id("lastName");
			  WebElement LastNameTextBox = driver.findElement(LastNameTextboxProperty);
			  LastNameTextBox.sendKeys(LastNameValue);
			  
			  By ExpectedEmployeeIdProperty = By.id("employeeId");
			  WebElement ExpectedEmployeeId = driver.findElement(ExpectedEmployeeIdProperty);
			  String ExpectedEmployeeIdValue = ExpectedEmployeeId.getAttribute("value");
			  
			  System.out.println("Expected employee Id is "+ExpectedEmployeeIdValue);
			  
			  By SaveButtonProperty = By.id("btnSave");
			  WebElement SaveButton = driver.findElement(SaveButtonProperty);
			  SaveButton.click();
			  //<h1>Personal Details</h1>
			  String ExpectedPage = "Full Name";
			  By PersonalDetailsFullNameProperty = By.className("hasTopFieldHelp");
				 WebElement personalDetailsFullName = driver.findElement(PersonalDetailsFullNameProperty);
				 String ActualPersonalDetailsFullName = personalDetailsFullName.getText();
			  
			  System.out.println("Actual Page title is  "+ActualPersonalDetailsFullName);
			 
			  if(ActualPersonalDetailsFullName.equals(ExpectedPage))
			  {
				  System.out.println("Page succefully navigated Personal Details Page :- Pass");
			  }
			  else
			  {
				  System.out.println("Failed to navigate to the Personal Details Page :- Fail");
				  
			  }
                By ActualFullnameProperty = By.id("personal_txtEmpFirstName");
                WebElement ActualFullNamePersonalDetailsPage = driver.findElement(ActualFullnameProperty);
                String ActualFullNameValue = ActualFullNamePersonalDetailsPage.getAttribute("value");
                
                System.out.println("Actual Full Name is "+ActualFullNameValue);
                
                if(ActualFullNameValue.equals(FullNameValue))
                {
                	System.out.println("Actual and Expected names matched");
                }
                else
                {
                	System.out.println("Actual and Expected names not matched");
                }
                
                //personal_txtEmpMiddleName
                By ActualMiddlenameProperty = By.id("personal_txtEmpMiddleName");
                WebElement ActualMiddleNamePersonalDetailsPage = driver.findElement(ActualMiddlenameProperty);
                String ActualMiddleNameValue = ActualMiddleNamePersonalDetailsPage.getAttribute("value");
                
                System.out.println("Actual Middle Name is "+ActualMiddleNameValue);
                
                if(ActualMiddleNameValue.equals(MiddleNameValue))
                {
                	System.out.println("Actual and Expected Middle names matched");
                }
                else
                {
                	System.out.println("Actual and Expected Middle names not matched");
                }
                
                By LastnameProperty = By.id("personal_txtEmpLastName");
                WebElement ActualLastNamePersonalDetailsPage = driver.findElement(LastnameProperty);
                String ActualLastNameValue = ActualLastNamePersonalDetailsPage.getAttribute("value");
                
                System.out.println("Actual Middle Name is "+ActualLastNameValue);
                
                if(ActualLastNameValue.equals(LastNameValue))
                {
                	System.out.println("Actual and Expected Last names matched");
                }
                else
                {
                	System.out.println("Actual and Expected Last names not matched");
                }
                
                By WelcomeAdminPropertyAfter = By.id("welcome");
   			 WebElement WelcomeAdminTextAfter = driver.findElement(WelcomeAdminPropertyAfter);
   			// String ActualWelcomeAdminAfter = WelcomeAdminTextAfter.getText();
   			WelcomeAdminTextAfter.click();
                Thread.sleep(5000);
           	 //<a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>
           	  By logoutButtonPtoperty = By.linkText("Logout");
           	  WebElement LogoutButton = driver.findElement(logoutButtonPtoperty);
           	  LogoutButton.click();
           	  
           	  By LoginPanelafterLogoutProperty = By.id("logInPanelHeading");
           		
           		
           	    WebElement ActualLoginPanelAfterLogout = driver.findElement(LoginPanelafterLogoutProperty);
           		String LoginPanelAfterLogoutText = ActualLoginPanelAfterLogout.getText();
           		
           		System.out.println("Actual login panel text is " + LoginPanelAfterLogoutText);
           		
           		if(LoginPanelAfterLogoutText.equals(ExpectedloginPanelText))
           		{
           			System.out.println("Successfully navigated back to Login Panel Page:- Pass");
           		}
           		else
           			System.out.println("Failed to Navigate back to Login Panel Page:- Fail");
           	 
           	 
           	 driver.quit();
           	 
           	
           	}
           		
           
	}
	
	
	
	             
	
