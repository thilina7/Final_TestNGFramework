/**
 * 
 */
package com.MyTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ReportListner.TestAllureListener;
import com.mypages.BaseTest;
import com.mypages.CheckoutPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

/**
 * @author thilina.karunarathna
 *
 */
@Listeners({TestAllureListener.class})
public class TestClass extends BaseTest{
	private static CheckoutPage checkoutPage;
	
	@Story("Story: Checking out a product")
	@Description("T001_Checking whether sub total is correct")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=1, enabled = true, description = "Checking whether sub total is correct")
	public void navigateToCheckoutPage() {
		checkoutPage = new CheckoutPage(driver);
		double itemPrice = checkoutPage.addingProductToCart();
		double totalPrice = checkoutPage.proceedToCheckout();
		Assert.assertEquals(itemPrice*3, totalPrice);
	}
	
	@Story("Story: Checking out a product")
	@Description("T002_Checking whether sub total is correct in the summery page")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=2, enabled = true, description = "Checking whether sub total is correct in the summery page")
	public void navigateToSummeryPage() {
		checkoutPage = new CheckoutPage(driver);
		double itemPrice =checkoutPage.addingProductToCart();
		checkoutPage.proceedToCheckout();
		checkoutPage.fillingBillingDetails("thilina","karu","Hugo-Junkers-Strasse 7 60386 Frankfurt am Main Germany","60487","Frankfurt am Main","test@gmail.com");
		double grandTotal = checkoutPage.proceedToCheckOrderPage();
		Assert.assertEquals(itemPrice*3, grandTotal);
	}
	
}