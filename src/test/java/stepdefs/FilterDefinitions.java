package stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FilterDefinitions {
    private WebDriver driver;

    public FilterDefinitions() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/verasv/Downloads/chromedriver");
        this.driver = new ChromeDriver();
    }

    @When("^I change filter range from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void i_change_filter_range_from_to(String arg1, String arg2) {
       try {
           WebElement slider = this.driver.findElement(By.xpath("//*[@id=\"slider-range\"]/div"));
           JavascriptExecutor js = (JavascriptExecutor) this.driver;

//        js.executeScript("arguments[0].setAttribute('style','left: 0.666667%; width: 8.83333%;')", slider);
       } catch (NotFoundException e){}

    }

    @Then("^Products are filtered within price range$")
    public void products_are_filtered_within_price_range() {
        List<WebElement> products = this.driver.findElements(By.className("item-price"));
//        if(products.contains("$300")){}
    }

    @After()
    public void closeBrowser() {
        this.driver.quit();
    }
}
