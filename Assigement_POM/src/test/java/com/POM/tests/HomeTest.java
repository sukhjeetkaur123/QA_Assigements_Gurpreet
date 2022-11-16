package com.POM.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.testBase.TestBase;

public class HomeTest extends TestBase {
	String actualTitle;

	public HomeTest() {
		super();

	}

	@BeforeSuite
	public void launch() {
		intialization();
	}

	@Test(priority = 1)
	public void checkTitle() {
		actualTitle = obj.getHomeData().verifyTitle();
		Assert.assertEquals(actualTitle, "Help Center");
	}

	@Test(priority = 2)
	public void verifyCheckBox() {
		obj.getHomeData().verifyBoxUnChecked();
	}

	@Test(priority = 3)
	public void selectRandmFilterAandCheckedOptionUnderFilter() throws InterruptedException {
		obj.getHomeData().selctRandomFilterAndSelectRandomOptionandAndCheckedUnderThat();

	}
}
