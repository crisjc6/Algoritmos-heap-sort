/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author CRISJC
 */
public class HeapSort {
    
    	public static void sort(int v[]) {
		Monticulo minHeap = new MonticuloMinimo();
		for (int i = 0; i < v.length; i++) {
			minHeap.insertar(v[i]);
		}
		for (int i = 0; i < v.length; i++) {
			v[i] = minHeap.eliminar();
		}
	}
    
}
