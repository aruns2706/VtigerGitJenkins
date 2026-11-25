package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectInformationPage {
	WebDriver driver;
	public ProjectInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "mouseArea_Project Name")
	private WebElement projectNameTbl;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement projectHeader;
	
	
	public WebElement getProjectNameTbl() {
		return projectNameTbl;
	}

	public WebElement getProjectHeader() {
		return projectHeader;
	}
	
	
}
