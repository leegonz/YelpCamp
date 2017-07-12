package pageobjects;

import org.openqa.selenium.By;

import auto.framework.PageBase;
import auto.framework.web.CheckBox;
import auto.framework.web.Element;
import auto.framework.web.Page;
import auto.framework.web.TextBox;

public class Yelp_LoginPage extends PageBase {
	
	
	public static final Element getStartedButton = new TextBox("Get Started Button", By.xpath("//a[@href='/login']"));
	
	public static final TextBox username = new TextBox("Username Textbox", By.id("username"));
	
	public static final TextBox password = new TextBox("Password Textbox", By.id("password"));
	
	public static final Element signInButton = new Element("SignIn Button", By.xpath("//button[contains(.,'SIGN IN')]"));
	
}
