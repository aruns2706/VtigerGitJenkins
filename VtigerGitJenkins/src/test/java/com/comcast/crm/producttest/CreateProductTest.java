package com.comcast.crm.producttest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.ObjectRepository.CreatingNewProductPage;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.ProductInformationPage;
import com.comcast.crm.ObjectRepository.ProductsPage;
import com.comcast.crm.ObjectRepository.VendorInfoPage;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
@Listeners(com.comcast.crm.listenerutility.ListenerImplementation.class)
public class CreateProductTest extends BaseClass{
	public String vendorName;
@Test(groups = "system")
public void createProductTest() throws Throwable {
	UtilityClassObject.getTest().log(Status.INFO,"read product Name from excel");
	String productName = eLib.getDataFromExcel("product", 1, 2)+jLib.getRandomNumber();
	
	HomePage hp = new HomePage(UtilityClassObject.getDriver());
	UtilityClassObject.getTest().log(Status.INFO,"Clicking on product link");
	hp.getProductsLink().click();
	ProductsPage pp = new ProductsPage(UtilityClassObject.getDriver());
	UtilityClassObject.getTest().log(Status.INFO,"Click on new product icon");
	pp.getCreateProductBtn().click();
	CreatingNewProductPage cnpp = new CreatingNewProductPage(UtilityClassObject.getDriver());
	UtilityClassObject.getTest().log(Status.INFO,"Enter product name");
	cnpp.getProductnameTxt().sendKeys(productName);
	UtilityClassObject.getTest().log(Status.INFO,"Click on save Btn");
	cnpp.getSaveBtn().click();
	
	ProductInformationPage pip = new ProductInformationPage(UtilityClassObject.getDriver());
	
	String actProductName = pip.getProductNameTbl().getText();
	UtilityClassObject.getTest().log(Status.INFO,"Verifying product name with Table");
	Assert.assertTrue(actProductName.contains(productName));
	
	UtilityClassObject.getTest().log(Status.INFO,"Verifying product name with Header");
	String actProductHeaderText = pip.getProductHeaderTxt().getText();
	Assert.assertTrue(actProductHeaderText.contains(productName));
	
	
	
}

@Test
public void createVendor() throws Throwable {
      vendorName = eLib.getDataFromExcel("product", 4, 3);
	HomePage hp = new HomePage(UtilityClassObject.getDriver());
	
	WebDriverUtility wLib =new WebDriverUtility();
	
	String newVendor=eLib.getDataFromExcel("product", 4, 4);
	wLib.selectByValue(hp.getQuickCreateDD(),newVendor);
	hp.getVendorNameTxt().sendKeys(vendorName);
	hp.getQuickSaveBtn().click();
	VendorInfoPage vip = new VendorInfoPage(UtilityClassObject.getDriver());
	String actVendorName = vip.getVendorNameCell().getText();
	Assert.assertTrue(actVendorName.contains(vendorName));	
}

@Test(dependsOnMethods = "createVendor")
public void createProductWithVendor() throws Throwable {
	UtilityClassObject.getTest().log(Status.INFO,"read product Name from excel");
	String productName = eLib.getDataFromExcel("product", 1, 2)+jLib.getRandomNumber();
	
	HomePage hp = new HomePage(UtilityClassObject.getDriver());
	UtilityClassObject.getTest().log(Status.INFO,"Clicking on product link");
	hp.getProductsLink().click();
	ProductsPage pp = new ProductsPage(UtilityClassObject.getDriver());
	UtilityClassObject.getTest().log(Status.INFO,"Click on new product icon");
	pp.getCreateProductBtn().click();
	CreatingNewProductPage cnpp = new CreatingNewProductPage(UtilityClassObject.getDriver());
	UtilityClassObject.getTest().log(Status.INFO,"Enter product name");
	cnpp.getProductnameTxt().sendKeys(productName);
	JavaUtility jLib = new JavaUtility();
	String startDate = jLib.getSystemDateYYYYMMDD();
	UtilityClassObject.getTest().log(Status.INFO,"Entering sales start date");
	cnpp.getSalesStartDate().sendKeys(startDate);
	String endDate = jLib.getRequiredDate(60);
	UtilityClassObject.getTest().log(Status.INFO,"Entering sales end date");
	cnpp.getSalesEndDate().sendKeys(endDate);
	cnpp.getVendorNameIcon().click();
	WebDriverUtility wLib = new WebDriverUtility();
	String partialTitle = eLib.getDataFromExcel("product", 4, 4);
	UtilityClassObject.getTest().log(Status.INFO,"Switching to vendor pop up");
	wLib.switchToTabOnTitle(UtilityClassObject.getDriver(), partialTitle);
	UtilityClassObject.getTest().log(Status.INFO,"searching for vendor name");
	cnpp.getVendorSearchTxt().sendKeys(vendorName);
	cnpp.getVendorSearchBtn().click();
	Thread.sleep(3000);
	UtilityClassObject.getTest().log(Status.INFO,"selecting the vendor");
	cnpp.getVendorNameTbl().click();
	
	String prdtPgeTitle = eLib.getDataFromExcel("product", 4, 5);
	UtilityClassObject.getTest().log(Status.INFO,"Switch back to product page");
	wLib.switchToTabOnTitle(UtilityClassObject.getDriver(), prdtPgeTitle);
	Thread.sleep(5000);
	UtilityClassObject.getTest().log(Status.INFO,"Entering product description");
	String description = eLib.getDataFromExcel("product", 4, 6);
	cnpp.getDescriptionTxt().sendKeys(description);
	UtilityClassObject.getTest().log(Status.INFO,"Click on save Btn");
	cnpp.getSaveBtn().click();
	

	ProductInformationPage pip = new ProductInformationPage(UtilityClassObject.getDriver());
	
	String actProductName = pip.getProductNameTbl().getText();
	UtilityClassObject.getTest().log(Status.INFO,"Verifying product name with Table");
	Assert.assertTrue(actProductName.contains(productName));
	
	UtilityClassObject.getTest().log(Status.INFO,"Verifying product name with Header");
	String actProductHeaderText = pip.getProductHeaderTxt().getText();
	Assert.assertTrue(actProductHeaderText.contains(productName));
	
	String actVendorName = pip.getVendorName().getText();
	SoftAssert softAssert = new SoftAssert();
	UtilityClassObject.getTest().log(Status.INFO,"Verifying vendor name with actual vendor name");
	softAssert.assertEquals(vendorName,actVendorName);
	String actStartdate = pip.getStartDate().getText();
	UtilityClassObject.getTest().log(Status.INFO,"Verifying start date data");
	softAssert.assertEquals(startDate, actStartdate);
	String actEnddate = pip.getEndDate().getText();
	UtilityClassObject.getTest().log(Status.INFO,"Verifying end date data");
	softAssert.assertEquals(endDate, actEnddate);
	String actDescription = pip.getDescriptionBox().getText();
	UtilityClassObject.getTest().log(Status.INFO,"Verifying the Description");
	softAssert.assertTrue(actDescription.contains(description));
	softAssert.assertAll();
	
}
}
