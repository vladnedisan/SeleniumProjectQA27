import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public static WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test");
    }

    @Test
    public void validLoginTest() {
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("vlad.nedisan@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("1234567");
        driver.findElement(By.id("send2")).click();
        //check hello message
        WebElement message = driver.findElement(By.cssSelector("[class='welcome-msg'] [class='hello']"));
        Assert.assertEquals(message.getText(), "Hello, Vlad Nedisan!");

        //check logout button is displayed after login
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        WebElement logoutButton = driver.findElement(By.cssSelector("[title='Log Out']"));
        Assert.assertTrue(logoutButton.isDisplayed());
    }

    @After
    public void quit() {
        driver.quit();
    }
}