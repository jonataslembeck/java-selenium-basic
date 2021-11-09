package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.AddCustomerPage;
import pages.BasePage;
import pages.PesquisarCustomerPage;

public class CadastroCustomersTest extends BasePage {

	String textoCadastro = "Teste Automacao";
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
		pesquisarCustomerPage.setCustomerName(textoCadastro);
		pesquisarCustomerPage.waitResultCustomerName(textoCadastro);
		Assert.assertEquals(textoCadastro, pesquisarCustomerPage.getResultCustomerName());
	}
	
	@Test	
	public void testExcluirCustomerSucesso() {
		cadastraCustomer();
		pesquisarCustomerPage.setCustomerName(textoCadastro);
		pesquisarCustomerPage.waitResultCustomerName(textoCadastro);
		pesquisarCustomerPage.selectAllCustomers();
		pesquisarCustomerPage.clickDelete();
		pesquisarCustomerPage.clickConfirmaDelete();
		delay(3);
		
		Assert.assertEquals(false, pesquisarCustomerPage.isVisibleResultCustomerName(textoCadastro));
	}
	
	private void cadastraCustomer() {
		pesquisarCustomerPage.accessPage();
		pesquisarCustomerPage.clickOkCookie();
		pesquisarCustomerPage.clickAddCustomer();
		
		addCustomerPage.setCustomerName(textoCadastro);
		addCustomerPage.setContactLastName("Teste");
		addCustomerPage.setContactFirstName("Jonatas Lembeck");
		addCustomerPage.setPhone("51 9999-9999");
		addCustomerPage.setAddressLine1("Av Assis Brasil, 3970");
		addCustomerPage.setAddressLine2("Torre D");
		addCustomerPage.setCity("Porto Alegre");
		addCustomerPage.setState("RS");
		addCustomerPage.setPostalCode("91000-000");
		addCustomerPage.setCountry("Brasil");
		addCustomerPage.setSalesRepEmployeeNumber("2");
		addCustomerPage.setCreditLimit(200.00);
		addCustomerPage.setDeleted(2);
		addCustomerPage.clickSaveChanges();

		delay(3);
	}
}
