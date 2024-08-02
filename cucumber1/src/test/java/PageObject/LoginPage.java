//package PageObject;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//public class LoginPage {
//	WebDriver driver;
//	
//	By username_box = By.xpath("//*[@id=\"username\"]");
//	
//	By password_box = By.xpath("//*[@id=\"password\"]");
//	
//	By login_btn = By.xpath("//*[@id=\"login\"]/button");
//	By logout_btn = By.xpath("/html/body/main/div[3]/div/a/i");
//	
//	public LoginPage(WebDriver driver) {
//		this.driver = driver;
//	}
//	
//	public void enter_username(String username) {
//		driver.findElement(username_box).sendKeys(username);
//	}
//	public void enter_password(String password) {
//		driver.findElement(password_box).sendKeys(password);
//	}
//	public void press_login_button() {
//		driver.findElement(login_btn).click();
//	}
//	public void loginvalidUser(String username, String password) {
//		driver.findElement(username_box).sendKeys(username);
//		driver.findElement(password_box).sendKeys(password);
//		driver.findElement(login_btn).click();
//		
//	}
//	public void logout_now() {
//		driver.findElement(logout_btn).click();
//	}
//
//}
