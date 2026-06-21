package model;

public class Tour {
    private String ciudad;
    private int cantidadMaxPersonas;
    private int precio;

    public Tour() {
    }

    public Tour(String ciudad, int cantidadMaxPersonas, int precio) {
        this.ciudad = ciudad;
        this.cantidadMaxPersonas = cantidadMaxPersonas;
        this.precio = precio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCantidadMaxPersonas() {
        return cantidadMaxPersonas;
    }

    public void setCantidadMaxPersonas(int cantidadMaxPersonas) {
        this.cantidadMaxPersonas = cantidadMaxPersonas;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "ciudad='" + ciudad + '\'' +
                ", cantidadMaxPersonas=" + cantidadMaxPersonas +
                ", precio=" + precio +
                '}';
    }
}
