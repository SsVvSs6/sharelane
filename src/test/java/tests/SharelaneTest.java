package tests;

// 1. Открыть браузер на страницу регистрации https://www.sharelane.com/cgi-bin/register.py
// 2. Ввести зип-код
// 3. Нажать "Продолжить"
// 4. Нажать "Регистрация"
// 5. Проверить сообщение

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class SharelaneTest {

    WebDriver driver;

    @Test
    public void verifyRegistrationTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.xpath("//input[@name='zip_code']")).sendKeys("11111");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        driver.findElement(By.xpath("//input[@value='Register']")).click();
        String actualText = driver.findElement(By.xpath("//span[@class='error_message']")).getText();
        Assert.assertEquals(actualText,
                "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
