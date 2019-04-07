package pe.edu.cibertec.inventoryroom;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView rvProduct;
    ProductAdapter adapter;
    List<Product> items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvProduct = findViewById(R.id.rvProduct);
    }
    @Override
    protected void onResume(){
        super.onResume();
        loadItems();
    }

    private void loadItems(){
        new GetAllContactTask().execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this,ProductActivity.class);
        startActivity(intent);
        return true;
    }

    private class GetAllContactTask extends AsyncTask<Void,Void, List<Product>> {
        @Override
        protected List<Product> doInBackground(Void... voids) {

            return AppDatabase.getInstance(MainActivity.this).productDao().getAll();

        }

        @Override
        protected void onPostExecute(List<Product> products) {
            super.onPostExecute(products);
            items = products;

            adapter = new ProductAdapter(items);
            rvProduct.setAdapter(adapter);
            rvProduct.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        }
    }
}
