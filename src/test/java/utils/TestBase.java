package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;
    public Properties properties;
    private static final String USERNAME = "prashantbabar_nGO8JI";
    private static final String ACCESS_KEY = "Dxe8CsKog9CxfhwynFrp";
    private static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY +
            "@hub-cloud.browserstack.com/wd/hub";

    public WebDriver initializeDriver() throws IOException {
        if (driver == null) {
            String browserProperties = loadProperties("browser");
            String browserMaven = System.getProperty(("browser"));
            String browser = browserMaven != null ? browserMaven : browserProperties;
            Log.info(browser);
            if (browser.equalsIgnoreCase("Chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                driver = new ChromeDriver(options);
                //Log.info("You have initialized a Chrome driver");
                navigate();
            } else if (browser.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
                FirefoxOptions options = new FirefoxOptions();
                options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
                driver = new FirefoxDriver(options);
                Log.info("You have initialized a Firefox driver");
                navigate();
            } else if (browser.equalsIgnoreCase("Edge")) {
                driver = new EdgeDriver();
                Log.info("You have initialized a Edge driver");
                navigate();
            } else if (browser.equalsIgnoreCase("Safari")) {
                driver = new SafariDriver();
                Log.info("You have initialized a Safari driver");
                navigate();
            } else if (browser.equalsIgnoreCase("Chrome headless")) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--headless");
                options.addArguments("--window-size=1920x1080");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-gpu");
                driver = new ChromeDriver(options);
                Log.info("You have initialized Chrome in headless mode");
                navigate();
            } else if (browser.equalsIgnoreCase("BrowserStackTests")) {
                //BrowserStack Integration
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "91.0");
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("name", "DemoQATest");
                caps.setCapability("buildName", "DemoQATestFlightBooking");
                driver = new RemoteWebDriver(new URL(URL), caps);
                Log.info("You have initialized Chrome in Browserstack");
                navigate();
            } else {
                Log.error("There is some error in Browser name");
            }
        }
        return driver;
    }

    public String loadProperties(String property) throws IOException {
        properties = new Properties();
        FileInputStream dataFile = new FileInputStream("src/test/resources/global.properties");
        properties.load(dataFile);
        return properties.getProperty(property);
    }

    public void navigate() throws IOException {
        driver.manage().window().maximize();
        driver.get(loadProperties("url"));
    }
}
