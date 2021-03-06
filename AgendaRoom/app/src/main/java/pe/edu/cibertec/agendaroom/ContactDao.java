package pe.edu.cibertec.agendaroom;




import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.Cursor;

import java.util.List;

//permite administrar mi BD

@Dao
public interface ContactDao {

    @Query("select * from contact")
    List<Contact> getAll();

    @Query("select * from contact")
    Cursor getAllCursor();

    @Query("select * from contact where id=:id")
    Contact getById(int id);

    @Query("select * from contact where id=:id")
    Cursor getByIdCursor(long id);

    @Insert
     void insert(Contact...contacts);

    @Update
    void update (Contact...contacts);

    @Delete
    void delete (Contact...contacts);

    @Query("delete from contact where name=:id")
    int deleteByIdCursor(long id);

    @Query("delete from contact")
    int deleteAllCursor();

    @Insert
    long insertCP(Contact contact);
}
