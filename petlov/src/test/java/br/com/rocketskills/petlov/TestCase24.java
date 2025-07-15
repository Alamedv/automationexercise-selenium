package br.com.rocketskills.petlov;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase24 {

	@Test
	@DisplayName("Download Invoice after purchase order")
	void createAccount() {

		NewUser user2 = new NewUser(

				"Almd",
				"almd@gmail.com",
				"123456",
				"Almd",
				"byo",
				"Ubisoft",
				"Ubisoft Office",
				"Mission St 20th floor",
				"San Francisco",
				"California",
				"94103",
				"USA",
				"1234567890");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");

		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://automationexercise.com/");

		driver.getTitle().contains("Automation Exercise");

		driver.findElement(By.cssSelector("[data-product-id='1']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-title.w-100"))).isDisplayed();
		driver.findElement(By.xpath("//u[normalize-space()='View Cart']")).click();

		driver.getTitle().contains("Automation Exercise - Checkout");
		driver.findElement(By.xpath("//li[@class='active']")).getText().contains("Shopping Cart");
		driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//u[normalize-space()='Register / Login']")))
				.click();

		Cadastro cadastro = new Cadastro();
		cadastro.createAccount(driver, user2);

		driver.findElement(By.xpath("//a[normalize-space()='Cart']//i[@class='fa fa-shopping-cart']")).click();
		driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

		driver.findElement(By.xpath("//h2[normalize-space()='Address Details']")).isDisplayed();
		driver.findElement(By.xpath("//h2[normalize-space()='Review Your Order']")).isDisplayed();
		driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Please deliver it as soon as possible.");
		driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
		driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("Almd");
		driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("" + System.currentTimeMillis());
		driver.findElement(By.xpath("//input[@placeholder='ex. 311']")).sendKeys("" + System.currentTimeMillis());
		driver.findElement(By.xpath("//input[@placeholder='MM']")).sendKeys("" + System.currentTimeMillis());
		driver.findElement(By.xpath("//input[@placeholder='YYYY']")).sendKeys("" + System.currentTimeMillis());
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='Congratulations! Your order has been confirmed!']"))).isDisplayed();

		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

	}
}