package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewProjectPage {
	WebDriver driver;
	public CreatingNewProjectPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "projectname")
	private WebElement projectNameTxt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "startdate")
	private WebElement startDateTxt;
	
	@FindBy(name = "targetenddate")
	private WebElement endDateTxt;
	
	@FindBy(id = "linktoaccountscontacts_type")
	private WebElement relatedToDD;
	 
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement relatedToPlusIcn;
	
	@FindBy(id = "search_txt")
	private WebElement orgPopUpSearchTxt;
	
	@FindBy(name = "search")
	private WebElement orgPopUpSearchIcn;
	
	@FindBy(xpath = "//tr[@class='lvtColData']/td/a")
	private WebElement selectedOrgInPopUp;
	
	@FindBy(id = "search_txt")
	private WebElement contactPopUpSearchTxt;
	
	@FindBy(name = "search")
	private WebElement contactPopUpSearchIcn;
	
	@FindBy(name = "//tr[@class='lvtColData']/td/a")
	private WebElement selectedContactInPopUp;
	
	@FindBy(name = "description")
	private WebElement descriptionTxt;
	
	
	
	
	public WebElement getDescriptionTxt() {
		return descriptionTxt;
	}

	public WebElement getContactPopUpSearchTxt() {
		return contactPopUpSearchTxt;
	}

	public WebElement getContactPopUpSearchIcn() {
		return contactPopUpSearchIcn;
	}

	public WebElement getSelectedContactInPopUp() {
		return selectedContactInPopUp;
	}

	public WebElement getProjectNameTxt() {
		return projectNameTxt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getStartDateTxt() {
		return startDateTxt;
	}

	public WebElement getEndDateTxt() {
		return endDateTxt;
	}

	public WebElement getRelatedToDD() {
		return relatedToDD;
	}

	public WebElement getRelatedToPlusIcn() {
		return relatedToPlusIcn;
	}

	public WebElement getOrgPopUpSearchTxt() {
		return orgPopUpSearchTxt;
	}

	public WebElement getOrgPopUpSearchIcn() {
		return orgPopUpSearchIcn;
	}

	public WebElement getSelectedOrgInPopUp() {
		return selectedOrgInPopUp;
	}
	
	
}
