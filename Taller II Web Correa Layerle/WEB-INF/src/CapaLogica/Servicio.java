package CapaLogica;
import java.io.Serializable;

public class Servicio implements Serializable
{
    
	private static final long serialVersionUID = 1L;
	private String codigo;
    private int distanciaMax;
    private double costoHora;
    private boolean embalaje;
    private boolean armado;

	//Crea un nuevo servivio con los datos ingresas    
	public Servicio(String codigo, int distanciaMax, double costoHora, boolean embalaje, boolean armado)
    {
		this.codigo = codigo;
		this.distanciaMax = distanciaMax;
		this.costoHora = costoHora;
		this.embalaje = embalaje;
		this.armado = armado;
	}
	
	
	//FUNCIONES SELECTORAS

	//Devuelve el codigo
	public String getCodigo()
    {
		return codigo;
	}

	//Devuelve la distancia maxima 
	public int getDistanciaMax()
    {
		return distanciaMax;
	}

	//Devuelve el costo por hora
	public double getCostoHora()
    {
		return costoHora;
	}

	//Devuelve si incluye embalaje o no
	public boolean getEmbalaje()
    {
		return embalaje;
	}

	//Devuelve si incluye armado o no
	public boolean getArmado()
    {
		return armado;
	}
    
}
