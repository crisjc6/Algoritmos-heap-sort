/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import com.sun.jmx.remote.internal.ArrayQueue;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class Heapsort {

    private static class DatosCliente  {

        Evento p;
        int urg;

        DatosCliente(Evento p, int urg) {
            this.p = p;
            this.urg = urg;
        }

        /**
         * Comparación de clientes por su urgencia
         */
       /* @Override
        public int compareTo(DatosCliente otro) {
            return this.urg == otro.urg;
        }*/
    }
    private ArrayList<DatosCliente> cliente;

    public Heapsort() {
        cliente = new ArrayList<DatosCliente>();
    }

    public void nuevoCliente(Evento p, int urg) {
        DatosCliente datos = new DatosCliente(p, urg);
        cliente.add(datos);
        sort(cliente);
                    for (DatosCliente i : cliente) {
            System.out.println("dato ordenado"+i.p.fecha);
    }
        
    }

    public void setCliente(ArrayList<DatosCliente> cliente) {
        this.cliente = cliente;
    }

    public ArrayList<DatosCliente> getCliente() {
        return cliente;
    }

    public Evento atenderCliente() throws NoSuchElementException {
        DatosCliente datos = getCliente().remove(0);
        return datos.p;
    }

    public DefaultTableModel muestraEstado() {
        System.out.println();
        System.out.println("--Estado de la cola--");
        System.out.println("No atendidos " + cliente.size());
        for (DatosCliente datos : cliente) {
            System.out.println(datos.p.getNombre() + " urgencia:" + datos.urg);
        }
        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        tableModel.addColumn("Apellidos");
        tableModel.addColumn("Nombres");
        tableModel.addColumn("Cédula");
        tableModel.addColumn("Gravedad");
        int pos = 0;
        Object[] fila = new Object[4];
        for (DatosCliente datos : cliente) {
            fila[0] = datos.p.getApellido();
            fila[1] = datos.p.getNombre();
            fila[2] = datos.p.getCedula();
            fila[3] = datos.p.getEmergencia();
          /*  if (datos.p.getEmergencia() == 0) {
                fila[3] = "Baja";
            }
            if (datos.p.getEmergencia() == 1) {
                fila[3] = "Media";
            }
            if (datos.p.getEmergencia() == 2) {
                fila[3] = "Alta";
            }
            if (datos.p.getEmergencia() == 3) {
                fila[3] = "Emergencia";

            }*/

            tableModel.addRow(fila);
            pos++;
        }
        return tableModel;
    }

    public void sort(ArrayList<DatosCliente> arr) {
        int n = arr.size();


        //System.err.println("esta ordenando los valores");
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract an element from heap 
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end 
            DatosCliente temp = arr.get(0);
            arr.set(0, arr.get(i));
            arr.set(i, temp);

            // call max heapify on the reduced heap 
            heapify(arr, i, 0);
        }

    }

    // To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
    void heapify(ArrayList<DatosCliente> arr, int n, int i) {
        int smallest = i; // Initialize largest as root 
        int l = 2 * i + 1; // left = 2*i + 1 
        int r = 2 * i + 2; // right = 2*i + 2 

        // If left child is smaller than root 
        if (l < n && arr.get(l).p.getEmergencia() > arr.get(smallest).p.getEmergencia()) {
            smallest = l;
        }

        // If right child is larger than smaller so far 
        if (r < n && arr.get(r).p.getEmergencia() > arr.get(smallest).p.getEmergencia()) {
            smallest = r;
        }

        // If smaller is not root 
        if (smallest != i) {
            DatosCliente swap = arr.get(i);
            arr.set(i, arr.get(smallest));
            arr.set(smallest, swap);

            // Recursively heapify the affected sub-tree 
            heapify(arr, n, smallest);
            
        }
    }

    /* A utility function to print array of size n */
    public void printArray(DatosCliente arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i].p.getEmergencia() + " ");
        }
        System.out.println();
    }

    public int numClientesEnEspera() {

        return cliente.size();

    }
}
