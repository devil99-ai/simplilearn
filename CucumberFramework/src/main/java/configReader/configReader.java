package configReader;

import org.openqa.selenium.remote.BrowserType;

public interface configReader {
	public String getUsername();
	public String getPassword();
	public String getWebSite();
	public ConfigurationBrowser.BrowserType getBrowser();
}
