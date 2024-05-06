package CapaLogica;
import java.util.LinkedList;
import ValueObjects.VOContratoFecha;

import java.io.Serializable;
import java.time.LocalDate;

public class Contratos implements Serializable
{
	private static final long serialVersionUID = 1L;
	private LinkedList<Contrato> sec;

	
	//Crea una secuencia de contratos vacía
	public Contratos()
	{
		this.sec = new LinkedList<Contrato>();
	}
	
	
	//METODOS PRIMITIVOS
	
	//Retorna el contrato en la k_esima posición. Las posiciones comienzan en 0
	//PRECONDICIONES: 1- posicion debe ser menor al largo de la lista
	//				  2- posicion debe ser MAYOR IGUAL a 0
	public Contrato k_esimo(int posicion)
	{
		return (this.sec.get(posicion));
	}
	
	//Retorna true si la secuencia está vacía
	public boolean esVacia()
	{
		return (this.sec.isEmpty());
	}
	
	//Retorna el número de elementos que tiene cargada la secuencia
	public int largo()
	{
		return (this.sec.size());
	}
	
	//Inserta un contrato al final de la secuencia
	public void insBack(Contrato contrato)
	{
		this.sec.add(contrato);
	}
	
	//Retorna el último elemento de la secuencia
	//PRECONDICION: la secuencia NO puede estar vacía (esVacia() == false)
	public Contrato back()
	{
		return (this.sec.getLast());
	}
	
	
	//METODOS ESPECIFICOS
	
	//Devuelve el monto recaudado por los contratos con fecha de inicio entre fecha1 y fecha2
	//PRECONDICIONES: 1- fecha1 <= fecha2
	//				  2- fecha1 <= k_esimo(0).getFecha()
	//				  3- fecha2 >= back().getFecha()
	//				  4- esVacia() == false
	public double montoRecaudadoPorRangoDeFecha(LocalDate fecha1, LocalDate fecha2)
	{
		double resultado = 0;
		int i = 0, largo = this.sec.size();
		Contrato contrato;
		do
		{
			contrato = this.sec.get(i);
			if((contrato.getFecha().isAfter(fecha1) || contrato.getFecha().isEqual(fecha1)) && (contrato.getFecha().isBefore(fecha2) || contrato.getFecha().isEqual(fecha2)))
			{
				resultado = resultado + contrato.getCostoFinal();
			}
			i++;
		}
		while((contrato.getFecha().isBefore(fecha2) || contrato.getFecha().isEqual(fecha2)) && i < largo);
		return resultado;
	}
	
	//Devuelve un arreglo con todos los contratos que contengan una fecha de inicio que coincida con la fecha ingresada
	//PRECONDICIÓN: esVacia() == false 
	public VOContratoFecha[] listarContratacionesPorFecha(LocalDate fecha)
	{
		int i = 0, largo = this.sec.size();
		Contrato contrato;
		LinkedList<Contrato> cont = new LinkedList<Contrato>();
		do
		{
			contrato = this.sec.get(i);
			if(contrato.getFecha().isEqual(fecha))
			{
				cont.add(contrato);
			}
			i++;
		}
		while((contrato.getFecha().isBefore(fecha) || contrato.getFecha().isEqual(fecha)) && i < largo);

		largo = cont.size();
		VOContratoFecha resu[] = new VOContratoFecha[largo];
		i = 0;
		for(Contrato elem: cont)
		{
			VOContratoFecha nuevo = new VOContratoFecha(elem.getNumero(), elem.getHoraInicio(), elem.getFinalizada());
			resu[i] = nuevo;
			i++;
		}
		
		return resu;
	}
	
}
