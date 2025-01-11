package SignInTest;

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

public class SignInTest {


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

        WebElement signInButton = webDriver.findElement(By.xpath("//*[@id=\"signin2\"]"));
        signInButton.click();
        Thread.sleep(2000);

        WebElement usernameLogIn = webDriver.findElement(By.id("username2"));
        WebElement passwordLogin = webDriver.findElement(By.id("userpassx"));

        usernameLogIn.sendKeys("rogoedhem7@gmail.com");
        Thread.sleep(1500);
        passwordLogin.sendKeys("qwertyuiop0192837465");
        Thread.sleep(1500);
        WebElement logInButton = webDriver.findElement(By.id("signin"));
        logInButton.click();

        webDriver.get(baseUrl);
        Thread.sleep(3000);

        webDriver.get("https://www.ue.ba/myaccount.php");

        Thread.sleep(1500);
        WebElement accountName = webDriver.findElement(By.xpath("//*[@id=\"regForm\"]/b[1]"));

        assertEquals("Edhem Rogo", accountName.getText());




    }



    @AfterAll
    public static void teardown(){
        if (webDriver!=null){
            webDriver.quit();
        }
    }
}
