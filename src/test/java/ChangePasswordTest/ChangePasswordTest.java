package ChangePasswordTest;

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

public class ChangePasswordTest {



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
    void changePasswordTest () throws InterruptedException {

        /*  IMPORTANT  --> If this test is run the password will be changed to "szoboszlai",
         thus some other tests might not run properly,
        like sign in. or any other that require sign in to be performed*/

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

        WebElement oldPass = webDriver.findElement(By.name("oldpass"));
        WebElement newPass1 = webDriver.findElement(By.name("newpass"));
        WebElement newPass2 = webDriver.findElement(By.name("newpass2"));


        oldPass.sendKeys("qwertyuiop0192837465");
        Thread.sleep(2000);
        newPass1.sendKeys("szoboszlai");
        Thread.sleep(2000);
        newPass2.sendKeys("szoboszlai");
        Thread.sleep(2000);
        WebElement changePasswordButton = webDriver.findElement(By.id("changepass"));
        changePasswordButton.click();
        Thread.sleep(2000);

        WebElement message = webDriver.findElement(By.xpath("//*[@id=\"changepassresult\"]/div/font/b"));

        assertEquals("Vaša lozinka je uspješno promjenjena", message.getText());

    }

    @Test
    void changePasswordFail_notEnoughCharacters () throws InterruptedException {

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

        WebElement oldPass = webDriver.findElement(By.name("oldpass"));
        WebElement newPass1 = webDriver.findElement(By.name("newpass"));
        WebElement newPass2 = webDriver.findElement(By.name("newpass2"));

        oldPass.sendKeys("qwertyuiop0192837465");
        Thread.sleep(2000);
        newPass1.sendKeys("sz");
        Thread.sleep(2000);
        newPass2.sendKeys("sz");
        Thread.sleep(2000);
        WebElement changePasswordButton = webDriver.findElement(By.id("changepass"));
        changePasswordButton.click();
        Thread.sleep(2000);

        WebElement errorMessage = webDriver.findElement(By.xpath("//*[@id=\"changepassresult\"]/font"));

        assertEquals("Nova lozinka sadrži manje od 6 znakova!", errorMessage.getText());

    }

    @Test
    void changePasswordTest_emptyField () throws InterruptedException {

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

        WebElement oldPass = webDriver.findElement(By.name("oldpass"));
        WebElement newPass1 = webDriver.findElement(By.name("newpass"));
        WebElement newPass2 = webDriver.findElement(By.name("newpass2"));


        oldPass.sendKeys("qwertyuiop0192837465");
        Thread.sleep(2000);
        newPass1.sendKeys("szoboszlai");
        Thread.sleep(2000);
        newPass2.sendKeys("");
        Thread.sleep(2000);
        WebElement changePasswordButton = webDriver.findElement(By.id("changepass"));
        changePasswordButton.click();
        Thread.sleep(2000);

        WebElement message = webDriver.findElement(By.xpath("//*[@id=\"changepassresult\"]/font"));

        assertEquals("Neka polja su prazna", message.getText());

    }

    @Test
    void changePasswordTest_differentInput () throws InterruptedException {

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

        WebElement oldPass = webDriver.findElement(By.name("oldpass"));
        WebElement newPass1 = webDriver.findElement(By.name("newpass"));
        WebElement newPass2 = webDriver.findElement(By.name("newpass2"));


        oldPass.sendKeys("qwertyuiop0192837465");
        Thread.sleep(2000);
        newPass1.sendKeys("szoboszlai");
        Thread.sleep(2000);
        newPass2.sendKeys("s");
        Thread.sleep(2000);
        WebElement changePasswordButton = webDriver.findElement(By.id("changepass"));
        changePasswordButton.click();
        Thread.sleep(2000);

        WebElement message = webDriver.findElement(By.xpath("//*[@id=\"changepassresult\"]/font"));

        assertEquals("Nova lozinka nije tačno ponovljena!", message.getText());

    }


    @AfterAll
    public static void teardown(){
        if (webDriver!=null){
            webDriver.quit();
        }
    }
}
