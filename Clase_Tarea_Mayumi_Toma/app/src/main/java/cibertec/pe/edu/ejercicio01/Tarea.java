package cibertec.pe.edu.ejercicio01;

import android.util.Log;


public class Tarea {

    //Atributos

    private String nombre;
    private String fecha;
    private String hora;

    //Constructores

    public Tarea(String nombre, String fecha, String hora) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Tarea() {
    }

    // Getter y setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void printTareas() {
        Log.d("Tareas", "Tarea de: " + getNombre());
    }
}
