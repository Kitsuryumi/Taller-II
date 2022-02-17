package ValueObjects;

public class VOServicio 
{
    private String codigo;
    private int distanciaMax;
    private double costoHora;
    private boolean embalaje;
    private boolean armado;
        
        
	public VOServicio(String codigo, int distanciaMax, double costoHora, boolean embalaje, boolean armado)
    {
		this.codigo = codigo;
		this.distanciaMax = distanciaMax;
		this.costoHora = costoHora;
		this.embalaje = embalaje;
		this.armado = armado;
	}

	public String getCodigo()
    {
		return codigo;
	}

	public int getDistanciaMax()
    {
		return distanciaMax;
	}

	public double getCostoHora()
    {
		return costoHora;
	}

	public boolean getEmbalaje()
    {
		return embalaje;
	}

	public boolean getArmado()
    {
		return armado;
	}

}
