package Testing;
import CapaLogica.Servicio;

public class TestingServicio
{

	public static void main(String[] args)
	{
		Servicio ser = new Servicio("258", 12, 25.5, false, true);
		System.out.println("Codigo: " + ser.getCodigo() + "\n" +  "Distancia maxima: " + ser.getDistanciaMax() + "\n" + "Costo hora: " + ser.getCostoHora() + "\n");
		if(ser.getEmbalaje())
		{
			System.out.println("Embalaje incluido\n");
		}
		else
		{
			System.out.println("No incluye embalaje\n");
		}
		if(ser.getArmado())
		{
			System.out.println("Armado incluido");
		}
		else
		{
			System.out.println("No incluye armado");
		}

	}

}
