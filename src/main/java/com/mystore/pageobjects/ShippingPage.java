package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass{

	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id="cgv")
	WebElement terms;
	
	@FindBy(xpath="//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckOutBtn;
	
	public void checkTheTerms() {
		Action.scrollByVisibilityOfElement(getDriver(), terms);
		//Action.waitTillElementDisplay(getDriver(), terms);
		Action.click(getDriver(), terms);
	}
	
	public PaymentPage clickOnProceedToCheckout() {
		Action.isSelected(getDriver(), terms);
		Action.click(getDriver(), proceedToCheckOutBtn);
		return new PaymentPage();

	}
	
}
