package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass{
	
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//a[@title='Pay by bank wire']")
	WebElement bankWireMethod;

	@FindBy(xpath="//a[@title='Pay by bank wire']")
	WebElement payByCheckMethod;
	
	public OrderSummaryPage clickOnPaymentmethod() {
		Action.click(getDriver(), bankWireMethod);
		return new OrderSummaryPage();
	}
}
