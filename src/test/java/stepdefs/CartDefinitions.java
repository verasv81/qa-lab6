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

public class CartDefinitions {
    private WebDriver driver;

    public CartDefinitions() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/verasv/Downloads/chromedriver");
        this.driver = new ChromeDriver();
    }

    @When("^I add to cart a product and edit quantity$")
    public void i_add_to_cart_a_product_and_edit_quantity() {
        WebElement el = this.driver.findElements(By.name("submit")).get(0);
        el.click();
    }

    @Then("^Quantity allows only integer values$")
    public void quantity_allows_only_integer_values() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @After()
    public void closeBrowser() {
        this.driver.quit();
    }
}
