package pe.edu.cibertec.agendaroom;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity //(tableName = "OtroNombreDistinto")
public class Contact {

    //ATRIBUTOS

    @PrimaryKey (autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "telephone")
    private String telephone;


    //CONSTRUCTORES ALT + ins

    public Contact(String name, String telephone) {
        this.name = name;
        this.telephone = telephone;
    }

    public Contact() {
    }

    //getter y setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


}
