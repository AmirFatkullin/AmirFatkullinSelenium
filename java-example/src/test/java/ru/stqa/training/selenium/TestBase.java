package ru.stqa.training.selenium.zadanie19;
import org.junit.Before;
import ru.stqa.training.selenium.zadanie19.Application;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestBase
{
    public static ThreadLocal<Application> tlApp = new ThreadLocal<>();
        public Application app;

        @Before
        public void start() {
            if (tlApp.get() != null) {
                app = tlApp.get();
                return;
            }

            app = new Application();
            tlApp.set(app);

            Runtime.getRuntime().addShutdownHook(
                    new Thread(() -> { app.quit(); app = null; }));
        }

}
