package Excepciones;

public class HoraValidaException extends Exception
{

	private static final long serialVersionUID = 1L;
	private String mensaje;


    public HoraValidaException(String msg)
    {
        this.mensaje = msg;
    }


    public String getMensaje()
    {
        return (this.mensaje);
    }

}
