package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCustomerPage extends BasePage {

	protected WebDriver driver;
	private final By fieldName = By.name("customerName");
	private final By fieldLastName = By.name("contactLastName");
	private final By fieldContactFirstName = By.name("contactFirstName");
	private final By fieldPhone = By.name("phone");
	private final By fieldAddressLine1 = By.name("addressLine1");
	private final By fieldAddressLine2 = By.name("addressLine2");
	private final By fieldCity = By.name("city");
	private final By fieldState = By.name("state");
	private final By fieldPostalCode = By.name("postalCode");
	private final By fieldCountry = By.name("country");
	private final By fieldSalesRepEmployeeNumber = By.name("salesRepEmployeeNumber");
	private final By fieldDeleted = By.name("deleted");
	private final By fieldCreditLimit = By.name("creditLimit");
	private final By btnSaveChanges = By.cssSelector("button.btn:nth-child(3)");
	
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setCustomerName(String name) {
		sendKeys(fieldName, name);
	}
	
	public void setContactLastName(String lastName) {
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
	
	public void setSalesRepEmployeeNumber(String employeer) {
		sendKeys(fieldSalesRepEmployeeNumber, employeer);
	}
	
	public void setCreditLimit(Double creditLimit) {
		sendKeys(fieldCreditLimit, String.valueOf(creditLimit));
	}

	public void setDeleted(Integer deleted) {
		sendKeys(fieldDeleted, String.valueOf(deleted));
	}
	
	public void clickSaveChanges() {
		click(btnSaveChanges);
	}
	
}
