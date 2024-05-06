package ValueObjects;
import java.io.Serializable;
import java.time.*;

public class VOListarContratacion implements Serializable
{
	private static final long serialVersionUID = 1L;
    private int numero;
    private LocalDate fecha;
    private String domOrigen;
    private String domDestino;
    private LocalTime horaInicio;
    private boolean finalizada;
    private int duracionHoras;
    private int duracionMinutos;
    private double costoFinal;
    private long cedula;
    private String nombre;
    private String apellido;
    private String tel;
    private String codigo;
    
    //Crea un nuevo VOlistarcontratacion con los datos ingresados.
	public VOListarContratacion(int numero, LocalDate fecha, String domOrigen, String domDestino, LocalTime horaInicio,
			boolean finalizada, int duracionHoras, int duracionMinutos, double costoFinal, long cedula, String nombre, String apellido,
			String tel, String codigo)
	{
		this.numero = numero;
		this.fecha = fecha;
		this.domOrigen = domOrigen;
		this.domDestino = domDestino;
		this.horaInicio = horaInicio;
		this.finalizada = finalizada;
		this.duracionHoras = duracionHoras;
		this.duracionMinutos = duracionMinutos;
		this.costoFinal = costoFinal;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tel = tel;
		this.codigo = codigo;
	}

	//GETTERS

	//Retorna el numero.
	public int getNumero()
	{
		return this.numero;
	}

	//Retrona la fecha
	public LocalDate getFecha() 
	{
		return this.fecha;
	}

	//Retorna el domicilio de origen.
	public String getDomOrigen() 
	{
		return this.domOrigen;
	}

	//Retorna el domicilio de destino.
	public String getDomDestino() 
	{
		return this.domDestino;
	}

	//Retorna la hora de inicio.
	public LocalTime getHoraInicio() 
	{
		return this.horaInicio;
	}

	//Retorna true si esta finalizada o false en caso contrario.
	public boolean getFinalizada()
	{
		return this.finalizada;
	}

	//Retorna un entero que representa las horas.
	public int getDuracionHoras()
	{
		return this.duracionHoras;
	}

	//Retorna un entero que representa los minutos.
	public int getDuracionMinutos()
	{
		return this.duracionMinutos;
	}

	//Retorna el costo final.
	public double getCostoFinal() 
	{
		return this.costoFinal;
	}

	//Retorna la cedula del cliente.
	public long getCedula() 
	{
		return this.cedula;
	}

	//Retrona el nombre del cliente.
	public String getNombre() 
	{
		return this.nombre;
	}

	//Retorna el apelido del cliente.
	public String getApellido() 
	{
		return this.apellido;
	}

	//Retorna el telefono del cliente.
	public String getTel() 
	{
		return this.tel;
	}

	//Retorna le codigo el servicio.
	public String getCodigo()
	{
		return this.codigo;
	}
	

}
