package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user launch website sauce demo")
    public void user_launch_website_sauce_demo() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        String loginPageAssert;
        loginPageAssert = driver.findElement(By.xpath("//*[@id='root']/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");
    }

    @When("user input valid username")
    public void user_input_valid_username() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("user input valid password")
    public void userInputValidPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("user click login button")
    public void userClickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user in dashboard page")
    public void userInDashboardPage() {
        String dashboardPageAssert = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(dashboardPageAssert, "Products");
        driver.close();
    }

    @And("user input invalid password")
    public void userInputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("secretsauce");
    }

    @Then("user get error message")
    public void userGetErrorMessage() {
        String errorLogin = driver.findElement(By.id("login_button_container")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
    }
}


