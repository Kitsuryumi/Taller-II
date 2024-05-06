package ValueObjects;

import java.io.Serializable;

public class VOFinalizarMudanza implements Serializable
{
	private static final long serialVersionUID = 1L;
    private int numero, horas, minutos;
    

	//Crea un nuevo VOFinalizaMudanza con los datos ingresados.
	public VOFinalizarMudanza(int numero, int horas, int minutos)
	{
		this.numero = numero;
		this.horas = horas;
		this.minutos = minutos;
	}

	//GETTERS

	//Retorna el numero.
	public int getNumero() 
	{
		return this.numero;
	}

	//Retrona un entero que representa las horas.
	public int getHoras()
	{
		return this.horas;
	} 
	
	//Retorna un entero que representa los minutos.
	public int getMinutos()
	{
		return this.minutos;
	}
	
    
    
}
