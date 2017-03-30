package ru.stqa.training.selenium;


import com.sun.javafx.scene.EnteredExitedHandler;
import org.apache.commons.exec.ExecuteException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementSelectionStateToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class zadanie11 {
    private WebDriver driver;
    private WebDriverWait wait;
    //public void selectByValue{}
    //public interface ISelect{};



    @Before
    public void start() {
        driver = new ChromeDriver();
        wait=new WebDriverWait(driver,10);


    }


    @Test
    public void my7testmenu() {
        driver.get("http://litecart.stqa.ru/index.php/en/create_account");
        //.findElement(By.name("username")).sendKeys("admin");
        //driver.findElement(By.name("password")).sendKeys("0b7dba1c77df25bf0");
        //driver.findElement(By.name("login")).click();
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

        //sendKeys(Keys.Pa);
        //driver.findElement(By.option("FL")).click();
        //driver.findElement(By.cssSelector("select").);
        //WebElement element = driver.findElement(By.name("zone_code"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement selectElem = driver.findElement(By.tagName("select")).findElement(By.name("name"));
        Select select = new Select(selectElem);
        select.selectByValue("FL");
        driver.findElement(By.name("email")).sendKeys("amr@ya.ru");
        driver.findElement(By.name("phone")).sendKeys("89015564879");
        driver.findElement(By.name("password")).sendKeys("12345678");
        driver.findElement(By.name("confirmed_password")).sendKeys("12345678");
        driver.findElement(By.name("create_account")).click();



        }




    @After
    public void stop() {
     // driver.quit();
      //driver=null;
    }
}