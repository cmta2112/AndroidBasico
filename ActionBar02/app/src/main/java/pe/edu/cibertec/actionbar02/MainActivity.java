package pe.edu.cibertec.actionbar02;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        TextView textView= findViewById(R.id.tvName);

        //noinspection SimplifiableIfStatement
        if (id == R.id.ins) {
            Toast.makeText(this, "Nuevo Registro", Toast.LENGTH_LONG).show();
            textView.setVisibility(View.VISIBLE);

        }
        if (id == R.id.upd) {
            Toast.makeText(this, "Actualizar Registro", Toast.LENGTH_LONG).show();
            textView.setVisibility(View.VISIBLE);
        }
        if (id == R.id.del) {
            //Toast.makeText(this, "Retirar Registro", Toast.LENGTH_LONG).show();
            textView.setVisibility(View.INVISIBLE);
        } // ---

        switch (id){
            case R.id.red:
                //textView.setTextColor(Color.RED)
                textView.setTextColor(getResources().getColor(R.color.colorRojo));
                break;

            case R.id.green:
                textView.setTextColor(getResources().getColor(R.color.colorVerde));

                break;

            case R.id.blue:
                textView.setTextColor(getResources().getColor(R.color.colorAzul));

                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
