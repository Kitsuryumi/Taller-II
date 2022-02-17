package ValueObjects;
import java.time.*;

public class VOFinalizarMudanza
{
    private int numero;
    private LocalTime hora;
    
	public VOFinalizarMudanza(int numero, LocalTime hora)
	{
		this.numero = numero;
		this.hora = hora;
	}

	public int getNumero() 
	{
		return numero;
	}

	public LocalTime getHora()
	{
		return hora;
	} 
	
    
    
}
