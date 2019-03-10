package pe.edu.cibertec.agendafragment;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment frDetails = new DetailContactFragment();

        int orientatioin = getResources().getConfiguration().orientation;

        if (orientatioin == Configuration.ORIENTATION_LANDSCAPE){

            getSupportFragmentManager().beginTransaction().add(R.id.frDetailContact,frDetails).commit();

            //fragment MANAGER jala al Fragment transsaction --> agregar o remover o remplazar --> se hace commit

        }






    }
}
