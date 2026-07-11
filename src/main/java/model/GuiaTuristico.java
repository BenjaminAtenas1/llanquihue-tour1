package model;

import javax.swing.*;

public class GuiaTuristico extends Persona implements Registrable{
    private String regionDeTrabajo;
    private double añosEnEmpresa;

    public GuiaTuristico(){
    }
    public GuiaTuristico(String nombreCompleto, String rut, String regionDeTrabajo, double añosEnEmpresa){
        super(nombreCompleto, rut);
        this.regionDeTrabajo = regionDeTrabajo;
        this.añosEnEmpresa = añosEnEmpresa;
    }
    public String getRegionDeTrabajo() {
        return regionDeTrabajo;
    }
    public void setRegionDeTrabajo(String regionDeTrabajo) {
        this.regionDeTrabajo = regionDeTrabajo;
    }
    public double getAñosEnEmpresa() {
        return añosEnEmpresa;
    }
    public void setAñosEnEmpresa(double añosEnEmpresa) {
        this.añosEnEmpresa = añosEnEmpresa;
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

        area.setText("El guía turístico " + nombreCompleto + " se encarga de los tour de la región " + regionDeTrabajo + " y tiene " + añosEnEmpresa
                + " años en la empresa.");

        ventanaInformacion.setLocationRelativeTo(null);
        ventanaInformacion.setVisible(true);
        area.setEditable(false);
        area.setFocusable(false);

    }

    @Override
    public String toString(){
        return "Nombre: " + nombreCompleto + " | Rut: " + rut + " | Region de trabajo: " + regionDeTrabajo
                + " | Años en la empresa: " + añosEnEmpresa;
    }
}
