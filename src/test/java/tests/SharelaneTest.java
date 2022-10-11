package tests;

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
// 1. Открыть браузер на страницу регистрации https://www.sharelane.com/cgi-bin/register.py
// 2. Ввести зип-код
// 3. Нажать "Продолжить"
// 4. Нажать "Регистрация"
// 5. Проверить сообщение
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

    @Test
    public void verifyEmptyLastNameTest() {
// 1. Открыть браузер на страницу регистрации https://www.sharelane.com/cgi-bin/register.py
// 2. Ввести зип-код
// 3. Нажать "Продолжить"
// 4. Заполнить поле "First Name"
// 5. Заполнить поле "Email"
// 6. Заполнить поле "Password"
// 7. Заполнить поле "Confirm Password"
// 8. Нажать "Зарегистрироваться"
// 9. Проверить сообщение
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.xpath("//input[@name='zip_code']")).sendKeys("11111");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("FirstA");
        driver.findElement(By.xpath("//input[@name='email']"))
                .sendKeys("vegac89352@civikli.com");
        driver.findElement(By.xpath("//input[@name='password1']")).sendKeys("Qwerty123");
        driver.findElement(By.xpath("//input[@name='password2']")).sendKeys("Qwerty123");
        driver.findElement(By.xpath("//input[@value='Register']")).click();
        String actualText = driver.findElement(By.xpath("//span[@class='confirmation_message']"))
                .getText();
        Assert.assertEquals(actualText, "Account is created!");
    }

    @Test
    public void verifyFullLastNameTest() {
// 1. Открыть браузер на страницу регистрации https://www.sharelane.com/cgi-bin/register.py
// 2. Ввести зип-код
// 3. Нажать "Продолжить"
// 4. Заполнить поле "First Name"
// 5. Заполнить поле "Last Name"
// 6. Заполнить поле "Email"
// 7. Заполнить поле "Password"
// 8. Заполнить поле "Confirm Password"
// 9. Нажать "Зарегистрироваться"
// 10. Проверить сообщение
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.xpath("//input[@name='zip_code']")).sendKeys("11111");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("FirstB");
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Last");
        driver.findElement(By.xpath("//input[@name='email']"))
                .sendKeys("jepive9236@canyona.com");
        driver.findElement(By.xpath("//input[@name='password1']")).sendKeys("Qwerty123");
        driver.findElement(By.xpath("//input[@name='password2']")).sendKeys("Qwerty123");
        driver.findElement(By.xpath("//input[@value='Register']")).click();
        String actualText = driver.findElement(By.xpath("//span[@class='confirmation_message']"))
                .getText();
        Assert.assertEquals(actualText, "Account is created!");
    }

    @Test
    public void verifyDigitsInFirstNameTest() {
// 1. Открыть браузер на страницу регистрации https://www.sharelane.com/cgi-bin/register.py
// 2. Ввести зип-код
// 3. Нажать "Продолжить"
// 4. Заполнить поле "First Name" с цифрой
// 5. Заполнить поле "Email"
// 6. Заполнить поле "Password"
// 7. Заполнить поле "Confirm Password"
// 8. Нажать "Зарегистрироваться"
// 9. Проверить сообщение
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.xpath("//input[@name='zip_code']")).sendKeys("11111");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("First4");
        driver.findElement(By.xpath("//input[@name='email']"))
                .sendKeys("hidabeg415@canyona.com");
        driver.findElement(By.xpath("//input[@name='password1']")).sendKeys("Qwerty123");
        driver.findElement(By.xpath("//input[@name='password2']")).sendKeys("Qwerty123");
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
