package ValueObjects;
import java.io.Serializable;

public class VOServicio implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String codigo;
    private int distanciaMax;
    private double costoHora;
    private boolean embalaje;
    private boolean armado;

    //Crea un nuevo VOServicio con los datos ingresados.
	public VOServicio(String codigo, int distanciaMax, double costoHora, boolean embalaje, boolean armado)
    {
		this.codigo = codigo;
		this.distanciaMax = distanciaMax;
		this.costoHora = costoHora;
		this.embalaje = embalaje;
		this.armado = armado;
	}

	//GETTERS

	//Retorna el codigo.
	public String getCodigo()
    {
		return codigo;
	}

	//Retorna la distancia maxima.
	public int getDistanciaMax()
    {
		return distanciaMax;
	}

	//Retorna el costo por hora.
	public double getCostoHora()
    {
		return costoHora;
	}

	//Retorna true si incluye embalaje y false en caso contrario.
	public boolean getEmbalaje()
    {
		return embalaje;
	}

	//Retorna true si incluye armado y false en caso contrario.
	public boolean getArmado()
    {
		return armado;
	}

}
