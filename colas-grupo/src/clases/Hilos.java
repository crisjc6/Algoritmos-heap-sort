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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;

/**
 *
 * @author USRBET
 */
public class Hilos  extends Thread{
    JTable tabla;
    JProgressBar barra;
    JLabel label, label2, icono;
    Heapsort cola;

    public Hilos(JProgressBar barra, Heapsort cola, JLabel label, JTable tabla, JLabel icono) {
        this.barra = barra;
        this.cola=cola;
        this.label = label;
        this.tabla = tabla;
        this.icono=icono;
        
    }
    private void setImagen(Evento line, boolean ban){
        Icon ico;
        /*if(ban){
        switch(line.fecha){
                    case 0:    
                        ico=new ImageIcon(getClass().getResource("/imagenes/emergencia0.png"));
                        icono.setIcon(ico);
                        break;
                    case 1:   
                        ico=new ImageIcon(getClass().getResource("/imagenes/emergencia1.jpg"));
                        icono.setIcon(ico);
                        break;
                    case 2:    
                        ico=new ImageIcon(getClass().getResource("/imagenes/emergencia2.jpg"));
                        icono.setIcon(ico);
                        break;
                    case 3:  
                        ico=new ImageIcon(getClass().getResource("/imagenes/emergencia3.jpg"));
                        icono.setIcon(ico);
                        break;
                }
        }else{
            ico=new ImageIcon(getClass().getResource("/imagenes/salud.jpg"));
            icono.setIcon(ico);
            label.setText("Gracias por la espera");            
        }*/
    }
    @Override
    public void run(){        
        try {
            while(cola.numClientesEnEspera()!=0){
                Evento line=cola.atenderCliente();
                label.setText(line.getApellido());
                try {
                    setImagen(line,true);
                    sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
                }
                tabla.setModel(cola.muestraEstado());
                tabla.repaint();
            }
            setImagen(null,false);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "No se");
            System.err.println(e.getMessage());
        }
        
       
        
    }

}
