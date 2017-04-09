import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.function.Function;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class zadanie14 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait=new WebDriverWait(driver,10);

    }

    @Test
    public void zadanie14()
    {

        driver.get("http://litecart.stqa.ru/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("0b7dba1c77df25bf0");
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));
        driver.get("http://litecart.stqa.ru/admin/?app=countries&doc=countries");
        driver.get("http://litecart.stqa.ru/admin/?app=countries&doc=edit_country");

        for (int i=0;i<8;i++)
        {
            String mainWindow = driver.getWindowHandle();
            System.out.println(mainWindow);
            Set<String> oldWindows = driver.getWindowHandles();
            List<WebElement> links=driver.findElements(By.cssSelector("#content [target='_blank']"));
            links.get(i).click();
            String newWindow = wait.until(anyWindowOtherThan(oldWindows));
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(mainWindow);
        }

    

    }

    public  ExpectedCondition<String> anyWindowOtherThan(Set<String> oldWindows) {
        return input->{Set<String> handles = input.getWindowHandles();
        handles.removeAll(oldWindows);
        return handles.size()>0 ? handles.iterator().next():null;
        };
    }


    @After
    public void stop() {
driver.quit();
driver=null;
    }
}
