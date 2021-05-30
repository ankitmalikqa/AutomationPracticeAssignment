package com.Test.Ankit.automation.steps;

import java.util.List;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Test.Ankit.Utility.PropFileHandler;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AutomationPracticeStepdef {
	    WebDriver driver=Hooks.driver;
	    public static String reference;
	    WebDriverWait wait = new WebDriverWait(driver, 25);
	    @Given("^I am on login page$")
	    public void i_am_on_login_page() throws Throwable {
            driver.get("http://automationpractice.com/");
	    }

		@Given("^I use the credentials to login into the website$")
		public void i_use_the_credentials_to_login_into_the_website() throws Throwable {
        	driver.findElement(By.cssSelector("input[id='email']")).sendKeys(PropFileHandler.readProperty("userName"));
			driver.findElement(By.cssSelector("input[id='passwd']")).sendKeys(PropFileHandler.readProperty("pass"));
		}

		@When("^I click on signIn button$")
		public void i_click_on_signIn_button() throws Throwable {
            driver.findElement(By.cssSelector(PropFileHandler.readProperty("login"))).click();
		}
		
		@When("^I click submit$")
		public void i_click_submit() throws Throwable {
			driver.findElement(By.cssSelector(PropFileHandler.readProperty("SubmitLogin"))).click();
		}
		@When("^I click on \"([^\"]*)\" tab$")
		public void i_click_on_tab(String product) throws Throwable {
			driver.findElement(By.xpath(PropFileHandler.readProperty("products").replace("product", product))).click();
		}

		@When("^I add \"([^\"]*)\" to cart$")
		public void i_add_to_cart(String type) throws Throwable {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PropFileHandler.readProperty("productType").replace("type", type)))).click();		   
		}

		@When("^I click on proceed to checkout button$")
		public void i_click_on_proceed_to_checkout_button() throws Throwable {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(PropFileHandler.readProperty("proceedCheckout")))));
			driver.findElement(By.xpath(PropFileHandler.readProperty("proceedCheckout"))).click();
			driver.findElement(By.xpath(PropFileHandler.readProperty("confirmCheckout"))).click();
		}

		@When("^I click on processAddress$")
		public void i_click_on_processAddress() throws Throwable {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(PropFileHandler.readProperty("processAddress")))));
			driver.findElement(By.xpath(PropFileHandler.readProperty("processAddress"))).click();			   
		}

		@When("^I click on checkbox to agree for terms$")
		public void i_click_on_checkbox_to_agree_for_terms() throws Throwable {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(PropFileHandler.readProperty("checkBoxTerms"))));
			driver.findElement(By.xpath(PropFileHandler.readProperty("checkBoxTerms"))).click();	
		}

		@When("^I confirm carrier$")
		public void i_confirm_carrier() throws Throwable {
			driver.findElement(By.xpath(PropFileHandler.readProperty("processCarrier"))).click();			   
		}

		@When("^I select bankWire as payment gateway$")
		public void i_select_bankWire_as_payment_gateway() throws Throwable {
			driver.findElement(By.xpath(PropFileHandler.readProperty("bankWire"))).click();	
			driver.findElement(By.xpath(PropFileHandler.readProperty("confirmPay"))).click();	
		}

		@When("^I read the reference$")
		public void i_read_the_reference() throws Throwable {
			WebElement element=driver.findElement(By.xpath(PropFileHandler.readProperty("referenceData")));
				if(element.getText().toString().contains("reference"))
				{
					int index=element.getText().toString().indexOf("reference");
					reference=element.getText().toString().substring(index+10,index+19);
				}
		}

		@Then("^I validate reference in order history$")
		public void i_validate_reference_in_order_history() throws Throwable {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(PropFileHandler.readProperty("orderHistory"))))).click();
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(PropFileHandler.readProperty("OrderList")))));
			List<WebElement> list=driver.findElements(By.xpath(PropFileHandler.readProperty("OrderList")));
			boolean flag=false;
			for(WebElement web:list)
			{
				if(web.getText().toString().contains(reference))
				{
					flag=true;
				}
			}
			Assert.assertEquals(true, flag);
		}
		@When("^I click on personalInfo$")
		public void i_click_on_personalInfo() throws Throwable {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(PropFileHandler.readProperty("personalInfo"))));
			driver.findElement(By.xpath(PropFileHandler.readProperty("personalInfo"))).click();	
		}

		@When("^I change the firstName to \"([^\"]*)\"$")
		public void i_change_the_firstName_to(String newName) throws Throwable {
			driver.findElement(By.xpath(PropFileHandler.readProperty("changeName"))).clear();	
			driver.findElement(By.xpath(PropFileHandler.readProperty("changeName"))).sendKeys(newName);	
			Thread.sleep(10000);
		}

		@When("^I add the old and new passwords$")
		public void i_add_the_old_and_new_passwords() throws Throwable {
			String oldPass=PropFileHandler.readProperty("pass");
			String newPass;
			if(!oldPass.contains("1"))
				newPass=oldPass+"1";
			else
				newPass=oldPass.substring(0,oldPass.length()-1);
			driver.findElement(By.xpath(PropFileHandler.readProperty("oldPass"))).sendKeys(oldPass);
			driver.findElement(By.xpath(PropFileHandler.readProperty("newPass"))).sendKeys(newPass);
			driver.findElement(By.xpath(PropFileHandler.readProperty("confirmPass"))).sendKeys(newPass);
			PropFileHandler.writeToFile("pass", newPass);
		}

		@When("^I click on submit button$")
		public void i_click_on_submit_button() throws Throwable {
			driver.findElement(By.xpath(PropFileHandler.readProperty("saveButton"))).click();
		}

		@When("^I verify the message \"([^\"]*)\"$")
		public void i_verify_the_message(String message) throws Throwable {
		   Assert.assertEquals(true, driver.findElement(By.xpath(PropFileHandler.readProperty("AlertMessage"))).getText().toString().contains(message));
		}
}
