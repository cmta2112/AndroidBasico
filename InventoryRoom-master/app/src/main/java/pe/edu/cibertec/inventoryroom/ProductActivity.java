package pe.edu.cibertec.inventoryroom;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;

public class ProductActivity extends AppCompatActivity {


    TextInputEditText etName, etDescription, etQuantity;
    int id;
    Product product;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        etName = findViewById(R.id.etName);
        etDescription = findViewById(R.id.etDescription);
        etQuantity = findViewById(R.id.etQuantity);

        ///gson para pasarlo de un lado a otro intent

        Gson gson = new Gson();
        String strObj = getIntent().getStringExtra("product");
        product = gson.fromJson(strObj, Product.class);


        if (product != null) {
            etName.setText(product.getName());
            etDescription.setText(product.getDescription());
            etQuantity.setText(String.valueOf(product.getQuantity()));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.product_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.optionSave:
                String name = etName.getText().toString();
                String description = etDescription.getText().toString();
                int quantity= Integer.parseInt(etQuantity.getText().toString());

                if (product != null) {
                    product.setName(name);
                    product.setDescription(description);
                    product.setQuantity(quantity);
                    new UpdateContactTask().execute(product);

                } else {
                    product = new Product(name,description,quantity);
                    new InsertContactTask().execute(product);
                }
                break;

            case R.id.optionDelete:
                new DeleteContactTask().execute(product);
                break;
        }
        finish();
        return true;
    }

    private class UpdateContactTask extends AsyncTask<Product, Void, Void> {
        @Override
        protected Void doInBackground(Product... products) {
            AppDatabase.getInstance(ProductActivity.this).productDao().update(products);

            return null;

        }
    }

    private class InsertContactTask extends AsyncTask<Product, Void, Void> {
        @Override
        protected Void doInBackground(Product...products) {
            AppDatabase.getInstance(ProductActivity.this).productDao().insert(products);

            return null;

        }
    }

    private class DeleteContactTask extends AsyncTask<Product, Void, Void> {
        @Override
        protected Void doInBackground(Product...products) {
            AppDatabase.getInstance(ProductActivity.this).productDao().delete(products);

            return null;

        }
    }

}
