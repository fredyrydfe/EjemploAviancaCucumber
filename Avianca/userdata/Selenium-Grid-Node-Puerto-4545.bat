Echo off
Title Nodo Puerto 4545

Echo Configurando la ubicacion del projecto
set ubicacionDelProyecto=%~d0%~p0 
pushd %ubicacionDelProyecto%

Echo Cargando HUB por defecto puerto 4444
java -jar selenium-server-standalone-3.2.0.jar -role node  -hub http://localhost:4444/grid/register
pause
