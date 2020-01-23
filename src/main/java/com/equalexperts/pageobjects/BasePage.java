package com.equalexperts.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  final WebDriver driver;
  private final WebDriverWait wait;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(this.driver, 5);
  }

  public void waitForElementToBeClickableBy(By by) {
    this.wait.until(ExpectedConditions.elementToBeClickable(by));
  }

  public void waitForElementCount(By by, int count) {
    this.wait.until(ExpectedConditions.numberOfElementsToBe(by, count));
  }
}
