import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TemaLab18 {

    //navigati pe google, faceti o cautare dupa orice doriti si dati click pe sectiunea de imagini
            public String baseUrl= "http://www.google.com/";
        public WebDriver driver = new ChromeDriver();

        @Test
        public void verifyHomePageSearch() {
            driver.get(baseUrl);
            //Accept cookies
            WebElement cookies = driver.findElement(By.id("L2AGLb"));
            cookies.click();
            // Find the text input element by its name
            WebElement element = driver.findElement(By.name("q"));
            // Enter something to search for
            element.click();
            element.sendKeys("Alice in Wonderland!");

            element.click();
            // Now submit the form. WebDriver will find the form for us from the element
            element.submit();
            // Check the title of the page
            System.out.println("Page title is: " + driver.getTitle());
           // driver.quit();
        }
}
