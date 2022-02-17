package Testing;
import java.time.LocalDate;
import java.time.LocalTime;
import CapaLogica.Cliente;
import CapaLogica.Contrato;
import CapaLogica.Servicio;

public class TestingContrato
{

	public static void main(String[] args)
	{
		LocalDate fecha = LocalDate.of(2000, 1, 1);
		LocalTime horaInicio = LocalTime.of(1,30, 0);
		LocalTime duracion = LocalTime.of(4, 20, 0);
		Cliente cliente = new Cliente("123", "Juan", "Gomez", "123456789");
		Servicio ser = new Servicio("258", 12, 25.5, false, true);
		Contrato contrato = new Contrato(1, fecha, "Calle Cuaresma 123", "Calle Pajaritos 420", horaInicio, true, duracion, 666.666, cliente, ser);
		System.out.println(contrato.getNumero() + "\n");
		System.out.println(contrato.getFecha() + "\n");
		System.out.println(contrato.getDomOrigen() + "\n");
		System.out.println(contrato.getDomDestino() + "\n");
		System.out.println(contrato.getHoraInicio() + "\n");
		if(contrato.getFinalizada())
		{
			System.out.println("Finalizado" + "\n");
		}
		else
		{
			System.out.println("No finalizado" + "\n");
		}
		System.out.println(contrato.getDuracion() + "\n");
		System.out.println(contrato.getCostoFinal() + "\n");
		System.out.println(contrato.getCliente().getCedula() + "\n" + contrato.getCliente().getNombre() + "\n" + contrato.getCliente().getApellido() + "\n" + contrato.getCliente().getTel());
		System.out.println("Codigo: " + contrato.getServicio().getCodigo() + "\n" +  "Distancia maxima: " + contrato.getServicio().getDistanciaMax() + "\n" + "Costo hora: " + contrato.getServicio().getCostoHora() + "\n");
	}

}
