package InpatientWard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Register_Patient {
	@FindBy(xpath="//a[@id='referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension']")
	public static WebElement Registerpatient;
	
	@FindBy(xpath="//input[@name='givenName']")
	public static WebElement Given_name;

	@FindBy(xpath="//input[@name='familyName']")
	public static WebElement Family_name;

	@FindBy(xpath="//button[@id='next-button']")
	public static WebElement button;

	@FindBy(xpath="//option[@value='F']")
	public static WebElement Female;

	@FindBy(xpath="//input[@id='birthdateDay-field']")
	public static WebElement Birth_date;

	@FindBy(xpath="//select[@id='birthdateMonth-field']")
	public static WebElement Birth_month;

	@FindBy(xpath="//input[@id='birthdateYear-field']")
	public static WebElement Birth_year;

	@FindBy(xpath="//input[@id='address1']")
	public static WebElement Address1;

	@FindBy(xpath="//input[@id='address2']")
	public static WebElement Address2;

	@FindBy(xpath="//input[@id='cityVillage']")
	public static WebElement City_Village;

	@FindBy(xpath="//input[@id='stateProvince']")
	public static WebElement State_province;

	@FindBy(xpath="//input[@id='country']")
	public static WebElement Country;

	@FindBy(xpath="//input[@id='postalCode']")
	public static WebElement Post_code;

	@FindBy(xpath="//input[@name='phoneNumber']")
	public static WebElement Patientphone;

	@FindBy(xpath="//select[@id='relationship_type']")
	public static WebElement Relationship_type;

	@FindBy(xpath="//input[@placeholder='Person Name']")
	public static WebElement Person_name;

	@FindBy(xpath="//input[@id='submit']")
	public static WebElement Confirm;
}
