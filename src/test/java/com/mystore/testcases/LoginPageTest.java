package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.IndexPage;

public class LoginPageTest extends BaseClass {
	
	IndexPage index;
	LoginPage loginPage;
	HomePage homePage;
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void loginTest(String uname, String pswd) {
		index=new IndexPage();
		loginPage=index.clickOnSignIn();
		homePage=loginPage.login(uname, pswd);
		String actualURL=homePage.getCurrentURL();
		Assert.assertEquals(actualURL, prop.getProperty("homepageurl"));
		
	}
	
}
