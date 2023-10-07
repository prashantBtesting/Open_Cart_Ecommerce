package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log;

import java.time.Duration;

public class landingPage {
    WebDriver driver;
    WebDriverWait wait;

    public landingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(xpath = "//a[normalize-space()='iPhone']")
    private WebElement Iphone;
    @FindBy(xpath = "//button[@id='button-cart']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//span[@id='cart-total']")
    private WebElement cartButton;
    @FindBy(xpath = "//strong[normalize-space()='View Cart']")
    private WebElement viewCartButton;

    public void addToCartIphone() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(Iphone));
        Iphone.click();
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
        addToCartButton.click();Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        cartButton.click();
        wait.until(ExpectedConditions.visibilityOf(viewCartButton));
        viewCartButton.click();
        String title = driver.getTitle();
        System.out.println(title);
        Log.info(title);
        Log.info("Clicked on add to cart button");

    }
}
