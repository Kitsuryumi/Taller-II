package ValueObjects;
import java.io.Serializable;
import java.time.*;

public class VOContrato implements Serializable
{
	private static final long serialVersionUID = 1L;
    private LocalDate fecha;
    private String domOrigen;
    private String domDestino;
    private LocalTime horaInicio;   
    
	//Crea un nuevo VOContrato con los datos ingresados.
	public VOContrato(LocalDate fecha, String domOrigen, String domDestino, LocalTime horaInicio)
    {
		this.fecha = fecha;
		this.domOrigen = domOrigen;
		this.domDestino = domDestino;
		this.horaInicio = horaInicio;
	}

	//GETTERS

	//Retorna la fecha.
	public LocalDate getFecha()
    {
		return fecha;
	}

	//Retorna el domicilio de origen.
	public String getDomOrigen()
    {
		return domOrigen;
	}

	//Retorna el domicilio de destino.
	public String getDomDestino()
    {
		return domDestino;
	}

	//Retorna la hora de inicio.
	public LocalTime getHoraInicio()
    {
		return horaInicio;
	}


}
