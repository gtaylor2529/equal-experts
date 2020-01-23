package com.equalexperts.pageobjects;

import com.equalexperts.helpers.DateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BookingPage extends BasePage {

  private static final String FIRST_NAME_LOCATOR = "firstname";
  private static final String ROW_LOCATOR = "row";
  private static final String BUTTON_LOCATOR = "input[type=button]";

  @FindBy(id = BookingPage.FIRST_NAME_LOCATOR)
  private WebElement firstName;

  @FindBy(id = "lastname")
  private WebElement lastName;

  @FindBy(id = "totalprice")
  private WebElement totalPrice;

  @FindBy(id = "depositpaid")
  private WebElement depositPaid;

  @FindBy(id = "checkin")
  private WebElement checkInDate;

  @FindBy(id = "checkout")
  private WebElement checkOutDate;

  @FindBy(id = "bookings")
  private WebElement bookings;

  @FindBy(id = "form")
  private WebElement form;

  @FindBy(className = BookingPage.ROW_LOCATOR)
  private List<WebElement> rows;

  public BookingPage(WebDriver driver) {
    super(driver);
  }

  public void enterValidDetails(String firstName) {
    this.firstName.sendKeys(firstName);
    this.lastName.sendKeys("Last");
    this.totalPrice.sendKeys("1000");
    new Select(depositPaid).selectByVisibleText("false");
    this.checkInDate.sendKeys(DateHelper.getCheckInDate());
    this.checkOutDate.sendKeys(DateHelper.getCheckOutDate());
    this.form.findElement(By.cssSelector(BookingPage.BUTTON_LOCATOR)).click();
  }

  public void isRendered() {
    this.waitForElementToBeClickableBy(By.id(BookingPage.FIRST_NAME_LOCATOR));
  }

  public int getRowCount() {
    return this.rows.size();
  }

  public void waitForBookingToSave(int existingRowCount) {
    this.waitForElementCount(By.className(BookingPage.ROW_LOCATOR), existingRowCount + 1);
  }

  public void waitForBookingToDelete(int existingRowCount) {
    this.waitForElementCount(By.className(BookingPage.ROW_LOCATOR), existingRowCount - 1);
  }

  public String getLatestBooking() {
    List<WebElement> bookingRows =
        this.bookings.findElements(By.className(BookingPage.ROW_LOCATOR));
    return bookingRows.get(bookingRows.size() - 1).getText();
  }

  public void deleteLatestBooking() {
    List<WebElement> bookingRows =
        this.bookings.findElements(By.className(BookingPage.ROW_LOCATOR));
    bookingRows
        .get(bookingRows.size() - 1)
        .findElement(By.cssSelector(BookingPage.BUTTON_LOCATOR))
        .click();
  }
}
