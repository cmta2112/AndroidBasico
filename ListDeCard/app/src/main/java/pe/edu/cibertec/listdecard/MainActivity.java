package pe.edu.cibertec.listdecard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import pe.edu.cibertec.listdecard.adapter.AmigosAdapter;
import pe.edu.cibertec.listdecard.dto.Amigos;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private AmigosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        listView = findViewById(R.id.listView);
        adapter = new AmigosAdapter(this, getData());
        listView.setAdapter(adapter);
    }

    private List<Amigos> getData() {
        List<Amigos> list_amigos = new ArrayList<>();
        list_amigos.add(new Amigos(R.drawable.juan, "Juan Tello", "jtello@yahoo.es"));
        list_amigos.add(new Amigos(R.drawable.ana, "Ana Torres", "atorres@hotmail.com"));
        list_amigos.add(new Amigos(R.drawable.andrea, "Andrea Andrade", "aandrade@gmail.com"));
        list_amigos.add(new Amigos(R.drawable.jenny, "Jenny Ramos", "jramos@gmail.com"));
        list_amigos.add(new Amigos(R.drawable.karla, "Karla Ramírez", "kramirez@hotmail.com"));
        return list_amigos;
    }
}