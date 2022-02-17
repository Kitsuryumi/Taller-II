package CapaLogica;
import java.util.TreeMap;
import CapaLogica.Servicio;
import ValueObjects.VOServicio;
import java.util.Iterator;

public class Servicios
{
	private TreeMap<String, Servicio> diccio;

	   
	public Servicios()
	{
		this.diccio = new TreeMap<String, Servicio>();
	}
   
	
   public boolean member(String clave)
   {
	   return (this.diccio.containsKey(clave));
   }
   
   
   public Servicio find(String clave)
   {
	   return (this.diccio.get(clave));
   }
   
   
   public void insert(Servicio servicio)
   {
	   this.diccio.put(servicio.getCodigo(), servicio);
   }
   

   public VOServicio[] listarServicios()
   {
      int tam = diccio.size();
      Iterator<Servicio> iter = diccio.values().iterator();
      VOServicio resultado []= new VOServicio[tam];
      int i = 0;
      while(iter.hasNext())
      {
         Servicio ser = iter.next();
         resultado[i] = new VOServicio(ser.getCodigo(), ser.getDistanciaMax(), ser.getCostoHora(), ser.getEmbalaje(), ser.getArmado());
         i++;
      }
      return resultado;
   }
   

}
