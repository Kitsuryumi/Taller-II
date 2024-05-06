package Servlets;

import java.io.IOException;
import java.rmi.Naming;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import CapaLogica.IFachada;
import ValueObjects.VOContratoFecha;


public class ContratosServlet  extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private IFachada fachada;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		boolean error = false;
		String msgError = new String();
		//Se obtiene el contexto del Servlet
		ServletContext context = this.getServletContext();
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
		
		if(!error)
		{
			try
			{
				int dia = Integer.parseInt(request.getParameter("dia"));
				int mes = Integer.parseInt(request.getParameter("mes"));
				int anio = Integer.parseInt(request.getParameter("anio"));
				LocalDate fecha = LocalDate.of(anio, mes, dia);
				synchronized (context)
				{
					try 
					{
						ArrayList<VOContratoFecha> arreContratos = new ArrayList<VOContratoFecha>(Arrays.asList(fachada.listarContratacionesPorFecha(fecha)));
						context.setAttribute("listadoContratos", arreContratos);
					} 
					catch(NullPointerException e)
					{
						error = true;
						msgError = "Error! no existe ningún contrato registrado con la fecha ingresada.";
					}
				}
			}
			catch(Exception e)
			{
				error = true;
				msgError = "Error! fecha inválida.";				}	
			}
		//Setea el mensaje de error en el request
		request.setAttribute("msgError", msgError);
		//Forwardea a la página apropiada
		RequestDispatcher rd;
		if (!error)
		{
			rd = request.getRequestDispatcher("ListadoContratos.jsp");
		}
		else
		{
			rd = request.getRequestDispatcher("Error.jsp");
		}
		rd.forward(request, response);
			
	}

}
