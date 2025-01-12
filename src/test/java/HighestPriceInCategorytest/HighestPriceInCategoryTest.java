package HighestPriceInCategorytest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighestPriceInCategoryTest {

    private static WebDriver webDriver;

    private static String baseUrl;

    private static JavascriptExecutor js;

    @BeforeAll
    public static void setUp() {

        System.setProperty("webdriver.chrome.driver", "/Users/edhemrogo/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
        baseUrl = "https://www.ue.ba";
        js = (JavascriptExecutor) webDriver;
        webDriver.get(baseUrl);
        webDriver.manage().window().maximize();

    }

    @Test
    void highestPriceInSmartphoneCategory () throws InterruptedException {

        Thread.sleep(2000);
        WebElement phone = webDriver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[1]/a"));
        Actions action = new Actions(webDriver);
        action.moveToElement(phone).build().perform();
        Thread.sleep(2000);
        WebElement smartphone = webDriver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[1]/ul/li[1]/a"));
        smartphone.click();
        Thread.sleep(5000);
        WebElement priceUpToDown = webDriver.findElement(By.xpath("//*[@id=\"sorting\"]/button[4]"));
        priceUpToDown.click();
        Thread.sleep(2000);
        WebElement highestPriceitem = webDriver.findElement(By.xpath("//*[@id=\"page\"]/ul[1]/li[1]"));
        highestPriceitem.click();
        Thread.sleep(3000);
        WebElement price = webDriver.findElement(By.xpath("//*[@id=\"prodload\"]/div[1]/div/div/div/div/div[1]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[1]/span"));

        assertEquals("729,00 KM", price.getText());

    }

    @Test
    void highestPriceInLaptopCategory () throws InterruptedException {

        Thread.sleep(2000);
        WebElement computer = webDriver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[2]/a"));
        Actions action = new Actions(webDriver);
        action.moveToElement(computer).build().perform();
        Thread.sleep(2000);
        WebElement laptop = webDriver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[2]/ul/li[1]/ul/li[1]/a"));
        laptop.click();
        Thread.sleep(5000);
        WebElement priceUpToDown = webDriver.findElement(By.xpath("//*[@id=\"sorting\"]/button[4]"));
        priceUpToDown.click();
        Thread.sleep(2000);
        WebElement highestPriceitem = webDriver.findElement(By.xpath("//*[@id=\"page\"]/ul[1]/li[1]"));
        highestPriceitem.click();
        Thread.sleep(3000);
        WebElement price = webDriver.findElement(By.xpath("//*[@id=\"prodload\"]/div[1]/div/div/div/div/div[1]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[1]/span[2]"));

        assertEquals("5.749,00 KM", price.getText());


    }

    @Test
    void highestPriceInKeyboardCategory () throws InterruptedException {

        Thread.sleep(2000);
        WebElement computer = webDriver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[2]/a"));
        Actions action = new Actions(webDriver);
        action.moveToElement(computer).build().perform();
        Thread.sleep(2000);
        WebElement keyboards = webDriver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[2]/ul/li[5]/ul/li[1]/a"));
        keyboards.click();
        Thread.sleep(5000);
        WebElement priceUpToDown = webDriver.findElement(By.xpath("//*[@id=\"sorting\"]/button[4]"));
        priceUpToDown.click();
        Thread.sleep(2000);
        WebElement highestPriceitem = webDriver.findElement(By.xpath("//*[@id=\"page\"]/ul[1]/li[1]"));
        highestPriceitem.click();
        Thread.sleep(3000);
        WebElement price = webDriver.findElement(By.xpath("//*[@id=\"prodload\"]/div[1]/div/div/div/div/div[1]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[1]/span"));

        assertEquals("409,00 KM", price.getText());

    }

    @Test
    void highestPriceInCPUCategory () throws InterruptedException {

        Thread.sleep(2000);

        WebElement computer = webDriver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[2]/a"));
        Actions action = new Actions(webDriver);
        action.moveToElement(computer).build().perform();
        Thread.sleep(2000);
        WebElement CPUs = webDriver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[2]/ul/li[6]/ul/li[1]/a"));
        CPUs.click();
        Thread.sleep(5000);
        WebElement priceUpToDown = webDriver.findElement(By.xpath("//*[@id=\"sorting\"]/button[4]"));
        priceUpToDown.click();
        Thread.sleep(2000);
        WebElement highestPriceitem = webDriver.findElement(By.xpath("//*[@id=\"page\"]/ul[1]/li[1]"));
        highestPriceitem.click();
        Thread.sleep(3000);
        WebElement price = webDriver.findElement(By.xpath("//*[@id=\"prodload\"]/div[1]/div/div/div/div/div[1]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[1]/span"));

        assertEquals("1.749,00 KM", price.getText());

    }



    @AfterAll
    public static void teardown(){
        if (webDriver!=null){
            webDriver.quit();
        }
    }
}
