package ValueObjects;
import java.io.Serializable;
import java.time.*;

public class VOContratoFecha implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int numero;
	private LocalTime horaInicio;
	private boolean finalizada;
	
	//Crea un nuevo VOContratoFecha con los datos ingresados.
	public VOContratoFecha(int numero, LocalTime horaInicio, boolean finalizada)
	{
		this.numero = numero;
		this.horaInicio = horaInicio;
		this.finalizada = finalizada;
	}

	//GETTERS

	//Retorna el numero
	public int getNumero()
	{
		return numero;
	}

	//Retorna la hora de inicio.
	public LocalTime getHoraInicio() 
	{
		return horaInicio;
	}

	//Retorna true si esta finalizada o false en caso contrario.
	public boolean getFinalizada() 
	{
		return finalizada;
	}
	
	
	
	
}
