package Excepciones;

public class PersistenciaException extends Exception
{
	private static final long serialVersionUID = 1L;
	String mensaje;
	
	public PersistenciaException(String msg)
	{
		this.mensaje = msg;
	}
	
	public String getMensaje()
	{
		return mensaje;
	}

}
