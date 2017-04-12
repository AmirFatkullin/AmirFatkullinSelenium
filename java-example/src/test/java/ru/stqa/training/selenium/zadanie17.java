package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class zadanie17 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait=new WebDriverWait(driver,10);

    }
    @Test
    public void getBrowserLogs()
    {
        driver.get("http://litecart.stqa.ru/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("0b7dba1c77df25bf0");
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));
        driver.findElement(By.cssSelector("[href='http://litecart.stqa.ru/admin/?app=catalog&doc=catalog']")).click();
        driver.findElement(By.cssSelector("[href='http://litecart.stqa.ru/admin/?app=catalog&doc=catalog&category_id=1']")).click();
        List<WebElement> product = driver.findElements(By.xpath(".//*[contains(@class,'row')]/td[3]/a"));
        int n=product.size();
        System.out.println(n);
        for(int i = 1;i<n;i++)
        {
            List<WebElement> productList = driver.findElements(By.xpath(".//*[contains(@class,'row')]/td[3]/a"));
            productList.get(i).click();
            driver.findElement(By.cssSelector("[href='http://litecart.stqa.ru/admin/?app=catalog&doc=catalog']")).click();
            driver.findElement(By.cssSelector("[href='http://litecart.stqa.ru/admin/?app=catalog&doc=catalog&category_id=1']")).click();
        }

        for (LogEntry l : driver.manage().logs().get("browser").getAll()) {
            System.out.println(l);
        }
    }


    @After
    public void stop() {
driver.quit();
driver=null;
    }
}
