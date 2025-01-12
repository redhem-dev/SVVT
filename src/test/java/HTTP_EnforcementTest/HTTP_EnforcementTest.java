package HTTP_EnforcementTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HTTP_EnforcementTest {

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
    public void testHttpsEnforcing() throws InterruptedException {

        String httpUrl = baseUrl.replace("https://", "http://");
        webDriver.get(httpUrl);
        webDriver.manage().window().maximize();
        Thread.sleep(2000);


        String currentUrl = webDriver.getCurrentUrl();
        assertTrue(currentUrl.startsWith("https://"), "The site should redirect to HTTPS");
    }

    @Test
    public void testNoMixedContent() {

        // Open the HTTPS site
        webDriver.get(baseUrl);

        // Execute JavaScript to retrieve all resources loaded on the page
        @SuppressWarnings("unchecked")
        List<String> resources = (List<String>) js.executeScript(
                "return Array.from(document.querySelectorAll('img, script, link, iframe, video, audio, source')).map(el => el.src || el.href).filter(url => url !== undefined);");

        // Assert that all resources use HTTPS
        boolean allHttps = resources.stream().allMatch(resource -> resource.startsWith("https://"));

        assertTrue(allHttps, "All resources on the page should use HTTPS to avoid mixed content issues.");
    }

    @AfterAll
    public static void tearDown() {
        // Close the browser
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
