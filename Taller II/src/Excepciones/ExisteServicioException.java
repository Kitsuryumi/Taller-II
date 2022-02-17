package Excepciones;

public class ExisteServicioException extends Exception
{
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
