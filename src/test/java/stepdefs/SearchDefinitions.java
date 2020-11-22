package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchDefinitions {
    private WebDriver driver;
    private WebElement search;

    public SearchDefinitions() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/verasv/Downloads/chromedriver");
        this.driver = new ChromeDriver();
    }

    @Given("^I am on Womens Page$")
    public void i_am_on_Womens_Page() {
        this.driver.get("https://adoring-\n" +
                "pasteur-3ae17d.netlify.app/womens.html");
    }

    @When("^I search for \"([^\"]*)\"$")
    public void i_search_for(String arg1){
        this.search = this.driver.findElement(By.name("search"));
        this.search.sendKeys(arg1);
    }

    @Then("^the result should be list of products matching search$")
    public void the_result_should_be_list_of_products_matching_search() {
        this.search.submit();
        try{
            this.driver.findElement(By.className("single-pro"));
        }catch (NotFoundException e) {
            throw new NotFoundException("Page not found!");
        }
    }

    @After()
    public void closeBrowser() {
        this.driver.quit();
    }
}
