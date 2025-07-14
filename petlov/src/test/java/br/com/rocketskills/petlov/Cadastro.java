package br.com.rocketskills.petlov;

import java.time.Duration;
import org.openqa.selenium.chrome.ChromeOptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

class NewUser {

	String username;
	String usermail;
	String userPassword;
	String firstName;
	String lastName;
	String company;
	String address1;
	String address2;
	String city;
	String state;
	String zipCode;
	String country;
	String mobileNumber;

	public NewUser(String username, String usermail, String userPassword, String firstName, String lastName,
			String company, String address1, String adress2, String city, String state, String zipCode, String country,
			String mobileNumber) {
		this.username = username;
		this.usermail = usermail;
		this.userPassword = userPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.address1 = address1;
		this.address2 = adress2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
		this.mobileNumber = mobileNumber;
	}
}

public class Cadastro {
	// steps 1, 2, 3, 4

	@Test
	@DisplayName("Deve poder entrar na pagina de login")
	void createPoint() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		driver.get("https://automationexercise.com/");

		WebElement title = driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));

		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(d -> title.isDisplayed());

		title.click();

		driver.close();
	}

	// remaining steps

	@Test
	@DisplayName("Deve iniciar o cadastro")
	void createAccount() {

		NewUser user1 = new NewUser(

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

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://automationexercise.com/signup");

		driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']"));
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(user1.username);
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(user1.usermail);
		driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();

		assert driver.findElement(By.xpath("//*[text()='Enter Account Information']")).isDisplayed();

		driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(user1.userPassword);
		driver.findElement(By.xpath("//select[@id='days']")).sendKeys("1");
		driver.findElement(By.xpath("//select[@id='months']")).sendKeys("January");
		driver.findElement(By.xpath("//select[@id='years']")).sendKeys("1990");
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(user1.firstName);
		driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys(user1.lastName);
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys(user1.company);
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(user1.address1);
		driver.findElement(By.xpath("//input[@id='address2']")).sendKeys(user1.address2);
		driver.findElement(By.xpath("//select[@id='country']")).sendKeys("United States");
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys(user1.state);
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys(user1.city);
		driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys(user1.zipCode);
		driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys(user1.mobileNumber);
		driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();
		assert driver.findElement(By.xpath("//b[normalize-space()='Account Created!']")).isDisplayed();
		driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
		driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
		

		driver.findElement(By.linkText("Delete Account")).click();
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();

		driver.close();
	}

}
