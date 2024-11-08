package model;

public class Client {

    private String name;

    public Client(String name, String rut) {
        this.name = name;
        this.rut = rut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    private String rut;

    @Override
    public String toString() {
        return "Cliente{" +
                "Nombre='" + name + '\'' +
                ", RUT='" + rut + '\'' +
                '}';
    }
}
