package mapaDeObjetos;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

// ---------------------------------------------------------
// LIBRERIAS PARA SELENIUM GRID
// ---------------------------------------------------------
import java.net.MalformedURLException;
import java.net.URL;

public class Global {

	public static WebDriver driver;
	public static int tamanoDeLaVentana;
	public static String url;
	public static WebDriverWait explicitWait;

	public static enum Browser {
		CHROME, FIREFOX, IE
	}

	public static void configurarGridParaEjecucionEnParalelo() throws MalformedURLException {
		String Nodo = "http://localhost:4444/wd/hub";
		DesiredCapabilities capacidades = DesiredCapabilities.chrome();
		driver = new RemoteWebDriver(new URL(Nodo), capacidades);
		driver.manage().window().maximize();
		tamanoDeLaVentana = driver.manage().window().getSize().getWidth();
	}

	public static void abrirElNavegador(Browser navegador) throws IOException {
		if (navegador.equals(Browser.CHROME)) {
			File directorioActual = new File(".");
			System.setProperty("webdriver.chrome.driver",
					directorioActual.getCanonicalPath() + "\\userdata\\chromedriver2_37.exe");
			driver = new ChromeDriver();
		} else if (navegador.equals(Browser.FIREFOX)) {
			driver = new FirefoxDriver();
		} else if (navegador.equals(Browser.IE)) {

		}
		driver.manage().window().maximize();
		tamanoDeLaVentana = driver.manage().window().getSize().getWidth();
	}

	public static void ingresarAlaPagina(String valor) throws IOException {
		driver.get(valor);
		url = valor;
	}

	public static void aplicarScroll(String scroll) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0," + scroll + ")", "");
	}

	public static void cerrarNavegador() {
		driver.quit();
	}

	public static void tomarEvidencia(Scenario escenario) {
		if (escenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			escenario.embed(screenshot, "imagen/png");
		} else {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			escenario.embed(screenshot, "imagen/png");
		}
	}

	public static void establecerTiempoDeEsperaExplicita(int tiempoDeEsperaEnSegundos) {
		explicitWait = new WebDriverWait(driver, tiempoDeEsperaEnSegundos);
	}

	public static void cerrarSesion() {
		driver.navigate().to(url);
	}

	public static HSSFSheet obtenerListaDeCoberturasDelArchivoDeExcel() throws IOException {
		File directorioActual = new File(".");
		File src = new File(directorioActual.getCanonicalPath() + "\\userdata\\lista de coberturas.xls");
		FileInputStream fis = new FileInputStream(src);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet hoja1 = wb.getSheetAt(0);
		return hoja1;
	}

	public static void verificarMensajeDeNotificacion(String arg1) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		explicitWait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id='cortinillaErrorBooking']/div/div/div[2]/div/div/div[2]/div/ul/li")));
		boolean mensajeDeAlertaEsVisible = false;
		if (driver.getPageSource().contains(arg1)) {
			mensajeDeAlertaEsVisible = true;
		} else {
			mensajeDeAlertaEsVisible = false;
		}
		Assert.assertEquals(true, mensajeDeAlertaEsVisible);
	}

}
