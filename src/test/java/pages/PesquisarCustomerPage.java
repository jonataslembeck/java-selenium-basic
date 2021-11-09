package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PesquisarCustomerPage extends BasePage {
	
	protected WebDriver driver;
	private final By btnAddCustomer = By.linkText("Add Customer");
	private final By btnOkCookie = By.id("cookie-accept");
	private final By btnDelete = By.cssSelector(".delete-selected-button");
	private final By btnDeleteConfirma = By.cssSelector("button.btn.btn-danger.delete-multiple-confirmation-button");
	private final By fieldCustomerName = By.xpath("//td[2]//input[@class='form-control gc-searchable-input']");
	private final By resultCustomerName = By.xpath("//td[@class='gc-data-container'][1]");
	private final By selectAll = By.cssSelector(".select-all-none");
	private final By msgDelete = By.xpath("//div[contains(text(),'Are you sure that you want to delete those')]");

	public PesquisarCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void accessPage() {
		visit("https://www.grocerycrud.com/docs/basic-example");
	}

	public void clickOkCookie(){
		click(btnOkCookie);
	}
	public void clickAddCustomer() {
		waitVisibilityOfElementLocated(btnAddCustomer);
		click(btnAddCustomer);
	}
	
	public void clickDelete() {
		waitVisibilityOfElementLocated(btnDelete);
		click(btnDelete);
	}
	
	public void clickConfirmaDelete() {
		waitVisibilityOfElementLocated(msgDelete);
		click(btnDeleteConfirma);
	}
	
	public void setCustomerName(String name) {
		waitVisibilityOfElementLocated(fieldCustomerName);
		sendKeys(fieldCustomerName, name);
	}
	
	public void selectAllCustomers() {
		click(selectAll);
	}

	public String getResultCustomerName(){
		return getText(resultCustomerName);
	}

	public void waitResultCustomerName(String customerNameEsperado){
		waitVisibilityOfElementLocated(By.xpath("//td[@class='gc-data-container'][1] //div[text()='"+customerNameEsperado+"']"));
	}

	public Boolean isVisibleResultCustomerName(String customerNameEsperado){
		String xpath = "//td[@class='gc-data-container'][1] //div[text()='"+customerNameEsperado+"']";
		return isVisible(By.xpath(xpath));
	}
}
