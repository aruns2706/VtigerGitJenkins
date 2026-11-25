package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInfoPage {
	WebDriver driver;
	public VendorInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
}
	
	@FindBy(id = "dtlview_Vendor Name")
	private WebElement vendorNameCell;
	
	public WebElement getVendorNameCell() {
		return vendorNameCell;
	}
	
}
