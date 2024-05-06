package CapaLogica;

public class MonitorEscrituraLectura
{
	private int cantLectores;
	private boolean escribiendo;
	
	//Crea un monitor para concurrencia
	public MonitorEscrituraLectura()
	{
		this.cantLectores = 0;
		this.escribiendo = false;
	}
	
	//Avisa al monitor que hay un metodo leyendo.
	public synchronized void comienzoLectura()
	{
		while(escribiendo)
		{
			try
            {
				this.wait();
			}
			catch (InterruptedException e)
            {
				
			}
		}
		this.cantLectores++;
	}
	
	//Avisa al monitor que el metodo salio de lectura
	public synchronized void terminoLectura()
	{
		this.cantLectores--;
		this.notify();
	}
	
	//Avisa al monitor que hay un escribiendo.
	public synchronized void comienzoEscritura()
	{
		while(cantLectores > 0 || escribiendo == true)
		{
			try
            {
				this.wait();
			}
			catch (InterruptedException e)
            {
				
			}
		}
		this.escribiendo = true;
	}
	
	//Avisa al monitor que el metodo termino escritura.
	public synchronized void terminoEscritura()
	{
		this.escribiendo = false;
		this.notifyAll();
	}
	
}
