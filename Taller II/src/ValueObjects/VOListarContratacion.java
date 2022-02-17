package ValueObjects;
import java.time.*;

public class VOListarContratacion
{
    private int numero;
    private LocalDate fecha;
    private String domOrigen;
    private String domDestino;
    private LocalTime horaInicio;
    private boolean finalizada;
    private LocalTime duracion;
    private float costoFinal;
    private String cedula;
    private String nombre;
    private String apellido;
    private String tel;
    private String codigo;
    
    
	public VOListarContratacion(int numero, LocalDate fecha, String domOrigen, String domDestino, LocalTime horaInicio,
			boolean finalizada, LocalTime duracion, float costoFinal, String cedula, String nombre, String apellido,
			String tel, String codigo)
	{
		this.numero = numero;
		this.fecha = fecha;
		this.domOrigen = domOrigen;
		this.domDestino = domDestino;
		this.horaInicio = horaInicio;
		this.finalizada = finalizada;
		this.duracion = duracion;
		this.costoFinal = costoFinal;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tel = tel;
		this.codigo = codigo;
	}


	public int getNumero()
	{
		return numero;
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


	public boolean getFinalizada()
	{
		return finalizada;
	}


	public LocalTime getDuracion()
	{
		return duracion;
	}


	public float getCostoFinal() 
	{
		return costoFinal;
	}


	public String getCedula() 
	{
		return cedula;
	}


	public String getNombre() 
	{
		return nombre;
	}


	public String getApellido() 
	{
		return apellido;
	}


	public String getTel() 
	{
		return tel;
	}


	public String getCodigo()
	{
		return codigo;
	}
	

}
