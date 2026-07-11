package model;

import javax.swing.*;
import java.util.ArrayList;

public class Cliente extends Persona implements Registrable{
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
    public void mostrarResumen(){

        JFrame ventanaInformacion = new JFrame("Información Excursión Cultural");
        ventanaInformacion.setSize(400, 370);
        ventanaInformacion.setLayout(null);
        ventanaInformacion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea area = new JTextArea();
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(10,50,360,260);
        ventanaInformacion.add(scroll);

        area.setText("El cliente " + nombreCompleto + " NRO ID: " + idCliente + " ha escogido el tour: " + tourElegido);

        ventanaInformacion.setLocationRelativeTo(null);
        ventanaInformacion.setVisible(true);
        area.setEditable(false);
        area.setFocusable(false);

    }
    @Override
    public String toString() {
        return "Nombre: " + getNombreCompleto() + " | Rut: " + getRut() + " | ID Cliente: " + idCliente + " | Tour elegido (ciudad): " + tourElegido;
    }
}
