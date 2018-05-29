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
	
	@Dado("^que he ingresado a la p�gina \"([^\"]*)\"$")
	public void que_he_ingresado_a_la_p�gina(String arg1) throws Throwable {
	    Global.ingresarAlaPagina(arg1);
	}
	
	@Entonces("^deber�a visualizar una notificaci�n indicando que \"([^\"]*)\"$")
	public void deber�a_visualizar_una_notificaci�n_indicando_que(String arg1) throws Throwable {
	    Global.verificarMensajeDeNotificacion(arg1);
	}
	
	

}
