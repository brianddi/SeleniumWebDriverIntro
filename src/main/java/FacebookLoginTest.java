import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FacebookLoginTest {

    private WebDriver driver;

    @BeforeClass
    public void setup () {
        System.setProperty("web-driver.chrome.driver", "\"C:\\Users\\Toshiba\\Desktop\\Chromedriver winzip_32\\chromedriver.exe\"");
        driver = new ChromeDriver();
            }
    /*@After class
    public void teardown() {
        driver.quit();
    }*/

    @Test
    public void testFacebookLogin() {
        driver.get("https://www.facebook.com");

        //Accept cookies
        try {
            WebElement acceptAllCookiesBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//button" + "[contains(.,'Allow')]")));
            acceptAllCookiesBtn.click();
        } catch (Exception e) {

            System.out.println("Cookie banner not found or could not be interacted with.");
        }

        //Login
        driver.findElement(By.id("email")).sendKeys( "your_facebook_email");
        driver.findElement(By.id("pass")).sendKeys( "your_facebook_password");
        driver.findElement(By.name("login")).click();

        //Verify login
        //driver.findElement(By.linkText("Find your account and login."));
        WebElement element = driver.findElement(By.linkText("Find your account and log in."));
        Assert.assertEquals( true, element.isDisplayed());

    }

}
