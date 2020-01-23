package com.equalexperts.stepdefs;

import com.equalexperts.pageobjects.BookingPage;
import com.equalexperts.scenariocontext.Keys;
import com.equalexperts.scenariocontext.ScenarioContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class BookingStepDefs {

  private ScenarioContext scenarioContext;
  private BookingPage bookingPage;

  public BookingStepDefs(ScenarioContext scenarioContext) {
    this.scenarioContext = scenarioContext;
    WebDriver driver = (WebDriver) this.scenarioContext.get(Keys.DRIVER);
    this.bookingPage = PageFactory.initElements(driver, BookingPage.class);
  }

  @When("I enter valid booking details")
  public void iEnterValidBookingDetails() {
    String firstName = "First " + System.currentTimeMillis();
    this.bookingPage.enterValidDetails(firstName);

    int existingRowCount = this.bookingPage.getRowCount();
    this.bookingPage.waitForBookingToSave(existingRowCount);

    this.scenarioContext.set(Keys.FIRST_NAME, firstName);
  }

  @Then("the booking is created successfully")
  public void theBookingIsCreatedSuccessfully() {
    String firstName = (String) this.scenarioContext.get(Keys.FIRST_NAME);
    assertThat(this.bookingPage.getLatestBookingDetails()).contains(firstName);
  }

  @Given("a booking exists")
  public void aBookingExists() {
    this.iEnterValidBookingDetails();
    this.theBookingIsCreatedSuccessfully();
  }

  @When("I delete the existing booking")
  public void iDeleteTheExistingBooking() {
    int existingRowCount = this.bookingPage.getRowCount();
    this.bookingPage.deleteLatestBooking();
    this.bookingPage.waitForBookingToDelete(existingRowCount);
  }

  @Then("the booking is deleted successfully")
  public void theBookingIsDeletedSuccessfully() {
    String firstName = (String) this.scenarioContext.get(Keys.FIRST_NAME);
    assertThat(this.bookingPage.getLatestBookingDetails()).doesNotContain(firstName);
  }
}
