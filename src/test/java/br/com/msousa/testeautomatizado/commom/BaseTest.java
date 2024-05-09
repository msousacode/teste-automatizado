package br.com.msousa.testeautomatizado.commom;

import br.com.msousa.testeautomatizado.utils.TempoUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaseTest {

    private By ordenarDrop;
    private By titleText;
    private WebDriver webDriver;

    @BeforeMethod
    public void setUp() {
        DesiredCapabilities caps = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver", "Drivers/geckodriver");

        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to("https://www.saucedemo.com/");
    }

    @Test(priority = 1)
    public void logarPortal() {
        webDriver.findElement(By.name("user-name")).sendKeys("standard_user");
        TempoUtil.aguardar3Min();
        //webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(60000));
        webDriver.findElement(By.name("password")).sendKeys("secret_sauce");
        TempoUtil.aguardar3Min();

        webDriver.findElement(By.name("login-button")).click();
        TempoUtil.aguardar3Min();

        /**
         * Exemplo de como abrir um elemento dropDown e selecionar um valor.
         *
         * Aqui foi utilizado o exemplo selecionando por index, mas poderia ser pela texto visível ou pelo value.
         */
        webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span/select")).click();
        TempoUtil.aguardar3Min();

        Select select = new Select(webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span/select")));
        select.selectByIndex(2);
        //Exemplo usando o texto visível.
        //select.selectByVisibleText("Price (high to low)");

    }
}
