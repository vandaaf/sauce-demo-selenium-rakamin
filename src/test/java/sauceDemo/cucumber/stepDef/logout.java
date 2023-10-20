package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class logout {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user already login")
    public void user_already_login (){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }


    @When("user click sidebar menu")
    public void userClickSidebarMenu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("user click logout")
    public void userClickLogout() {
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("user in login page")
    public void userInLoginPage() {
        String loginPageAssert;
        loginPageAssert = driver.findElement(By.xpath("//*[@id='root']/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");
    }
}
