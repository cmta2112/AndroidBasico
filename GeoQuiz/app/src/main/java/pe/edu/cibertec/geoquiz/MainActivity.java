package pe.edu.cibertec.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        public void respCorrecta(View v){
            Toast toast = Toast.makeText(this, "Respuesta Correcta", Toast.LENGTH_SHORT);
            toast.show();


    }

    public void respIncorrecta(View v){
        Toast toast = Toast.makeText(this, "Respuesta Incorrecta", Toast.LENGTH_SHORT);
        toast.show();

    }

}


