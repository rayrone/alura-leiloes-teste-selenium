package br.com.caelum.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.caelum.util.WebDriverConfigurator;

public class LeiloesPage {

	private final WebDriver driver;

	public LeiloesPage(WebDriver driver) {
		this.driver = driver;
	}

	public void visita() {
		driver.get(WebDriverConfigurator.getUrl("/leiloes"));
	}

	public NovoLeilaoPage novo() {
		driver.findElement(By.linkText("Novo Leilão")).click();
		return new NovoLeilaoPage(driver);
	}

	public boolean existe(String produto, double valor, String usuario, boolean usado) {
		String pageSource = driver.getPageSource();
		return pageSource.contains(produto) && pageSource.contains(String.valueOf(valor))
				&& pageSource.contains(usuario) && pageSource.contains(usado ? "Sim" : "Não");
	}

	public DetalhesDoLeilaoPage detalhes(int posicao) {
		List<WebElement> elementos = driver.findElements(By.linkText("exibir"));
		elementos.get(posicao - 1).click();
		return new DetalhesDoLeilaoPage(driver);
	}
}
