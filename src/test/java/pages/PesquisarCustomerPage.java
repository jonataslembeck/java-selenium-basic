package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PesquisarCustomerPage extends BasePage {
	
	protected WebDriver driver;
	private final By btnAddCustomer = By.linkText("Add Customer");
	private final By btnDelete = By.cssSelector(".no-border-left span");
	private final By btnDeleteConfirma = By.cssSelector("button.btn.btn-danger.delete-multiple-confirmation-button");
	private final By fieldName = By.name("customerName");
	private final By selectAll = By.cssSelector(".no-border-right  div input");
	private final By msgDelete = By.cssSelector(".alert-delete-multiple");
	private final By msgDeleteSucess = By.cssSelector("body > div.alert.alert-success.growl-animated.animated.bounceInDown > span:nth-child(4) > p");
		
	public PesquisarCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void accessPage() {
		visit("https://www.grocerycrud.com/demo/bootstrap_theme");
	}

	public void clickAddCustomer() {
		click(btnAddCustomer);
	}
	
	public void clickDelete() {
		waitVisibilityOfElementLocated(btnDelete);
		click(btnDelete);
	}
	
	public void clickConfirmaDelete() {
		click(btnDeleteConfirma);
	}
	
	public void setName(String name) {
		sendKeys(fieldName, name);
	}
	
	public void selectAllCustomers() {
		click(selectAll);
	}
	
	public String getMessageDelete() {
		waitVisibilityOfElementLocated(msgDelete);
		return getText(msgDelete);
	}
	
	public String getMessageSucessDelete() {
		waitVisibilityOfElementLocated(msgDeleteSucess);
		return getText(msgDeleteSucess);
	}
}
