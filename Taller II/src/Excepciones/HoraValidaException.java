package Excepciones;

public class HoraValidaException extends Exception
{
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
