package com.equalexperts.stepdefs.hooks;

import com.equalexperts.driver.Driver;
import com.equalexperts.scenariocontext.Keys;
import com.equalexperts.scenariocontext.ScenarioContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class BaseHooks {

  private ScenarioContext scenarioContext;

  public BaseHooks(ScenarioContext scenarioContext) {
    this.scenarioContext = scenarioContext;
  }

  @Before(order = 1)
  public void driverSetup() {
    WebDriver driver = Driver.newInstance();
    driver.get("http://hotel-test.equalexperts.io/");
    this.scenarioContext.set(Keys.DRIVER, driver);
  }

  @After
  public void scenarioTearDown(Scenario scenario) {
    WebDriver driver = (WebDriver) this.scenarioContext.get(Keys.DRIVER);
    if (driver == null) throw new RuntimeException("No driver has been found");
    try {
      byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
      scenario.embed(screenshot, "image/png", "Screenshot");
    } catch (WebDriverException somePlatformsDontSupportScreenshots) {
      System.err.println(somePlatformsDontSupportScreenshots.getMessage());
    }
    Driver.tearDownInstance(driver);
  }
}
