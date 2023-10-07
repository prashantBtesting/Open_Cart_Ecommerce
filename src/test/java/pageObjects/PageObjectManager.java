package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectManager {
    WebDriver driver;
    WebDriverWait wait;
    landingPage landingPage;
    productDisplayPage PDPPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;

    }

    public landingPage getLandingPage() {
        landingPage = new landingPage();
        return landingPage;
    }
    public productDisplayPage getPDPPage(){
        PDPPage =new  productDisplayPage();
        return PDPPage;
    }
}
