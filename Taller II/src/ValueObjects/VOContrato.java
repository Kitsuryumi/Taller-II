package ValueObjects;
import java.time.*;

public class VOContrato 
{
    private LocalDate fecha;
    private String domOrigen;
    private String domDestino;
    private LocalTime horaInicio;   
    

	public VOContrato(LocalDate fecha, String domOrigen, String domDestino, LocalTime horaInicio)
    {
		this.fecha = fecha;
		this.domOrigen = domOrigen;
		this.domDestino = domDestino;
		this.horaInicio = horaInicio;
	}


	public LocalDate getFecha()
    {
		return fecha;
	}


	public String getDomOrigen()
    {
		return domOrigen;
	}


	public String getDomDestino()
    {
		return domDestino;
	}


	public LocalTime getHoraInicio()
    {
		return horaInicio;
	}


}
