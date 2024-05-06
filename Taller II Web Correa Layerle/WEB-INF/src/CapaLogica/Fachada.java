package CapaLogica;
import java.io.IOException;
import java.time.*;

import CapaPersistencia.Contenedor;
import CapaPersistencia.Persistencia;
import ValueObjects.VOServicio;
import ValueObjects.VOCliente;
import ValueObjects.VOContrato;
import ValueObjects.VOFinalizarMudanza;
import ValueObjects.VOListarContratacion;
import ValueObjects.VOContratoFecha;
import Excepciones.ExisteServicioException;
import Excepciones.ExisteClienteException;
import Excepciones.FechaValidaException;
import Excepciones.HoraValidaException;
import Excepciones.PersistenciaException;
import Excepciones.ExisteContratoException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Fachada extends UnicastRemoteObject implements IFachada
{
	
	private static final long serialVersionUID = 1L;
	private static Fachada instancia;
	private Servicios diccioServicios;
	private Clientes diccioClientes;    
    private Contratos secContratos;
	private MonitorEscrituraLectura monitor;
	
	
	//Constructor de Fachada, se ejecutará en caso de que no existan instancias de fachada.
    private Fachada()throws RemoteException
    {
		this.diccioServicios = new Servicios();
		this.diccioClientes = new Clientes();
		this.secContratos = new Contratos();
		this.monitor = new MonitorEscrituraLectura();
	}
 
    //Método interno de procedimientos de escritura.
	//Respalda la imformacion luego de un metodo de escritura.
	//en caso de que ocurra un error en el respaldo, arroja PersistenciaException.
    private void respaldoAutomatico() throws RemoteException, PersistenciaException 
    {
    	Persistencia.respaldar("datos.dat", this.diccioClientes, this.diccioServicios, this.secContratos);
	}
    
    //Genera una instancia de Fachada, si esta ya existe la retorna.
    public static Fachada getInstancia() throws RemoteException
    {
    	if(instancia == null)
    	{
    		instancia = new Fachada();
    	}
    	return instancia;
    }
    
    
	//Metodo escritor
	//Si se ingresa un servicio ya registrado en el sistema, tira ExisteServicioException
	//En caso de que haya algun problema al respaldar, puede tirar PersistenciaException y/o RemoteException
    public void altaServicio(VOServicio voServicio) throws RemoteException, ExisteServicioException, PersistenciaException 
    {
    	this.monitor.comienzoEscritura();
        if(this.diccioServicios.member(voServicio.getCodigo()))
        {
        	this.monitor.terminoEscritura();
        	throw new ExisteServicioException("Error: El servicio ya existe en el sistema.");
        }
        else
        {
            Servicio nuevo = new Servicio(voServicio.getCodigo(), voServicio.getDistanciaMax(), voServicio.getCostoHora(), voServicio.getEmbalaje(), voServicio.getArmado());
        	this.diccioServicios.insert(nuevo);
			this.respaldoAutomatico();
        	this.monitor.terminoEscritura();
        }
    }
    
	//Metodo escritor
	//Si se ingresa un cliente ya registrado en el sistema, tira ExisteClienteException
	//En caso de que haya algun problema al respaldar, puede tirar PersistenciaException y/o RemoteException
    public void altaCliente(VOCliente voCliente) throws RemoteException, ExisteClienteException, PersistenciaException
    {
    	this.monitor.comienzoEscritura();
    	if(this.diccioClientes.member(voCliente.getCedula()))
    	{
    		this.monitor.terminoEscritura();
    		throw new ExisteClienteException("Error: El cliente ya existe en el sistema.");
    	}
    	else
    	{
    		Cliente nuevo = new Cliente(voCliente.getCedula(), voCliente.getNombre(), voCliente.getApellido(), voCliente.getTel());
    		this.diccioClientes.insert(nuevo);
     		this.respaldoAutomatico();
    		this.monitor.terminoEscritura();
    	}
    }
    
	//Metodo lector.
	//Devuelve un arreglo de VOClientes conteniendo la totalidad de clientes cargados en el diccionario.
    public VOCliente[] listarClientes() throws RemoteException
    {
		this.monitor.comienzoLectura();
		VOCliente listado[] = this.diccioClientes.listarClientes();
		this.monitor.terminoLectura();
    	return listado;
    }
   
	//Metodo escritor.
	//Registra un nuevo contrato.   
    public void contratacionDeServicio(String codigo, long cedula, VOContrato voContrato) throws RemoteException, ExisteServicioException, ExisteClienteException, FechaValidaException, HoraValidaException, PersistenciaException
    {
    	this.monitor.comienzoEscritura();
    	if(!(this.diccioServicios.member(codigo)))
        {
    		this.monitor.terminoEscritura();
            throw new ExisteServicioException("Error: El servicio no existe en el sistema.");
        }
    	else
    	{
    		if(!(this.diccioClientes.member(cedula)))
    		{
    			this.monitor.terminoEscritura();
    			throw new ExisteClienteException("Error: El cliente no existe en el sistema.");
    		}
    		else
    		{
				if(this.secContratos.esVacia())
				{
					Cliente cliente = this.diccioClientes.find(cedula);
					Servicio servicio = this.diccioServicios.find(codigo);
					Contrato nuevo = new Contrato(1, voContrato.getFecha(), voContrato.getDomOrigen(), voContrato.getDomDestino(), voContrato.getHoraInicio(), cliente, servicio);
					this.secContratos.insBack(nuevo);
					this.respaldoAutomatico();
					this.monitor.terminoEscritura();
				}
				else
				{
					Contrato cont = this.secContratos.back();
					if(voContrato.getFecha().isBefore(cont.getFecha()))
					{
						this.monitor.terminoEscritura();
						throw new FechaValidaException("Error: La fecha del contrato a registrar debe ser igual o posterior al ultimo contrato registrado.");
					}
					else
					{
						if(voContrato.getFecha().isEqual(cont.getFecha()))
						{
							if(cont.getHoraInicio().plusHours(2).compareTo(voContrato.getHoraInicio()) > 0)
							{
								this.monitor.terminoEscritura();
								throw new HoraValidaException("Error: La hora de inicio del contrato a registrar debe ser dos horas posterior al ultimo contrato registrado.");
							}
							else
							{
								Cliente cliente = this.diccioClientes.find(cedula);
								Servicio servicio = this.diccioServicios.find(codigo);
								Contrato nuevo = new Contrato((cont.getNumero()+1), voContrato.getFecha(), voContrato.getDomOrigen(), voContrato.getDomDestino(), voContrato.getHoraInicio(), cliente, servicio);
								this.secContratos.insBack(nuevo);
								this.respaldoAutomatico();
								this.monitor.terminoEscritura();
							}
						}
						else
						{
							Cliente cliente = this.diccioClientes.find(cedula);
							Servicio servicio = this.diccioServicios.find(codigo);
							Contrato nuevo = new Contrato((cont.getNumero()+1), voContrato.getFecha(), voContrato.getDomOrigen(), voContrato.getDomDestino(), voContrato.getHoraInicio(), cliente, servicio);
							this.secContratos.insBack(nuevo);
							this.respaldoAutomatico();
							this.monitor.terminoEscritura();
						}
					}
				}
    		}
    	}
    }
    
	//Metodo escritor  
	//Finaliza un contrato seteando duracion, finalizada y costo final con los valores del VOFinalizarMudanza pasado por parametro.  
    public void finalizarMudanza(VOFinalizarMudanza mudanza) throws RemoteException, ExisteContratoException, PersistenciaException
    {
		this.monitor.comienzoEscritura();
    	if(mudanza.getNumero() > this.secContratos.largo())
    	{
    		this.monitor.terminoEscritura();
    		throw new ExisteContratoException("Error: No existe un contrato registrado con el numero ingresado.");
    	}
    	else
    	{
    		Contrato contrato = this.secContratos.k_esimo(mudanza.getNumero()-1);
    		if(contrato.getFinalizada())
    		{
    			this.monitor.terminoEscritura();
    			throw new ExisteContratoException("Error: El contrato con el numero ingresado ya esta finalizado.");
    		}
    		else
    		{
    			contrato.setDuracion(mudanza.getHoras(), mudanza.getMinutos());
        		contrato.setFinalizada();
        		contrato.setCostoFinal();
     		    this.respaldoAutomatico();
        		this.monitor.terminoEscritura();
    		}
    	}
    }
    
    //Metodo lector 
	//Devuelve un VOListarcontratacion cargado con los datos del contrato con el numero pasado por parametro.   
    public VOListarContratacion listarContratacion(int numero) throws RemoteException, ExisteContratoException
    {
		this.monitor.comienzoLectura();
    	if(numero > this.secContratos.largo() || numero == 0)
    	{
			this.monitor.terminoLectura();
    		throw new ExisteContratoException("Error: No existe un contrato registrado con el numero ingresado.");
    	}
    	else
    	{
    		Contrato contrato = this.secContratos.k_esimo(numero-1);
    		VOListarContratacion resultado = new VOListarContratacion(contrato.getNumero(), contrato.getFecha(), contrato.getDomOrigen(), contrato.getDomDestino(),
    														contrato.getHoraInicio(), contrato.getFinalizada(), contrato.getDuracionHoras(), contrato.getDuracionMinutos(),
    														contrato.getCostoFinal(), contrato.getCliente().getCedula(), contrato.getCliente().getNombre(), contrato.getCliente().getApellido(),
    														contrato.getCliente().getTel(), contrato.getServicio().getCodigo());
			this.monitor.terminoLectura();
			return resultado;
    	}
    }
    
    //Metodo lector   
	//Devuelve la suma del costo final de todos los contratos comprendidos entre las fechas pasadas por parametro, incluidas estas. 
    public double montoRecaudadoPorRangoDeFecha(LocalDate fecha1, LocalDate fecha2) throws RemoteException, FechaValidaException, ExisteContratoException
    {
		this.monitor.comienzoLectura();
    	if(!(this.secContratos.esVacia()))
    	{
    		if(fecha2.isBefore(fecha1))
    		{
				this.monitor.terminoLectura();
    			throw new FechaValidaException("Error: La primera fecha es menor a la segunda fecha ingresada.");
    		}
    		else
    		{
    			Contrato ultimo = this.secContratos.back();
    			if(ultimo.getFecha().isBefore(fecha1))
    			{
					this.monitor.terminoLectura();
    				throw new FechaValidaException("Error: El periodo ingresado es posterior al ultimo contrato.");
    			}
    			else
    			{
    				Contrato primero = this.secContratos.k_esimo(0);
    				if(primero.getFecha().isAfter(fecha2))
    				{
						this.monitor.terminoLectura();
    					throw new FechaValidaException("Error: El periodo ingresado es anterior al primer contrato.");
    				}
    				else
    				{
    					double resultado = this.secContratos.montoRecaudadoPorRangoDeFecha(fecha1, fecha2);
    					this.monitor.terminoLectura();
    					return resultado;
    				}
    			}
    		}
    	}
    	else
    	{
    		this.monitor.terminoLectura();
    		throw new ExisteContratoException("Error: No hay contratos registrados");
    	}
    }
    
    //Metodo escritor .
	//Respalda informacion del disco.
	//Puede arrojar PersistenciaException en caso de que se produsca un error de respaldo.   
    public void respaldarInformacion() throws RemoteException, PersistenciaException 
    {
		this.monitor.comienzoEscritura();
    	Persistencia.respaldar("datos.dat", this.diccioClientes, this.diccioServicios, this.secContratos);
    	this.monitor.terminoEscritura();
	}

//Metodo lector
//Recupera todos los datos de disco
//Puede tirar PersistenciaException en caso de que el archivo esté vacío
    public void levantarInformacion() throws RemoteException, ClassNotFoundException, IOException, PersistenciaException
    {
    	this.monitor.comienzoLectura();
    	Contenedor contenedor;
		contenedor = Persistencia.recuperar("datos.dat");
		this.diccioClientes = contenedor.getDiccioClientes();
		this.diccioServicios = contenedor.getDiccioServicios();
    	this.secContratos = contenedor.getSecContratos();
    	this.monitor.terminoLectura();
    }

//Metodo lector
//Retorna un arreglo con todos los servicios cargados
    public VOServicio[] listarServicios() throws RemoteException
    {;
		this.monitor.comienzoLectura();
		VOServicio listado [] = this.diccioServicios.listarServicios();
		this.monitor.terminoLectura();
    	return listado;
    }
    
 //Metodo lector   
 //Dada una fecha, retorna un arreglo de VOContratoFecha(contienen las variables de numero de contrato, hora de inicio y finalizada)
    public VOContratoFecha[] listarContratacionesPorFecha(LocalDate fecha) throws RemoteException
    {
		this.monitor.comienzoLectura();
		VOContratoFecha voContratoFecha[] = null;
    	if(this.secContratos.esVacia())
		{
			this.monitor.terminoLectura();
		}
		else
		{
			Contrato primero = this.secContratos.k_esimo(0);
			if(primero.getFecha().isAfter(fecha))
			{
				this.monitor.terminoLectura();
			}
			else
			{
				Contrato ultimo = this.secContratos.back();
				if(ultimo.getFecha().isBefore(fecha))
				{
					this.monitor.terminoLectura();
				}
				else
				{
					voContratoFecha = this.secContratos.listarContratacionesPorFecha(fecha);
					this.monitor.terminoLectura();
				}
			} 
		}
    	return voContratoFecha;
    }

}
