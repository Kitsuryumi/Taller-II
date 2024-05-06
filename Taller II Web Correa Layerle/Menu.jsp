<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
<link href= "css/Estilo.css" rel = "stylesheet" type= "text/css"/>
</head>
  <body>
  <div id= "contenedorTitulo">
  	<h1 align="center">Mudanzas De Aquí Para Allá</h1>
  </div>
  <p align="center"><br><img id="logo" src= "Imagenes/logo.png"></p>
  <div id= "contenedorSubTitulo">
  	<h2 align="center">Bienvenido al sitio oficial de Mudanzas De Aquí Para Allá.</h2>
  </div>
  	<div id= "contenedorListarServicios">
	  		<p align="center">Para consultar la lista de servicios ofrecidos </p>
	  		<form id="formServicios" action='Servicios' method='POST'>
		      	<input type='submit' value='LISTAR SERVICIOS'>
	  		</form>
  	</div>
  	<div id= "contenedorListarContratos">
  		<p align="center">Para consultar la  lista de contratos registrados en una fecha, ingrese la fecha a consultar en el formulario</p>
  		<form id="formContratos" action='Contratos' method='POST'>
  		 	<p align="center">Dia :<input id= "dia" type = 'number' name = 'dia' min="1" max="31"> / Mes :<input id= "mes" type = 'number' name = 'mes' min="1" max="12"> / Año :<input id= "anio" type = 'number' name = 'anio'>
  		 	<br>
  		 	<br>
  		 	<input type='submit' value='LISTAR CONTRATOS'> </p>
  		</form>
  	</div>
	<br>
  </body>
</html>