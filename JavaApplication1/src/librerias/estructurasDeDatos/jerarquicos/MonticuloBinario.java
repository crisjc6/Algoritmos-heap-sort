/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librerias.estructurasDeDatos.jerarquicos;

import librerias.estructurasDeDatos.modelos.*;

/**
 *
 * @author USRLAM
 */
public class MonticuloBinario< E extends Comparable<E>> implements ColaPrioridad<E> {

    protected E elArray[];
    protected int talla;
    protected static final int CAPACIDAD_POR_DEFECTO = 20;

    public MonticuloBinario() {
        elArray = (E[]) new Comparable[CAPACIDAD_POR_DEFECTO];
        talla = 0;
    }

    public void insertar(E x) {
        //if (talla == elArray.length - 1) duplicarArray();
        
        int hueco = ++talla;
        while (hueco > 1 && x.compareTo(elArray[hueco / 2]) < 0) {
            elArray[hueco] = elArray[hueco / 2];
            hueco = hueco / 2;
        }
        elArray[hueco] = x;
    }

    public E eliminarMin() {
        E elMinimo = recuperarMin();
        elArray[1]  = elArray[talla--];
        hundir(1);
        return elMinimo;
    }

    private void hundir(int hueco) {
        E aux = elArray[hueco];
        int hijo = hueco*2;
        boolean esHeap = false;
        while(hijo <= talla && !esHeap)
            {
                if (hijo != talla && elArray[hijo + 1].compareTo(elArray[hijo]) < 0) {
                    hijo++;
                }
                if (elArray[hijo].compareTo(aux) < 0) {
                    elArray[hueco] = elArray[hijo];
                    hueco = hijo;
                    hijo = hueco * 2;
                } else {
                    esHeap = true;
                }
            }
            elArray[hueco] = aux;
        }
    

    //El mínimo elemento está en la posición 1
    public E recuperarMin() {
        return elArray[1];
    }

    public boolean esVacia() {
        return (talla == 0);
    }

    public String toString() {
        String res = "";
        if (talla > 0) {
            for (int i = 1; i <= talla; i++) {
                res += " " + elArray[i];
            }
        }
        return res;
    }

    public void iniciarMonticulo(E v[]) { //En la clase MonticuloBinario
        for (int i = 0; i < v.length; i++) {
            elArray[i + 1] = v[i];
        }
        talla = v.length;
        arreglarMonticulo();
    }

    private void arreglarMonticulo() {
        for (int i = talla / 2; i > 0; i--) {
            hundir(i);
        }
    }
}
