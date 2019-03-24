package pe.edu.cibertec.agendaroom;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Switch;

public class ContactActivity extends AppCompatActivity {

    TextInputEditText etName, etTelephone;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        etName = findViewById(R.id.etName);
        etTelephone =findViewById(R.id.etTelephone);

        id = getIntent().getIntExtra("id",-1);

        if (id > -1){
            String name= getIntent().getStringExtra("name");
            String telephone = getIntent().getStringExtra("telephone");
            etName.setText(name);
            etTelephone.setText(telephone);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_contact,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Contact contact;
        contact = new Contact();

        switch (item.getItemId()){
            case R.id.optionSave:
                String name = etName.getText().toString();
                String telephone = etTelephone.getText().toString();

                if(id == -1){
                    contact = new Contact(name,telephone);

                    //esto te permite cargarlo a la base de datos
                    AppDatabase.getInstance(this).contactDao().insert(contact);

                }else{
                    contact.setId(id);
                    contact.setName(name);
                    contact.setTelephone(telephone);
                    AppDatabase.getInstance(this).contactDao().update(contact);
                }


                
                break;
            case R.id.optionDelete:
                contact.setId(id);
                AppDatabase.getInstance(this).contactDao().delete(contact);
                break;
        }

        finish();
        return true;

    }
}

