package step_definition;

import config.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import page_object.search_page;

public class searchSteps extends Config {

    @Given("^Navigate to google page$")
    public void navigate_to_google_page() {
        Config config = new Config();
        config.beforTest();
    }
    @When("^Insert the word (.*)$")
    public void insert_the_word(String phrase){
        search_page.search(phrase);
    }

    @Then("^The numbers of links in the first page are (.*)$")
    public void the_numbers_of_links_in_the_first_page_are(String links){
        Assert.assertEquals(String.valueOf(search_page.getLinks()),links);

    }

    @And("^Click on link number (.*)$")
    public void click_on_link_number(String num){
        search_page.clickOnNextLink(num);
    }
}