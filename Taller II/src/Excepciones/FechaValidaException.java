package Excepciones;

public class FechaValidaException extends Exception
{
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
