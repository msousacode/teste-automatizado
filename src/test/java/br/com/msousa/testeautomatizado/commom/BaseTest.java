package br.com.msousa.testeautomatizado.commom;

import br.com.msousa.testeautomatizado.utils.TempoUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseTest {

    private WebDriver webDriver;

    @BeforeMethod
    public void setUp() {
        DesiredCapabilities caps = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver", "Drivers/geckodriver");

        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to("https://www.saucedemo.com/");

        TempoUtil.aguardar5Min();
    }

    @Test
    public void logarPortal() {
        webDriver.findElement(By.name("user-name")).sendKeys("standard_user");
        TempoUtil.aguardar3Min();
        webDriver.findElement(By.name("password")).sendKeys("secret_sauce");
        TempoUtil.aguardar3Min();
        webDriver.findElement(By.name("login-button")).click();

        TempoUtil.aguardar5Min();
    }
}
