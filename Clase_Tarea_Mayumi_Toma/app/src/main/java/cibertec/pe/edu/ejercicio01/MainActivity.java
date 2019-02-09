package cibertec.pe.edu.ejercicio01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tarea1 t1 = new Tarea1("Matemáticas","22/05/2018","15:00");
        Tarea2 t2 = new Tarea2("Historia","21/07/2018","18:00");
        Tarea3 t3 = new Tarea3("Ciencia","15/05/2018","19:00");

        ArrayList<Tarea> listaTareas;
        listaTareas = new ArrayList<>();
        listaTareas.add(t1);
        listaTareas.add(t2);
        listaTareas.add(t3);

        for (int i=0; i<listaTareas.size();i++){
            listaTareas.get(i).printTareas();


        }








    }
}
