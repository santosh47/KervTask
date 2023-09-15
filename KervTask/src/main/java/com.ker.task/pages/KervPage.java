package com.ker.task.pages;
import com.ker.task.base.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.support.*;



public class KervPage {

    int time = 90;
    Duration duration = Duration.ofSeconds(time);
    WebDriverWait wait = new WebDriverWait(Base.driver, duration);

    public KervPage() {
        PageFactory.initElements(Base.driver, this);


    }


    @FindBy(xpath = "//*[@id=\"BorlabsCookieBox\"]/div/div/div/div[1]/div/div/div/p[2]/a")
    public static WebElement cookiesButton;

    @FindBy(xpath = "(//div[@class='navbar__link navbar__link--root navbar__link--has-children'])[6]")
    private WebElement elementToHover;

    @FindBy(xpath = "//div[@class='navbar__sub-big-list']//a[normalize-space()='Job Opportunities']")
    private WebElement jobOpportunitiesLink;

    @FindBy(xpath = "//div[normalize-space()='Filter your search:']")
    private WebElement filterHeading;

    @FindBy(xpath = "//button[normalize-space()='Location']")
    private WebElement locationButton;

    @FindBy(xpath = "//button[normalize-space()='Type']")
    private WebElement typeButton;

    @FindBy(xpath = "//div[@class='search-filters__group-heading']//button[normalize-space()='Remote']")
    private WebElement remoteButton;

    @FindBy(xpath = "//input[@placeholder='Search vacancies here']")
    private WebElement searchInput;

    @FindBy(xpath = "(//div[@class='search-results__title'])[1]")
    private WebElement searchResult;

    @FindBy(xpath = "//input[@placeholder='Search vacancies here']")
    private WebElement searchJob;



    public void acceptCookies() {

        wait.until(ExpectedConditions.elementToBeClickable(cookiesButton));
        cookiesButton.click();
    }
    //input[@placeholder='Search vacancies here']

    public void hoverOverElementToClick() {
        Actions actions = new Actions(Base.driver);
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(elementToHover))).perform();
    }

    public void clickJobOpportunitiesLink() {
        wait.until(ExpectedConditions.elementToBeClickable(jobOpportunitiesLink)).click();
    }

    public void scrollToFilterHeading() {
        ((JavascriptExecutor) Base.driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});", locationButton);
    }

    public void clickLocationButton() throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(locationButton)).click();
    }

    public void selectLocation(String location) {
        String xpath = "//button[normalize-space()='" + location + "']";



        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();


    }

    public void clickTypeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(typeButton)).click();
    }

    public void selectType(String type) {
        String xpath = "//button[normalize-space()='" + type + "']";

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();

    }

    public void clickRemote() {

        ((JavascriptExecutor) Base.driver).executeScript("arguments[0].scrollIntoView(true);", remoteButton);

        wait.until(ExpectedConditions.elementToBeClickable(remoteButton)).click();
    }

    public void selectRemote(String remote) throws InterruptedException {

        Thread.sleep(4000);

        String xpath = "//button[normalize-space()='" + remote + "']";

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();

    }

    public void search(String search) {

        ((JavascriptExecutor) Base.driver).executeScript("arguments[0].scrollIntoView(true);", searchJob);

        searchJob.sendKeys("Senior Test Engineer’");
        searchJob.sendKeys(Keys.ENTER);

    }
    public String getSearchResultText() {
        return wait.until(ExpectedConditions.visibilityOf(searchResult)).getText();
    }
}

