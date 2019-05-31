/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import javax.swing.JOptionPane;

public abstract class Monticulo {

    static final int TAMINI = 5;
    private int numElem;
    public int[] valores;

    protected int[] nodo;
    private static final int RAIZ = 1;

    public Monticulo() {
        numElem = 0;

        this.nodo = new int[TAMINI + 1];
    }

	private int padre(int i) {
		return i / 2;
	}

	private int hijoIzquierdo(int i) {
		return 2 * i;
	}

	private int hijoDerecho(int i) {
		return 2 * i + 1;
	}

    private void flotar(int actual) {
        while (!condicion(actual, padre(actual))) {
            intercambiar(actual, padre(actual));
            actual = padre(actual);

        }

    }

    private boolean monticuloLleno() {
        // return (numElem == v.length);
        return (numElem == nodo.length);
    }

    public void insertar(int clave) {

        if (monticuloLleno()) {
            throw new IllegalStateException("No se puede insertar nuevo elemento. Montículo lleno.");
        }

        nodo[++numElem] = clave;

        flotar(numElem);

        montar();
        this.valores = nodo;
        for (int i = 0; i < nodo.length; i++) {
            System.out.println("valor del nodo" + " " + nodo[i]);
        }
        JOptionPane.showMessageDialog(null, numElem);
    }

    public boolean esVacio() {
        return numElem == 0;
    }

    public int eliminar() throws IllegalStateException {
        if (this.estaVacio()) {
            throw new IllegalStateException("No se puede eliminar un elemento. Montículo vacío.");
        }
        int nodo = this.nodo[RAIZ];
        this.nodo[RAIZ] = this.nodo[numElem--];
        this.hundir(RAIZ);
        return nodo;
    }

    private void montar() {
        for (int i = numElem / 2; i >= 1; i--) {
            this.hundir(i);
        }
    }   

    private boolean tieneHijoIzquierdo(int i) {
        return this.hijoIzquierdo(i) <= numElem;
    }

    private boolean tieneHijoDerecho(int i) {
        return this.hijoDerecho(i) <= numElem;
    }

    private boolean tieneHijoUnico(int i) {
        return this.tieneHijoIzquierdo(i) && !this.tieneHijoDerecho(i);
    }

    public boolean estaVacio() {
        return numElem == 0;
    }

    public boolean estaLleno() {
        return numElem == this.nodo.length - 1;
    }

    protected boolean esHoja(int i) {
        return !this.tieneHijoIzquierdo(i) && !this.tieneHijoDerecho(i);
    }

    protected abstract boolean condicion(int hijo, int padre);

    protected void intercambiar(int i, int j) {
        int tmp = this.nodo[i];
        this.nodo[i] = this.nodo[j];
        this.nodo[j] = tmp;
    }

    private void hundir(int i) {
        if (!this.esHoja(i)) {
            if (!this.tieneHijoUnico(i)) {
                if (!this.condicion(this.hijoIzquierdo(i), i) || !this.condicion(this.hijoDerecho(i), i)) {
                    if (!this.condicion(this.hijoIzquierdo(i), this.hijoDerecho(i))) {
                        this.intercambiar(i, this.hijoIzquierdo(i));
                        this.hundir(this.hijoIzquierdo(i));
                    } else {
                        this.intercambiar(this.hijoDerecho(i), i);
                        this.hundir(this.hijoDerecho(i));
                    }
                }
            } else {
                if (!this.condicion(this.hijoIzquierdo(i), i)) {
                    this.intercambiar(i, this.hijoIzquierdo(i));
                    this.hundir(this.hijoIzquierdo(i));
                }
            }
        }
    }
	public int pispear() throws IllegalStateException {
		if (this.estaVacio()) {
			throw new IllegalStateException("No se puede pispear un elemento. Montículo vacío.");
		}
		return this.nodo[RAIZ];
	}

	public void mostrar() {
		for (int i = 1; i <= this.numElem / 2; i++) {
			System.out.print("Padre: " + this.nodo[i]);
			if (this.tieneHijoIzquierdo(i)) {
				System.out.print(" HijoIzquierdo: " + this.nodo[2 * i]);
			}
			if (this.tieneHijoDerecho(i)) {
				System.out.print(" HijoDerecho: " + this.nodo[2 * i + 1]);
			}
			System.out.println();
		}
	}
}
