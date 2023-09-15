package com.krv.stepdef;



import com.ker.task.config.PropertyFileReader;
import com.ker.task.config.PathHelper;
import com.ker.task.base.Browser;
import com.ker.task.base.Base;

import com.ker.task.config.PropertyFileReader;

import com.ker.task.config.PathHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Hooks {
    private static Logger log = Logger.getLogger(Hooks.class);

    @Before
    public void setUp(Scenario scenario) {
        PropertyConfigurator.configure(PathHelper.getResourcePath("/src/main/resources/ConfigurationFile/log4j.properties"));
        log.info("Scenario Started: " + scenario.getName());
        Base.reader = new PropertyFileReader();
        Browser.startBrowser();
        Browser.maximize();
    }

    @After
    public void closeBrowser(Scenario scenario) {
        if (scenario.isFailed()) {
            //scenario.embed(Browser.takeScreenshot(), "image/png");
        }
        log.info("Scenario Completed: " + scenario.getName());
        log.info("Scenario Status is: " + scenario.getStatus());
        Base.driver.quit();
    }

}
