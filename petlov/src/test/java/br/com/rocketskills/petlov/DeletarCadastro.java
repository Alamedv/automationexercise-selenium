package br.com.rocketskills.petlov;

import java.time.Duration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeletarCadastro {

	void deleteAccount(WebDriver driver) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://automationexercise.com/signup");

		driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']"));
	
		driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();

		assert driver.findElement(By.xpath("//*[text()='Enter Account Information']")).isDisplayed();

	
		driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();
		assert driver.findElement(By.xpath("//b[normalize-space()='Account Created!']")).isDisplayed();
		driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
		driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();

		driver.findElement(By.linkText("Delete Account")).click();
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();

		driver.close();
	}

}
