/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;

public class Hilos extends Thread {

    JTable tabla;
    JProgressBar barra;
    JLabel label, label2, icono;
    Heapsort cola;

    public Hilos(JProgressBar barra, Heapsort cola, JLabel label, JTable tabla, JLabel icono) {
        this.barra = barra;
        this.cola = cola;
        this.label = label;
        this.tabla = tabla;
        this.icono = icono;

    }

    private void setImagen(Evento line, boolean ban) {
        Icon ico;
    }

    @Override
    public void run() {
        try {
            while (cola.numClientesEnEspera() != 0) {
                Evento line = cola.atenderEvento();
                label.setText("<html><body><b>Nombre:</b> " + line.getNombre() + "<br><b>Fecha:</b> " + line.getFecha() + "<br><b>Telefono:</b> " + line.getTelf() + "</body></html>");
                try {
                    setImagen(line, true);
                    sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
                }
                tabla.setModel(cola.muestraEstado());
                tabla.repaint();
            }
            setImagen(null, false);

        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "No se");
            System.err.println(e.getMessage());
        }
    }
}
