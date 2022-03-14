package com.twoitesting;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static com.twoitesting.Hooks.*;

public class LoginSteps {



    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get(baseURL);
    }

    @When("I use the username {string} and the password {string}")
    public void i_use_the_username_and_the_password(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.linkText("Submit")).click();

    }

    @Then("I am logged in")
    public void i_am_logged_in() throws InterruptedException {
        Thread.sleep(1000);
        Assertions.assertTrue(driver.getCurrentUrl().equals("https://www.edgewordstraining.co.uk/webdriver2/sdocs/add_record.php"));

    }

    @Then("I fail to log in")
    public void i_fail_to_log_in() throws InterruptedException {
        Thread.sleep(1000);
        driver.switchTo().alert().dismiss();
        Assertions.assertTrue(driver.getCurrentUrl().equals("https://www.edgewordstraining.co.uk/webdriver2/sdocs/auth.php"));

    }
}
