package CapaLogica;
import java.io.Serializable;
import java.time.*;

public class Contrato implements Serializable
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
    private Cliente cliente;
    private Servicio servicio;
    
	//Crea un nuevo contrato con los datos ingresados.
    //El atributo finalizada se inicializa en false, los atributos duracionHoras, duracionMinuntos y costoFinal, en 0
	public Contrato(int numero, LocalDate fecha, String domOrigen, String domDestino, LocalTime horaInicio, Cliente cliente, Servicio servicio)
    {
		this.numero = numero;
		this.fecha = fecha;
		this.domOrigen = domOrigen;
		this.domDestino = domDestino;
		this.horaInicio = horaInicio;
		this.finalizada = false;
		this.duracionHoras = 0;
		this.duracionMinutos = 0;
		this.costoFinal = 0.0;
		this.cliente = cliente;
		this.servicio = servicio;
	}
	
	
	//FUNCIONES SELECTORAS
	
	//Retorna el numero de contrato
	public int getNumero()
    {
		return numero;
	}

	//Retorna la fecha
	public LocalDate getFecha()
    {
		return fecha;
	}

	//Retorna el domicilio origen
	public String getDomOrigen()
    {
		return domOrigen;
	}

	//Retorna el domicilio destino
	public String getDomDestino()
    {
		return domDestino;
	}
	
	//Retorna la hora de inicio
	public LocalTime getHoraInicio()
    {
		return horaInicio;
	}

	//Retorna true si el contrato esta finalizado
	public boolean getFinalizada()
    {
		return finalizada;
	}

	//Retorna las horas de la duración
	public int getDuracionHoras()
    {
		return duracionHoras;
	}

	//Retorna los minutos de la duración
	public int getDuracionMinutos()
	{
		return duracionMinutos;
	}

	//Retorna el costo final
	public double getCostoFinal()
    {
		return costoFinal;
	}

	//Retorna el cliente que realizó la contratación
	public Cliente getCliente()
    {
		return cliente;
	}

	//Retorna el servicio contratado
	public Servicio getServicio()
    {
		return servicio;
	}
    
	
	//SETTERS
	
	//Setea en true el atributo finalizada
	public void setFinalizada()
	{
		this.finalizada = true;
	}

	//Setea las horas y minutos de duración
	public void setDuracion(int horas, int minutos)
	{
		this.duracionHoras = horas;
		this.duracionMinutos = minutos;
	}

	//Calcula y setea el costo final del contrato
	public void setCostoFinal()
	{
		this.costoFinal = ((this.servicio.getCostoHora() * this.duracionHoras) + (this.servicio.getCostoHora() * (this.duracionMinutos / 60.0)));
	}	
    
}
