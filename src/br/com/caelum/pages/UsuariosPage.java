package br.com.caelum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.caelum.util.WebDriverConfigurator;

public class UsuariosPage {

	private final WebDriver driver;

	public UsuariosPage(WebDriver driver) {
		this.driver = driver;
	}

	public void visita() {
		driver.get(WebDriverConfigurator.getUrl("/usuarios"));
	}

	public NovoUsuarioPage novo() {
		driver.findElement(By.linkText("Novo Usuário")).click();
		return new NovoUsuarioPage(driver);
	}

	public boolean existeNaListagem(String nome, String email) {
		String pageSource = driver.getPageSource();
		return pageSource.contains(nome) && pageSource.contains(email);
	}
}
