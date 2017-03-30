package ru.stqa.training.selenium;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;



public class zadanie11 {
    private WebDriver driver;
    private WebDriverWait wait;



    @Before
    public void start() {
        driver = new ChromeDriver();
        wait=new WebDriverWait(driver,10);
    }


    @Test
    public void zadanie11() {
        driver.get("http://litecart.stqa.ru/index.php/en/create_account");
        driver.findElement(By.name("tax_id")).sendKeys("12452556");
        driver.findElement(By.name("company")).sendKeys("Google");
        driver.findElement(By.name("firstname")).sendKeys("Amir");
        driver.findElement(By.name("lastname")).sendKeys("Fatkullin");
        driver.findElement(By.name("address1")).sendKeys("Green street");
        driver.findElement(By.name("address2")).sendKeys("Yellow street");
        driver.findElement(By.name("postcode")).sendKeys("99999");
        driver.findElement(By.name("city")).sendKeys("New York");
        driver.findElement(By.className("select2-selection__rendered")).click();
        driver.findElement(By.className("select2-search__field")).sendKeys("United States"+ Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement selectElem = driver.findElement(By.xpath("//select[@name='zone_code']"));
        Select select = new Select(selectElem);
        select.selectByValue("FL");
        driver.findElement(By.name("email")).sendKeys("amirkaaaaaabcd@ya.ru");
        driver.findElement(By.name("phone")).sendKeys("89015564879");
        driver.findElement(By.name("password")).sendKeys("12345678");
        driver.findElement(By.name("confirmed_password")).sendKeys("12345678");
        driver.findElement(By.name("create_account")).click();
        driver.findElement(By.linkText("Logout")).click();
        driver.findElement(By.name("email")).sendKeys("amirkaaaaaab@ya.ru");
        driver.findElement(By.name("password")).sendKeys("12345678");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.linkText("Logout")).click();
        }


    @After
    public void stop() {
     //driver.quit();
      //driver=null;
    }
}