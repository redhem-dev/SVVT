package KeybardVSMousePriceTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KeyboardVSMousePriceTest {

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
    void keyboardVSMousePriceTest () throws InterruptedException {

        Thread.sleep(2000);

        WebElement equipment = webDriver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[2]/a"));
        equipment.click();
        Thread.sleep(3000);

        WebElement keyboards = webDriver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[2]/ul/li[5]/ul/li[1]/a"));
        keyboards.click();
        Thread.sleep(1500);

        WebElement priceUpToDown = webDriver.findElement(By.xpath("//*[@id=\"sorting\"]/button[4]"));
        priceUpToDown.click();
        Thread.sleep(2000);

        WebElement keyboardHighestPrice = webDriver.findElement(By.xpath("//*[@id=\"page\"]/ul[1]/li[1]"));
        keyboardHighestPrice.click();
        Thread.sleep(2000);

        WebElement priceK = webDriver.findElement(By.xpath("//*[@id=\"prodload\"]/div[1]/div/div/div/div/div[1]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[1]/span/ins"));

        String keyboardPrice = priceK.getText().substring(0,3);


        webDriver.get(baseUrl);
        Thread.sleep(2000);
        WebElement equipment2 = webDriver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[2]/a"));
        equipment2.click();
        Thread.sleep(3000);
        WebElement mice = webDriver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[2]/ul/li[5]/ul/li[2]/a"));
        mice.click();
        Thread.sleep(2500);
        WebElement priceUpToDown2 = webDriver.findElement(By.xpath("//*[@id=\"sorting\"]/button[4]"));
        priceUpToDown2.click();
        Thread.sleep(3000);
        WebElement mouseHighestPrice = webDriver.findElement(By.xpath("//*[@id=\"page\"]/ul[1]/li[1]/div/span/div[2]/h3"));
        mouseHighestPrice.click();
        Thread.sleep(3000);

        WebElement priceM = webDriver.findElement(By.xpath("//*[@id=\"prodload\"]/div[1]/div/div/div/div/div[1]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[1]/span/ins"));
        String priceMouse = priceM.getText().substring(0,3);

        int finalPriceKeyboard = Integer.parseInt(keyboardPrice);
        int finalPriceMouse = Integer.parseInt(priceMouse);

        assertTrue(finalPriceKeyboard>finalPriceMouse);





    }

    /*
    Test made to assure weather the price of the most expensive keyboard is greater than the most expensive mouse
     */

    @AfterAll
    public static void teardown(){
        if (webDriver!=null){
            webDriver.quit();
        }
    }
}
