package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {
	WebDriver driver;
	public ProductInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "mouseArea_Product Name")
	private WebElement productNameTbl;
	
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement productHeaderTxt;
	
	@FindBy(id = "dtlview_Sales Start Date")
	private WebElement startDate;
	
	@FindBy(id = "dtlview_Sales End Date")
	private WebElement endDate;
	
	@FindBy(xpath = "//td[@id='mouseArea_Vendor Name']/a")
	private WebElement vendorName;
	
	@FindBy(id = "mouseArea_Description")
	private WebElement descriptionBox;
	
	public WebElement getDescriptionBox() {
		return descriptionBox;
	}

	public WebElement getEndDate() {
		return endDate;
	}

	public WebElement getVendorName() {
		return vendorName;
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getProductNameTbl() {
		return productNameTbl;
	}

	public WebElement getProductHeaderTxt() {
		return productHeaderTxt;
	}
	
}
