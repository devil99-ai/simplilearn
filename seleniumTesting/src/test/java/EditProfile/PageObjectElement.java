package EditProfile;

import org.openqa.selenium.By;

public class PageObjectElement {
	public By login_or_signUp_btn = By.xpath("/html/body/a[2]");
	public By fill_email = By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input");
	public By fill_passwd = By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input");
	public By login_btn = By.xpath("/html/body/form/table/tbody/tr[3]/td/button");
	public By home_btn = By.xpath("/html/body/a[1]");
	public By edit_profile_btn = By.xpath("/html/body/a[5]");
	public By password = By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input");
	public By confirm_password=By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input");
	public By first_name_fill = By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input");
	public By last_name_fill = By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/input");
	public By age_fill = By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input");
	public By address_fill = By.xpath("/html/body/form/table/tbody/tr[6]/td[2]/input");
	public By update_btn = By.xpath("/html/body/form/table/tbody/tr[7]/td/button");

}
