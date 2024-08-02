package utility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
public class ResourceHelper {
	
	public static String getResourcePath(String resource) {
		String path = getResourcePath()+resource;
		return path;
	}

	public static String getResourcePath() {
		// TODO Auto-generated method stub
		String path = System.getProperty("user.dir");
		System.out.println(path);
		return path;
	}
	public static FileInputStream getResourcePathInputStream(String Path) throws FileNotFoundException {
		return new FileInputStream(ResourceHelper.getResourcePath(Path));
		
	}
	public static void main(String[] args) {
		getResourcePath();
	}
}
