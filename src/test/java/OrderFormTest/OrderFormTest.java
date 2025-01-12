package OrderFormTest;

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

public class OrderFormTest {

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
    void orderFormTest_emptyAddress () throws InterruptedException {

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
        Thread.sleep(2000);



        WebElement addToCartbutton = webDriver.findElement(By.xpath("//*[@id=\"prodload\"]/div[1]/div/div/div/div/div[1]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[2]/button[1]"));
        addToCartbutton.click();

        Thread.sleep(3000);

        WebElement cart = webDriver.findElement(By.xpath("//*[@id=\"mycart\"]/ul/li/a/span"));
        cart.click();
        Thread.sleep(1500);
        WebElement viewCart = webDriver.findElement(By.xpath("//*[@id=\"mycart\"]/ul/li/div/div/div/p[2]/a[1]"));
        viewCart.click();

        Thread.sleep(3000);
        WebElement checkout = webDriver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div/div/div/div/a"));
        checkout.click();

        Thread.sleep(3000);

        WebElement address = webDriver.findElement(By.id("adresa"));
        address.clear();
        Thread.sleep(3000);

        WebElement finishOrderButton = webDriver.findElement(By.xpath("//*[@id=\"checkout\"]/div[2]/div/div/div[2]/div/input"));
        finishOrderButton.click();

        Thread.sleep(3000);

        WebElement error = webDriver.findElement(By.id("upozorenje"));

        assertEquals("Neka polja nisu unesena!", error.getText());



    }

    @Test
    void orderFormTest_emptyPhoneNumber () throws InterruptedException {

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
        Thread.sleep(2000);



        WebElement addToCartbutton = webDriver.findElement(By.xpath("//*[@id=\"prodload\"]/div[1]/div/div/div/div/div[1]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[2]/button[1]"));
        addToCartbutton.click();

        Thread.sleep(3000);

        WebElement cart = webDriver.findElement(By.xpath("//*[@id=\"mycart\"]/ul/li/a/span"));
        cart.click();
        Thread.sleep(1500);
        WebElement viewCart = webDriver.findElement(By.xpath("//*[@id=\"mycart\"]/ul/li/div/div/div/p[2]/a[1]"));
        viewCart.click();

        Thread.sleep(3000);
        WebElement checkout = webDriver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div/div/div/div/a"));
        checkout.click();

        Thread.sleep(3000);

        WebElement phoneNumber = webDriver.findElement(By.id("tel"));
        phoneNumber.clear();
        Thread.sleep(3000);

        WebElement finishOrderButton = webDriver.findElement(By.xpath("//*[@id=\"checkout\"]/div[2]/div/div/div[2]/div/input"));
        finishOrderButton.click();

        Thread.sleep(3000);

        WebElement error = webDriver.findElement(By.id("upozorenje"));

        assertEquals("Neka polja nisu unesena!", error.getText());



    }

    @Test
    void orderFormTest_emptyZipCode () throws InterruptedException {

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
        Thread.sleep(2000);



        WebElement addToCartbutton = webDriver.findElement(By.xpath("//*[@id=\"prodload\"]/div[1]/div/div/div/div/div[1]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[2]/button[1]"));
        addToCartbutton.click();

        Thread.sleep(3000);

        WebElement cart = webDriver.findElement(By.xpath("//*[@id=\"mycart\"]/ul/li/a/span"));
        cart.click();
        Thread.sleep(1500);
        WebElement viewCart = webDriver.findElement(By.xpath("//*[@id=\"mycart\"]/ul/li/div/div/div/p[2]/a[1]"));
        viewCart.click();

        Thread.sleep(3000);
        WebElement checkout = webDriver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div/div/div/div/a"));
        checkout.click();

        Thread.sleep(3000);

        WebElement zipCode = webDriver.findElement(By.id("ptt"));
        zipCode.clear();
        Thread.sleep(3000);

        WebElement finishOrderButton = webDriver.findElement(By.xpath("//*[@id=\"checkout\"]/div[2]/div/div/div[2]/div/input"));
        finishOrderButton.click();

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
