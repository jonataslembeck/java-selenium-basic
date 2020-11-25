package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.AddCustomerPage;
import pages.BasePage;
import pages.PesquisarCustomerPage;

public class CadastroCustomersTest extends BasePage {
	
	WebDriver driver = getDriver();
	PesquisarCustomerPage pesquisarCustomerPage = new PesquisarCustomerPage(driver);
	AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
	
	
	@After
	public void tearDown(){
		fechaNavegador();
	}
	
	@Test
	public void testCadastraCustomerSucesso() {
		cadastraCustomer();
		String messageExpected = "Your data has been successfully stored into the database. Edit Customer or Go back to list";
		Assert.assertEquals(messageExpected, addCustomerPage.getMessage());
	}
	
	@Test	
	public void testExcluirCustomerSucesso() {
		cadastraCustomer();
		addCustomerPage.clickGoBackToList();
		pesquisarCustomerPage.setName("Teste Automação");
		delay(2);
		pesquisarCustomerPage.selectAllCustomers();
		pesquisarCustomerPage.clickDelete();
		pesquisarCustomerPage.getMessageDelete().contains("Are you sure that you want to delete those");
		pesquisarCustomerPage.clickConfirmaDelete();
		
		Assert.assertEquals("Your data has been successfully deleted from the database.", pesquisarCustomerPage.getMessageSucessDelete());
	}
	
	private void cadastraCustomer() {
		pesquisarCustomerPage.accessPage();
		pesquisarCustomerPage.clickAddCustomer();
		
		addCustomerPage.setName("Teste Automação");
		addCustomerPage.setLastName("Teste");
		addCustomerPage.setContactFirstName("Jonatas Lembeck");
		addCustomerPage.setPhone("51 9999-9999");
		addCustomerPage.setAddressLine1("Av Assis Brasil, 3970");
		addCustomerPage.setAddressLine2("Torre D");
		addCustomerPage.setCity("Porto Alegre");
		addCustomerPage.setState("RS");
		addCustomerPage.setPostalCode("91000-000");
		addCustomerPage.setCountry("Brasil");
		addCustomerPage.setFromEmployeer("Fixter");
		addCustomerPage.setCreditLimit(200.00);
		addCustomerPage.clickSave();
	}
}
