package pe.edu.cibertec.proyectotarea;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvTarea;
    TareaAdapter adapter;
    List<Tarea> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvTarea = findViewById(R.id.rvTarea);
    }

    @Override
    protected void onResume(){
        super.onResume();
        loadItems();
    }

    private void loadItems(){
        new GetAllTareaTask().execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this,TareaActivity.class);
        startActivity(intent);
        return true;
    }

    private class GetAllTareaTask extends AsyncTask<Void,Void, List<Tarea>> {
        @Override
        protected List<Tarea> doInBackground(Void... voids) {

            return AppDatabase.getInstance(MainActivity.this).tareaDao().getAll();

        }

        @Override
        protected void onPostExecute(List<Tarea> tareas) {
            super.onPostExecute(tareas);
            items = tareas;

            adapter = new TareaAdapter(items);
            rvTarea.setAdapter(adapter);
            rvTarea.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        }
    }

}
