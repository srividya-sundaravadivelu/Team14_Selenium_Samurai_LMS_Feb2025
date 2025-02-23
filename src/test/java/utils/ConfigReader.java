package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	private static Properties properties = new Properties();    

	static {
		try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config/config.properties")) {
			if (input == null) {
				throw new RuntimeException("config.properties file not found");
			}
			properties.load(input);
		} catch (IOException ex) {
			throw new RuntimeException("Error loading config.properties file", ex);
		}
	}

	public static void setBrowser(String browserName) {
		properties.setProperty("browser", browserName);
	}

	public static String getBrowser() {
		return properties.getProperty("browser");
	}

	public static String getBaseUrl() {
		return properties.getProperty("base.url");
	}

	public static String getPageLoadTimeout() {
		return properties.getProperty("page.load.timeout");
	}

	public static long getWebDriverWaitTimeout() {
		return Long.parseLong(properties.getProperty("webdriver.wait.timeout"));
	}

	// Login Page URLs
	public static String getLoginUrl() {
		return properties.getProperty("login.url");
	}
	// Home Page URL
	public static String getHomeUrl() {
		return properties.getProperty("home.url");
	}
	public static String getProgramUrl() {
		return properties.getProperty("program.url");
	}
	
	public static boolean isChromeHeadless() {
		return Boolean.parseBoolean(properties.getProperty("browser.chrome.headless", "false"));
	}
	
	public static boolean isFireFoxHeadless() {
		return Boolean.parseBoolean(properties.getProperty("browser.firefox.headless", "false"));
	}
	
	public static boolean isEdgeHeadless() {
		return Boolean.parseBoolean(properties.getProperty("browser.edge.headless", "false"));
	}
	
	public static String getHomePageTitle() {
		return properties.getProperty("home.title");
	}
}
