package Excepciones;

public class ExisteClienteException extends Exception
{
	
	private static final long serialVersionUID = 1L;
	private String mensaje;


    public ExisteClienteException(String msg)
    {
        this.mensaje = msg;
    }


    public String getMensaje()
    {
        return this.mensaje;
    }

    
}
