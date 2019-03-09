package pe.edu.cibertec.agenda;

public class Contacto {

    //Atributos

    private String name;
    private String company;
    private int number;

    //getter y setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    //contructores


    public Contacto() {
    }

    public Contacto(String name, String company, int number) {
        this.name = name;
        this.company = company;
        this.number = number;
    }
}
