package model;

import javax.swing.*;

public class Jefe extends Persona implements Registrable{
    private String regionAcargo;
    private double añosEnEmpresa;

    public Jefe(){
    }
    public Jefe(String nombreCompleto, String rut, String regionAcargo, double añosEnEmpresa){
        super(nombreCompleto, rut);
        this.regionAcargo = regionAcargo;
        this.añosEnEmpresa = añosEnEmpresa;
    }
    public String getRegionAcargo() {
        return regionAcargo;
    }
    public void setRegionAcargo(String regionAcargo) {
        this.regionAcargo = regionAcargo;
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

        area.setText("El jefe " + nombreCompleto + " es el encargado de la región " + regionAcargo + " y tiene " + añosEnEmpresa
                        + " años en la empresa.");

        ventanaInformacion.setLocationRelativeTo(null);
        ventanaInformacion.setVisible(true);
        area.setEditable(false);
        area.setFocusable(false);

    }


    @Override
    public String toString(){
        return "Nombre: " + nombreCompleto + " | Rut: " + rut + " | Region a cargo: " + regionAcargo
                + " | Años en la empresa: " + añosEnEmpresa;
    }

}
