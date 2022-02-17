package CapaLogica;
import CapaLogica.Contrato;
import java.util.LinkedList;
import ValueObjects.VOContratoFecha;
import java.time.LocalDate;

public class Contratos
{
	private LinkedList<Contrato> sec;

	
	public Contratos()
	{
		this.sec = new LinkedList<Contrato>();
	}
	
	
	public Contrato k_esimo(int posicion)
	{
		return (this.sec.get(posicion));
	}
	
	
	public boolean esVacia()
	{
		return (this.sec.size() == 0);
	}
	
	
	public int largo()
	{
		return (this.sec.size());
	}
	
	
	public void insBack(Contrato contrato)
	{
		this.sec.add(contrato);
	}
	
	
	public Contrato back()
	{
		return (this.sec.getLast());
	}
	
	
	public double montoRecaudadoPorRangoDeFecha(LocalDate fecha1, LocalDate fecha2)
	{
		double resultado = 0;
		int i = 0, largo = this.sec.size();
		Contrato contrato;
		do
		{
			contrato = this.sec.get(i);
			if((contrato.getFecha().isAfter(fecha1) || contrato.getFecha().isEqual(fecha1)) && (contrato.getFecha().isBefore(fecha2) || contrato.getFecha().isEqual(fecha2)))
			{
				resultado = resultado + contrato.getCostoFinal();
			}
			i++;
		}
		while((contrato.getFecha().isBefore(fecha2) || contrato.getFecha().isEqual(fecha2)) && i < largo);
		return resultado;
	}
	
	
	public VOContratoFecha[] listarContratacionesPorFecha(LocalDate fecha)
	{
		int i = 0, largo = this.sec.size();
		Contrato contrato;
		LinkedList<Contrato> cont = new LinkedList<Contrato>();
		do
		{
			contrato = this.sec.get(i);
			if(contrato.getFecha().isEqual(fecha))
			{
				cont.add(contrato);
			}
			i++;
		}
		while((contrato.getFecha().isBefore(fecha) || contrato.getFecha().isEqual(fecha)) && i < largo);

		largo = cont.size();
		VOContratoFecha resu[] = new VOContratoFecha[largo];
		i = 0;
		for(Contrato elem: cont)
		{
			VOContratoFecha nuevo = new VOContratoFecha(elem.getNumero(), elem.getHoraInicio(), elem.getFinalizada());
			resu[i] = nuevo;
			i++;
		}
		
		return resu;
	}
	
	
}
