package pe.edu.cibertec.listcardpropuesto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import pe.edu.cibertec.listcardpropuesto.Adapter.FrutasAdapter;
import pe.edu.cibertec.listcardpropuesto.dto.Frutas;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private FrutasAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        listView = findViewById(R.id.listView);
        adapter = new FrutasAdapter(this, getData());
        listView.setAdapter(adapter);

    }

    private List<Frutas> getData() {
        List<Frutas> list_amigos = new ArrayList<>();
        list_amigos.add(new Frutas(R.drawable.freesa, "Fresa", "Las fresas y los fresones crecen en el fresal"));
        list_amigos.add(new Frutas(R.drawable.manzana, "Manzana", "La manzana es una fruta pomacea"));
        list_amigos.add(new Frutas(R.drawable.naranja, "Naranja", "La naranja es el fruto del naranjo dulce arbol"));
        list_amigos.add(new Frutas(R.drawable.platano, "Platano", "Los platanos son amarillos"));
        list_amigos.add(new Frutas(R.drawable.pera, "Pera", "Las peras son jugosas y ricas"));


        return list_amigos;
    }
}
