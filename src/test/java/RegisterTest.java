import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class RegisterTest {
    private WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test");
    }

    @Test
    public void validRegisterTest() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Vlad");
        driver.findElement(By.id("lastname")).sendKeys("Nedisan");
        driver.findElement(By.id("email_address")).sendKeys("vladnedisan" + randomInt + "@yahoo.com");
        driver.findElement(By.id("password")).sendKeys("1234567");
        driver.findElement(By.id("confirmation")).sendKeys("1234567");
        driver.findElement(By.cssSelector(" #form-validate > div.fieldset > ul > li.control > label")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button")).click();
        //check success message after register
        WebElement successMessage = driver.findElement(By.cssSelector("[class='success-msg']"));
        Assert.assertEquals(successMessage.getText(), "Thank you for registering with Madison Island.");
        //check account information box is displayed
        WebElement accountInformationBox = driver.findElement(By.cssSelector("[class='box-account box-info']"));
        Assert.assertTrue(accountInformationBox.isDisplayed());
    }

    @After
    public void quit() {
        driver.quit();
    }

}
