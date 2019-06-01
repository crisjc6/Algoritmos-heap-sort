/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Jorge
 */
public class Evento {
    String nombre, apellido, cedula;
    int fecha;

    public Evento(String nombre, String apellido, String cedula, int emergencia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fecha = emergencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido+"   "+nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getEmergencia() {
        return fecha;
    }

    public void setEmergencia(int emergencia) {
        this.fecha = emergencia;
    }
    
}
