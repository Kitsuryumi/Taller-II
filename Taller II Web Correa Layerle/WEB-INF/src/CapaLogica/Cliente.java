package CapaLogica;
import java.io.Serializable;

public class Cliente implements Serializable
{
	private static final long serialVersionUID = 1L;
	private long cedula;
    private String nombre;
    private String apellido;
    private String tel;
    
    
    //Crea un nuevo cliente con los datos ingresados
	public Cliente(long cedula, String nombre, String apellido, String tel)
    {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tel = tel;
	}

	
	//FUNCIONES SELECTORAS
	
	//Retorna la cédula
	public long getCedula()
    {
		return cedula;
	}
	
	//Retorna el nombre
	public String getNombre()
    {
		return nombre;
	}
	
	//Retorna el apellido
	public String getApellido()
    {
		return apellido;
	}

	//Retorna el teléfono
	public String getTel()
    {
		return tel;
	}
	
}
