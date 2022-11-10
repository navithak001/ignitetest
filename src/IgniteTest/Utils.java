package IgniteTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {

	public static boolean IsValid(WebDriver driver, WebElement elem) {
		 return (Boolean)((JavascriptExecutor)driver).executeScript("return arguments[0].validity.valid;", elem);
	}
	
	public static void Click(WebDriver driver, WebElement elem) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", elem);
	}
}
