package Servlets;

import java.io.IOException;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CapaLogica.IFachada;
import ValueObjects.VOServicio;

public class ServiciosServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private IFachada fachada;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		boolean error = false;
		String msgError = new String();
		//Se obtiene de web.xml los parámetros de conexión
		String ip = super.getInitParameter("ipServidor");
		String puerto = super.getInitParameter("puertoServidor");
		String nomObj = super.getInitParameter("nombreObjeto");
		//Se establece la ruta ip y el puerto
		String ruta = "//" + ip + ":" + puerto + "/" + nomObj;
		
		try
		{
			//Se accede remotamente a la fachada
			fachada = (IFachada) Naming.lookup(ruta);
		}
		catch (Exception e)
		{
			error = true;
			msgError = "Error de conexión con el servidor, por favor inténtelo de nuevo.";
		}
		try
		{
			//Se levanta la informacion del disco
			fachada.levantarInformacion();
		}
		catch (Exception e)
		{
			error = true;
			msgError = "Error de conexión con el servidor, por favor inténtelo de nuevo.";
		}
		
		//Se obtiene el contexto del Servlet
		ServletContext context = this.getServletContext();
		
		if(!error)
		{
			synchronized(context)
			{
				ArrayList<VOServicio> listado = new ArrayList<VOServicio>(Arrays.asList(fachada.listarServicios()));
				//Agrega el listado como atributo de contexto
				context.setAttribute("listadoServicios", listado);
			}
		}
		//Setea el mensaje de error en el request
	    request.setAttribute("msgError", msgError);
	    //Forwardea a la página apropiada
		RequestDispatcher rd;
		if (!error)
		{
			rd = request.getRequestDispatcher("ListadoServicios.jsp");
		}	
		else
		{
			rd = request.getRequestDispatcher("Error.jsp");
		}
		rd.forward(request, response);	
	}
}
