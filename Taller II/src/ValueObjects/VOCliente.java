package ValueObjects;

public class VOCliente 
{
	private String cedula;
    private String nombre;
    private String apellido;
    private String tel;
    
    
    public VOCliente(String cedula, String nombre, String apellido, String tel)
    {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tel = tel;
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
}
