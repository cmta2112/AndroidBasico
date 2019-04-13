package pe.edu.cibertec.proyectotarea;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;

public class TareaActivity extends AppCompatActivity {


    TextInputEditText etName;
    int id;
    Tarea tarea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarea);

        etName = findViewById(R.id.etName);

        //se usa gson para pasar la info de un lado a otro
        //Se pasa un objeto

        Gson gson = new Gson();
        String strObj = getIntent().getStringExtra("tarea");
        tarea = gson.fromJson(strObj, Tarea.class);


        if (tarea != null) {
            etName.setText(tarea.getName());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tarea_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.optionSave:
                String name = etName.getText().toString();

                //para editar el nombre de la tarea

                if (tarea != null){
                tarea.setName(name);
                new UpdateTareaTask().execute(tarea);

            } else{

                //para ingresar una nueva tarea
                tarea = new Tarea(name);
                new InsertTareaTask().execute(tarea);
            }
            break;
                //Para borrar una tarea
            case R.id.optionDelete:
                new DeleteTareaTask().execute(tarea);
                break;
        }
        finish();
        return true;
    }

    private class UpdateTareaTask extends AsyncTask<Tarea, Void, Void> {
        @Override
        protected Void doInBackground(Tarea...tareas) {
            AppDatabase.getInstance(TareaActivity.this).tareaDao().update(tareas);

            return null;

        }
    }

    private class InsertTareaTask extends AsyncTask<Tarea, Void, Void> {
        @Override
        protected Void doInBackground(Tarea...tareas) {
            AppDatabase.getInstance(TareaActivity.this).tareaDao().insert(tareas);

            return null;

        }
    }

    private class DeleteTareaTask extends AsyncTask<Tarea, Void, Void> {
        @Override
        protected Void doInBackground(Tarea...tareas) {
            AppDatabase.getInstance(TareaActivity.this).tareaDao().delete(tareas);

            return null;

        }
    }

}
