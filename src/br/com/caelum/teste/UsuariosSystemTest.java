package br.com.caelum.teste;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.caelum.pages.UsuariosPage;
import br.com.caelum.util.WebDriverConfigurator;

public class UsuariosSystemTest {

	private WebDriver driver;
	private UsuariosPage usuarios;

	@Before
	public void setUp() {
		driver = WebDriverConfigurator.configure();
		driver.get(WebDriverConfigurator.getUrlLimparBase());

		usuarios = new UsuariosPage(driver);
	}

	@Test
	public void deveAdicionarUmUsuario() {
		usuarios.visita();
		usuarios.novo().cadastra("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br");

		assertTrue(usuarios.existeNaListagem("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br"));
	}

	@After
	public void tearDown() {
		driver.close();
	}
}
