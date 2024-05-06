package CapaLogica;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

import Excepciones.ExisteClienteException;
import Excepciones.ExisteContratoException;
import Excepciones.ExisteServicioException;
import Excepciones.FechaValidaException;
import Excepciones.HoraValidaException;
import Excepciones.PersistenciaException;
import ValueObjects.VOCliente;
import ValueObjects.VOContrato;
import ValueObjects.VOContratoFecha;
import ValueObjects.VOFinalizarMudanza;
import ValueObjects.VOListarContratacion;
import ValueObjects.VOServicio;

public interface IFachada extends Remote
{
    public void altaServicio(VOServicio voServicio) throws RemoteException, ExisteServicioException, PersistenciaException;
    public void altaCliente(VOCliente voCliente) throws RemoteException, ExisteClienteException, PersistenciaException;
    public VOCliente[] listarClientes() throws RemoteException;
    public void contratacionDeServicio(String codigo, long cedula, VOContrato voContrato) throws RemoteException, ExisteServicioException, ExisteClienteException, FechaValidaException, HoraValidaException, PersistenciaException;
    public void finalizarMudanza(VOFinalizarMudanza mudanza) throws RemoteException, ExisteContratoException, PersistenciaException;
    public VOListarContratacion listarContratacion(int numero) throws RemoteException, ExisteContratoException;
    public double montoRecaudadoPorRangoDeFecha(LocalDate fecha1, LocalDate fecha2) throws RemoteException, FechaValidaException, ExisteContratoException;
    public void respaldarInformacion() throws RemoteException, PersistenciaException;
    public void levantarInformacion() throws RemoteException, ClassNotFoundException, IOException, PersistenciaException;
    public VOServicio[] listarServicios() throws RemoteException;
    public VOContratoFecha[] listarContratacionesPorFecha(LocalDate fecha) throws RemoteException;

}
