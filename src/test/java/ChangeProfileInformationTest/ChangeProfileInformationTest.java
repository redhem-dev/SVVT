package ChangeProfileInformationTest;

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

public class ChangeProfileInformationTest {



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
    void changeAddressTest () throws InterruptedException {



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

        Thread.sleep(3500);

        WebElement address = webDriver.findElement(By.name("address"));
        address.clear();
        Thread.sleep(500);
        address.sendKeys("Hamdije Kresevljakovica 50");
        Thread.sleep(500);
        WebElement submitButton = webDriver.findElement(By.id("updateaccount"));
        submitButton.click();

        Thread.sleep(2000);

        WebElement message = webDriver.findElement(By.xpath("//*[@id=\"updateresult\"]/div/font/b"));

        assertEquals("Vaši podaci su uspješno snimljeni", message.getText());



    }


    @Test
    void changeZipCodeTest () throws InterruptedException {


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

        Thread.sleep(3500);

        WebElement zipCode = webDriver.findElement(By.name("zip"));
        zipCode.clear();
        Thread.sleep(500);
        zipCode.sendKeys("71100");
        Thread.sleep(500);
        WebElement submitButton = webDriver.findElement(By.id("updateaccount"));
        submitButton.click();

        Thread.sleep(2000);

        WebElement message = webDriver.findElement(By.xpath("//*[@id=\"updateresult\"]/div/font/b"));

        assertEquals("Vaši podaci su uspješno snimljeni", message.getText());



    }

    @Test
    void changeCityTest () throws InterruptedException {


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

        Thread.sleep(3500);

        WebElement city = webDriver.findElement(By.name("city"));
        city.clear();
        Thread.sleep(500);
        city.sendKeys("Zenica");
        Thread.sleep(500);
        WebElement submitButton = webDriver.findElement(By.id("updateaccount"));
        submitButton.click();

        Thread.sleep(2000);

        WebElement message = webDriver.findElement(By.xpath("//*[@id=\"updateresult\"]/div/font/b"));

        assertEquals("Vaši podaci su uspješno snimljeni", message.getText());



    }

    @Test
    void changePhoneNumberTest () throws InterruptedException {


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

        Thread.sleep(3500);

        WebElement phone = webDriver.findElement(By.name("phone"));
        phone.clear();
        Thread.sleep(500);
        phone.sendKeys("0607899987");
        Thread.sleep(500);
        WebElement submitButton = webDriver.findElement(By.id("updateaccount"));
        submitButton.click();

        Thread.sleep(2000);

        WebElement message = webDriver.findElement(By.xpath("//*[@id=\"updateresult\"]/div/font/b"));

        assertEquals("Vaši podaci su uspješno snimljeni", message.getText());



    }


    @AfterAll
    public static void teardown(){
        if (webDriver!=null){
            webDriver.quit();
        }
    }
}
