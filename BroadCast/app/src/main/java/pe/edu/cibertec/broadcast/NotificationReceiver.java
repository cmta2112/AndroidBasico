package pe.edu.cibertec.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Toast;

public class NotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // esto ocurre cuando llaman al evento

        switch (intent.getAction()) {
            case "pe.edu.cibertec.ACTION":
                String messsage = "Accion de la aplicacion";
                showNotification(context, messsage);
                //Toast.makeText(context, "Acción de la aplicación", Toast.LENGTH_SHORT).show();
                break;

            case "android.intent.action.AIRPLANE_MODE":
                messsage = "Accion cambio modo avion";
                showNotification(context, messsage);
                break;


        }
    }

    private void showNotification(Context context, String message) {

        // aqui estoy creando la notificacion

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "idChannel")
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle("Nueva Notificación")
                .setContentText(message);

        // esta parte es para mostrar la notificacion
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
        managerCompat.notify(0, builder.build());


    }

}
