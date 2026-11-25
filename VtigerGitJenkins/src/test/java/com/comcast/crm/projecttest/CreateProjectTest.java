package com.comcast.crm.projecttest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectRepository.CreatingNewProjectPage;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.ProjectInformationPage;
import com.comcast.crm.ObjectRepository.ProjectsPage;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
@Listeners(com.comcast.crm.listenerutility.ListenerImplementation.class)
public class CreateProjectTest extends BaseClass {
@Test
public void createProjectTest() throws Throwable {
	HomePage hp = new HomePage(UtilityClassObject.getDriver());
	hp.getMoreLink().click();
	hp.getProjectsLink().click();
	ProjectsPage pp = new ProjectsPage(UtilityClassObject.getDriver());
	pp.getNewProjectIcn().click();
	CreatingNewProjectPage cnpp = new CreatingNewProjectPage(UtilityClassObject.getDriver());
	ExcelUtility eLib = new ExcelUtility();
	JavaUtility jLib = new JavaUtility();
	
	String projectName = eLib.getDataFromExcel("project", 1, 2)+ jLib.getRandomNumber();
	cnpp.getProjectNameTxt().sendKeys(projectName);
	cnpp.getSaveBtn().click();
	
	ProjectInformationPage pip=new ProjectInformationPage(UtilityClassObject.getDriver());
	pip.getProjectHeader().getText();
	
	pip.getProjectNameTbl().getText();
}
}
