package pe.edu.cibertec.proyectotarea;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface TareaDao {

    //permite administrar mi BD

    @Query("select * from tarea")
    List<Tarea> getAll();

    @Insert
    void insert(Tarea... tareas);

    @Update
    void update(Tarea... tareas);

    @Delete
    void delete(Tarea... tareas);


}
