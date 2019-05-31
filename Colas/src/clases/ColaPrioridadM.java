/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

public class ColaPrioridadM {

    public Monticulo getCp() {
        return cp;
    }
    
    protected Monticulo cp;
    
    public ColaPrioridadM(){
        cp = new Monticulo();
    }
    // añade una tarea a la cola
    public void inserEnPrioridad(Tarea t)throws Exception{
        cp.insertar(t);
    }
    public Tarea elementoMin ()throws Exception{
        return (Tarea)cp.buscarMinimo();
    }
    public Tarea quitarMin()throws Exception{
        return (Tarea)cp.eliminarMinimo();
    }
    public boolean colaPrioridadVacia(){
        return cp.esVacio();
    }
    
    
}
