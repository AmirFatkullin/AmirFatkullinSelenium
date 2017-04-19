package ru.stqa.training.selenium.zadanie19;

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

public class zadanie19 extends TestBase
{
    int i;
    @Test
    public void zadanie19()
    {
        for(int i=0;i<3;i++)
        {
            app.Selection_Duck_on_MainPAGE();
            app.Add_Duck_on_productPAGE();
        }

        app.Remove_from_CartPAGE();

    }


}