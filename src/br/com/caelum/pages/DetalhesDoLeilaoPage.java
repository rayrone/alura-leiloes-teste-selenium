package br.com.caelum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetalhesDoLeilaoPage {

	private final WebDriver driver;

	public DetalhesDoLeilaoPage(WebDriver driver) {
		this.driver = driver;
	}

	public void lance(String usuario, double valor) {
		Select cbUsuario = new Select(driver.findElement(By.name("lance.usuario.id")));
		WebElement txtValor = driver.findElement(By.name("lance.valor"));

		cbUsuario.selectByVisibleText(usuario);
		txtValor.sendKeys(String.valueOf(valor));

		driver.findElement(By.id("btnDarLance")).click();
	}

	public boolean existeLance(String usuario, double valor) {

		// Esperando 10s para que a requisição ajax já tenha sido executada e a
		// view atualizada
		Boolean temUsuario = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.textToBePresentInElementLocated(By.id("lancesDados"), usuario));

		if (temUsuario)
			return driver.getPageSource().contains(String.valueOf(valor));

		return false;
	}

}
