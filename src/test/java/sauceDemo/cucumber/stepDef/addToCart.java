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

public class addToCart {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user already login to sauce demo web")
    public void user_already_login_to_sauce_demo_web(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("user click add to cart")
    public void user_click_add_to_cart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @And("user click cart icon")
    public void user_click_cart_icon() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    @Then("user is on your cart page")
    public void user_is_on_your_cart_page() {
        String yourCardPage = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(yourCardPage, "Your Cart");
    }
}
