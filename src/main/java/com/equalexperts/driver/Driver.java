package com.equalexperts.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Driver {

  public static WebDriver newInstance() {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().pageLoadTimeout(30, SECONDS);
    driver.manage().window().maximize();
    return driver;
  }

  public static void tearDownInstance(WebDriver driver) {
    driver.quit();
  }
}
