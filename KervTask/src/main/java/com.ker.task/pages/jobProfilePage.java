package com.ker.task.pages;

import com.ker.task.base.Base;
import com.ker.task.base.Elements;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;
import java.util.Set;

import static com.ker.task.base.Base.driver;

public class jobProfilePage {
    int time = 90;
    Duration duration = Duration.ofSeconds(time);
    WebDriverWait wait = new WebDriverWait(Base.driver, duration);

    public jobProfilePage() {
        PageFactory.initElements(Base.driver, this);



    }



        @FindBy(id = "candidate_first_name")
        private WebElement firstNameInput;

        @FindBy(id = "candidate_last_name")
        private WebElement lastNameInput;

        @FindBy(id = "candidate_email")
        private WebElement emailInput;

        @FindBy(id = "candidate_phone")
        private WebElement phoneInput;

        @FindBy(xpath = "//input[@id='notice_period']")
        private WebElement noticePeriodInput;

        @FindBy(id = "resume")
        private WebElement resumeInput;



        public void ProfileDetails(DataTable dataTable) {
            Map<String,String> map = dataTable.asMap(String.class,String.class);
            Elements.TypeText(firstNameInput,map.get("FirstName"));
            Elements.TypeText(lastNameInput,map.get("LastName"));
            Elements.TypeText(emailInput,map.get("Email"));
            Elements.TypeText(phoneInput,map.get("MobileNumber"));

        }








        public void uploadResume(String filePath) {
            resumeInput.sendKeys(filePath);
        }

        public  void selectJob(String jobTitle) {
            driver.findElement(By.xpath("//div[@id='search-results']//div[2]//a[1]")).click();

            String currentWindowHandle = driver.getWindowHandle();

            Set<String> windowHandles = driver.getWindowHandles();


            for (String windowHandle : windowHandles) {
                if (!windowHandle.equals(currentWindowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }


            }
            }
}


