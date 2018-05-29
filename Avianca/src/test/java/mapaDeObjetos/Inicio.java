package mapaDeObjetos;

import static mapaDeObjetos.Global.driver;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Inicio {

	public static String ciudadPartida = null, ciudadDestino = null;

	public static void seleccionarCiudadDePartida(String valor) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("bkOrigen")).click();
		driver.findElement(By.id("bkOrigen")).sendKeys(valor);
		Thread.sleep(1000);
		driver.findElement(By.id("bkOrigen")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("bkOrigen")).sendKeys(Keys.ENTER);
		ciudadPartida = valor;
	}

	public static void seleccionarCiudadDeDestino(String valor) throws InterruptedException {
		driver.findElement(By.id("bkDestino")).click();
		driver.findElement(By.id("bkDestino")).sendKeys(valor);
		Thread.sleep(1000);
		driver.findElement(By.id("bkDestino")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("bkDestino")).sendKeys(Keys.ENTER);
		ciudadDestino = valor;
	}

	public static void seleccionarFechaDePartida(String valor) {
		if (valor.equals("día en curso")) {
			valor = obtenerFechaActual();
			driver.findElement(By.id("bkFechaIda")).clear();
			driver.findElement(By.id("bkFechaIda")).click();
			driver.findElement(By.id("bkFechaIda")).sendKeys(valor);
		} else if (valor.contains("días menor a la fecha en curso")) {
			valor = obtenerFechaInferiorAlDiaActual(valor);
			driver.findElement(By.id("bkFechaIda")).clear();
			driver.findElement(By.id("bkFechaIda")).click();
			driver.findElement(By.id("bkFechaIda")).sendKeys(valor);
		}
	}

	private static String obtenerFechaInferiorAlDiaActual(String valor) {
		String dias = valor.substring(0, 1);
		int numeroDeDias = Integer.parseInt(dias);
		int dia = Calendar.getInstance().get(Calendar.DAY_OF_MONTH) - numeroDeDias;
		int mes = Calendar.getInstance().get(Calendar.MONTH) + 1;
		int año = Calendar.getInstance().get(Calendar.YEAR);
		String fecha = String.format("%02d", dia) + "" + String.format("%02d", mes) + "" + año;
		return fecha;
	}

	private static String obtenerFechaActual() {
		int dia = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		int mes = Calendar.getInstance().get(Calendar.MONTH) + 1;
		int año = Calendar.getInstance().get(Calendar.YEAR);
		String fecha = String.format("%02d", dia) + "" + String.format("%02d", mes) + "" + año;
		return fecha;
	}

	public static void seleccionarFechaDeRegreso(String valor) {
		if (valor.contains("días despues de la fecha en curso")) {
			String dias = valor.substring(0, 1);
			valor = obtenerFechaPosterior(dias);
		}
		driver.findElement(By.id("bkFechaRegreso")).clear();
		driver.findElement(By.id("bkFechaRegreso")).sendKeys(valor);
	}

	private static String obtenerFechaPosterior(String valor) {
		int numeroDeDias = Integer.parseInt(valor);
		int dia = Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + numeroDeDias;
		int mes = Calendar.getInstance().get(Calendar.MONTH) + 1;
		int año = Calendar.getInstance().get(Calendar.YEAR);
		String fecha = String.format("%02d", dia) + "" + String.format("%02d", mes) + "" + año;
		return fecha;
	}

	public static void presionarBotonBuscarVuelos() {
		WebElement elemento = driver.findElement(By.cssSelector("input.boton-principal.btn.boton-submit"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", elemento);
	}

	public static void dejarVaciaLaFechaDePartida() {
		driver.findElement(By.id("bkFechaIda")).clear();
	}

	public static void marcarOpcionDeTrayecto(String valor) {
		if (valor.equals("Solo ida")) {
			driver.findElement(By.id("bkRbIda")).click();
		}
	}

}
