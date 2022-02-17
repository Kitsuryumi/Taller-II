package Testing;
import CapaLogica.Cliente;

public class TestingCliente
{

	public static void main(String[] args)
	{
		Cliente prueba = new Cliente("123", "Juan", "Gomez", "123456789");
		System.out.println(prueba.getCedula() + "\n" + prueba.getNombre() + "\n" + prueba.getApellido() + "\n" + prueba.getTel());
	}

}
