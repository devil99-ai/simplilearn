import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;

public class Login {
	public static void main(String[] args) {


// TODO Auto-generated method stub WebDriver driver = new ChromeDriver();

			driver.get("https://adactinhotelapp.com/");

			driver.manage().window().maximize();

			WebElement username =driver.findElement(By.xpath("(//input[@class='login_input'])[1]"));

			username.sendKeys("pearlchri");

			WebElement password =driver.findElement(By.xpath("(//input[@class='login_input'])[2]"));

			password.sendKeys("Password@1");

			WebElement login =driver.findElement(By.id("login"));

			login.click();

			WebElement SubmitBtn =driver.findElement(By.xpath("//input[contains(@name, 'Submit')]"));

			Boolean enabledOrNot = SubmitBtn.isEnabled();
			System.out.println(enabledOrNot);


})