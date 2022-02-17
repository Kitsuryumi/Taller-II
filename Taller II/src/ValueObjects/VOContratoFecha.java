package ValueObjects;
import java.time.*;

public class VOContratoFecha
{
	private int numero;
	private LocalTime horaInicio;
	private boolean finalizada;
	
	
	public VOContratoFecha(int numero, LocalTime horaInicio, boolean finalizada)
	{
		this.numero = numero;
		this.horaInicio = horaInicio;
		this.finalizada = finalizada;
	}


	public int getNumero()
	{
		return numero;
	}


	public LocalTime getHoraInicio() 
	{
		return horaInicio;
	}


	public boolean getFinalizada() 
	{
		return finalizada;
	}
	
	
	
	
}
