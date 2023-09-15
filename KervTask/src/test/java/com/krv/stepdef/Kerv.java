package com.krv.stepdef;

import com.ker.task.pages.KervPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static com.ker.task.base.Base.driver;

public class Kerv {

    KervPage page;

    @Given("User navigates to the Kerv site")
    public void User_navigates_to_the_Kerv_site() throws InterruptedException {

        driver.get("https://kerv.com/careers-at-kerv/");

    }

    @When("User Accepts cookies")
    public void User_Accepts_cookies() {

        page = new KervPage();
        page.acceptCookies();

    }

    @And("User clicks on careers")
    public void User_clicks_on_careers() throws InterruptedException {
        page = new KervPage();
        page.hoverOverElementToClick();
        page.clickJobOpportunitiesLink();
        page.scrollToFilterHeading();
    }

    @And("User selects {string} India")
    public void User_selects_location(String location) throws InterruptedException {
        page.clickLocationButton();
        page.selectLocation(location);
    }


    @And("User selects {string} Full time")
    public void User_selects_type(String type) {
        page.clickTypeButton();
        page.selectType(type);
    }


    @And("User selects {string} Hybrid")
    public void User_selects_remote(String remote) throws InterruptedException {
        page.clickRemote();
        page.selectRemote(remote);
    }

    @And("user enter {string} to search")
    public void user_enter_job_search(String jobtitle) {
        page.search("jobtitle");
        String expectedResult = "Senior Test Engineer- Automation";

        String actualResult = page.getSearchResultText();

        Assert.assertEquals(actualResult, expectedResult, "Search result does not match expected result");

        List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='search-results__title']"));

        for (WebElement list : elementList) {
            String jobsList = list.getText();
            System.out.println(jobsList);
        }
    }



}


