package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage {
	
	public WebDriver driver;
	
	public MenuPage(WebDriver driver) {
		this.driver = driver;
	}

	//locatori sau webelements
	//WebElement buton =  driver.findElement(By.ceva(""))
	public By homeLink = By.linkText("HOME");
	public By contactLink = By.linkText("CONTACTS");
	public By loginLink = By.linkText("Login");
	public By shopLink = By.linkText("BOOKS");
	
	//metode specifice cu locatori sau elementele de mai sus
	//metode specifice inseamna functionalitate a paginii in care ma aflu
	public void navigateTo(By locator) {
		driver.findElement(locator).click();
	}
	
}
