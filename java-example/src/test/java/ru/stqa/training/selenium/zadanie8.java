//package ru.stqa.training.selenium;


         import org.junit.*;
         import org.openqa.selenium.By;

         import org.openqa.selenium.WebDriver;

         import org.openqa.selenium.WebElement;
         import org.openqa.selenium.chrome.ChromeDriver;
         import org.openqa.selenium.support.ui.WebDriverWait;

         import java.util.List;


         public class zadanie8 {
             WebDriver driver;
             WebDriverWait wait;
             int k, n;

             @Before
             public void start() {
                 driver = new ChromeDriver();
                 wait=new WebDriverWait(driver,10);

             }

             @Test
     public void zadanie8()
             {
                driver.get("http://litecart.stqa.ru/index.php/en/");

                List <WebElement> products = driver.findElements(By.cssSelector("li.product"));
                        k=products.size();

                        for (int i=0; i<k; i++  )
                            {
                            products = driver.findElements(By.id("li.product"));
                            WebElement element = products.get(i);
                                List <WebElement> stickers = driver.findElements(By.cssSelector("li.product .sticker"));
                                n = stickers.size();
                                Assert.assertTrue(n == 1);
                            }
            }

             @After
    public void stop()
             {
                driver.quit();
               driver = null;
             }

         }
