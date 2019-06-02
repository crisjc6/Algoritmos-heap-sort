/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import javax.swing.table.DefaultTableModel;

public class Heapsort {

    private static class DatosEvento {

        Evento p;
        int urg;

        DatosEvento(Evento p, int urg) {
            this.p = p;
            this.urg = urg;
        }
    }
    private ArrayList<DatosEvento> even;

    public Heapsort() {
        even = new ArrayList<DatosEvento>();
    }

    public void nuevoEvento(Evento p, int urg) {
        DatosEvento datos = new DatosEvento(p, urg);
        even.add(datos);
        sort(even);
        for (DatosEvento i : even) {
            System.out.println("dato ordenado" + i.p.fecha);
        }

    }

    public void setEven(ArrayList<DatosEvento> even) {
        this.even = even;
    }

    public ArrayList<DatosEvento> getEven() {
        return even;
    }

    public Evento atenderEvento() throws NoSuchElementException {
        DatosEvento datos = getEven().remove(0);
        return datos.p;
    }

    public DefaultTableModel muestraEstado() {
        System.out.println();
        System.out.println("--Estado de la cola--");
        System.out.println("No atendidos " + even.size());
        for (DatosEvento datos : even) {
            System.out.println(datos.p.getNombre() + datos.urg);
        }
        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        tableModel.addColumn("Nombre");
        tableModel.addColumn("Descripcion");
        tableModel.addColumn("Fecha");
        tableModel.addColumn("Teléfono");
        int pos = 0;
        Object[] fila = new Object[4];
        for (DatosEvento datos : even) {
            fila[0] = datos.p.getNombre();
            fila[1] = datos.p.getDescripcion();
            fila[2] = datos.p.getFecha();
            fila[3] = datos.p.getTelf();

            tableModel.addRow(fila);
            pos++;
        }
        return tableModel;
    }

    public void sort(ArrayList<DatosEvento> arr) {
        int n = arr.size();

        //System.err.println("esta ordenando los valores");
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract an element from heap 
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end 
            DatosEvento temp = arr.get(0);
            arr.set(0, arr.get(i));
            arr.set(i, temp);

            // call max heapify on the reduced heap 
            heapify(arr, i, 0);
        }

    }

    // To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
    void heapify(ArrayList<DatosEvento> arr, int n, int i) {
        int smallest = i; // Initialize largest as root 
        int l = 2 * i + 1; // left = 2*i + 1 
        int r = 2 * i + 2; // right = 2*i + 2 

        // If left child is smaller than root 
        if (l < n && arr.get(l).p.getFecha() > arr.get(smallest).p.getFecha()) {
            smallest = l;
        }

        // If right child is larger than smaller so far 
        if (r < n && arr.get(r).p.getFecha() > arr.get(smallest).p.getFecha()) {
            smallest = r;
        }

        // If smaller is not root 
        if (smallest != i) {
            DatosEvento swap = arr.get(i);
            arr.set(i, arr.get(smallest));
            arr.set(smallest, swap);

            // Recursively heapify the affected sub-tree 
            heapify(arr, n, smallest);

        }
    }

    /* Impresion del array de tamano n  */
    public void printArray(DatosEvento arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i].p.getFecha() + " ");
        }
        System.out.println();
    }

    public int numClientesEnEspera() {

        return even.size();

    }
}
