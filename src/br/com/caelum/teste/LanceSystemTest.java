package br.com.caelum.teste;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.caelum.pages.DetalhesDoLeilaoPage;
import br.com.caelum.pages.LeiloesPage;
import br.com.caelum.pages.UsuariosPage;
import br.com.caelum.util.WebDriverConfigurator;

public class LanceSystemTest {

	private WebDriver driver;
	private LeiloesPage leiloes;

	@Before
	public void setUp() {
		driver = WebDriverConfigurator.configure();
		driver.get(WebDriverConfigurator.getUrlLimparBase());

		leiloes = new LeiloesPage(driver);

		UsuariosPage usuarios = new UsuariosPage(driver);
		usuarios.visita();
		usuarios.novo().cadastra("Paulo Henrique", "paulo@henrique.com");
		usuarios.novo().cadastra("José Eduardo", "jose@eduardo.com");

		LeiloesPage leiloes = new LeiloesPage(driver);
		leiloes.visita();
		leiloes.novo().preenche("Geladeira", 100, "Paulo Henrique", false);
	}

	@Test
	public void deveFazerUmLance() {
		DetalhesDoLeilaoPage lances = leiloes.detalhes(1);
		lances.lance("José Eduardo", 150);

		assertTrue(lances.existeLance("José Eduardo", 150));
	}

	@After
	public void tearDown() {
		driver.close();
	}
}
