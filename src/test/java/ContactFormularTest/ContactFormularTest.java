package ContactFormularTest;

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

public class ContactFormularTest {

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
    void contactFormularTest () throws InterruptedException {

        Thread.sleep(2000);

        WebElement contactForm = webDriver.findElement(By.xpath("//*[@id=\"footer\"]/div/div[1]/div[2]/div/div[1]/p[1]/strong[2]/a"));
        js.executeScript("window.scrollBy(0,600)", "");
        contactForm.click();
        Thread.sleep(3000);

        WebElement firstName = webDriver.findElement(By.id("cf_name"));
        WebElement lastName = webDriver.findElement(By.id("cf_lastname"));
        WebElement email = webDriver.findElement(By.id("cf_email"));
        WebElement subject = webDriver.findElement(By.id("cf_subject"));
        WebElement message = webDriver.findElement(By.id("cf_message"));
        WebElement sendButton = webDriver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/section[2]/div/div/div[1]/div/form/p[8]/button"));

        firstName.sendKeys("Mujo");
        Thread.sleep(1500);
        lastName.sendKeys("Mujic");
        Thread.sleep(1500);
        email.sendKeys("mujo.adzem@gmail.com");
        Thread.sleep(1500);
        subject.sendKeys("Testiranje u Svrhu SVVT projekta");
        Thread.sleep(1500);
        message.sendKeys("Ovo je poruka poslana u svrhu fakultetskog projekta za predmet iz SVVT-a. Nema potrebe za odgovor, hvala na razumijevanju.");
        Thread.sleep(4500);
        /*Since this part of the form is reCaptcha, I am going to solve it manually.*/
        Thread.sleep(1500);
        sendButton.click();

        Thread.sleep(5000 );

        assertEquals("https://www.ue.ba/php_helpers/_contact-process.php", webDriver.getCurrentUrl());

        /*
        This test makes sure that the form takes us to different web-page when all the information is put in correctly.
         */

    }

    @Test
    void contactFormularTest2 () throws InterruptedException {

        Thread.sleep(2000);

        WebElement contactForm = webDriver.findElement(By.xpath("//*[@id=\"footer\"]/div/div[1]/div[2]/div/div[1]/p[1]/strong[2]/a"));
        js.executeScript("window.scrollBy(0,600)", "");
        contactForm.click();
        Thread.sleep(3000);

        WebElement firstName = webDriver.findElement(By.id("cf_name"));
        WebElement lastName = webDriver.findElement(By.id("cf_lastname"));
        WebElement email = webDriver.findElement(By.id("cf_email"));
        WebElement subject = webDriver.findElement(By.id("cf_subject"));
        WebElement message = webDriver.findElement(By.id("cf_message"));
        WebElement sendButton = webDriver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/section[2]/div/div/div[1]/div/form/p[8]/button"));

        firstName.sendKeys("Mujo");
        Thread.sleep(1500);
        lastName.sendKeys("Mujic");
        Thread.sleep(1500);
        email.sendKeys("mujo.adzemgmail.com");
        Thread.sleep(1500);
        subject.sendKeys("Testiranje u Svrhu SVVT projekta");
        Thread.sleep(1500);
        message.sendKeys("Ovo je poruka poslana u svrhu fakultetskog projekta za predmet iz SVVT-a. Nema potrebe za odgovor, hvala na razumijevanju.");
        Thread.sleep(4500);
        /*Since this part of the form is reCaptcha, I am going to solve it manually.*/
        Thread.sleep(1500);
        sendButton.click();

        Thread.sleep(5000 );
        WebElement wrongEmailAddressError = webDriver.findElement(By.xpath("/html/body/div/p"));

        assertEquals("Attention! You have entered an invalid e-mail address, try again.", wrongEmailAddressError.getText());



        /*
        This test makes sure that the form will provide us with the error message if the email is not input correctly.
         */

    }

    @Test
    void contactFormularTestReCaptchaFail () throws InterruptedException {

        Thread.sleep(2000);

        WebElement contactForm = webDriver.findElement(By.xpath("//*[@id=\"footer\"]/div/div[1]/div[2]/div/div[1]/p[1]/strong[2]/a"));
        js.executeScript("window.scrollBy(0,600)", "");
        contactForm.click();
        Thread.sleep(3000);

        WebElement firstName = webDriver.findElement(By.id("cf_name"));
        WebElement lastName = webDriver.findElement(By.id("cf_lastname"));
        WebElement email = webDriver.findElement(By.id("cf_email"));
        WebElement subject = webDriver.findElement(By.id("cf_subject"));
        WebElement message = webDriver.findElement(By.id("cf_message"));
        WebElement sendButton = webDriver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/section[2]/div/div/div[1]/div/form/p[8]/button"));

        firstName.sendKeys("Mujo");
        Thread.sleep(1500);
        lastName.sendKeys("Mujic");
        Thread.sleep(1500);
        email.sendKeys("mujo@adzemgmail.com");
        Thread.sleep(1500);
        subject.sendKeys("Testiranje u Svrhu SVVT projekta");
        Thread.sleep(1500);
        message.sendKeys("Ovo je poruka poslana u svrhu fakultetskog projekta za predmet iz SVVT-a. Nema potrebe za odgovor, hvala na razumijevanju.");
        Thread.sleep(4500);
        /*Since this part of the form is reCaptcha, in this case I will not solve it manually.*/
        Thread.sleep(1500);
        sendButton.click();

        Thread.sleep(5000 );
        WebElement pageIsNotWorkingError = webDriver.findElement(By.xpath("//*[@id=\"main-message\"]/h1/span"));

        assertEquals("This page isn’t working", pageIsNotWorkingError.getText());



        /*
        This test makes sure that the form will provide us with the error message if the email is not input correctly.
         */

    }

    @AfterAll
    public static void teardown(){
        if (webDriver!=null){
            webDriver.quit();
        }
    }



}
