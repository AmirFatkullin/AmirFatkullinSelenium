package ru.stqa.training.selenium;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.internal.FindsByClassName;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class my7testmenu {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait=new WebDriverWait(driver,10);
    }


    @Test
    public void my7testmenu() {
        driver.get("http://litecart.stqa.ru/admin/");
        driver.findElements(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("0b7dba1c77df25bf0");
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));


        }
    boolean areElementsPresent(WebDriver driver, By.ById("box-apps-menu")
    {
        return driver.findElements("box-apps-menu").size() > 0;
    }



    @After
    public void stop() {
        driver.quit();
        driver=null;
    }
}