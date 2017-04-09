import org.apache.commons.lang3.ObjectUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class zadanie13 {
    private WebDriver driver;
    private WebDriverWait wait;
    WebElement Cart;
    WebElement Remove;
    @Before
    public void start() {
        driver = new ChromeDriver();
        wait=new WebDriverWait(driver,10);

    }

    @Test
    public void zadanie13() {
        for (int i = 0; i < 3; i++) {
            driver.get("http://litecart.stqa.ru/index.php/en/");
            List<WebElement> products = driver.findElements(By.cssSelector("li.product"));
            products.get(0).click();
            String zag=driver.findElement(By.cssSelector("h1")).getAttribute("textContent");
            String zagetalon="Yellow Duck";
            if (zag.compareTo(zagetalon)== 0)
            {
                Select Select = new Select(driver.findElement(By.cssSelector("select")));
                Select.selectByValue("Small");
            }
            driver.findElement(By.cssSelector("[name='add_cart_product']")).click();
            Cart = driver.findElement(By.id("cart"));
            wait.until(textToBePresentInElement(Cart.findElement(By.cssSelector("span.quantity")), Integer.toString(i + 1)));
        }

        driver.findElement(By.cssSelector(".link[href='http://litecart.stqa.ru/index.php/en/checkout']")).click();
        wait.until(titleContains("Checkout"));


        for(int n=1;n<=3;n++) {
            WebElement prodTable = wait.until(presenceOfElementLocated(By.id("order_confirmation-wrapper")));
            List<WebElement> prodList = driver.findElements(By.cssSelector("li.shortcut"));
            if(prodList.size()>0)
            {
            prodList.get(0).click();
            }
            driver.findElement(By.name("remove_cart_item")).click();
            wait.until(stalenessOf(prodTable));
            }
        }

    @After
    public void stop() {
driver.quit();
driver=null;
    }
}
