package CapaLogica;
import java.util.TreeMap;
import CapaLogica.Cliente;
import ValueObjects.VOCliente;
import java.util.Iterator;

public class Clientes
{
   private TreeMap<String, Cliente> diccio;

   
	public Clientes()
	{
		this.diccio = new TreeMap<String, Cliente>();
	}
   
	
   public boolean member(String clave)
   {
	   return (this.diccio.containsKey(clave));
   }
   
   
   public Cliente find(String clave)
   {
	   return (this.diccio.get(clave));
   }
   
   
   public void insert(Cliente cliente)
   {
	   this.diccio.put(cliente.getCedula(), cliente);
   }
   

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
