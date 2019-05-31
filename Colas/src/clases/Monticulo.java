/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import javax.swing.JOptionPane;

public class Monticulo {

    static final int TAMINI = 20;
    private int numElem;
    private Comparador[] v;

    public Monticulo() {
        numElem = 0;
        v = new Comparador[TAMINI];
    }

    public static int padre(int i) {
        return (i - 1) / 2;
    }

    public static int hijoIzq(int i) {
        return (2 * i + 1);
    }

    public static int hijoDer(int i) {
        return (2 * i + 1) + 1;
    }

    private void flotar(int i) {
        Comparador nuevaClave = v[i];
        while ((i > 0) && (v[padre(i)].mayorQue(nuevaClave))) {
            v[i] = v[padre(i)]; // baja el padre al hueco
            i = padre(i); // sube un nivel en el árbol
        }
        v[i] = nuevaClave; // sitúa la clave en su posición
        
    }

    private boolean monticuloLleno() {
        return (numElem == v.length);
    }

    private void ampliar() {
        Comparador[] anteriorV = v;
        v = new Comparador[numElem + TAMINI];
        for (int j = 0; j < numElem; j++) {
            v[j] = anteriorV[j];
        }
    }

    public void insertar(Comparador clave) {
        if (monticuloLleno()) {
            ampliar();
        }
        v[numElem] = clave;
        flotar(numElem);
        numElem=numElem+1;
        JOptionPane.showMessageDialog(null, numElem);
    }

    public Comparador buscarMinimo() throws Exception {
        if (esVacio()) {
            throw new Exception("Acceso a montículo vacío");
        }
        return v[0];
    }

    public boolean esVacio() {
        return numElem == 0;
    }

    public void criba(int raiz) {
        boolean esMonticulo;
        int hijo;
        esMonticulo = false;
        while ((raiz < numElem / 2) && !esMonticulo) {
            // determina el índice del hijo menor
            if (hijoIzq(raiz) == (numElem - 1)) // único descendiente
            {
                hijo = hijoIzq(raiz);
            } else if (v[hijoIzq(raiz)].menorQue(v[hijoDer(raiz)])) {
                hijo = hijoIzq(raiz);
            } else {
                hijo = hijoDer(raiz);
            }
            // compara raiz con el menor de los hijos
            if (v[hijo].menorQue(v[raiz])) {
                Comparador t = v[raiz];
                v[raiz] = v[hijo];
                v[hijo] = t;
                raiz = hijo;
                /* continua por la rama de claves mínimas */
            } else {
                esMonticulo = true;
            }
        }
    }

    public Comparador eliminarMinimo() throws Exception {
        
        if (esVacio()) {
            throw new Exception("Acceso a montículo vacío");
        }
        Comparador menor;
        menor = v[0];
        v[0] = v[numElem - 1];
        criba(0);
        numElem--;
        return menor;
    }

    public static void criba2(Comparador v[], int raiz, int ultimo) {
        boolean esMonticulo;
        int hijo;
        int numElem = ultimo + 1;
        esMonticulo = false;
        while ((raiz < numElem / 2) && !esMonticulo) {
            // determina el índice del hijo mayor
            if (Monticulo.hijoIzq(raiz) == (numElem - 1)) {
                hijo = Monticulo.hijoIzq(raiz);
            } else if (v[Monticulo.hijoIzq(raiz)].mayorQue(
                    v[Monticulo.hijoDer(raiz)])) {
                hijo = Monticulo.hijoIzq(raiz);
            } else {
                hijo = Monticulo.hijoDer(raiz);
            }
            // compara raiz con el mayor de los hijos
            if (v[hijo].mayorQue(v[raiz])) {
                Comparador t = v[raiz];
                v[raiz] = v[hijo];
                v[hijo] = t;
                raiz = hijo;
                /* continua por la rama de claves máximas */
            } else {
                esMonticulo = true;
            }
        }
    }

    public static void ordenacionMonticulo(Comparador v[], int n) {
        int j;
        for (j = n / 2; j >= 0; j--) {
            criba2(v, j, n - 1);
        }
        for (j = n - 1; j >= 1; j--) {
            Comparador t;
            t = v[0];
            v[0] = v[j];
            v[j] = t;
            criba2(v, 0, j - 1);
        }
        
    }
    
    
   /* public void conseguirArreglo() throws Exception{
        //Comparador[] anteriorV = v;
        Comparador menor;
        
        if (esVacio()) {
            throw new Exception("Acceso a montículo vacío");
        }
        
        for (int j = 0; j < numElem; j++) {
            menor = v[j];
            //criba(0);
            //numElem--;
            Tarea tarea = (Tarea) menor;
            Evento evento = (Evento)tarea.item;
            
            System.out.println(numElem+"---"+evento.getNombre());
        }
        
                     
    }*/
            
}
