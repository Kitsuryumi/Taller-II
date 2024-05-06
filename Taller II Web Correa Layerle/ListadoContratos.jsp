<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id='listadoContratos' scope='application' class='java.util.ArrayList' />

<html>
  <head>
    <title> Listado de contratos. </title>
    <link href= "css/Estilo.css" rel = "stylesheet" type= "text/css"/>
  </head>
  <body>
  <div id="contenedorTituloListadoContratos">
  	<h1 align="center">Listado de contratos</h1>
  </div>
  
   <p align="center"><br><img id="logo" src= "Imagenes/logo.png"></p>
  
  <div id="contenedorTablaListadoContratos">
  	<table id="tablaListadoContratos">
  		<tr>
				<td><b> Numero de contrato </b></td>
				<td><b> Hora de inicio </b></td>
				<td><b> Finalizado </b></td>
				<c:forEach items="${listadoContratos}" var="i" >
				<tr>
					<td> ${i.getNumero()} </td>
					<td> ${i.getHoraInicio()} </td>
					<c:if test="${i.getFinalizada()}"><td>Sí</td></c:if>
					<c:if test="${!i.getFinalizada()}"><td>No</td></c:if>
				</tr>
			</c:forEach>				
		</tr>
	</table>
  </div>
  
  <button class = "button" onClick="window.location.reload();">ACTUALIZAR RESULTADOS</button>
  <form id="formVolverAlMenu" action= 'Menu.jsp'><input type='submit' value= 'VOLVER AL MENU PRINCIPAL'></form>

  </body>
</html>
					
