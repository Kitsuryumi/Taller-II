package Excepciones;

public class ExisteClienteException extends Exception
{
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
