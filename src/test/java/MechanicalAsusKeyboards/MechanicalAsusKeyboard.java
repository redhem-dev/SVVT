package MechanicalAsusKeyboards;

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

public class MechanicalAsusKeyboard {

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
    void signIn () throws InterruptedException {

        Thread.sleep(2000);


        WebElement equipment = webDriver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[2]/a"));
        equipment.click();
        Thread.sleep(3000);

        WebElement keyboards = webDriver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[2]/ul/li[5]/ul/li[1]/a"));
        keyboards.click();
        Thread.sleep(1500);
        WebElement asusRadio = webDriver.findElement(By.xpath("//*[@id=\"sidebar-widget\"]/div/form/div/ul/label[1]/input"));
        js.executeScript("arguments[0].click()", asusRadio);
        WebElement mechanicalRadio = webDriver.findElement(By.xpath("//*[@id=\"sidebar-widget\"]/div/form/ul/li[3]/label[1]/input"));
        js.executeScript("arguments[0].scrollIntoView(true)", mechanicalRadio);
        Thread.sleep(1500);
        js.executeScript("arguments[0].click()", mechanicalRadio);
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,-300)", "");
        Thread.sleep(3000);

        WebElement keyboardName = webDriver.findElement(By.xpath("//*[@id=\"page\"]/ul[1]/li/div/span/div[2]/h3"));
        assertEquals("ASUS Mehanička Gaming Tastatura Rog Falchion Ace", keyboardName.getText());

    }



    @AfterAll
    public static void teardown(){
        if (webDriver!=null){
            webDriver.quit();
        }
    }
}
