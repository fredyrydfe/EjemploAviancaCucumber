package definicionDePasos;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import mapaDeObjetos.Global;
import mapaDeObjetos.Inicio;
import mapaDeObjetos.Reserva;

public class BusquedaDeVuelos {
	
	@Dado("^que he seleccionado como ciudad de partida \"([^\"]*)\"$")
	public void que_he_seleccionado_como_ciudad_de_partida(String arg1) throws Throwable {
		Global.aplicarScroll("200");
	    Inicio.seleccionarCiudadDePartida(arg1);
	}

	@Dado("^que he seleccionado como ciudad de destino \"([^\"]*)\"$")
	public void que_he_seleccionado_como_ciudad_de_destino(String arg1) throws Throwable {
	    Inicio.seleccionarCiudadDeDestino(arg1);
	}

	@Dado("^que he seleccionado como fecha de partida \"([^\"]*)\"$")
	public void que_he_seleccionado_como_fecha_de_partida(String arg1) throws Throwable {
	    Inicio.seleccionarFechaDePartida(arg1);
	}

	@Dado("^que he seleccionado como fecha de regreso \"([^\"]*)\"$")
	public void que_he_seleccionado_como_fecha_de_regreso(String arg1) throws Throwable {
		Inicio.seleccionarFechaDeRegreso(arg1);
	}

	@Cuando("^presione el botón Buscar vuelos$")
	public void presione_el_botón_Buscar_vuelos() throws Throwable {
		Global.aplicarScroll("300");
	    Inicio.presionarBotonBuscarVuelos();
	}

	@Entonces("^debería visualizar los vuelos disponibles para el trayecto \"([^\"]*)\"$")
	public void debería_visualizar_los_vuelos_disponibles_para_el_trayecto(String arg1) throws Throwable {
	    Reserva.esperarPorLaPaginaDeReserva();
	    if (arg1.equals("Ida y regreso")) {
	    	Reserva.verificarQueSeVisualicenLasCiudadesSeleccionadasDeIdaYRegreso();
		} else if (arg1.equals("Solo ida")) {
			Reserva.verificarQueSeVisualicenLasCiudadesSeleccionadasSoloDeIda();
		}
	}

	@Dado("^que he marcado el trayecto \"([^\"]*)\"$")
	public void que_he_marcado_el_trayecto(String arg1) throws Throwable {
	    Inicio.marcarOpcionDeTrayecto(arg1);
	}
	
	@Dado("^que he seleccionado una cantidad de pasajeros superior a la permitida$")
	public void que_he_seleccionado_una_cantidad_de_pasajeros_superior_a_la_permitida() throws Throwable {
	    
	}
	
	@Dado("^que no he seleccionado una fecha de partida$")
	public void que_no_he_seleccionado_una_fecha_de_partida() throws Throwable {
	    Inicio.dejarVaciaLaFechaDePartida();
	}
	
	@Entonces("^debería visualizar una notificación en la pantalla de reserva indicando que debo ingresar una fecha de partida igual o superior a la fecha en curso$")
	public void debería_visualizar_una_notificación_en_la_pantalla_de_reserva_indicando_que_debo_ingresar_una_fecha_de_partida_igual_o_superior_a_la_fecha_en_curso() throws Throwable {
	    Reserva.verificarMensajeDeNotificacionFechaDePartidaInferior();
	}

}
