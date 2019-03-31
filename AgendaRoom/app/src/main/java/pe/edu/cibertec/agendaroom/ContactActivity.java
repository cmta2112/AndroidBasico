package pe.edu.cibertec.agendaroom;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Switch;

import com.google.gson.Gson;

import java.util.List;

public class ContactActivity extends AppCompatActivity {

    TextInputEditText etName, etTelephone;
    Contact contact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        etName = findViewById(R.id.etName);
        etTelephone = findViewById(R.id.etTelephone);


        Gson gson = new Gson();
        String strObj = getIntent().getStringExtra("contact");
        contact = gson.fromJson(strObj, Contact.class);


        if (contact != null) {
            etName.setText(contact.getName());
            etTelephone.setText(contact.getTelephone());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_contact, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.optionSave:
                String name = etName.getText().toString();
                String telephone = etTelephone.getText().toString();
                if (contact != null) {
                    contact.setName(name);
                    contact.setTelephone(telephone);
                    new UpdateContactTask().execute(contact);

                } else {
                    contact = new Contact(name, telephone);
                    new InsertContactTask().execute(contact);
                }
                break;

            case R.id.optionDelete:
                new DeleteContactTask().execute(contact);
                break;
        }
        finish();
        return true;
    }

    private class UpdateContactTask extends AsyncTask<Contact, Void, Void> {
        @Override
        protected Void doInBackground(Contact... contacts) {
            AppDatabase.getInstance(ContactActivity.this).contactDao().update(contacts);

            return null;

        }
    }

    private class InsertContactTask extends AsyncTask<Contact, Void, Void> {
        @Override
        protected Void doInBackground(Contact... contacts) {
            AppDatabase.getInstance(ContactActivity.this).contactDao().insert(contacts);

            return null;

        }
    }

    private class DeleteContactTask extends AsyncTask<Contact, Void, Void> {
        @Override
        protected Void doInBackground(Contact... contacts) {
            AppDatabase.getInstance(ContactActivity.this).contactDao().delete(contacts);

            return null;

        }
    }


}

