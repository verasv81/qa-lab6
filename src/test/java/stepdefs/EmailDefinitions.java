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

public class EmailDefinitions {
    private WebDriver driver;

    public EmailDefinitions() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/verasv/Downloads/chromedriver");
        this.driver = new ChromeDriver();
    }

    @Given("^I am on Sign up dialog$")
    public void i_am_on_Sign_up_dialog() {
        this.driver.get("https://adoring-pasteur-3ae17d.netlify.app/index.html");
        try {
            WebElement element = this.driver.findElement(By.xpath("//*[@id=\"home\"]/div/ul/li[1]/a"));
            element.click();
        } catch (NotFoundException e) {
            throw new NotFoundException("Element not found");
        }

    }

    @When("^I fill invalid email$")
    public void i_fill_invalid_email(){
        try {
            WebElement input = this.driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[2]/div[1]/form/div[2]/input"));
//            input.sendKeys("valera");
        } catch (NotFoundException e) {
            throw new NotFoundException("Element not found");
        }
    }

    @Then("^input field works properly$")
    public void input_field_works_properly() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @After()
    public void closeBrowser() {
        this.driver.quit();
    }
}
