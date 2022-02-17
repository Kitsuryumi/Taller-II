package Testing;
import CapaLogica.Contrato;
import CapaLogica.Contratos;
import CapaLogica.Cliente;
import CapaLogica.Servicio;
import ValueObjects.VOContratoFecha;
import java.time.LocalDate;
import java.time.LocalTime;


public class TestingContratos
{

	public static void main(String[] args)
	{
		Cliente cliente1 = new Cliente("1","Juan","Perez","1");
		Cliente cliente2 = new Cliente("2","Maria","Paez","2");
		Cliente cliente3 = new Cliente("3","Pedro","Nuniez","3");

		Servicio ser1 = new Servicio("2", 12, 25.5, false, true);
		Servicio ser2 = new Servicio("3", 35, 15.3, true, true);
		Servicio ser3 = new Servicio("1", 12, 27.8, false, false);

		Contrato contrato1 = new Contrato(1, LocalDate.of(2022,2,2), "Calle Mas Larga que la Cuaresma 123", "Calle Pajaritos 420", LocalTime.now(), true, LocalTime.of(2,30,0), 5.0, cliente1, ser1);
		Contrato contrato2 = new Contrato(2, LocalDate.of(2022,2,2), "Calle Napoleon 3", "Calle Mazmorra 724", LocalTime.now(), true, LocalTime.of(2,30,0), 1.0, cliente2, ser2);
		Contrato contrato3 = new Contrato(3, LocalDate.of(2022,2,2), "Calle Chthulu 666", "Calle Apocalipsis 5", LocalTime.now(), true, LocalTime.of(2,30,0), 15.0, cliente3, ser3);

		Contratos contratos = new Contratos();
		
		contratos.insBack(contrato1);
		
		if(contratos.esVacia())
		{
			System.out.println("Vacia");
		}
		else
		{
			System.out.println("NO Vacia");
		}
		
		contratos.insBack(contrato2);
		contratos.insBack(contrato3);
		
		System.out.println(contratos.k_esimo(2).getDomOrigen());
		
		System.out.println(contratos.largo());
		
		System.out.println(contratos.back().getDomOrigen());
		
		System.out.println("\nMonto recaudado: " + contratos.montoRecaudadoPorRangoDeFecha(LocalDate.of(2022, 2, 2), LocalDate.of(2022, 2, 2)));
		
		VOContratoFecha blep [] = contratos.listarContratacionesPorFecha(LocalDate.of(2022, 2, 2));
		for(VOContratoFecha elem: blep)
		{
			System.out.println("Numero: " + elem.getNumero() + "\nHora Inicio: " + elem.getHoraInicio() + "\nFinalizada?: " + elem.getFinalizada() + "\n\n");	
		}
	}

}
