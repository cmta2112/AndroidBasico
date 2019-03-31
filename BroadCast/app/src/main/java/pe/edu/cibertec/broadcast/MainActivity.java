package pe.edu.cibertec.broadcast;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btAction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createNotificationChannel();

        btAction = findViewById(R.id.btAction);

        btAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Emitir la accion/evento de la aplicacion

                Intent intent = new Intent();
                intent.setAction("pe.edu.cibertec.ACTION");
                sendBroadcast(intent);

            }
        });

        //registrar el Receiver
        registerNotificationReceiver();
    }

    // simpre se necesita tener este canal para poder hacer notificaciones a partir de la verion 28 de android
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence channel = "canal";
            String description = "Descripcion del canal";

            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notificationChannel = new NotificationChannel("idChannel", channel, importance);

            notificationChannel.setDescription(description);

            NotificationManager manager = getSystemService(NotificationManager.class);

            manager.createNotificationChannel(notificationChannel);
        }
    }


    private void registerNotificationReceiver() {
        NotificationReceiver receiver = new NotificationReceiver();

        //PERMITE HACER ACCIONES/EVENTOS EN LOS COMPONENTES
        IntentFilter filter = new IntentFilter();
        //el intent_filter sirve para registrar la accion y para emitir la accion es el intent
        filter.addAction("pe.edu.cibertec.ACTION");
        filter.addAction("android.intent.action.AIRPLANE_MODE");
        this.registerReceiver(receiver, filter);

    }
}
