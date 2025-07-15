package br.com.rocketskills.petlov;

import java.time.Duration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cadastro {

	void createAccount(WebDriver driver, NewUser user1) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");

		
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

		
	}

}
