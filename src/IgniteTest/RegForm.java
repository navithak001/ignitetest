package IgniteTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegForm {
	WebDriver _driver;
	public RegForm(WebDriver driver) {
		_driver = driver;
	}
	
	public WebElement getFirstName(){
		return _driver.findElement(By.id("firstName"));
	}
	
	public WebElement getLastName(){
		return _driver.findElement(By.id("lastName"));
	}
	
	public WebElement getEmail(){
		return _driver.findElement(By.id("userEmail"));
	}
	
	public WebElement getGender(){
		return _driver.findElement(By.name("gender"));
	}
	
	public WebElement getGender_Male(){
		return _driver.findElement(By.id("gender-radio-1"));
	}
	
	public WebElement getGender_Female(){
		return _driver.findElement(By.id("gender-radio-2"));
	}
	
	public WebElement getGender_Other(){
		return _driver.findElement(By.id("gender-radio-3"));
	}
	
	public WebElement getPhoneNumber(){
		return _driver.findElement(By.id("userNumber"));
	}
	
	public WebElement getDateOfBirth(){
		return _driver.findElement(By.id("dateOfBirthInput"));
	}
	
	public WebElement getHobbies_Sports(){
		return _driver.findElement(By.id("hobbies-checkbox-1"));
	}
	
	public WebElement getHobbies_Reading(){
		return _driver.findElement(By.id("hobbies-checkbox-2"));
	}
	
	public WebElement getHobbies_Music(){
		return _driver.findElement(By.id("hobbies-checkbox-3"));
	}
	
	public WebElement getPicture(){
		return _driver.findElement(By.id("uploadPicture"));
	}
	
	public WebElement getCurrentAddress(){
		return _driver.findElement(By.id("currentAddress"));
	}
	
	public WebElement getModal(){
		if(_driver.findElements(By.className("modal-content")).isEmpty())
			return null;
		
		return _driver.findElement(By.className("modal-content"));
	}
	
	public WebElement getSubmit(){
		return _driver.findElement(By.id("submit"));
	}
}
