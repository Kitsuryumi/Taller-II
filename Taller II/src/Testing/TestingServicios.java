package Testing;
import CapaLogica.Servicio;
import CapaLogica.Servicios;
import ValueObjects.VOServicio;

public class TestingServicios
{

	public static void main(String[] args)
	{
		Servicio ser1 = new Servicio("2", 12, 25.5, false, true);
		Servicio ser2 = new Servicio("3", 35, 15.3, true, true);
		Servicio ser3 = new Servicio("1", 12, 27.8, false, false);
		
		Servicios servicios = new Servicios();
		
		servicios.insert(ser2);
		servicios.insert(ser3);
		servicios.insert(ser1);
		
		VOServicio listarServicios[]= servicios.listarServicios();
		
		for( VOServicio elem : listarServicios)
		{
			System.out.println("\n------------------------------------------------\n");
			System.out.println("Codigo: " + elem.getCodigo() + "\n");
			System.out.println("Distancia maxima: " + elem.getDistanciaMax() + "\n");
			System.out.println("Costo hora: " + elem.getCostoHora() + "\n");
			if(elem.getArmado())
			{
				System.out.println("Armado: true\n");
			}
			else
			{
				System.out.println("Armado: false\n");
			}
			if(elem.getEmbalaje())
			{
				System.out.println("Embalaje: true\n");
			}
			else
			{
				System.out.println("Embalaje: false\n");
			}
			System.out.println("\n------------------------------------------------\n");
		}
		if(servicios.member("5"))
		{
			System.out.println("Pertenece: true\n");
		}
		else
		{
			System.out.println("Pertenece: false\n");
		}
		
		System.out.println(servicios.find("3").getCostoHora());

	}

}
