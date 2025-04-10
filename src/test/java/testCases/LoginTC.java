package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobject.LoginPageObjects;
import utilities.LoginData;

public class LoginTC extends baseClass {
	
	LoginPageObjects login ;
	@Test
	public void loginWithValidCred()
	{
		setup();
		login =new LoginPageObjects(driver);
		login.Uname.sendKeys("Admin");
		login.Password.sendKeys("admin123");
		login.Loginbtn.click();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	//Data With Excel File
	@Test(dataProvider="LoginData")
	public void LoginWithExcelData(String UserName, String Password,String TC)
	{
		setup();
		login =new LoginPageObjects(driver);
		login.Uname.sendKeys(UserName);
		login.Password.sendKeys(Password);
		login.Loginbtn.click();
		String URL=driver.getCurrentUrl();
		switch(TC){
			case "Valid" :Assert.assertEquals(URL, "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
			              break;
			   
			case "Invalid":Assert.assertEquals(URL,"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			               break;
			               
			default: System.out.println("Invalid Test Case");
			
			
		}
//		if(URL.equals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"))
//		{
//			Assert.assertEquals(URL, "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
//		}
//		else
//		{
//			Assert.assertEquals(URL,"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		}
		
	}
	
	@DataProvider(name="LoginData")
	public String[][] data() throws IOException
	{
		return LoginData.ExcelRead("C:\\Users\\GANESH TAMBE\\Desktop\\LoginData.xlsx");
	}

}
