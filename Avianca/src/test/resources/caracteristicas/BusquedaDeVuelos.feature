# language: es
# encoding: iso-8859-1
## ININTER-44 Activar plan
Característica: Búsqueda de vuelos
  Como usuario de la aerolínea quiero consultar los vuelos disponibles 
  para la ciudad de mi interés a la cual deseo a viajar.

  @PruebasDeHumo @Regresión
  Escenario: el usuario consulta los vuelos disponibles para el trayecto de ida y regreso
    Dado que he ingresado a la página "https://www.avianca.com/co/es/"
    Y que he seleccionado como ciudad de partida "Medellín"
    Y que he seleccionado como ciudad de destino "Bogotá"
    Y que he seleccionado como fecha de partida "día en curso"
    Y que he seleccionado como fecha de regreso "3 días despues de la fecha en curso"
    Cuando presione el botón Buscar vuelos
    Entonces debería visualizar los vuelos disponibles para el trayecto "Ida y regreso"

  @Regresión
  Escenario: el usuario consulta los vuelos disponibles para el trayecto de ida
    Dado que he ingresado a la página "https://www.avianca.com/co/es/"
    Y que he marcado el trayecto "Solo ida"
    Y que he seleccionado como ciudad de partida "Medellín"
    Y que he seleccionado como ciudad de destino "Bogotá"
    Y que he seleccionado como fecha de partida "día en curso"
    Cuando presione el botón Buscar vuelos
    Entonces debería visualizar los vuelos disponibles para el trayecto "Solo ida"

  @Regresión
  Escenario: el usuario no diligencia la ciudad de partida
    Dado que he ingresado a la página "https://www.avianca.com/co/es/"
    Y que he seleccionado como ciudad de destino "Bogotá"
    Y que he seleccionado como fecha de partida "día en curso"
    Y que he seleccionado como fecha de regreso "3 días despues de la fecha en curso"
    Cuando presione el botón Buscar vuelos
    Entonces debería visualizar una notificación indicando que "Selecciona un origen"

  @Regresión
  Escenario: el usuario no diligencia la ciudad de destino
    Dado que he ingresado a la página "https://www.avianca.com/co/es/"
    Y que he seleccionado como ciudad de partida "Medellín"
    Y que he seleccionado como fecha de partida "día en curso"
    Y que he seleccionado como fecha de regreso "3 días despues de la fecha en curso"
    Cuando presione el botón Buscar vuelos
    Entonces debería visualizar una notificación indicando que "Selecciona un destino"

  @Regresión
  Escenario: el usuario no diligencia la fecha de partida
    Dado que he ingresado a la página "https://www.avianca.com/co/es/"
    Y que he seleccionado como ciudad de partida "Medellín"
    Y que he seleccionado como ciudad de destino "Bogotá"
    Y que he seleccionado como fecha de regreso "3 días despues de la fecha en curso"
    Y que no he seleccionado una fecha de partida
    Cuando presione el botón Buscar vuelos
    Entonces debería visualizar una notificación indicando que "Ingrese una fecha adecuada"

  @Regresión
  Escenario: el usuario no diligencia la fecha de regreso
    Dado que he ingresado a la página "https://www.avianca.com/co/es/"
    Y que he seleccionado como ciudad de partida "Medellín"
    Y que he seleccionado como ciudad de destino "Bogotá"
    Y que he seleccionado como fecha de partida "día en curso"
    Cuando presione el botón Buscar vuelos
    Entonces debería visualizar una notificación indicando que "Ingresa una fecha de regreso igual o posterior a la fecha de ida pero que no supere, respecto a la fecha actual, un rango de 355 días."

  @Regresión
  Escenario: el usuario ingresa una fecha de partida inferior a la fecha en curso
    Dado que he ingresado a la página "https://www.avianca.com/co/es/"
    Y que he seleccionado como ciudad de partida "Medellín"
    Y que he seleccionado como ciudad de destino "Bogotá"
    Y que he seleccionado como fecha de regreso "3 días despues de la fecha en curso"
    Y que he seleccionado como fecha de partida "5 días menor a la fecha en curso"
    Cuando presione el botón Buscar vuelos
    Entonces debería visualizar una notificación en la pantalla de reserva indicando que debo ingresar una fecha de partida igual o superior a la fecha en curso

  @Regresió
  Escenario: el usuario ingresa una fecha de regreso superior a un año con respecto al día en curso
    Dado que he ingresado a la página "https://www.avianca.com/co/es/"
    Y que he seleccionado como ciudad de partida "Medellín"
    Y que he seleccionado como ciudad de destino "Bogotá"
    Y que he seleccionado como fecha de partida "día en curso"
    Y que he seleccionado como fecha de regreso "un año despues de la fecha en curso"
    Cuando presione el botón Buscar vuelos
    Entonces debería visualizar una notificación indicando que "debo seleccionar una fecha menor a 365 días despues de la fecha en curso"

  @Regresió
  Escenario: el usuario ingresa una cantidad de pasajeros superior a la cantidad máxima permitida
    Dado que he ingresado a la página "https://www.avianca.com/co/es/"
    Y que he seleccionado como ciudad de partida "Medellín"
    Y que he seleccionado como ciudad de destino "Bogotá"
    Y que he seleccionado como fecha de partida "día en curso"
    Y que he seleccionado como fecha de regreso "3 días despues de la fecha en curso"
    Y que he seleccionado una cantidad de pasajeros superior a la permitida
    Cuando presione el botón Buscar vuelos
    Entonces debería visualizar una notificación indicando que "debo seleccionar una cantidad de pasajeros inferior"
