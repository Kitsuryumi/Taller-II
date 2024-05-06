package CapaLogica;
import java.util.TreeMap;
import java.io.Serializable;
import ValueObjects.VOCliente;
import java.util.Iterator;

public class Clientes implements Serializable
{
	private static final long serialVersionUID = 1L;
	private TreeMap<Long, Cliente> diccio;

   
	//Crea un diccionario de Clientes vacío
	public Clientes()
	{
		this.diccio = new TreeMap<Long, Cliente>();
	}
   
	
	//METODOS PRIMITIVOS
	
   //Retorna true si existe un cliente con la clave ingresada en el diccionario.
   public boolean member(long clave)
   {
	   return (this.diccio.containsKey(clave));
   }
   
   //Retorna el cliente del diccionario con la clave ingresada
   //PRECONDICION: El cliente debe existir en el diccionario. (member(clave) == true)
   public Cliente find(long clave)
   {
	   return (this.diccio.get(clave));
   }
   
   //Inserta un nuevo cliente en el diccionario
   //PRECONDICION: El cliente NO debe existir en el diccionario. (member(clave) == false)
   public void insert(Cliente cliente)
   {
	   this.diccio.put(cliente.getCedula(), cliente);
   }
   
   
   //METODO ESPECIFICO
   //Devuelve un arreglo de VOClientes conteniendo la totalidad de clientes cargados en el diccionario.
   public VOCliente[] listarClientes()
   {
      int tam = diccio.size();
      Iterator<Cliente> iter = diccio.values().iterator();
      VOCliente resultado []= new VOCliente[tam];
      int i = 0;
      while(iter.hasNext())
      {
         Cliente cli = iter.next();
         resultado[i] = new VOCliente(cli.getCedula(), cli.getNombre(), cli.getApellido(), cli.getTel());
         i++;
      }
      return resultado;
   }
   
   
   
}
