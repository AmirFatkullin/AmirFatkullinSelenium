package ru.stqa.training.selenium;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.internal.FindsByClassName;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

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
    public void zadanie7() {
        int i,e,n,k;
        driver.get("http://litecart.stqa.ru/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("0b7dba1c77df25bf0");
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));

        List <WebElement> elements= driver.findElements(By.cssSelector("li#app-"));
        List<WebElement> podelements;
        WebElement element,podelement;
        n=elements.size();

        for(i=0;i<n;i++)
        {
            elements=driver.findElements(By.cssSelector("li#app-"));
            element=elements.get(i);
            wait=new WebDriverWait(driver,10);
            element.click();

            elements=driver.findElements(By.cssSelector("li#app-"));
            element=elements.get(i);
            podelements=element.findElements(By.cssSelector("[id^=doc-]"));
            k=podelements.size();

            if (k>0)
            {
                for(e=0;e<k;e++)
                {
                    elements=driver.findElements(By.cssSelector("li#app-"));
                    element=elements.get(i);
                    podelements=element.findElements(By.cssSelector("[id^=doc-]"));
                    podelement=podelements.get(e);
                    podelement.click();
                    driver.findElement(By.cssSelector("h1"));
                }
            }
            else
            {
                driver.findElement(By.cssSelector("h1"));
            }
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver=null;
    }
}