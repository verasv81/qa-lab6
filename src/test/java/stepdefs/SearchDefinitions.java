package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchDefinitions {
    private WebDriver driver;

    public SearchDefinitions() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/verasv/Downloads/chromedriver");
        this.driver = new ChromeDriver();
    }

    @Given("^I am on Home Page$")
    public void i_am_on_Home_Page() {
        this.driver.get("https://adoring-pasteur-3ae17d.netlify.app/index.html");
    }

    @When("^I check search input from navbar$")
    public void i_check_search_input_from_navbar() {
       driver.findElement(By.cssSelector(".header-middle form input[type=\"submit\"] "));
    }

    @Then("^the search icon should be centered horizontally and vertically$")
    public void the_search_icon_should_be_centered_horizontally_and_vertically() throws Throwable{
        WebElement element = driver.findElement(By.cssSelector(".header-middle form input[type=\"submit\"] "));
        if(element.getCssValue("background-position") != "center") {
            throw new Error("Not centered!");
        }
    }

    @After()
    public void closeBrowser() {
        this.driver.quit();
    }
}
