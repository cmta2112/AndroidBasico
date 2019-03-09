package pe.edu.cibertec.agenda;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

// Vista --> se crea una variable de la vista tipo recyclerView

    RecyclerView rvContact;

    // Modelo: informacion a mostrar

    ArrayList<Contacto> items;

    //Adaptador

    AdapterContact adapterContact;

    final static int REQUEST_CODE_MAIN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enlazar variable con su vista a partir del id

        rvContact = findViewById(R.id.rvContact);

        //Asignar espacio en memoeria para el arreglo

        items = new ArrayList<>();

        //Cargar la info para mostrar

        loadItems();

        //Inicializo el adaptador
        adapterContact= new AdapterContact(items);

        //asociar el adapter con el recicle view
        rvContact.setAdapter(adapterContact);

        // tambien definir si va a ser horizontal o vertical
        rvContact.setLayoutManager(new LinearLayoutManager(this));

    }

    private void loadItems() {
        //Intancia un objeto de la clase Product
        Contacto ContactoRepuesto = new Contacto("Alejandro","Hiraoka",989896537);

        //Agrega el objeto creado a la lista
        items.add(ContactoRepuesto);


        Contacto ContactoMantenimiento= new Contacto("Cesar", "Grupo Eulen", 3960455);
        items.add(ContactoMantenimiento);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.main_menu,menu);
        return  true;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE_MAIN && resultCode == RESULT_OK){
            String name = data.getStringExtra("contact_name");
            String company = data.getStringExtra("contact_company");
            int number = data.getIntExtra("contact_number",0);

            Contacto contacto= new Contacto(name,company,number);

            items.add(contacto);

            adapterContact.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent = new Intent(this,ContactActivity.class);
        startActivityForResult(intent,REQUEST_CODE_MAIN);
        return true;

    }
}
