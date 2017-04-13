package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;


import javax.xml.bind.Element;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class zadanie9 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait=new WebDriverWait(driver,10);

    }

    @Test
    public void zadanie9()
    {
        driver.get("http://litecart.stqa.ru/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("0b7dba1c77df25bf0");
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));

        driver.get("http://litecart.stqa.ru/admin/?app=countries&doc=countries");
        List<WebElement> countries=driver.findElements(By.xpath(".//*[contains(@class,row)]/td[5]/a"));
        int n=countries.size();

       for(int i=0;(i+1)<n;i++)
        {
            List<WebElement> countriesupload=driver.findElements(By.xpath(".//*[contains(@class,row)]/td[5]/a"));
            String stroka1=countriesupload.get(i).getAttribute("textContent");
            String stroka2=countriesupload.get(i+1).getAttribute("textContent");
            if (stroka1.compareTo(stroka2)<0)
            {
                System.out.println("Алфавитный порядок соблюдается");
            }
                else {System.out.println("ОШИБКА! Алфавитный порядок не соблюдается!!!!!!!!!!!!!!");}


        }
        driver.get("http://litecart.stqa.ru/admin/?app=geo_zones&doc=geo_zones");
        driver.findElement(By.xpath(".//*[contains(@class,'dataTable')]/tbody/tr[2]/td[3]/a")).click();
        List <WebElement> geo=driver.findElements(By.xpath(".//*[contains(@class,'dataTable')]/tbody/tr[2]/td[3]/select[1]/option"));
        for(int g=1;(g+1)<(geo.size());g++)
            {
                List <WebElement> geo1=driver.findElements(By.xpath(".//*[contains(@class,'dataTable')]/tbody/tr[2]/td[3]/select[1]/option"));
                String strok1 = geo1.get(g).getAttribute("textContent");
                String strok2 = geo1.get(g + 1).getAttribute("textContent");
                if (strok1.compareTo(strok2)<0)
                {
                    System.out.println("Алфавитный порядок геозон Канады соблюдается");
                }
                else {System.out.println("ОШИБКА! Алфавитный порядок ГЕОЗОН Канады не соблюдается!!!!!!!!!!!!!!");}
            }



        driver.get("http://litecart.stqa.ru/admin/?app=geo_zones&doc=geo_zones");
        driver.findElement(By.xpath(".//*[contains(@class,'dataTable')]/tbody/tr[3]/td[3]/a")).click();
        List <WebElement> geozon=driver.findElements(By.xpath(".//*[contains(@class,'dataTable')]/tbody/tr[2]/td[3]/select[1]/option"));
        for(int b=1;(b+1)<(geozon.size());b++)
        {
            List <WebElement> geo1=driver.findElements(By.xpath(".//*[contains(@class,'dataTable')]/tbody/tr[2]/td[3]/select[1]/option"));
            String strok11 = geo1.get(b).getAttribute("textContent");
            String strok22 = geo1.get(b + 1).getAttribute("textContent");
            if (strok11.compareTo(strok22)<0)
            {
                System.out.println("Алфавитный порядок геозон США соблюдается");
            }
            else {System.out.println("ОШИБКА! Алфавитный порядок ГЕОЗОН США не соблюдается!!!!!!!!!!!!!!");}
        }
    }

    @After
    public void stop() {
        //driver.quit();
        //driver=null;
    }
}
