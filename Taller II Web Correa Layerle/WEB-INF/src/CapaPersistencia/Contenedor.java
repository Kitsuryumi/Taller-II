package CapaPersistencia;

import java.io.Serializable;

import CapaLogica.Clientes;
import CapaLogica.Contratos;
import CapaLogica.Servicios;

public class Contenedor implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Clientes diccioClientes;
	private Servicios diccioServicios;
	private Contratos secContratos;
	
	//Crea un nuevo contenedor con las tres colecciones ingresadas
	public Contenedor(Clientes diccioClientes, Servicios diccioServicios, Contratos secContratos)
	{
		this.diccioClientes = diccioClientes;
		this.diccioServicios = diccioServicios;
		this.secContratos = secContratos;
	}

	//Retorna el diccionario de clientes
	public Clientes getDiccioClientes()
	{
		return diccioClientes;
	}

	//Retorna el diccionario de servicios
	public Servicios getDiccioServicios()
	{
		return diccioServicios;
	}

	//Retorna la secuencia de contratos
	public Contratos getSecContratos()
	{
		return secContratos;
	}
	

}
