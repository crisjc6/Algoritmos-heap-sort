/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librerias.estructurasDeDatos.modelos;

/**
 *
 * @author USRLAM
 */
public interface ColaPrioridad<E extends Comparable<E>> {

    void insertar(E x);

    E recuperarMin();

    E eliminarMin();

    boolean esVacia();
}
