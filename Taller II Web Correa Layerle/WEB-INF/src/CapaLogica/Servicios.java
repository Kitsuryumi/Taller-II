package CapaLogica;
import java.util.TreeMap;
import ValueObjects.VOServicio;

import java.io.Serializable;
import java.util.Iterator;

public class Servicios implements Serializable
{
	private static final long serialVersionUID = 1L;
	private TreeMap<String, Servicio> diccio;

	//Crea un diccionario de servicios vacio.
	public Servicios()
	{
		this.diccio = new TreeMap<String, Servicio>();
	}
   
	//METODOS PRIMITIVOS

   //Retorna true si existe el servicio con la clave pasada por parametro.
   public boolean member(String clave)
   {
	   return (this.diccio.containsKey(clave));
   }
   
   //Devuelve un servicio con la clave pasada por parametro
   //Precondicion: servicio existe en el diccionario(member() = true).
   public Servicio find(String clave)
   {
	   return (this.diccio.get(clave));
   }
   
   //Agrega un servicio al diccionario
   //Precondicion: servicio no existe en el diccionario(member() = false).
   public void insert(Servicio servicio)
   {
	   this.diccio.put(servicio.getCodigo(), servicio);
   }
   
   //METODO ESPECIFICO

   //Devuelve un arreglo de VOservicio cargado con todos los servicios del diccionario.
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
