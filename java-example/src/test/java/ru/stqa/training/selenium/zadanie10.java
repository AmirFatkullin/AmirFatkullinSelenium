import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static javax.swing.text.html.CSS.getAttribute;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class zadanie10 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait=new WebDriverWait(driver,10);

    }

    @Test
    public void zadanie10() {
        WebElement element;
        WebElement element1;
        int i=0;
        int e=0;
        int n,k;

        //Сравнение названия товара на разных страницах
        driver.get("http://litecart.stqa.ru/index.php/en/");
        String titleonmainpage =driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div[4]/div/ul/li/a[1]/div[2]")).getAttribute("textContent");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div[4]/div/ul/li/a[1]/div[2]")).click();

        String titleonduckpage=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/h1")).getAttribute("textContent");
                if (titleonmainpage.compareTo(titleonduckpage) != 0)
                {
                    System.out.println("Ошибка! Строки " + titleonmainpage + " и " + titleonduckpage + " не совпадают");
                }
                else    {
                    System.out.println("Отлично! Строки " + titleonmainpage + " и " + titleonduckpage + " совпадают");
                        }


        //Сравнение акционной цены на разных страницах
        driver.get("http://litecart.stqa.ru/index.php/en/");
        String priceonmainpage =driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div[4]/div/ul/li/a[1]/div[4]/strong")).getAttribute("textContent");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div[4]/div/ul/li/a[1]/div[2]")).click();
        String priceonduckpage=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/strong")).getAttribute("textContent");
        if (priceonmainpage.compareTo(priceonduckpage) != 0)
        {
            System.out.println("Ошибка! Акционные цены " + priceonmainpage + " и " + priceonduckpage + " не совпадают");
        }
        else    {
            System.out.println("Отлично! Акционные цены " + priceonmainpage + " и " + priceonduckpage + " совпадают");
        }



        //Сравнение обычной цены на разных страницах
        driver.get("http://litecart.stqa.ru/index.php/en/");
        String notpriceonmainpage =driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div[4]/div/ul/li/a[1]/div[4]/s")).getAttribute("textContent");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div[4]/div/ul/li/a[1]/div[2]")).click();
        //element1.click();
        String notpriceonduckpage=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/s")).getAttribute("textContent");
        if (notpriceonmainpage.compareTo(notpriceonduckpage) != 0)
        {
            System.out.println("Ошибка! Обычные цены " + notpriceonmainpage + " и " + notpriceonduckpage + " не совпадают");
        }
        else    {
            System.out.println("Отлично! Обычные цены " + notpriceonmainpage + " и " + notpriceonduckpage + " совпадают");
        }


        //Проверка цвета акционной цены(красная) на главной странице
        driver.get("http://litecart.stqa.ru/index.php/en/");
        String color=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div[4]/div/ul/li/a[1]/div[4]/strong")).getCssValue("color");
        String redcolor="rgba(204, 0, 0, 1)";
        if (color.compareTo(redcolor)!=0)
        {
            System.out.println("Ошибка! " + redcolor + " !=" + color + " Акционная цена на глав.странице не красного цвета");
        }
        else    {
            System.out.println("Отлично! "+ redcolor + "=" + color + " Акционная цена на глав.странице красного цвета");
        }


        //Проверка цвета акционной цены(красная) на странице товара
        driver.get("http://litecart.stqa.ru/index.php/en/");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div[4]/div/ul/li/a[1]/div[2]")).click();
        String color1=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/strong")).getCssValue("color");
        System.out.println(color1);
        String redcolor1="rgba(204, 0, 0, 1)";
        if (color1.compareTo(redcolor1)!=0)
        {
            System.out.println("Ошибка! " + redcolor1 + " !=" + color1 + " Акционная цена на странице товара не красного цвета");
        }
        else    {
            System.out.println("Отлично! "+ redcolor1 + "=" + color1 + " Акционная цена на странице товара красного цвета");
        }


        //Проверка жирности акционной цены(bold)
        driver.get("http://litecart.stqa.ru/index.php/en/");
        String fat=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div[4]/div/ul/li/a[1]/div[4]/strong")).getCssValue("font-weight");
        String referencefat="bold";
        if (color.compareTo(redcolor)!=0)
        {
            System.out.println("Ошибка! " + referencefat + " !=" + fat + " Акционная цена не жирная");
        }
        else    {
            System.out.println("Отлично! "+ referencefat + "=" + fat + " Акционная цена жирная");
        }

        //Проверка цвета обычной цены на главной странице(серая)
        driver.get("http://litecart.stqa.ru/index.php/en/");
        String notpricecolor=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div[4]/div/ul/li/a[1]/div[4]/s")).getCssValue("color");
        String graycolor="rgba(119, 119, 119, 1)";
        if (notpricecolor.compareTo(graycolor)!=0)
        {
            System.out.println("Ошибка! " + graycolor + " !=" + notpricecolor + " Цена не серого цвета");
        }
        else    {
            System.out.println("Отлично! "+ graycolor + "=" + notpricecolor + " Цена серого цвета");
        }

        //Проверка цвета обычной цены на странице товара(серая)
        driver.get("http://litecart.stqa.ru/index.php/en/");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div[4]/div/ul/li/a[1]/div[2]")).click();
        String notpricecolor1=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/s")).getCssValue("color");
        String graycolor1="rgba(102, 102, 102, 1)";
        if (notpricecolor1.compareTo(graycolor1)!=0)
        {
            System.out.println("Ошибка! " + graycolor1 + " !=" + notpricecolor1 + " Обычная цена на странице товара не серого цвета");
        }
        else    {
            System.out.println("Отлично! "+ graycolor1 + "=" + notpricecolor1 + " Обычная цена на странице товара серого цвета");
        }



        //Проверка на зачеркнутый шрифт обычной цены (и проверка на цвет обычной цены)
        driver.get("http://litecart.stqa.ru/index.php/en/");
        String Strikethrough=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div[4]/div/ul/li/a[1]/div[4]/s")).getCssValue("text-decoration");
        //System.out.println(Strikethrough);
        String Strikethroughprice="line-through solid rgb(119, 119, 119)";
        if (Strikethrough.compareTo(Strikethroughprice)!=0)
        {
            System.out.println("Ошибка! " + Strikethroughprice + " !=" + Strikethrough + " Цена не серого цвета либо не зачеркнута");
        }
        else    {
            System.out.println("Отлично! "+ Strikethroughprice + "=" + Strikethrough + " Цена серого цвета и зачеркнута");
        }


        //
    }



    @After
    public void stop() {
//driver.quit();
//driver=null;
    }
}
