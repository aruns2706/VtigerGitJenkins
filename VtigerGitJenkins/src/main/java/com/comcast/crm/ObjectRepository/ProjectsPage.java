package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectsPage {
	WebDriver driver;
	public ProjectsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Projects...']")
	private WebElement newProjectIcn;
	
	public WebElement getNewProjectIcn() {
		return newProjectIcn;
	}
	
}
