package scenarios;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.security.SecureRandom;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.KeyEvent;

import auto.framework.Keyboard;
import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.TestManager;
import auto.framework.WebManager;
import auto.framework.assertion.Conditions;
import auto.framework.web.Element;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import pageobjects.Yelp_EditPage;
import pageobjects.Yelp_HomePage;
import pageobjects.Yelp_LoginPage;

public class YelpEditTest extends TestBase {
	public static XSSFSheet ExcelWSheet;
	public static XSSFWorkbook ExcelWBook;
    public static XSSFCell Cell;
    public static XSSFRow Row;
    
    @Test
	public void testScenario() throws Exception {
		
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("YelpCamp", "RowSelection='Yelp_TestData'");

		TestCases.preRequisiteStepsYelp(testDataHandler);
		TestCases.editCampground(testDataHandler);
	}
	
 
	public static class TestCases {

		
		public static void preRequisiteStepsYelp(TestDataHandler testDataHandler) throws Exception {
			ReportLog.setTestCase("Pre-Requisite Steps");
			ReportLog.setTestStep("Go to this URL: http://52.213.201.100");
			WebControl.open(testDataHandler.url);
			WebControl.clearData();
			
			ReportLog.setTestStep("Login in Yelp Camp Site.");
			Yelp_LoginPage.getStartedButton.click();
			Yelp_LoginPage.username.waitForExist(true, 10);
			Yelp_LoginPage.username.type(testDataHandler.column3);
			Yelp_LoginPage.password.type(testDataHandler.column4);
			Yelp_LoginPage.signInButton.click();

		}
		
		public static void editCampground(TestDataHandler testDataHandler) throws Exception {
			ReportLog.setTestCase("editCampground Steps");

			ReportLog.setTestStep("Select Campground");
			Yelp_HomePage.batanesOption.click();
			Yelp_HomePage.editButton.click();
			Yelp_EditPage.yelp_EditCampgroundsSection.descriptionField.waitForExist(true, 10);
			Yelp_EditPage.yelp_EditCampgroundsSection.descriptionField.type(testDataHandler.column5);
			Yelp_EditPage.yelp_EditCampgroundsSection.applyChangesButton.click();
		}
		
		
	
	}

}
