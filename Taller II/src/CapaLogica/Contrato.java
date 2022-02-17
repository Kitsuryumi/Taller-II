package CapaLogica;
import java.time.*;
import CapaLogica.Cliente;
import CapaLogica.Servicio;

public class Contrato
{
    private int numero;
    private LocalDate fecha;
    private String domOrigen;
    private String domDestino;
    private LocalTime horaInicio;
    private boolean finalizada;
    private LocalTime duracion;
    private double costoFinal;
    private Cliente cliente;
    private Servicio servicio;
    
    
	public Contrato(int numero, LocalDate fecha, String domOrigen, String domDestino, LocalTime horaInicio,
			boolean finalizada, LocalTime duracion, double costoFinal, Cliente cliente, Servicio servicio)
    {
		this.numero = numero;
		this.fecha = fecha;
		this.domOrigen = domOrigen;
		this.domDestino = domDestino;
		this.horaInicio = horaInicio;
		this.finalizada = finalizada;
		this.duracion = duracion;
		this.costoFinal = costoFinal;
		this.cliente = cliente;
		this.servicio = servicio;
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


	public double getCostoFinal()
    {
		return costoFinal;
	}


	public Cliente getCliente()
    {
		return cliente;
	}


	public Servicio getServicio()
    {
		return servicio;
	}
    
    
	public void setFinalizada(boolean finalizada)
	{
		this.finalizada = finalizada;
	}


	public void setDuracion(LocalTime duracion)
	{
		this.duracion = duracion;
	}


	public void setCostoFinal(float costoFinal)
	{
		this.costoFinal = costoFinal;
	}	
    
}
