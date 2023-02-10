package com.actitime.testscript;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.generic.FileLib;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;

@Listeners(com.actitime.generic.ListenerImplementation.class)


public class ProjectModule extends BaseClass {
	
	@Test
	public void testCreateCustomer() throws InterruptedException, EncryptedDocumentException, IOException {
	Reporter.log("CreateProject",true);
	FileLib f=new FileLib();
	String projectName = f.getExcelData("CreateProject", 1, 2);
	String projectDescprition = f.getExcelData("CreateProject", 1, 3);
	HomePage h=new HomePage(driver);
	h.setTaskTab();
	TaskListPage t=new TaskListPage(driver);
	t.getAddNewBtn().click();
	t.getNewProjectOption().click();
	t.getProjectNameTbx().sendKeys(projectName);
	t.getProjectDescriptionTbx().sendKeys(projectDescprition);
	t.getSelectProjectDD().click();
	t.getOurCompanyTbx().click();
	t.getCreateProjectBtn().click();
	WebDriverWait wait=new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.textToBePresentInElement(t.getActualProject(), projectName));
	String actualText = t.getActualCustomer().getText();
	Assert.assertEquals(actualText, projectName);
	}
		
	}

