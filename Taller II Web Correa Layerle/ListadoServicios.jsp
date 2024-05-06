<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id='listadoServicios' scope='application' class='java.util.ArrayList' />  

<html>
  <head>
    <title> Listado de servicios. </title>
    <link href= "css/Estilo.css" rel = "stylesheet" type= "text/css"/>
  </head>
  <body>
  <div id="contenedorTituloListadoServicios">
  	<h1 align="center">Listado de servicios</h1>
  </div>
  
   <p align="center"><br><img id="logo" src= "Imagenes/logo.png"></p>
   
  <div id="contenedorTablaListadoServicios">
  	<table id="tablaListadoServicios">
  		<tr>
				<td><b> Código de servicio </b></td>
				<td><b> Distancia máxima </b></td>
				<td><b> Costo por hora </b></td>
				<td><b> Embalaje </b></td>
				<td><b> Armado </b></td>
				<c:forEach items="${listadoServicios}" var="i" >
				<tr>
					<td> ${i.getCodigo()} </td>
					<td> ${i.getDistanciaMax()} </td>
					<td> $ ${i.getCostoHora()} </td>
					<c:if test="${i.getEmbalaje()}"><td>Sí</td></c:if>
					<c:if test="${!i.getEmbalaje()}"><td>No</td></c:if>
					<c:if test="${i.getArmado()}"><td>Sí</td></c:if>
					<c:if test="${!i.getArmado()}"><td>No</td></c:if>
				</tr>
			</c:forEach>					
		</tr>
	</table>
  </div>
  
  <button class= button onClick="window.location.reload();">ACTUALIZAR RESULTADOS</button>
  <form id="formVolverAlMenu" action= 'Menu.jsp'><input type='submit' value= 'VOLVER AL MENU PRINCIPAL'></form>

  </body>
</html>
			