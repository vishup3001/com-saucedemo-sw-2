package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseurl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        // Open browser and launch base url
        openBrowser(baseurl);
    }

    @After
    public void terminateBrowser() {
        // Close all windows
        closeBrowser();
    }

    @Test
    public void userSholdLoginSuccessfullyWithValid() {
        String expectedMessage = "Products";
        //Element to send username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // Element to send password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //Element to click login button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        // Element to get message
        WebElement getMessage = driver.findElement(By.xpath("//span[@class='title']"));
        String actualMessage = getMessage.getText();
        // verification of actual message and excepted message
        Assert.assertEquals("Fail to click on login button", expectedMessage, actualMessage);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {

        int actualProdut = 6;
        //Element to send username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // Element to send password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //Element to click login button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        //Element to get number of product
        List<WebElement> listOfProduct = driver.findElements(By.xpath("//*[@class='inventory_item_name']"));
        int exceptedProduct = listOfProduct.size();
        // verification of actual message and excepted message
        Assert.assertEquals("Fail to loging", actualProdut, exceptedProduct);
    }


}
