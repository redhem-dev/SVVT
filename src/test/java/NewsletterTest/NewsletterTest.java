package NewsletterTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.http.Message;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewsletterTest {


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
    void newsletterTest () throws InterruptedException {

        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,6000)", "");
        Thread.sleep(4000);

        WebElement newsletterLabel = webDriver.findElement(By.xpath("//*[@id=\"EMAIL\"]"));
        WebElement submitButton = webDriver.findElement(By.name("subscribe"));

        newsletterLabel.sendKeys("mujo.mujic1234@hotmail.com");
        Thread.sleep(2000);
        submitButton.click();
        Thread.sleep(2000);

        WebElement message = webDriver.findElement(By.xpath("//*[@id=\"notification_container\"]/span"));
        Thread.sleep(2000);

        assertEquals("Hvala na registraciji!\nVaš email je uspjšeno dodan u bazu!", message.getText());





    }

    @Test
    void newsletterTest2 () throws InterruptedException {

        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,6000)", "");
        Thread.sleep(4000);

        WebElement newsletterLabel = webDriver.findElement(By.xpath("//*[@id=\"EMAIL\"]"));
        WebElement submitButton = webDriver.findElement(By.name("subscribe"));

        newsletterLabel.sendKeys("mujo.mujic1234@hotmail.com");
        Thread.sleep(2000);
        submitButton.click();
        Thread.sleep(2000);

        WebElement message = webDriver.findElement(By.xpath("//*[@id=\"notification_container\"]/span"));
        Thread.sleep(2000);

        assertEquals("Unešeni email se već nalazi na listi!", message.getText());


    }



    @AfterAll
    public static void teardown(){
        if (webDriver!=null){
            webDriver.quit();
        }
    }

}
