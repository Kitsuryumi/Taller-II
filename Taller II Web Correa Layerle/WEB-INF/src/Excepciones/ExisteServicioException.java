package Excepciones;

public class ExisteServicioException extends Exception
{
	
	private static final long serialVersionUID = 1L;
	private String mensaje;


    public ExisteServicioException(String msg)
    {
        this.mensaje = msg;
    }


    public String getMensaje()
    {
        return this.mensaje;
    }

    
}
