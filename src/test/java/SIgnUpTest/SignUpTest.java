package SIgnUpTest;

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

public class SignUpTest {


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
    void signUp () throws InterruptedException {

        Thread.sleep(2000);

        WebElement signInButton = webDriver.findElement(By.xpath("//*[@id=\"signin2\"]"));
        signInButton.click();
        Thread.sleep(2000);

        WebElement nameRegister = webDriver.findElement(By.id("name"));
        WebElement emailRegister = webDriver.findElement(By.id("email"));
        WebElement addressRegister = webDriver.findElement(By.id("address"));
        WebElement usernameRegister = webDriver.findElement(By.id("username"));
        WebElement zipcodeRegister = webDriver.findElement(By.id("zip"));
        WebElement cityRegister = webDriver.findElement(By.id("city"));
        WebElement passwordRegister = webDriver.findElement(By.id("userpass"));
        WebElement repeatPasswordRegister = webDriver.findElement(By.id("userpass2"));
        WebElement phoneRegister = webDriver.findElement(By.id("phone"));
        WebElement submitButton = webDriver.findElement(By.id("regsubmit"));

        nameRegister.sendKeys("Edhem Rogo");
        Thread.sleep(1000);
        emailRegister.sendKeys("rogoedhem7@gmail.com");
        Thread.sleep(1000);
        addressRegister.sendKeys("Bratunacka 22");
        Thread.sleep(1000);
        usernameRegister.sendKeys("edhemrogo_edhemaga");
        Thread.sleep(1000);
        zipcodeRegister.sendKeys("71000");
        Thread.sleep(1000);
        cityRegister.sendKeys("Sarajevo");
        Thread.sleep(1000);
        passwordRegister.sendKeys("qwertyuiop0192837465");
        Thread.sleep(1000);
        repeatPasswordRegister.sendKeys("qwertyuiop0192837465");
        Thread.sleep(1000);
        phoneRegister.sendKeys("0608980099");
        Thread.sleep(1000);

        submitButton.click();
        Thread.sleep(1000);

        WebElement errorMessage = webDriver.findElement(By.xpath("//*[@id=\"err\"]/span"));



        assertEquals("Određena polja nisu ispravno popunjena, molimo Vas da ispravite iste:\n" +
                "☞ Unešeni email je već registrovan u bazi.", errorMessage.getText());



        /*Since this user has already been registered, this tests ensures that no 2 users can register with the same email address.
        If we wanted to register, we would have to use a different email address.
         */

    }

    @Test
    void signUp2 () throws InterruptedException {

        Thread.sleep(2000);

        WebElement signInButton = webDriver.findElement(By.xpath("//*[@id=\"signin2\"]"));
        signInButton.click();
        Thread.sleep(2000);

        WebElement nameRegister = webDriver.findElement(By.id("name"));
        WebElement emailRegister = webDriver.findElement(By.id("email"));
        WebElement addressRegister = webDriver.findElement(By.id("address"));
        WebElement usernameRegister = webDriver.findElement(By.id("username"));
        WebElement zipcodeRegister = webDriver.findElement(By.id("zip"));
        WebElement cityRegister = webDriver.findElement(By.id("city"));
        WebElement passwordRegister = webDriver.findElement(By.id("userpass"));
        WebElement repeatPasswordRegister = webDriver.findElement(By.id("userpass2"));
        WebElement phoneRegister = webDriver.findElement(By.id("phone"));
        WebElement submitButton = webDriver.findElement(By.id("regsubmit"));

        nameRegister.sendKeys("Edhem Spahic");
        Thread.sleep(1000);
        emailRegister.sendKeys("rogoedhem758@gmail.com");
        Thread.sleep(1000);
        addressRegister.sendKeys("Hamdije Kresevljakovica 22");
        Thread.sleep(1000);
        usernameRegister.sendKeys("edhemrogo_aga");
        Thread.sleep(1000);
        zipcodeRegister.sendKeys("71000");
        Thread.sleep(1000);
        cityRegister.sendKeys("Sarajevo");
        Thread.sleep(1000);
        passwordRegister.sendKeys("qwertyuiop0192837465");
        Thread.sleep(1000);
        repeatPasswordRegister.sendKeys("qwertyuiop0192837465");
        Thread.sleep(1000);
        phoneRegister.sendKeys("0608980099");
        Thread.sleep(1000);

        submitButton.click();
        Thread.sleep(1000);

        webDriver.get(baseUrl);

        WebElement signInButton2 = webDriver.findElement(By.xpath("//*[@id=\"signin2\"]"));
        signInButton2.click();
        Thread.sleep(2000);

        WebElement usernameLogIn = webDriver.findElement(By.id("username2"));
        WebElement passwordLogin = webDriver.findElement(By.id("userpassx"));

        usernameLogIn.sendKeys("rogoedhem758@gmail.com");
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

        assertEquals("Edhem Spahic", accountName.getText());




        /*Since this user has not already been registered, this test will make a new user and will not give a error box
         */

    }



    @AfterAll
    public static void teardown(){
        if (webDriver!=null){
            webDriver.quit();
        }
    }

}
