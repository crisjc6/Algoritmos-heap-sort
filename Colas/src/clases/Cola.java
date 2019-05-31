/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Cola {
    
    private ColaPrioridadM colaEspera = new ColaPrioridadM();
    private ColaPrioridadM colaAux;

    public ColaPrioridadM getColaEspera() {
        return colaEspera;
    }

    public void setColaEspera(ColaPrioridadM colaEspera) {
        this.colaEspera = colaEspera;
    }
        
	// final de la clase DatosCliente

	// cola del servicio
	//private Queue<DatosCliente> colaEspera;
	/**
	* Constructor de ColaEspera
	*/
        //private ArrayList<Evento> colaEspera;
        
	        
	/**
	* Nuevo cliente; se mete en la cola de espera
	*/
	public void nuevoEvento(Cliente cliente, int fecha) throws Exception{
            Tarea tarea = new Tarea(cliente, fecha);
            colaEspera.inserEnPrioridad(tarea);
           // colaEspera.getCp().conseguirArreglo();
	}

	/**
	* Atender cliente: se saca de la cola de
	* espera; retorna el cliente atendido
	*/

	 

	public Cliente atenderCliente() throws NoSuchElementException, Exception{
            //Evento eventoAtendido;
            Tarea tarea = colaEspera.quitarMin();
            System.out.println(tarea.item);
            return (Cliente)tarea.item;
	}


	/**
	* Mostrar el estado de la cola de espera
	*/

	public DefaultTableModel muestraEstado() throws Exception {
            System.out.println();
            System.out.println("--Estado de la cola--");
            //System.out.println("No atendidos "+colaEspera.size());
            
            DefaultTableModel tableModel = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int fila,int columna){
                    return false;
                }
            };

            tableModel.addColumn("Nombre");
            tableModel.addColumn("Descripcion");
            tableModel.addColumn("Fecha");

            int pos=0;
            Object[] fila = new Object[3];
            
            
            colaAux = colaEspera;
            
                //JOptionPane.showMessageDialog(null, "Entro");
            
            while(!colaAux.colaPrioridadVacia()){
                Tarea tarea = colaEspera.quitarMin();
                Cliente cliente = (Cliente)tarea.item;
                fila[0]=cliente.getNombre();
                fila[1]=cliente.getDescripcion();
                fila[2]=tarea.prioridad;

                tableModel.addRow(fila);
                    pos++;
                }
                System.err.println("esta aqui");
                return tableModel;
	}
    
}