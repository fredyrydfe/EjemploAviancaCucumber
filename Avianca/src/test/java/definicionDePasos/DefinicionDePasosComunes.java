package definicionDePasos;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import mapaDeObjetos.Global;
import mapaDeObjetos.Global.Browser;

public class DefinicionDePasosComunes {
	
	@Before
	public static void preparar_ambiente_de_prueba() throws Throwable {
		Global.configurarGridParaEjecucionEnParalelo();
		//Global.abrirElNavegador(Browser.CHROME);
		Global.establecerTiempoDeEsperaExplicita(30);
	}

	@After
	public static void finalizar_ejecucion(Scenario escenario) throws Throwable {
		Global.tomarEvidencia(escenario);
		Global.cerrarNavegador();
	}
	
	@Dado("^que he ingresado a la página \"([^\"]*)\"$")
	public void que_he_ingresado_a_la_página(String arg1) throws Throwable {
	    Global.ingresarAlaPagina(arg1);
	}
	
	@Entonces("^debería visualizar una notificación indicando que \"([^\"]*)\"$")
	public void debería_visualizar_una_notificación_indicando_que(String arg1) throws Throwable {
	    Global.verificarMensajeDeNotificacion(arg1);
	}
	
	

}
