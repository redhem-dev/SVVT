package JWT_Token_Test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import static org.junit.jupiter.api.Assertions.*;

public class JWT_Token_Test {

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
    void JWT_NotNullAfterLogIn () throws InterruptedException {

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

        String jwtToken = (String) js.executeScript("return localStorage.getItem('twk_token_5a0726a7bb0c3f433d4c89b2');");
        Thread.sleep(3000);

        System.out.println(jwtToken);

        assertNotNull(jwtToken, "Token should not be null after login.");



    }

    @Test
    void JWT_NotNullBeforeLogIn () throws InterruptedException {

        Thread.sleep(3000);

        String jwtToken = (String) js.executeScript("return localStorage.getItem('twk_token');");
        Thread.sleep(3000);

        System.out.println(jwtToken);

        assertNull(jwtToken, "Token should be null before login.");



    }




    @AfterAll
    public static void teardown(){
        if (webDriver!=null){
            webDriver.quit();
        }
    }
}
