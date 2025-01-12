package FastCheckoutTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FastCheckoutTest {
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

    /* Tests in this Class should be run separately*/

    @Test
    void fastCheckoutTest_noPhoneNumber () throws InterruptedException {

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
        Thread.sleep(4000);



        WebElement fastCheckoutButton = webDriver.findElement(By.xpath("//*[@id=\"prodload\"]/div[1]/div/div/div/div/div[1]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[2]/button[2]"));
        fastCheckoutButton.click();

        Thread.sleep(4000);
        WebElement name = webDriver.findElement(By.id("name"));
        WebElement address = webDriver.findElement(By.id("address"));
        WebElement zipCode = webDriver.findElement(By.id("zip"));
        WebElement city = webDriver.findElement(By.id("city"));
        WebElement phoneNumber = webDriver.findElement(By.id("phone"));


        name.sendKeys("Mujo");
        Thread.sleep(1500);
        address.sendKeys("Drinska 1");
        Thread.sleep(1500);
        zipCode.sendKeys("71000");
        Thread.sleep(1500);
        city.sendKeys("Sarajevo");
        WebElement submitButton = webDriver.findElement(By.xpath("//*[@id=\"checkoutexp\"]/div[2]/div[8]/div/button"));
        Thread.sleep(1500);
        submitButton.click();
        Thread.sleep(3000);

        WebElement error = webDriver.findElement(By.id("upozorenje"));
        assertEquals("Neka polja nisu unesena!", error.getText());

    }

    @Test
    void fastCheckoutTest_noCity () throws InterruptedException {

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
        Thread.sleep(4000);



        WebElement fastCheckoutButton = webDriver.findElement(By.xpath("//*[@id=\"prodload\"]/div[1]/div/div/div/div/div[1]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[2]/button[2]"));
        fastCheckoutButton.click();

        Thread.sleep(4000);
        WebElement name = webDriver.findElement(By.id("name"));
        WebElement address = webDriver.findElement(By.id("address"));
        WebElement zipCode = webDriver.findElement(By.id("zip"));
        WebElement city = webDriver.findElement(By.id("city"));
        WebElement phoneNumber = webDriver.findElement(By.id("phone"));


        name.sendKeys("Mujo");
        Thread.sleep(1500);
        address.sendKeys("Drinska 1");
        Thread.sleep(1500);
        zipCode.sendKeys("71000");
        Thread.sleep(1500);
        phoneNumber.sendKeys("061234444");
        WebElement submitButton = webDriver.findElement(By.xpath("//*[@id=\"checkoutexp\"]/div[2]/div[8]/div/button"));
        Thread.sleep(1500);
        submitButton.click();
        Thread.sleep(3000);

        WebElement error = webDriver.findElement(By.id("upozorenje"));
        assertEquals("Neka polja nisu unesena!", error.getText());

    }

    @Test
    void fastCheckoutTest_noZipCode () throws InterruptedException {

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
        Thread.sleep(4000);



        WebElement fastCheckoutButton = webDriver.findElement(By.xpath("//*[@id=\"prodload\"]/div[1]/div/div/div/div/div[1]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[2]/button[2]"));
        fastCheckoutButton.click();

        Thread.sleep(4000);
        WebElement name = webDriver.findElement(By.id("name"));
        WebElement address = webDriver.findElement(By.id("address"));
        WebElement zipCode = webDriver.findElement(By.id("zip"));
        WebElement city = webDriver.findElement(By.id("city"));
        WebElement phoneNumber = webDriver.findElement(By.id("phone"));


        name.sendKeys("Mujo");
        Thread.sleep(1500);
        address.sendKeys("Drinska 1");
        Thread.sleep(1500);
        city.sendKeys("Sarajevo");
        Thread.sleep(1500);
        phoneNumber.sendKeys("0668788890");
        WebElement submitButton = webDriver.findElement(By.xpath("//*[@id=\"checkoutexp\"]/div[2]/div[8]/div/button"));
        Thread.sleep(1500);
        submitButton.click();
        Thread.sleep(3000);

        WebElement error = webDriver.findElement(By.id("upozorenje"));
        assertEquals("Neka polja nisu unesena!", error.getText());

    }

    @Test
    void fastCheckoutTest_noName () throws InterruptedException {

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
        Thread.sleep(4000);



        WebElement fastCheckoutButton = webDriver.findElement(By.xpath("//*[@id=\"prodload\"]/div[1]/div/div/div/div/div[1]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[2]/button[2]"));
        fastCheckoutButton.click();

        Thread.sleep(4000);
        WebElement name = webDriver.findElement(By.id("name"));
        WebElement address = webDriver.findElement(By.id("address"));
        WebElement zipCode = webDriver.findElement(By.id("zip"));
        WebElement city = webDriver.findElement(By.id("city"));
        WebElement phoneNumber = webDriver.findElement(By.id("phone"));



        address.sendKeys("Drinska 1");
        Thread.sleep(1500);
        city.sendKeys("Sarajevo");
        Thread.sleep(1500);
        zipCode.sendKeys("71210");
        Thread.sleep(1500);
        phoneNumber.sendKeys("0668788890");
        WebElement submitButton = webDriver.findElement(By.xpath("//*[@id=\"checkoutexp\"]/div[2]/div[8]/div/button"));
        Thread.sleep(1500);
        submitButton.click();
        Thread.sleep(3000);

        WebElement error = webDriver.findElement(By.id("upozorenje"));
        assertEquals("Neka polja nisu unesena!", error.getText());

    }

    @AfterAll
    public static void teardown(){
        if (webDriver!=null){
            webDriver.quit();
        }
    }


}
