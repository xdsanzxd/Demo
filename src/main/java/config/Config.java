package config;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class Config extends Data{
    public static WebDriver driver;

    @BeforeSuite
    public void beforTest(){
        System.setProperty("webdriver.chrome.driver", "/home/odak/Documents/chromedriver_linux64/chromedriver");
        if(Data.BROWSER == "chrome"){
            driver = new ChromeDriver();
        }
        if (Data.BROWSER == "firefox"){
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        driver.get(Data.URL);
        driver.manage().window().maximize();
    }
    @AfterTest
    public void afterTest(){
        driver.close();
    }
    @AfterSuite
    public void afterSuite(){
        driver.quit();
    }
}
