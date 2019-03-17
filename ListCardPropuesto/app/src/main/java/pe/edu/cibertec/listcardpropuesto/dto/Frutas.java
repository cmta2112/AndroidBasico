package pe.edu.cibertec.listcardpropuesto.dto;

public class Frutas {

    private Integer foto;
    private String nombre;
    private String descripcion;

    //contructores



    public Frutas(Integer foto, String nombre, String descripcion) {
        this.foto = foto;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }


    // setter y getter


    public Integer getFoto() {
        return foto;
    }

    public void setFoto(Integer foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
