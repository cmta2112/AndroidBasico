package pe.edu.cibertec.agendaroom;




import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

//permite administrar mi BD

@Dao
public interface ContactDao {

    @Query("select * from contact")
    List<Contact> getAll();

    @Insert
     void insert(Contact...contacts);

    @Update
    void update (Contact...contacts);

    @Delete
    void delete (Contact...contacts);




}
