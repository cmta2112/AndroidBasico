package pe.edu.cibertec.agendaroom;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Contact.class}, version = 1)

public abstract class AppDatabase extends RoomDatabase {

    public abstract ContactDao contactDao();

    private static AppDatabase instance = null;

    // static poque se usa la misma instancia y no se hace a cada rato new
    public static AppDatabase getInstance(Context context){
        if (instance == null){
            //si tiene valor nulo se crea la instancia , singleton - sincrono
            // es para abrir una conexion a la base de datos

            instance = Room.databaseBuilder(context, AppDatabase.class,"db").allowMainThreadQueries().build();
        }
        return instance;
    }
}
