
package clases;

import com.toedter.calendar.JCalendar;
import java.util.Date;

/**
 *
 * @author Crishtian
 */
public class Evento extends Tarea{
    //String nombre, descripcion;
    Cliente cliente;
    int fecha;

    public Evento(Cliente cliente, int fecha) {
        super(cliente, fecha);
    }

    
    public int getFecha() {
        return fecha;
    }

    public void setFecha(int tiempo) {
        this.fecha = tiempo;
    }
    
}
