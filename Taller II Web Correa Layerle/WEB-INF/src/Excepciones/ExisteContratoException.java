package Excepciones;

public class ExisteContratoException extends Exception
{
	
	private static final long serialVersionUID = 1L;
	private String mensaje;


    public ExisteContratoException(String msg)
    {
        this.mensaje = msg;
    }


    public String getMensaje()
    {
        return this.mensaje;
    }
}
