package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

public class IndexPagetest extends BaseClass {
	
	IndexPage index;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@Test
	public void verifyLogo() {
		index =new IndexPage();
		boolean result=index.validateLogo();
		Assert.assertTrue(result);
	}
	
	

}
