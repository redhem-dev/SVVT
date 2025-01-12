package CategoryIntegrityTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.chrono.ThaiBuddhistEra;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CategoryIntegrityTest {

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
    void categoryIntegrityTest () throws InterruptedException {

        Thread.sleep(2000);

        WebElement phones = webDriver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[1]/a"));
        Thread.sleep(2000);

        phones.click();
        Thread.sleep(1500);
        WebElement smartphones = webDriver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[1]/ul/li[1]/a"));
        Thread.sleep(2500);
        smartphones.click();
        Thread.sleep(3500);
        String categoryFirst = webDriver.getCurrentUrl();
        WebElement firstProduct = webDriver.findElement(By.xpath("//*[@id=\"page\"]/ul[1]/li[1]/div"));
        firstProduct.click();
        Thread.sleep(2500);
        WebElement category = webDriver.findElement(By.xpath("//*[@id=\"prodload\"]/div[1]/div/div/div/div/div[1]/div[2]/div/div[2]/div/div/div[1]/div[2]/span[3]/a"));
        category.click();
        String categorySecond = webDriver.getCurrentUrl();
        Thread.sleep(5000);

        assertEquals(categoryFirst, categorySecond);



    }

    @Test
    void categoryIntegrityTest2 () throws InterruptedException {

        Thread.sleep(2000);

        WebElement phones = webDriver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[1]/a"));
        Thread.sleep(2000);

        phones.click();
        Thread.sleep(1500);
        WebElement smartphones = webDriver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[1]/ul/li[1]/a"));
        Thread.sleep(2500);
        smartphones.click();
        Thread.sleep(3500);
        WebElement firstProduct = webDriver.findElement(By.xpath("//*[@id=\"page\"]/ul[1]/li[1]/div"));
        firstProduct.click();
        Thread.sleep(2500);
        WebElement category = webDriver.findElement(By.xpath("//*[@id=\"prodload\"]/div[1]/div/div/div/div/div[1]/div[2]/div/div[2]/div/div/div[1]/div[2]/span[3]/a"));
        category.click();
        String categoryOfProduct = webDriver.getCurrentUrl();

        Thread.sleep(2000);
        WebElement baseCategory = webDriver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[2]/a"));
        baseCategory.click();
        Thread.sleep(3000);
        WebElement category2 = webDriver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[2]/ul/li[2]/ul/li[1]/a"));
        Thread.sleep(2000);
        category2.click();
        Thread.sleep(3000);
        WebElement firstProduct2 = webDriver.findElement(By.xpath("//*[@id=\"page\"]/ul[1]/li[1]/div"));
        Thread.sleep(1500);
        firstProduct2.click();
        Thread.sleep(3000);
        WebElement category2nd = webDriver.findElement(By.xpath("//*[@id=\"prodload\"]/div[1]/div/div/div/div/div[1]/div[2]/div/div[2]/div/div/div[1]/div[2]/span[3]/a"));
        category2nd.click();
        String categoryOfProduct2 = webDriver.getCurrentUrl();

        Thread.sleep(3000);

        assertNotEquals(categoryOfProduct, categoryOfProduct2);







    }

    @AfterAll
    public static void teardown(){
        if (webDriver!=null){
            webDriver.quit();
        }
    }
}
