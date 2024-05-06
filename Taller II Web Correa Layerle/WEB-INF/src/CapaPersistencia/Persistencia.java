package CapaPersistencia;

import java.io.*;

import CapaLogica.Clientes;
import CapaLogica.Contratos;
import CapaLogica.Servicios;
import CapaPersistencia.Contenedor;
import Excepciones.PersistenciaException;

public class Persistencia
{
	//Respalda en disco la información contenida en las tres colecciones de la fachada utilizando un contenedor.
	//Puede tirar PersistenciaException en caso de que se produzca un error.
	public static void respaldar(String nomArch, Clientes diccioClientes, Servicios diccioServicios, Contratos secContratos) throws PersistenciaException
	{
		try	
		{
			FileOutputStream f = new FileOutputStream(nomArch);
			ObjectOutputStream o = new ObjectOutputStream(f);
			Contenedor contenedor = new Contenedor(diccioClientes, diccioServicios, secContratos);
			o.writeObject(contenedor);
			o.close();
			f.close();
		}
		catch(IOException e)
		{
			throw new PersistenciaException("Error al respaldar.");
		}
	}
	
	//Retorna un contenedor con todos los datos almacenados en disco
	//Puede tirar PersistenciaException en caso de que el archivo estuviera vacío.
	//PRECONDICION: tiene que existir un archivo con el nombre ingresado
	public static Contenedor recuperar(String nomArch) throws PersistenciaException, IOException, ClassNotFoundException
	{
		Contenedor contenedor;
		File archivo = new File(nomArch);
		if(!archivo.exists())
		{
			throw new PersistenciaException("Error: El archivo no existe");
		}
		else
		{
			FileInputStream f = new FileInputStream(nomArch);
			ObjectInputStream o = new ObjectInputStream(f);
			contenedor = (Contenedor) o.readObject();
			o.close();
			f.close();
			if(contenedor == null)
			{
				throw new PersistenciaException("Error al recuperar.");
			}
			else
			{
				return contenedor;
			}
		}
	}
}
