import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class zadanie12 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait=new WebDriverWait(driver,10);

    }

    @Test
    public void zadanie12()
        {
        driver.get("http://litecart.stqa.ru/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("0b7dba1c77df25bf0");
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));
        driver.findElement(By.cssSelector("[href='http://litecart.stqa.ru/admin/?app=catalog&doc=catalog']")).click();
        driver.findElement(By.cssSelector("[href='http://litecart.stqa.ru/admin/?category_id=0&app=catalog&doc=edit_product']")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Enabled')]")).click();
        driver.findElement(By.cssSelector("[name='name[en]']")).sendKeys("NewMyDUCK");
        driver.findElement(By.cssSelector("[name=code]")).sendKeys("123456");
        driver.findElement(By.cssSelector("[data-name='Rubber Ducks']")).click();
        driver.findElement(By.cssSelector("[value='1-3']")).click();
        driver.findElement(By.cssSelector("[name=quantity]")).clear();
        driver.findElement(By.cssSelector("[name=quantity]")).sendKeys("100");
        driver.findElement(By.cssSelector("[name='new_images[]']")).sendKeys("C:\\Users\\Амир\\Downloads\\images.png");
        driver.findElement(By.cssSelector("[name='date_valid_from']")).sendKeys("12052015");
        driver.findElement(By.cssSelector("[name='date_valid_to']")).sendKeys("12052018");

        driver.findElement(By.cssSelector("[href='#tab-information']")).click();
        Select manufacturerSelect = new Select(driver.findElement(By.name("manufacturer_id")));
        manufacturerSelect.selectByValue("1");
        driver.findElement(By.cssSelector("[name='keywords']")).sendKeys("fdhgdfhjgfh");
            driver.findElement(By.cssSelector("[name='short_description[en]']")).sendKeys("qwrfasdghkkkjhgk");
            driver.findElement(By.cssSelector("[name='description[en]']")).sendKeys("32tgrabcdqwrfasdghkkkjhgk");
            driver.findElement(By.cssSelector("[name='head_title[en]']")).sendKeys("abcdqwrfasdghkkkjhgk");
            driver.findElement(By.cssSelector("[name='meta_description[en]']")).sendKeys("34tgbdfabcdqwrfasdghkkkjhgk");

            driver.findElement(By.cssSelector("[href='#tab-prices']")).click();
            driver.findElement(By.cssSelector("[name='purchase_price']")).clear();
            driver.findElement(By.cssSelector("[name='purchase_price']")).sendKeys("5000");
            Select dollarsSelect = new Select(driver.findElement(By.cssSelector("[name='purchase_price_currency_code']")));
            dollarsSelect.selectByValue("USD");
            driver.findElement(By.cssSelector("[name='save']")).click();
                driver.findElement(By.linkText("NewMyDUCK"));


        }

    @After
    public void stop() {
driver.quit();
driver=null;
    }
}
