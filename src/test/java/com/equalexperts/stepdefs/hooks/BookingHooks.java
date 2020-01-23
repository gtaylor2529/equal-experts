package com.equalexperts.stepdefs.hooks;

import com.equalexperts.pageobjects.BookingPage;
import com.equalexperts.scenariocontext.Keys;
import com.equalexperts.scenariocontext.ScenarioContext;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BookingHooks {

  private BookingPage bookingPage;

  public BookingHooks(ScenarioContext scenarioContext) {
    WebDriver driver = (WebDriver) scenarioContext.get(Keys.DRIVER);
    this.bookingPage = PageFactory.initElements(driver, BookingPage.class);
  }

  @Before(order = 2)
  public void waitForPageToRender() {
    this.bookingPage.isRendered();
  }
}
