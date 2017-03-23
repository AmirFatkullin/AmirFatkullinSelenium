package ru.stqa.training.selenium;

        import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.HasCapabilities;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.remote.DesiredCapabilities;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.openqa.selenium.ie.InternetExplorerDriver;


        import java.io.File;

        import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class my6testIE {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        DesiredCapabilities caps = new DesiredCapabilities();
        //driver = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        driver = new InternetExplorerDriver(caps);
                //new InternetExplorerDriver()
                  //      .setLegacy(true)
                    //    .setBinary(new FirefoxBinary(new File("C:\\Program Files (x86)\\Nightly\\firefox.exe"))));
        //caps.setCapability(FirefoxDriver.MARIONETTE, false);
        // driver = new FirefoxDriver(caps);
        //driver = new FirefoxDriver(
        //new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe")),
        //new FirefoxProfile(), caps);
        //driver = new FirefoxDriver(
        //new FirefoxBinary(new File"C:\\Program Files\\Mozilla Firefox\\firefox.exe")),
        //new FirefoxProfile(), caps);
        System.out.println(((HasCapabilities) driver).getCapabilities());
        wait=new WebDriverWait(driver,10);
    }

    @Test
    public void my6testIE() {
        driver.get("http://litecart.stqa.ru/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("0b7dba1c77df25bf0");
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));
    }

    @After
    public void stop() {
        driver.quit();
        driver=null;
    }
}