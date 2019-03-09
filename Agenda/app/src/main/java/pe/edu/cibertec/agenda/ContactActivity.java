package pe.edu.cibertec.agenda;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ContactActivity extends AppCompatActivity{

    TextInputEditText etName, etCompany, etNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        etName = findViewById(R.id.etName);
        etCompany = findViewById(R.id.etCompany);
        etNumber = findViewById(R.id.etNumber);
    }


    // como queremos mostrar un menu en la pantalla , entonces se "infla"

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contact_menu,menu);
        return  true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String name = etName.getText().toString();
        String company= etCompany.getText().toString();
        int number= Integer.parseInt(etNumber.getText().toString());

        //Product product = new Product(name,description,quantity);

        Intent intent = getIntent();

        intent.putExtra("contact_name",name);
        intent.putExtra("contact_company",company);
        intent.putExtra("contact_number",number);

        //Tarea: en lugar de pasar 3 parametros pasar toda la clase
        //Tip: Google pass clase intent
        //GSON

        setResult(RESULT_OK,intent);


        finish();

        return true;


    }
}
