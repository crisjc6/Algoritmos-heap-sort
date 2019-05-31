
package clases;

public class Tarea implements Comparador {

    protected Cliente item;
    protected int prioridad;

    public Tarea(Cliente q, int n) {
        item = q;
        prioridad = n;
    }

    public int numPrioridad() {
        return prioridad;
    }

    public boolean igualQue(Object op2) {

        Tarea n2 = (Tarea) op2;
        return prioridad == n2.prioridad;
    }

    public boolean menorQue(Object op2) {
        // orden inverso, es decir, prioridad 0 > prioridad 1
        Tarea n2 = (Tarea) op2;
        return prioridad > n2.prioridad;
    }

    public boolean menorIgualQue(Object op2) {
        Tarea n2 = (Tarea) op2;
        return prioridad >= n2.prioridad;
    }

    public boolean mayorQue(Object op2) {
        Tarea n2 = (Tarea) op2;
        return prioridad < n2.prioridad;
    }

    public boolean mayorIgualQue(Object op2) {
        Tarea n2 = (Tarea) op2;
        return prioridad <= n2.prioridad;
    }
}
