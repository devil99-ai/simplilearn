package SignUp;

import org.openqa.selenium.By;

public class PageObjectElement {
	public By login_or_signUp_btn = By.xpath("/html/body/a[2]");
	public By sign_up_btn = By.xpath("/html/body/form/table/tbody/tr[3]/td/a");
	public By fill_email = By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input");
	public By fill_password = By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input");
	public By fill_confirm_password = By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input");
	public By fill_first_name = By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/input");
	public By fill_last_name = By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input");
	public By fill_age = By.xpath("/html/body/form/table/tbody/tr[6]/td[2]/input");
	public By fill_address = By.xpath("/html/body/form/table/tbody/tr[7]/td[2]/input");
	public By click_sign_up = By.xpath("/html/body/form/table/tbody/tr[8]/td/button");


}
