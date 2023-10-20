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

public class checkout {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user already login to dashboard")
    public void user_already_login_to_dashboard(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("user choose the product")
    public void user_choose_the_product() {
        driver.findElement(By.xpath("//*[@id='inventory_container']/div/div[1]/div[2]")).getText();
    }

    @Then("user click Add to cart button")
    public void user_click_add_to_cart_button() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @And("user click icon cart")
    public void user_click_icon_cart() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    @Then("user click checkout button")
    public void user_click_checkout_button() {
        driver.findElement(By.id("checkout")).click();
    }

    @Given("user input identity")
    public void user_input_identity() {
        driver.findElement(By.id("first-name")).sendKeys("anne");
        driver.findElement(By.id("last-name")).sendKeys("christ");
        driver.findElement(By.id("postal-code")).sendKeys("131313");
    }

    @Then("user click continue button")
    public void user_click_continue_button() {
        driver.findElement(By.id("continue")).click();
        String checkoutOverviewPage = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(checkoutOverviewPage, "Checkout: Overview");
    }

    @And("user click finish button")
    public void user_click_finish_button() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("user click back home button")
    public void user_click_back_home_button() {
        String checkoutCompletePage = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(checkoutCompletePage, "Checkout: Complete!");
    }
}
