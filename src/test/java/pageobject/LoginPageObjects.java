package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
	
	public LoginPageObjects(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
@FindBy(xpath="//input[@name='username']")
public WebElement Uname;

@FindBy(xpath="//input[@name='password']")
public WebElement Password;

@FindBy(xpath="//button[@type='submit']")
public WebElement Loginbtn;



}
