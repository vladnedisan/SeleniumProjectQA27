import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutTest {
    private WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test");
    }

    @Test
    public void checkoutTest() {
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(4) > a")).click();
        //check url
        Assert.assertEquals(driver.getCurrentUrl(), "http://testfasttrackit.info/selenium-test/checkout/cart/");
        //check empty cart title
        WebElement emptyCartTitle = driver.findElement(By.cssSelector("[class='page-title'] h1"));
        Assert.assertEquals(emptyCartTitle.getText(), "SHOPPING CART IS EMPTY");
        //check empty cart message
        WebElement emptyCartMessage = driver.findElement(By.cssSelector("[class='cart-empty']"));
        Assert.assertEquals(emptyCartMessage.getText(), "You have no items in your shopping cart.\n" + "Click here to continue shopping.");
    }

    @After
    public void quit() {
        driver.quit();
    }
}