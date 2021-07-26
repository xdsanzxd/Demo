package page_object;

import config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class search_page extends Config {


    private static By searchBar = By.name("q");

    public search_page(WebDriver driver) {
        this.driver = driver;
    }

    public static void search(String text) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
        driver.findElement(searchBar).sendKeys(text, Keys.RETURN);
    }

    public static int getLinks() {
        List<WebElement> links =driver.findElements(By.cssSelector(".hlcw0c > .g .yuRUbf"));
        System.out.println(links.size()+ " Links in Page 1");
        return links.size();
    }

    public static void clickOnNextLink(String num){
        driver.findElement(By.xpath("//div/div["+num+"]/div/div/div/a/h3")).click();
    }
}