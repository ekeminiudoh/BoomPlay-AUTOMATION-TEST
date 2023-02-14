package BoomPlayWebAPP;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;


public class TC_002_VerifyInvalidLogin {
    //declare webdriver
    public static WebDriver driver;
    private String baseURL;
    @Test
    public void Invalidlogin() {
        //navigate to base url
        driver.get(baseURL);
        //manage synchronization
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //find Login link element and click on it.
        driver.findElement(By.xpath("/html/body/article[2]/article/div/div/strong/button[1]")).click();
        //find Phone input field element and send invalid Phone.
        driver.findElement(By.name("phone")).sendKeys("81035576532");
        //find password input field element and send invalid password.
        driver.findElement(By.name("pw")).sendKeys("signaturess");
        //find login button element and click on it.
        driver.findElement(By.className("submit")).click();
        WebElement BoyVybe = driver.findElement(By.xpath("/html/body/article[2]/article/a/div[2]/strong"));
        Assert.assertEquals(false, BoyVybe.isDisplayed());
        System.out.println("Invalid Credentials, Unsucessful Login");
    }
    @BeforeTest
    public void setUp() {
        //setup browser driver and path
        System.setProperty("webdriver.firefox.driver", "BoomPlayAutomation\\src\\main\\resources\\driver\\geckodriver.exe");
        //instantiate webdriver object
        driver=new FirefoxDriver();
        //maximize browser
        driver.manage().window().maximize();
        baseURL = "https://www.boomplay.com/";
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
