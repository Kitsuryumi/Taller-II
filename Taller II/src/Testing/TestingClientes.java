package Testing;
import CapaLogica.Cliente;
import CapaLogica.Clientes;
import ValueObjects.VOCliente;

public class TestingClientes
{

	public static void main(String[] args)
	{
		
		Cliente cliente1 = new Cliente("1","Juan","Perez","1");
		Cliente cliente2 = new Cliente("2","Maria","Paez","2");
		Cliente cliente3 = new Cliente("3","Pedro","Nuniez","3");
		
		Clientes clientes = new Clientes();
		clientes.insert(cliente3);
		clientes.insert(cliente1);
		clientes.insert(cliente2);
		
		VOCliente listarclientes[] = clientes.listarClientes();
		
		for(VOCliente elem: listarclientes)
		{
			System.out.println("--------------------------\n" + "CEDULA: " + elem.getCedula() + "\n" + "NOMBRE: " + elem.getNombre() + "\n" + "APELLIDO: " + elem.getApellido() + "\n" + "TELEFONO: " + elem.getTel() + "\n--------------------------\n");
		}
		
		if(clientes.member("4"))
		{
			System.out.println("Es miembro\n");
		}
		else
		{
			System.out.println("No es miembro\n");
		}
		
		System.out.println(clientes.find("1").getApellido());

	}

}
