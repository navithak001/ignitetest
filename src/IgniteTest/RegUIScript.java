package IgniteTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class RegUIScript {
	
	static WebDriver driver;
	static RegForm regForm;
	
	@BeforeSuite
	public static void SetUp() {
		
		try {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
			driver = (WebDriver) new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
			
			driver.get("https://demoqa.com/automation-practice-form");
			
			regForm = new RegForm(driver);
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public static void ValidateRequiredFields() {
		try {
			driver.navigate().refresh();
			Thread.sleep(2000);
		
			Utils.Click(driver, regForm.getSubmit());
			Assert.assertTrue(!Utils.IsValid(driver, regForm.getFirstName()));
			Assert.assertTrue(!Utils.IsValid(driver, regForm.getLastName()));
			Assert.assertTrue(!Utils.IsValid(driver, regForm.getGender()));
			Assert.assertTrue(!Utils.IsValid(driver, regForm.getPhoneNumber()));
			
			regForm.getFirstName().sendKeys("Navitha");
			Assert.assertTrue(Utils.IsValid(driver, regForm.getFirstName()));
			Assert.assertTrue(!Utils.IsValid(driver, regForm.getLastName()));
			Assert.assertTrue(!Utils.IsValid(driver, regForm.getGender()));
			Assert.assertTrue(!Utils.IsValid(driver, regForm.getPhoneNumber()));
			
			regForm.getLastName().sendKeys("Mandava");
			Assert.assertTrue(Utils.IsValid(driver, regForm.getFirstName()));
			Assert.assertTrue(Utils.IsValid(driver, regForm.getLastName()));
			Assert.assertTrue(!Utils.IsValid(driver, regForm.getGender()));
			Assert.assertTrue(!Utils.IsValid(driver, regForm.getPhoneNumber()));
			
			Utils.Click(driver, regForm.getGender_Female());
			Assert.assertTrue(Utils.IsValid(driver, regForm.getFirstName()));
			Assert.assertTrue(Utils.IsValid(driver, regForm.getLastName()));
			Assert.assertTrue(Utils.IsValid(driver, regForm.getGender()));
			Assert.assertTrue(!Utils.IsValid(driver, regForm.getPhoneNumber()));
			
			regForm.getPhoneNumber().sendKeys("7717444144");
			Assert.assertTrue(Utils.IsValid(driver, regForm.getFirstName()));
			Assert.assertTrue(Utils.IsValid(driver, regForm.getLastName()));
			Assert.assertTrue(Utils.IsValid(driver, regForm.getGender()));
			Assert.assertTrue(Utils.IsValid(driver, regForm.getPhoneNumber()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public static void EmailValidation() {
		try {
			driver.navigate().refresh();
			Thread.sleep(2000);
			
			regForm.getEmail().sendKeys("invalid@email");
			Utils.Click(driver, regForm.getSubmit());
			Assert.assertTrue(!Utils.IsValid(driver, regForm.getEmail()));
			
			regForm.getEmail().clear();
			regForm.getEmail().sendKeys("navitha@mandava.com");
			Assert.assertTrue(Utils.IsValid(driver, regForm.getEmail()));
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public static void PhoneValidation() {
		try {
			driver.navigate().refresh();
			Thread.sleep(2000);
			
			regForm.getPhoneNumber().clear();
			regForm.getPhoneNumber().sendKeys("invalidnum");
			Utils.Click(driver, regForm.getSubmit());
			Assert.assertTrue(!Utils.IsValid(driver, regForm.getPhoneNumber()));
			
			regForm.getPhoneNumber().clear();
			regForm.getPhoneNumber().sendKeys("7717665667");
			Assert.assertTrue(Utils.IsValid(driver, regForm.getPhoneNumber()));
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public static void DOBValidation() {
		try {
			driver.navigate().refresh();
			Thread.sleep(2000);
			
			regForm.getDateOfBirth().clear();
			Date currentDate = new Date();
			Calendar c = Calendar.getInstance();
		    c.setTime(currentDate);
		    c.add(Calendar.YEAR, 1);
		    DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
			regForm.getDateOfBirth().sendKeys(dateFormat.format(c.getTime()));
			Utils.Click(driver, regForm.getSubmit());
			Assert.assertTrue(!Utils.IsValid(driver, regForm.getDateOfBirth()));
			
			regForm.getDateOfBirth().clear();
			c.setTime(currentDate);
			regForm.getDateOfBirth().sendKeys(dateFormat.format(c.getTime()));
			Assert.assertTrue(Utils.IsValid(driver, regForm.getDateOfBirth()));
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public static void AntiXSSValidation() {
		try {
			driver.navigate().refresh();
			Thread.sleep(2000);
			
			regForm.getFirstName().clear();
			regForm.getFirstName().sendKeys("Attacker \"/><script>StealCredentials()</script>");			
			Utils.Click(driver, regForm.getSubmit());
			Assert.assertTrue(!Utils.IsValid(driver, regForm.getFirstName()));
			
			regForm.getLastName().clear();
			regForm.getLastName().sendKeys("Attacker \"/><script>StealCredentials()</script>");			
			Utils.Click(driver, regForm.getSubmit());
			Assert.assertTrue(!Utils.IsValid(driver, regForm.getLastName()));
			
			regForm.getEmail().clear();
			regForm.getEmail().sendKeys("Attacker \"/><script>StealCredentials()</script>");			
			Utils.Click(driver, regForm.getSubmit());
			Assert.assertTrue(!Utils.IsValid(driver, regForm.getEmail()));
			
			regForm.getPhoneNumber().clear();
			regForm.getPhoneNumber().sendKeys("Attacker \"/><script>StealCredentials()</script>");			
			Utils.Click(driver, regForm.getSubmit());
			Assert.assertTrue(!Utils.IsValid(driver, regForm.getPhoneNumber()));
			
			regForm.getCurrentAddress().clear();
			regForm.getCurrentAddress().sendKeys("Attacker \"/><script>StealCredentials()</script>");			
			Utils.Click(driver, regForm.getSubmit());
			Assert.assertTrue(!Utils.IsValid(driver, regForm.getCurrentAddress()));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public static void ValidateCompleteForm() {
		try {
			driver.navigate().refresh();
			Thread.sleep(2000);
			
			regForm.getFirstName().sendKeys("Navitha");
			regForm.getLastName().sendKeys("Mandava");
			regForm.getEmail().sendKeys("navitha@mandava.com");
			Utils.Click(driver, regForm.getGender_Female());
			regForm.getPhoneNumber().sendKeys("7717656543");
			regForm.getDateOfBirth().clear();
			regForm.getDateOfBirth().sendKeys("01 Nov 1990");
			Utils.Click(driver, regForm.getHobbies_Sports());
			Utils.Click(driver, regForm.getHobbies_Reading());
			Utils.Click(driver, regForm.getHobbies_Music());
			regForm.getCurrentAddress().sendKeys("Test Address");
			Utils.Click(driver, regForm.getSubmit());
			
			Assert.assertTrue(regForm.getModal() != null);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
	
}
