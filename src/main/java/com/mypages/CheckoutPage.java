/**
 * 
 */
package com.mypages;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.config.configProperties;

import io.qameta.allure.Step;

/**
 * @author thilina.karunarathna
 *
 */
public class CheckoutPage extends BasePage {

	// Page locators:

	private By coffeeCategoryButton = By.xpath("//*[@id=\"app\"]/div/header/div[2]/div[3]/div/div/div/a[2]");
	private By selectProduct = By.xpath("//*[@id=\"category\"]/div[2]/div/div[2]/div[2]/div[3]/div/div[4]/div[1]/div/div[2]/a");
	private By clearCookies = By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]");
	private By selectNumber3 = By.xpath("//*[@id=\"viewport\"]/div[4]/div/section[1]/div/section/div[2]/div[2]/div/label[3]");
	private By priceLabel = By.xpath("//*[@id=\"viewport\"]/div[4]/div/section[1]/div/section/div[2]/div[1]/div[1]/div/div[1]/span");
	private By addToCart = By.xpath("//*[@id=\"viewport\"]/div[4]/div/section[1]/div/section/div[2]/div[3]/button[1]");
	private By showCart = By.xpath("//*[@id=\"app\"]/div/header/div[2]/div[2]/div[3]/div[2]/a/button");
	private By subTotalLabel = By.xpath("//*[@id=\"viewport\"]/div[4]/div/div[1]/div[2]/div[2]/div[1]/div/div/div[3]/div/div[3]/span[1]");
	private By shoppingcartTitle = By.xpath("//*[@id=\"viewport\"]/div[4]/div/div[1]/div[2]/div[2]/div[1]/section[2]/div/div");
	private By checkoutButton = By.xpath("//*[@id=\"viewport\"]/div[4]/div/div[1]/div[2]/div[2]/div[2]/section[1]/div[1]/div[3]/div[4]/a");
	private By continueButton = By.xpath("//*[@id=\"viewport\"]/div[4]/div/section/div/div[1]/form/button");
	private By radioButton = By.xpath("//*[@id=\"billing-new-address-form\"]/div/ul/li[2]/div/div[2]/div/label[1]");	
	private By fName = By.xpath("//*[@id=\"billing:firstname\"]");
	private By lName = By.xpath("//*[@id=\"billing:lastname\"]");
	private By address = By.xpath("//*[@id=\"billing:street1\"]");
	private By pcode = By.xpath("//*[@id=\"billing:postcode\"]");
	private By city = By.xpath("//*[@id=\"billing:city\"]");
	private By email = By.xpath("//*[@id=\"billing:email\"]");
	private By continuePayment = By.xpath("//*[@id=\"billing-buttons-container\"]/button");
	private By proceedPayment = By.xpath("//button[contains(text(),'Speichern') and @tabindex='-1'] ");
	private By continueOverview = By.xpath("//*[@id=\"payment-buttons-container\"]/button");
	private By grandTotal = By.xpath("//*[@id=\"checkout-review-table-wrapper\"]/div[2]/table/tbody/tr[3]/td[2]/strong/span");
	//*[@id="totals-checkout-sidebar"]/table/tbody/tr[3]/td[2]
	


	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	// public getters	
	public WebElement getCoffeeCategoryButton() {
		waitForElementtoBeClickable(coffeeCategoryButton);
		return getElement(coffeeCategoryButton);
	}


	public WebElement getRadioButton() {
		return getElement(radioButton);
	}
	

	public WebElement getGrandTotal() {
		return getElement(grandTotal);
	}

	public WebElement getSelectProduct() {
		waitForElementtoBeClickable(selectProduct);
		return getElement(selectProduct);
	}

	
	public WebElement getClearCookies() {
		waitForElementtoBeClickable(clearCookies);
		return getElement(clearCookies);
	}

	public WebElement getShoppingcartTitle() {
		waitForElementtoBeClickable(shoppingcartTitle);
		return getElement(shoppingcartTitle);
	}

	public WebElement getselectNumber3() {
		waitForElementtoBeClickable(selectNumber3);
		return getElement(selectNumber3);
	}



	public WebElement getPriceLabel() {
		waitForElementtoBeClickable(priceLabel);
		return getElement(priceLabel);
	}

	public WebElement getShowCart() {
		waitForElementtoBeClickable(showCart);
		return getElement(showCart);
	}

	public WebElement getAddToCart() {
		waitForElementtoBeClickable(addToCart);
		return getElement(addToCart);
	}



	public WebElement getSubTotalLabel() {
		waitForElementtoBeClickable(subTotalLabel);
		return getElement(subTotalLabel);
	}



	public WebElement getCheckoutButton() {
		waitForElementtoBeClickable(checkoutButton);
		return getElement(checkoutButton);
	}



	public WebElement getContinueButton() {
		waitForElementtoBeClickable(continueButton);
		return getElement(continueButton);
	}



	public WebElement getfName() {
		waitForElementtoBeClickable(fName);
		return getElement(fName);
	}



	public WebElement getlName() {
		waitForElementtoBeClickable(lName);
		return getElement(lName);
	}



	public WebElement getAddress() {
		waitForElementtoBeClickable(address);
		return getElement(address);
	}



	public WebElement getPcode() {
		waitForElementtoBeClickable(pcode);
		return getElement(pcode);
	}



	public WebElement getCity() {
		waitForElementtoBeClickable(city);
		return getElement(city);
	}



	public WebElement getEmail() {
		waitForElementtoBeClickable(email);
		return getElement(email);
	}



	public WebElement getContinuePayment() {
		waitForElementtoBeClickable(continuePayment);
		return getElement(continuePayment);
	}



	public List<WebElement> getProceedPayment() {
		waitForElementtoBeClickable(proceedPayment);
		return getElements(proceedPayment);
	}



	public WebElement getContinueOverview() {
		waitForElementtoBeClickable(continueOverview);
		return getElement(continueOverview);
	}
	
	//Action methods
	
	public double addingProductToCart() {
		getCoffeeCategoryButton().click();
		getClearCookies().click();
		getSelectProduct().click();
		String itemPrice = getPriceLabel().getText();
		String sub = removeLastChar(itemPrice);
		String replaceValue=sub.replace(',','.');
		getselectNumber3().click();
		getAddToCart().click();
		return Double.parseDouble(replaceValue);
	}
	
	public double proceedToCheckout() {
		getShowCart().click();
		getShoppingcartTitle().click();
		getSubTotalLabel().click();
		String subTotal = getSubTotalLabel().getText();
		String sub= removeLastChar(subTotal);
		String replaceValue=sub.replace(',','.');
		getCheckoutButton().click();
		getContinueButton().click();
		return Double.parseDouble(replaceValue);
	}
	
	public void fillingBillingDetails(String fname, String lname, String address, String pcode, String city, String email) {
		getRadioButton().click();
		getfName().sendKeys(fname);
		getlName().sendKeys(lname);
		getAddress().sendKeys(address);
		getPcode().sendKeys(pcode);
		getCity().sendKeys(city);
		getEmail().sendKeys(email);
		getContinuePayment().click();
	}
	
	public double proceedToCheckOrderPage() {
		System.out.println("array size"+getProceedPayment().size());
		getProceedPayment().get(1).click();
		getContinueOverview().click();
		String grandTotal = getGrandTotal().getText();
		String sub= removeLastChar(grandTotal);
		String replacespaces=sub.replace(',','.');
		String replaceValue=replacespaces.replace(" ","");
		return Double.parseDouble(replaceValue);
	}
	
	public static String removeLastChar(String s) {
	    return (s == null || s.length() == 0)
	      ? null 
	      : (s.substring(0, s.length() - 1));
	}
}
