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
public class MonticuloMinimo extends Monticulo {

	public MonticuloMinimo() {
		super();
		this.nodo[0] = Integer.MIN_VALUE;
	}

	@Override
	protected boolean condicion(int hijo, int padre) {
		return this.nodo[hijo] >= this.nodo[padre];
	}
	
}
