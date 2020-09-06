package br.com.caelum.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverConfigurator {

	public static WebDriver configure() {
		System.setProperty("webdriver.gecko.driver", "E:/dev_gm/run/geckodriver.exe");
		return new FirefoxDriver();
	}

	public static String getUrl(String resource) {
		return "http://localhost:8080" + resource;
	}

	public static String getUrlLimparBase() {
		return getUrl("/apenas-teste/limpa");
	}
}
