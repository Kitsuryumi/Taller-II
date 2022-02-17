package CapaLogica;
import CapaLogica.Servicios;
import CapaLogica.Clientes;
import CapaLogica.Contratos;
import CapaLogica.Servicio;
import CapaLogica.Cliente;
import CapaLogica.Contrato;
import ValueObjects.VOServicio;
import ValueObjects.VOCliente;
import ValueObjects.VOContrato;
import ValueObjects.VOContratoFecha;
import ValueObjects.VOFinalizarMudanza;
import ValueObjects.VOListarContratacion;
import Excepciones.ExisteServicioException;
import Excepciones.ExisteClienteException;
import Excepciones.FechaValidaException;
import Excepciones.HoraValidaException;

public class Fachada
{
	private Servicios diccioServicios;
	private Clientes diccioClientes;    
    private Contratos secContratos;
	
    
    public Fachada()
    {
		this.diccioServicios = new Servicios();
		this.diccioClientes = new Clientes();
		this.secContratos = new Contratos();
	}
    
    
    public void altaServicio(VOServicio voServicio) throws ExisteServicioException
    {
        if(this.diccioServicios.member(voServicio.getCodigo()))
        {
        	throw new ExisteServicioException("Error: El servicio ya existe en el sistema.");
        }
        else
        {
            Servicio nuevo = new Servicio(voServicio.getCodigo(), voServicio.getDistanciaMax(), voServicio.getCostoHora(), voServicio.getEmbalaje(), voServicio.getArmado());
        	this.diccioServicios.insert(nuevo);
        }
    }
    

    public void altaCliente(VOCliente voCliente) throws ExisteClienteException
    {
    	if(this.diccioClientes.member(voCliente.getCedula()))
    	{
    		throw new ExisteClienteException("Error: El cliente ye exise en el sistema.");
    	}
    	else
    	{
    		Cliente nuevo = new Cliente(voCliente.getCedula(), voCliente.getNombre(), voCliente.getApellido(), voCliente.getTel());
    		this.diccioClientes.insert(nuevo);
    	}
    }
    

    public VOCliente[] listarClientes()
    {
    	return (this.diccioClientes.listarClientes());
    }
   
    
    public void contratacionDeServicio(String codigo, String cedula, VOContrato voContrato) throws ExisteServicioException, ExisteClienteException, FechaValidaException, HoraValidaException
    {
    	if(!(this.diccioServicios.member(codigo)))
        {
            throw new ExisteServicioException("Error: El servicio no existe en el sistema.");
        }
    	else
    	{
    		if(!(this.diccioClientes.member(cedula)))
    		{
    			throw new ExisteClienteException("Error: El cliente no existe en el sistema.");
    		}
    		else
    		{
				if(this.secContratos.esVacia())
				{
					Cliente cliente = this.diccioClientes.find(cedula);
					Servicio servicio = this.diccioServicios.find(codigo);
					Contrato nuevo = new Contrato(1, voContrato.getFecha(), voContrato.getDomOrigen(), voContrato.getDomDestino(), voContrato.getHoraInicio(), false, null, 0.0, cliente, servicio);
					this.secContratos.insBack(nuevo);
				}
				else
				{
					Contrato cont = this.secContratos.back();
					if(voContrato.getFecha().isBefore(cont.getFecha()))
					{
						throw new FechaValidaException("Error: La fecha del contrato a registrar debe ser igual o posterior al ultimo contrato registrado ");
					}
					else
					{
						if(voContrato.getFecha().isEqual(cont.getFecha()))
						{
							if(cont.getHoraInicio().plusHours(2).compareTo(voContrato.getHoraInicio()) < 0)
							{
								throw new HoraValidaException("Error: La hora de inicio del contrato a registrar debe ser dos horas posterior al ultimo contrato registrado");
							} 
							else
							{
								Cliente cliente = this.diccioClientes.find(cedula);
								Servicio servicio = this.diccioServicios.find(codigo);
								Contrato nuevo = new Contrato((cont.getNumero()+1), voContrato.getFecha(), voContrato.getDomOrigen(), voContrato.getDomDestino(), voContrato.getHoraInicio(), false, null, 0.0, cliente, servicio);
								this.secContratos.insBack(nuevo);
							}
						}
						else
						{
							Cliente cliente = this.diccioClientes.find(cedula);
							Servicio servicio = this.diccioServicios.find(codigo);
							Contrato nuevo = new Contrato((cont.getNumero()+1), voContrato.getFecha(), voContrato.getDomOrigen(), voContrato.getDomDestino(), voContrato.getHoraInicio(), false, null, 0.0, cliente, servicio);
							this.secContratos.insBack(nuevo);
						}
					}
				}
    		}
    	}
    }

}
