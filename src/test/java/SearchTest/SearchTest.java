package SearchTest;

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

public class SearchTest {
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
    void searchTest () throws InterruptedException {

        Thread.sleep(2000);

        WebElement searchButton = webDriver.findElement(By.id("search"));
        WebElement searchLabel = webDriver.findElement(By.name("searchfor"));
        WebElement searchSubmit = webDriver.findElement(By.id("searchsubmit"));

        searchButton.click();
        Thread.sleep(1500);
        searchLabel.sendKeys("BORG Wireless Miš MW02");
        Thread.sleep(1500);
        searchSubmit.click();

        Thread.sleep(3000);

        WebElement searchMessage = webDriver.findElement(By.xpath("//*[@id=\"results\"]/div/div[1]/h1"));

        assertEquals("Pregled proizvoda \"BORG Wireless Miš MW02\"", searchMessage.getText());



    }

    @Test
    void searchTestFail () throws InterruptedException {

        Thread.sleep(2000);

        WebElement searchButton = webDriver.findElement(By.id("search"));
        WebElement searchLabel = webDriver.findElement(By.name("searchfor"));
        WebElement searchSubmit = webDriver.findElement(By.id("searchsubmit"));

        searchButton.click();
        Thread.sleep(1500);
        searchLabel.sendKeys("BORG Wireless Miš MW02M9");
        Thread.sleep(1500);
        searchSubmit.click();

        Thread.sleep(3000);

        WebElement searchMessage = webDriver.findElement(By.xpath("//*[@id=\"results\"]/div/div[1]/h1"));

        assertEquals("Nema pronađenih proizvoda za \"BORG Wireless Miš MW02M9\"", searchMessage.getText());



    }



    @AfterAll
    public static void teardown(){
        if (webDriver!=null){
            webDriver.quit();
        }
    }
}
