package Login;

import org.openqa.selenium.By;

public class PageObjectElement {
	public By login_or_signUp_btn = By.xpath("/html/body/a[2]");
	public By fill_email = By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input");
	public By fill_passwd = By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input");
	public By login_btn = By.xpath("/html/body/form/table/tbody/tr[3]/td/button");

}
