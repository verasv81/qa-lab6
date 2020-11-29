package stepdefs;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GoogleDefinitions {
    private WebDriver driver;
    private WebElement search;
    private String text;
    private String text1;

    public GoogleDefinitions() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/verasv/Downloads/chromedriver");
        this.driver = new ChromeDriver();
    }

    @Given("^The google page is loaded$")
    public void the_google_page_is_loaded(){
        this.driver.get("https://www.google.com");
    }

    @When("^Search for:$")
    public void search_for(DataTable arg1) throws InterruptedException{
        List<String> s = arg1.asList(String.class);

        for(int i = 1; i < s.size(); i++) {
            this.search = this.driver.findElement(By.className("gLFyf"));
            this.search.clear();
            this.search.sendKeys(s.get(i));
            Thread.sleep(2000);
            this.search.sendKeys(Keys.ENTER);
            Thread.sleep(2000);
        }
    }

    @Then("^Present list of (\\d+) search results$")
    public void present_list_of_search_results(int arg1) throws InterruptedException {
        Thread.sleep(2000);
        Integer n = this.driver.findElements(By.className("LC20lb")).size();
        Assert.assertEquals(arg1, n+1);
    }

    @When("^Search for \"([^\"]*)\"$")
    public void search_for(String arg1) throws Exception {
        this.search = this.driver.findElement(By.className("gLFyf"));
        this.search.clear();
        this.search.sendKeys(arg1);
        this.search.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

    @Then("^Present services for \"([^\"]*)\"$")
    public void present_services_for(String arg1) {
        try {
            this.driver.findElement(By.xpath("#rso > div:nth-child(1) > div > div.AEprdc.vk_c > div > div:nth-child(3)"));
        }catch (NotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    @When("^Search for \"([^\"]*)\" and \"([^\"]*)\"$")
    public void search_for(String arg1, String arg2) throws Exception {
        this.search = this.driver.findElement(By.className("gLFyf"));
        this.search.clear();
        this.search.sendKeys(arg1);
        this.search.sendKeys(Keys.ENTER);


        WebElement link = this.driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div[1]/a/h3/span"));
        text = link.getText();
        Thread.sleep(2000);

        this.search = this.driver.findElement(By.className("gLFyf"));
        this.search.clear();
        this.search.sendKeys(arg2);
        this.search.sendKeys(Keys.ENTER);


        WebElement link2 = this.driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div[1]/a/h3/span"));
        text1 = link2.getText();
        Thread.sleep(2000);

    }

    @Then("^Search Should have same result$")
    public void search_Should_have_same_result() throws Exception {
        Assert.assertEquals(this.text, this.text1);
    }

    @When("^Search for converter value \"([^\"]*)\"$")
    public void search_for_converter_value(String arg1) throws Exception {
        this.search = this.driver.findElement(By.className("gLFyf"));
        this.search.clear();
        this.search.sendKeys(arg1);
        this.search.sendKeys(Keys.ENTER);

    }

    @Then("^Converter is displayed on the top$")
    public void converter_is_displayed_on_the_top() throws Exception {
        WebElement convertor = this.driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/h2"));
        String text = convertor.getText();

        Assert.assertEquals(text, "Convertor valutar");

    }

    @Then("^Present Weather service$")
    public void present_Weather_service() throws Exception {
        WebElement meteo = this.driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/h2"));
        String text = meteo.getText();
        Assert.assertEquals(text, "Rezultatul pentru prognoza meteo");
    }


    @After()
    public void closeBrowser() {
        this.driver.quit();
    }
}
