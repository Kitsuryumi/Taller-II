package Excepciones;

public class FechaValidaException extends Exception
{

	private static final long serialVersionUID = 1L;
	private String mensaje;


    public FechaValidaException(String msg)
    {
        this.mensaje = msg;
    }


    public String getMensaje()
    {
        return (this.mensaje);
    }

}
