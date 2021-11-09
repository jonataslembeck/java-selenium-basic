package pages;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected static WebDriver driver;

	public static WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriverManager.chromedriver().driverVersion("95.0.4638.69").setup(); // -> Força versão do driver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public static void fechaNavegador() {
		driver.quit();
	}
	
	public void visit(String url) {
		driver.get(url);
	}

	private static WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	public void click(By locator) {
		findElement(locator).click();
	}

	public void sendKeys(By locator, String text) {
		findElement(locator).sendKeys(text);
	}

	public String getText(By locator) {
		String texto = driver.findElement(locator).getText();
		return texto;
	}

	public void waitVisibilityOfElementLocated(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public Boolean isVisible(By locator){
		Boolean isPresent = driver.findElements(locator).size() > 0;
		if (isPresent) {
			return true;
		}else{
			return false;
		}
	}
	
	public static void delay(double segundos) {		
		try {
			Thread.sleep((int)segundos * 1000);
		} catch (InterruptedException e) {
			System.out.println("Erro ao aguardar o tempo." + e.getMessage());
		}
	}
}
