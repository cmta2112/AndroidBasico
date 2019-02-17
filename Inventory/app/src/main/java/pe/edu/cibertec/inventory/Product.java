package pe.edu.cibertec.inventory;

public class Product {

  //  pojo --> objective java optic

    //Atributos
    private String name;
    private String description;
    private int quantity;

    //getters y setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Contructores (Alt + ins)


    public Product(String name, String description, int quantity) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    public Product() {
    }
}
