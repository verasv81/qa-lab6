package stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class PhoneDefinitions {
    private WebDriver driver;

    public  PhoneDefinitions() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/verasv/Downloads/chromedriver");
        this.driver = new ChromeDriver();
    }

    @Given("^I am on Contact Page$")
    public void i_am_on_Contact_Page() {
        this.driver.get("https://adoring-pasteur-3ae17d.netlify.app/contact.html");
    }

    @When("^I click phone number$")
    public void i_click_phone_number() {
        WebElement element = this.driver.findElement(By.cssSelector(".contact-right span"));
        if(!element.isDisplayed()) {
            throw new NotFoundException("Element not found");
        }

        element.click();
    }

    @Then("^phone number is called$")
    public void phone_number_is_called() {
        WebElement element = this.driver.findElement(By.cssSelector(".contact-right"));
        try {
            element.findElement(By.xpath("//a[href=\"tel"));
        } catch (NoSuchElementException e) {
            throw new NotFoundException("Element not found");
        }
    }

    @After()
    public void closeBrowser() {
        this.driver.quit();
    }

}
