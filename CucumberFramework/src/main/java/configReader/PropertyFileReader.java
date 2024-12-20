package configReader;

import java.util.Properties;
import ConfigurationBrowser.BrowserType;
import com.aventstack.extentreports.reporter.configuration.util.ResourceHelper;
import utility.ResourceHelper;
import io.cucumber.core.resource.Resource;

public class PropertyFileReader implements configReader {
	private Properties prop = null;
	public PropertyFileReader(){
		prop = new Properties();
		try {
			prop.load(utility.ResourceHelper.getResourcePathInputStream("/src/main/java/configFile/config.properties"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return prop.getProperty("Username");
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return prop.getProperty("Password");
	}

	@Override
	public String getWebSite() {
		// TODO Auto-generated method stub
		return prop.getProperty("Website");
	}

	@Override
	public BrowserType getBrowser() {
		// TODO Auto-generated method stub
		return BrowserType.valueOf(prop.getProperty("Browser"));
	}

}
