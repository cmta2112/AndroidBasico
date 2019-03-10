package pe.edu.cibertec.activitylifecicle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    public  static  final String TAG = "LifyCicle2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d(TAG,"Ingrese al metodo onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG,"Ingrese al metodo onStart");
    }



    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG,"Ingrese al metodo onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG,"Ingrese al metodo onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"Ingrese al metodo onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"Ingrese al metodo onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"Ingrese al metodo onRestart");
    }
}
