package TestCase;
import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Base_pack.Base;
import Homepage.Capture_Vitals;
import InpatientWard.Register_Patient;
import Loginpage.Login_page1;

public class Test_case extends Base{
	public Login_page1 lp;

	public Test_case() throws IOException {
	super();
	lp=new Login_page1();
	}



	@BeforeSuite
	public void Launching_Browser()
	{
	initialisation();
	}
	@BeforeMethod 
	public void BeforeTest() throws IOException {
	lp=new Login_page1();
	PageFactory.initElements(driver,Register_Patient.class);//calling xpath from one class to another - Page Factory 
	PageFactory.initElements(driver,Capture_Vitals.class);
	}
	@Test(dependsOnMethods="Invalid_Sign_in")
	public void Sign_in() throws Exception {
	lp.signin("Admin","Admin123");
}
	@Test()
	public void Invalid_Sign_in() throws Exception {
	lp.Invalid_login("Admin1", "Admin123");
	Thread.sleep(1000);

}

	@Test(dependsOnMethods = "Sign_in")
	public void Inpatient_Ward() throws InterruptedException
	{
	Register_Patient.Registerpatient.click();
	Register_Patient.Given_name.sendKeys("Revathy");
	Register_Patient.Family_name.sendKeys("Elavarasu");
	Register_Patient.button.click();
	Thread.sleep(1000);
	Register_Patient.Female.click();
	Register_Patient.button.click();
	Register_Patient.Birth_date.sendKeys("04");
	Select Birth=new Select(Register_Patient.Birth_month);
	Birth.selectByVisibleText("September");
	Register_Patient.Birth_year.sendKeys("1993");
	Thread.sleep(1000);
	Register_Patient.button.click();
	Register_Patient.Address1.sendKeys("No. 14 Erikarai Street");
	Register_Patient.Address2.sendKeys("Irumbuliyur");
	Register_Patient.City_Village.sendKeys("Tambaram");
	Register_Patient.State_province.sendKeys("Chennai");
	Register_Patient.Country.sendKeys("India");
	Register_Patient.Post_code.sendKeys("600045");
	Thread.sleep(1000);
	Register_Patient.button.click();
	Register_Patient.Patientphone.sendKeys("7358454998");
	Register_Patient.button.click();
	Select Relationship=new Select(Register_Patient.Relationship_type);
	Relationship.selectByVisibleText("Parent");
	Register_Patient.Person_name.sendKeys("Elavarasu");
	Register_Patient.button.click();
	Register_Patient.Confirm.click();
	}
	@Test(dependsOnMethods = "Inpatient_Ward")
	public void CaptureVitals() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.navigate().to("https://demo.openmrs.org/openmrs/login.htm");
		Capture_Vitals.CaptureTab.click();
		Capture_Vitals.SearchTab.sendKeys("1002KL"+Keys.ENTER);
		String Name=Capture_Vitals.patienttab.getText();
		System.out.println(Name);
		String Expected="Patient ID 1002KL";
		Assert.assertEquals(Name, Expected);
	}
}
