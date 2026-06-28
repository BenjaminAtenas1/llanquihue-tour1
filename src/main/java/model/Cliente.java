package model;

import java.util.ArrayList;

public class Cliente extends Persona{
    private int idCliente;
    private String tourElegido;

    public Cliente(){

    }

    public Cliente(String nombreCompleto, String rut, int idCliente, String tourElegido) {
        super(nombreCompleto, rut);
        this.idCliente = idCliente;
        this.tourElegido = tourElegido;
    }

    public int getIdCliente() {

        return idCliente;
    }

    public void setIdCliente(int idCliente) {

        this.idCliente = idCliente;
    }

    public String getTourElegido() {

        return tourElegido;
    }

    public void setTourElegido(String tourElegido) {

        this.tourElegido = tourElegido;
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombreCompleto() + " | Rut: " + getRut() + " | ID Cliente: " + idCliente + " | Tour elegido (ciudad): " + tourElegido;
    }
}
