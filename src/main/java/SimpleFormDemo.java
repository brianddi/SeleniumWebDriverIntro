import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleFormDemo {

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

    @Test //verifica ca e scris cuvantul "test" in casuta de text (message)
    public void singleInputField() {
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        driver.findElement(By.id("user-message")).sendKeys( "test");
        driver.findElement(By.id("showInput")).click();
        WebElement yourMessage = driver.findElement(By.id("message"));
        Assert.assertEquals( true, yourMessage.isDisplayed());
    }





    @Test //verifica ca nu exista nimic scris in casuta de text
    public void checkThatTheInputFieldIsEmpty() {
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        driver.findElement(By.id("showInput")).click();
        WebElement yourMessage = driver.findElement(By.id("message"));
        Assert.assertEquals( false, yourMessage.isDisplayed());
    }

}
