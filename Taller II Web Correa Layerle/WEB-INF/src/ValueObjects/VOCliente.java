package ValueObjects;

import java.io.Serializable;

public class VOCliente implements Serializable
{
	private static final long serialVersionUID = 1L;
	private long cedula;
    private String nombre;
    private String apellido;
    private String tel;
    
    //Crea un nuevo VOCliente con los datos ingresados.
    public VOCliente(long cedula, String nombre, String apellido, String tel)
    {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tel = tel;
	}

	//GETTERS

	//Retorna la cedula.
	public long getCedula()
    {
		return cedula;
	}

	//Retorna el nombre.
	public String getNombre()
    {
		return nombre;
	}

	//Retorna el apellido.
	public String getApellido()
    {
		return apellido;
	}

	//Retorna el telefono.
	public String getTel()
    {
		return tel;
	}
}
