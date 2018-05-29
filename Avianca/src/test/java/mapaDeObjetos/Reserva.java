package mapaDeObjetos;

import static mapaDeObjetos.Global.driver;

import static mapaDeObjetos.Inicio.ciudadPartida;

import java.util.concurrent.TimeUnit;

import static mapaDeObjetos.Inicio.ciudadDestino;

import org.junit.Assert;
import org.openqa.selenium.By;

public class Reserva {

	public static void esperarPorLaPaginaDeReserva() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='FrameAmadeus']")));
		driver.findElement(By.xpath("//*[@id='fpp_departure_title']")).isDisplayed();
	}

	public static void verificarQueSeVisualicenLasCiudadesSeleccionadasDeIdaYRegreso() {
		String ciudadDeIdaGeneradaEnElSistema = driver
				.findElement(By.xpath("//*[@id='availability-bound-0']/header/h2/div[1]/div[1]/div/div/div/div"))
				.getText();
		String ciudadDeRegresoGeneradaEnElSistema = driver
				.findElement(By.xpath("//*[@id='availability-bound-0']/header/h2/div[1]/div[2]/div/div/div/div"))
				.getText();
		Assert.assertEquals(ciudadPartida.toUpperCase(), ciudadDeIdaGeneradaEnElSistema);
		Assert.assertEquals(ciudadDestino.toUpperCase(), ciudadDeRegresoGeneradaEnElSistema);
	}

	public static void verificarQueSeVisualicenLasCiudadesSeleccionadasSoloDeIda() {
		String ciudadDeIdaGeneradaEnElSistema = driver
				.findElement(By.xpath("//*[@id='availability-bound-0']/header/h2/div[1]/div[1]/div/div/div/div"))
				.getText();
		Assert.assertEquals(ciudadPartida.toUpperCase(), ciudadDeIdaGeneradaEnElSistema);
	}

	public static void verificarMensajeDeNotificacionFechaDePartidaInferior() {
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='FrameAmadeus']")));
		String mensajeEsperado1 = "En este momento no podemos procesar tu solicitud. Inténtalo nuevamente";
		String mensajeEsperado2 = "Ha solicitado una fecha de salida posterior a las fechas válidas. Las fechas válidas son las comprendidas entre -12 horas y 355 días. Por favor, modifique las fechas e inténtelo de nuevo. (10032)";
		String mensajeEsperado3 = "La fecha/hora de vuelta es anterior o igual a la fecha/hora de salida. Ajuste las fechas/horas e inténtelo de nuevo. (10000)";
		String mensaje1 = driver.findElement(By.xpath("//*[@id='global-error-message']/div/p")).getText();
		String mensaje2 = driver.findElement(By.xpath("//*[@id='global-error-message']/div/ul/li[1]/span")).getText();
		String mensaje3 = driver.findElement(By.xpath("//*[@id='global-error-message']/div/ul/li[2]/span")).getText();
		Assert.assertEquals(mensajeEsperado1, mensaje1);
		Assert.assertEquals(mensajeEsperado2, mensaje2);
		Assert.assertEquals(mensajeEsperado3, mensaje3);
	}

}
