# language: es
# encoding: iso-8859-1
## ININTER-44 Activar plan
Caracter�stica: B�squeda de vuelos
  Como usuario de la aerol�nea quiero consultar los vuelos disponibles 
  para la ciudad de mi inter�s a la cual deseo a viajar.

  @PruebasDeHumo @Regresi�n
  Escenario: el usuario consulta los vuelos disponibles para el trayecto de ida y regreso
    Dado que he ingresado a la p�gina "https://www.avianca.com/co/es/"
    Y que he seleccionado como ciudad de partida "Medell�n"
    Y que he seleccionado como ciudad de destino "Bogot�"
    Y que he seleccionado como fecha de partida "d�a en curso"
    Y que he seleccionado como fecha de regreso "3 d�as despues de la fecha en curso"
    Cuando presione el bot�n Buscar vuelos
    Entonces deber�a visualizar los vuelos disponibles para el trayecto "Ida y regreso"

  @Regresi�n
  Escenario: el usuario consulta los vuelos disponibles para el trayecto de ida
    Dado que he ingresado a la p�gina "https://www.avianca.com/co/es/"
    Y que he marcado el trayecto "Solo ida"
    Y que he seleccionado como ciudad de partida "Medell�n"
    Y que he seleccionado como ciudad de destino "Bogot�"
    Y que he seleccionado como fecha de partida "d�a en curso"
    Cuando presione el bot�n Buscar vuelos
    Entonces deber�a visualizar los vuelos disponibles para el trayecto "Solo ida"

  @Regresi�n
  Escenario: el usuario no diligencia la ciudad de partida
    Dado que he ingresado a la p�gina "https://www.avianca.com/co/es/"
    Y que he seleccionado como ciudad de destino "Bogot�"
    Y que he seleccionado como fecha de partida "d�a en curso"
    Y que he seleccionado como fecha de regreso "3 d�as despues de la fecha en curso"
    Cuando presione el bot�n Buscar vuelos
    Entonces deber�a visualizar una notificaci�n indicando que "Selecciona un origen"

  @Regresi�n
  Escenario: el usuario no diligencia la ciudad de destino
    Dado que he ingresado a la p�gina "https://www.avianca.com/co/es/"
    Y que he seleccionado como ciudad de partida "Medell�n"
    Y que he seleccionado como fecha de partida "d�a en curso"
    Y que he seleccionado como fecha de regreso "3 d�as despues de la fecha en curso"
    Cuando presione el bot�n Buscar vuelos
    Entonces deber�a visualizar una notificaci�n indicando que "Selecciona un destino"

  @Regresi�n
  Escenario: el usuario no diligencia la fecha de partida
    Dado que he ingresado a la p�gina "https://www.avianca.com/co/es/"
    Y que he seleccionado como ciudad de partida "Medell�n"
    Y que he seleccionado como ciudad de destino "Bogot�"
    Y que he seleccionado como fecha de regreso "3 d�as despues de la fecha en curso"
    Y que no he seleccionado una fecha de partida
    Cuando presione el bot�n Buscar vuelos
    Entonces deber�a visualizar una notificaci�n indicando que "Ingrese una fecha adecuada"

  @Regresi�n
  Escenario: el usuario no diligencia la fecha de regreso
    Dado que he ingresado a la p�gina "https://www.avianca.com/co/es/"
    Y que he seleccionado como ciudad de partida "Medell�n"
    Y que he seleccionado como ciudad de destino "Bogot�"
    Y que he seleccionado como fecha de partida "d�a en curso"
    Cuando presione el bot�n Buscar vuelos
    Entonces deber�a visualizar una notificaci�n indicando que "Ingresa una fecha de regreso igual o posterior a la fecha de ida pero que no supere, respecto a la fecha actual, un rango de 355 d�as."

  @Regresi�n
  Escenario: el usuario ingresa una fecha de partida inferior a la fecha en curso
    Dado que he ingresado a la p�gina "https://www.avianca.com/co/es/"
    Y que he seleccionado como ciudad de partida "Medell�n"
    Y que he seleccionado como ciudad de destino "Bogot�"
    Y que he seleccionado como fecha de regreso "3 d�as despues de la fecha en curso"
    Y que he seleccionado como fecha de partida "5 d�as menor a la fecha en curso"
    Cuando presione el bot�n Buscar vuelos
    Entonces deber�a visualizar una notificaci�n en la pantalla de reserva indicando que debo ingresar una fecha de partida igual o superior a la fecha en curso

  @Regresi�
  Escenario: el usuario ingresa una fecha de regreso superior a un a�o con respecto al d�a en curso
    Dado que he ingresado a la p�gina "https://www.avianca.com/co/es/"
    Y que he seleccionado como ciudad de partida "Medell�n"
    Y que he seleccionado como ciudad de destino "Bogot�"
    Y que he seleccionado como fecha de partida "d�a en curso"
    Y que he seleccionado como fecha de regreso "un a�o despues de la fecha en curso"
    Cuando presione el bot�n Buscar vuelos
    Entonces deber�a visualizar una notificaci�n indicando que "debo seleccionar una fecha menor a 365 d�as despues de la fecha en curso"

  @Regresi�
  Escenario: el usuario ingresa una cantidad de pasajeros superior a la cantidad m�xima permitida
    Dado que he ingresado a la p�gina "https://www.avianca.com/co/es/"
    Y que he seleccionado como ciudad de partida "Medell�n"
    Y que he seleccionado como ciudad de destino "Bogot�"
    Y que he seleccionado como fecha de partida "d�a en curso"
    Y que he seleccionado como fecha de regreso "3 d�as despues de la fecha en curso"
    Y que he seleccionado una cantidad de pasajeros superior a la permitida
    Cuando presione el bot�n Buscar vuelos
    Entonces deber�a visualizar una notificaci�n indicando que "debo seleccionar una cantidad de pasajeros inferior"
