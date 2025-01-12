package DescriptionAndArticleCodeIntegrityTest;

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
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DescriptionAndArticleCodeIntegrityTest {

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
    void descriptionAndArticleCodeIntegrityTest () throws InterruptedException {

        Thread.sleep(2000);

        WebElement computers = webDriver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[2]/a"));
        computers.click();
        Thread.sleep(2000);

        WebElement notebooks = webDriver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[2]/ul/li[1]/ul/li[1]/a"));
        notebooks.click();
        Thread.sleep(2000);

        WebElement appleCheckbox = webDriver.findElement(By.xpath("//*[@id=\"sidebar-widget\"]/div/form/div/ul/label[2]/input"));
        js.executeScript("arguments[0].click()", appleCheckbox);
        Thread.sleep(2000);
        WebElement m3_10coreGPU_checkbox = webDriver.findElement(By.xpath("//*[@id=\"sidebar-widget\"]/div/form/ul/li[6]/ul/li[1]/label/input"));
        js.executeScript("arguments[0].click()", m3_10coreGPU_checkbox);
        Thread.sleep(2000);
        WebElement firstProduct = webDriver.findElement(By.xpath("//*[@id=\"page\"]/ul[1]/li"));
        firstProduct.click();
        Thread.sleep(3000);

        WebElement description1 = webDriver.findElement(By.xpath("//*[@id=\"prodload\"]/div[1]/div/div/div/div/div[1]/div[2]/div/div[1]/p"));
        String description1st = description1.getText();
        WebElement articleCode1 = webDriver.findElement(By.xpath("//*[@id=\"prodload\"]/div[1]/div/div/div/div/div[1]/div[2]/div/div[2]/div/div/div[1]/div[2]/span[1]/span"));
        String articleCode1st = articleCode1.getText();

        webDriver.get(baseUrl);

        Thread.sleep(2000);

        WebElement computers2 = webDriver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[2]/a"));
        computers2.click();
        Thread.sleep(2000);

        WebElement notebooks2 = webDriver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[2]/ul/li[1]/ul/li[1]/a"));
        notebooks2.click();
        Thread.sleep(2000);

        WebElement appleCheckbox2 = webDriver.findElement(By.xpath("//*[@id=\"sidebar-widget\"]/div/form/div/ul/label[2]/input"));
        js.executeScript("arguments[0].click()", appleCheckbox2);
        Thread.sleep(2000);
        WebElement m3_10coreGPU_checkbox2 = webDriver.findElement(By.xpath("//*[@id=\"sidebar-widget\"]/div/form/ul/li[6]/ul/li[1]/label/input"));
        js.executeScript("arguments[0].click()", m3_10coreGPU_checkbox2);
        Thread.sleep(2000);
        WebElement firstProduct2 = webDriver.findElement(By.xpath("//*[@id=\"page\"]/ul[1]/li"));
        firstProduct2.click();
        Thread.sleep(3000);

        WebElement description2 = webDriver.findElement(By.xpath("//*[@id=\"prodload\"]/div[1]/div/div/div/div/div[1]/div[2]/div/div[1]/p"));
        WebElement articleCode2 = webDriver.findElement(By.xpath("//*[@id=\"prodload\"]/div[1]/div/div/div/div/div[1]/div[2]/div/div[2]/div/div/div[1]/div[2]/span[1]/span"));

        assertEquals(description1st, description2.getText());
        assertEquals(articleCode1st, articleCode2.getText());


    }

    @Test
    void descriptionAndArticleCodeIntegrityTest2 () throws InterruptedException {

        Thread.sleep(2000);

        WebElement computers = webDriver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[2]/a"));
        computers.click();
        Thread.sleep(2000);

        WebElement notebooks = webDriver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[2]/ul/li[1]/ul/li[1]/a"));
        notebooks.click();
        Thread.sleep(2000);

        WebElement appleCheckbox = webDriver.findElement(By.xpath("//*[@id=\"sidebar-widget\"]/div/form/div/ul/label[2]/input"));
        js.executeScript("arguments[0].click()", appleCheckbox);
        Thread.sleep(2000);
        WebElement m3_10coreGPU_checkbox = webDriver.findElement(By.xpath("//*[@id=\"sidebar-widget\"]/div/form/ul/li[6]/ul/li[1]/label/input"));
        js.executeScript("arguments[0].click()", m3_10coreGPU_checkbox);
        Thread.sleep(2000);
        WebElement firstProduct = webDriver.findElement(By.xpath("//*[@id=\"page\"]/ul[1]/li"));
        firstProduct.click();
        Thread.sleep(3000);

        WebElement description1 = webDriver.findElement(By.xpath("//*[@id=\"prodload\"]/div[1]/div/div/div/div/div[1]/div[2]/div/div[1]/p"));
        String description1st = description1.getText();
        WebElement articleCode1 = webDriver.findElement(By.xpath("//*[@id=\"prodload\"]/div[1]/div/div/div/div/div[1]/div[2]/div/div[2]/div/div/div[1]/div[2]/span[1]/span"));
        String articleCode1st = articleCode1.getText();

        webDriver.get(baseUrl);

        Thread.sleep(2000);

        WebElement computers2 = webDriver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[2]/a"));
        computers2.click();
        Thread.sleep(2000);

        WebElement notebooks2 = webDriver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[2]/ul/li[1]/ul/li[1]/a"));
        notebooks2.click();
        Thread.sleep(2000);

        WebElement appleCheckbox2 = webDriver.findElement(By.xpath("//*[@id=\"sidebar-widget\"]/div/form/div/ul/label[2]/input"));
        js.executeScript("arguments[0].click()", appleCheckbox2);
        Thread.sleep(2000);
        WebElement firstProduct2 = webDriver.findElement(By.xpath("//*[@id=\"page\"]/ul[1]/li[2]"));
        firstProduct2.click();
        Thread.sleep(3000);

        WebElement description2 = webDriver.findElement(By.xpath("//*[@id=\"prodload\"]/div[1]/div/div/div/div/div[1]/div[2]/div/div[1]/p"));
        WebElement articleCode2 = webDriver.findElement(By.xpath("//*[@id=\"prodload\"]/div[1]/div/div/div/div/div[1]/div[2]/div/div[2]/div/div/div[1]/div[2]/span[1]/span"));

        assertNotEquals(description1st, description2.getText());
        assertNotEquals(articleCode1st, articleCode2.getText());

        /*
        These test assure that no 2 products have the same description and article number.
         */


    }



    @AfterAll
    public static void teardown(){
        if (webDriver!=null){
            webDriver.quit();
        }
    }
}
