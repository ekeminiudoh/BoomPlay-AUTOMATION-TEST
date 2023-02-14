package BoomPlayWebAPP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class TC_001_VerifyValidLogin {
    //Declare Web driver
    public static WebDriver driver;
    private String baseURL;

    @BeforeTest
    public void setUp() {
        //setup browser driver and path
        System.setProperty("webdriver.firefox.driver", "BoomPlayAutomation\\src\\main\\resources\\driver\\geckodriver.exe");
        //instantiate webdriver object
        driver = new FirefoxDriver();
        //maximize browser
        driver.manage().window().maximize();
        baseURL = "https://www.boomplay.com/";

    }

    @Test()
    public void validLogin() {
        //navigate to base url
        driver.get(baseURL);
        //manage synchronization
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //find Log in link element and click on it.
        driver.findElement(By.xpath("/html/body/article[2]/article/div/div/strong/button[1]")).click();
        //find Phone input field element and send valid Phone.
        driver.findElement(By.name("phone")).sendKeys("8103249067");
        //find password input field element and send valid password.
        driver.findElement(By.name("pw")).sendKeys("signature");
        //find login button element and click on it.
        driver.findElement(By.className("submit")).click();
        //instantiate soft assert object
        WebElement BoyVybe = driver.findElement(By.xpath("/html/body/article[2]/article/a/div[2]/strong"));
        Assert.assertEquals(true, BoyVybe.isDisplayed());
        System.out.println("Login Successful");

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

