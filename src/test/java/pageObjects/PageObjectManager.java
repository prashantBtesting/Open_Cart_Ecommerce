package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObjectManager {
    WebDriver driver;
    landingPage landingPage;
    productDisplayPage PDPPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public landingPage getLandingPage() {
        landingPage = new landingPage(driver);
        return landingPage;
    }
    public productDisplayPage getPDPPage(){
        PDPPage =new  productDisplayPage(driver);
        return PDPPage;
    }
}
