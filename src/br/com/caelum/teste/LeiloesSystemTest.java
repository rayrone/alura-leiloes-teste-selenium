package br.com.caelum.teste;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.caelum.pages.LeiloesPage;
import br.com.caelum.pages.UsuariosPage;
import br.com.caelum.util.WebDriverConfigurator;

public class LeiloesSystemTest {

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
	}

	@Test
	public void deveCadastrarUmLeilao() {
		leiloes.visita();
		leiloes.novo().preenche("Geladeira", 123, "Paulo Henrique", true);

		assertTrue(leiloes.existe("Geladeira", 123, "Paulo Henrique", true));
	}

	@After
	public void tearDown() {
		driver.close();
	}
}
