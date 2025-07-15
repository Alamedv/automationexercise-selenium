package br.com.rocketskills.petlov;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeletarCadastro {

	void deleteAccount(WebDriver driver) {

		try {

			driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
			driver.findElement(By.linkText("Delete Account")).click();
			driver.findElement(By.cssSelector(".btn.btn-primary")).click();

			driver.close();

		} catch (Exception e) {

			System.out.println("User is not signed up, cannot delete account.");
			return;
		}

	}

}
