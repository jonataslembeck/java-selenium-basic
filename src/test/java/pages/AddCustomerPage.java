package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCustomerPage extends BasePage {

	protected WebDriver driver;
	private final By fieldName = By.id("field-customerName");
	private final By fieldLastName = By.id("field-contactLastName");
	private final By fieldContactFirstName = By.id("field-contactFirstName");
	private final By fieldPhone = By.id("field-phone");
	private final By fieldAddressLine1 = By.id("field-addressLine1");
	private final By fieldAddressLine2 = By.id("field-addressLine2");
	private final By fieldCity = By.id("field-city");
	private final By fieldState = By.id("field-state");
	private final By fieldPostalCode = By.id("field-postalCode");
	private final By fieldCountry = By.name("country");
	private final By fieldCreditLimit = By.name("creditLimit");
	private final By btnSave = By.id("form-button-save");
	private final By message = By.cssSelector("#report-success > p");
	private final By linkGoBackToList = By.partialLinkText("Go back to list");
	
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setName(String name) {
		sendKeys(fieldName, name);
	}
	
	public void setLastName(String lastName) {
		sendKeys(fieldLastName, lastName);
	}
	
	public void setContactFirstName(String contactFirstName) {
		sendKeys(fieldContactFirstName, contactFirstName);
	}
	
	public void setPhone(String phone) {
		sendKeys(fieldPhone, phone);
	}
	
	public void setAddressLine1(String addressLine1) {
		sendKeys(fieldAddressLine1, addressLine1);
	}
	
	public void setAddressLine2(String addressLine2) {
		sendKeys(fieldAddressLine2, addressLine2);
	}
	
	public void setCity(String city) {
		sendKeys(fieldCity, city);
	}
	
	public void setState(String state) {
		sendKeys(fieldState, state);
	}
	
	public void setPostalCode(String postalCode) {
		sendKeys(fieldPostalCode, postalCode);
	}
	
	public void setCountry(String country) {
		sendKeys(fieldCountry, country);
	}
	
	public void setFromEmployeer(String employeer) {
		click(By.cssSelector("#field_salesRepEmployeeNumber_chosen a"));		
		sendKeys(By.cssSelector("#field_salesRepEmployeeNumber_chosen > div > div > input[type=text]"), employeer);
		click(By.cssSelector("#field_salesRepEmployeeNumber_chosen > div > ul > li")); 
	}
	
	public void setCreditLimit(Double creditLimit) {
		sendKeys(fieldCreditLimit, String.valueOf(creditLimit));
	}
	
	public void clickSave() {
		click(btnSave);
	}
	
	public void clickGoBackToList() {
		click(linkGoBackToList);
	}
	
	public String getMessage() {
		waitVisibilityOfElementLocated(message);
		return getText(message);
	}
	
}
