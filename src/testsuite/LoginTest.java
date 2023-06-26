package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/\n";

    @Before
    public void test() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id = 'login-button']")).click();
        String expectedtext = "Products";
//String actualText=driver.findElement(By.xpath("//span[@class =''title]")).getText();


    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id = 'login-button']")).click();
        List<WebElement> elementlist = driver.findElements(By.className("inventory_item"));
        System.out.println("Total Product are " + elementlist.size());
    }

    @After
    public void close() {
        closeBrowser();
    }
}
