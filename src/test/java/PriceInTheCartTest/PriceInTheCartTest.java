package PriceInTheCartTest;

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

public class PriceInTheCartTest {
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
    void priceInTheCartTest () throws InterruptedException {

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

        WebElement priceK = webDriver.findElement(By.xpath("//*[@id=\"prodload\"]/div[1]/div/div/div/div/div[1]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[1]/span/ins"));

        String keyboardPrice = priceK.getText().substring(0,3);

        Thread.sleep(2000);

        WebElement addToCartbutton = webDriver.findElement(By.xpath("//*[@id=\"prodload\"]/div[1]/div/div/div/div/div[1]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[2]/button[1]"));
        addToCartbutton.click();

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

        WebElement addToCartbutton2 = webDriver.findElement(By.xpath("//*[@id=\"prodload\"]/div[1]/div/div/div/div/div[1]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[2]/button[1]"));
        addToCartbutton2.click();

        int priceOfBoth = Integer.parseInt(keyboardPrice) + Integer.parseInt(priceMouse);

        Thread.sleep(3000);
        webDriver.get(baseUrl);

        WebElement openCart = webDriver.findElement(By.xpath("//*[@id=\"mycart\"]/ul/li/a"));
        openCart.click();
        Thread.sleep(1500);

        WebElement viewCart = webDriver.findElement(By.xpath("//*[@id=\"mycart\"]/ul/li/div/div/div/p[2]/a[1]/span[2]"));
        viewCart.click();
        Thread.sleep(3000);

        WebElement finalPrice = webDriver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div/div/div/table/tbody/tr[3]/td/strong/span"));
        String priceOfBoth2 = finalPrice.getText().substring(0,3);

        int pp2 = Integer.parseInt(priceOfBoth2);

        assertEquals(priceOfBoth, pp2);


    }

    @Test
    void priceInTheCartTest_emptyCart () throws InterruptedException {

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

        WebElement cartButton = webDriver.findElement(By.xpath("//*[@id=\"mycart\"]/ul/li/a/i"));
        cartButton.click();

        Thread.sleep(2000);

        WebElement emptyCartMessage = webDriver.findElement(By.xpath("//*[@id=\"mycart\"]/ul/li/div/div/div/p"));

        assertEquals("Vaša korpa je prazna!\n" +
                "Ukoliko žekite izvršiti narudžbu potrebno je da željene artikle dodate u korpu.", emptyCartMessage.getText());


    }





    @AfterAll
    public static void teardown(){
        if (webDriver!=null){
            webDriver.quit();
        }
    }
}
