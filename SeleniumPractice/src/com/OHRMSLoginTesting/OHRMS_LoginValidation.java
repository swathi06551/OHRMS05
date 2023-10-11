package com.OHRMSLoginTesting;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OHRMS_LoginValidation {

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
	 else {
		 System.out.println("Welcome admin message not displayed: - Fail");
	 }
	 WelcomeAdminText.click();
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
