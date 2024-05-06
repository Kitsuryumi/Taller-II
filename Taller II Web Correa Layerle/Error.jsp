<jsp:useBean id='msgError' scope='request' class='java.lang.String' />  

<html>
  <head>
    <title>ERROR</title>
     <link href= "css/Estilo.css" rel = "stylesheet" type= "text/css"/>
  </head>
  
  <div id= "contenedorTituloError">
  	<h1 align="center"><b>ERROR!</b></h1>
  </div>
   <p align="center"><br><img id="logo" src= "Imagenes/logo.png"></p>
  <div id= "contenedorMensajeError">
  	<p><b>${msgError}</b></p>
  </div>
	
  <form id="formVolverAlMenu" action= 'Menu.jsp'><input type='submit' value= 'VOLVER AL MENU PRINCIPAL'></form>

  </body>
  
</html>