package com.krv.stepdef;
import com.ker.task.pages.jobProfilePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import static com.ker.task.base.Base.driver;

public class JobProfile {

    jobProfilePage  jobProfilePage;

    @And("User selects job")
    public void addUser_selects_jobJob() throws InterruptedException {

        jobProfilePage = new jobProfilePage();
        jobProfilePage.selectJob("Senior Test Engineer- Automation");
    }
      @And("User enters profile details")
              public void User_enters_profile_details(DataTable dataTable) {

          jobProfilePage.ProfileDetails(dataTable);


          jobProfilePage.uploadResume("C:\\Users\\chava\\Downloads\\Santosh chavan (1).pdf");

          driver.findElement(By.xpath("//*[@id=\"cta-form\"]/div/div/div/form/button")).submit();


      }
      @Then("should display message Thank you for your application")
    public void should_display_message_Thank_you_for_your_application() throws InterruptedException {


         WebElement jobApply = driver.findElement(By.xpath("//p[@class='form-feedback-message']"));

         String jobApplyConfirm = jobApply.getText();

        String expectedText = "Thank you for your application.";

          Assert.assertEquals(jobApplyConfirm, expectedText, "Text does not match the expected value");
        }



}