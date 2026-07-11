package model;

import javax.swing.*;

public class PaseoLacustre extends ServicioTuristico implements Registrable{
    private String tipoEmbarcacion;

    public PaseoLacustre(){
    }
    public PaseoLacustre(String nombre, int duracionHoras, String tipoEmbarcacion){
        super(nombre, duracionHoras);
        this.tipoEmbarcacion = tipoEmbarcacion;
    }
    public String getTipoEmbarcacion(){
        return tipoEmbarcacion;
    }
    public void setTipoEmbarcacion(String tipoEmbarcacion){
        this.tipoEmbarcacion = tipoEmbarcacion;
    }
    @Override
    public void mostrarInformacion(){
        //Se pone un mensaje distinto para mostrar que a pesar de que el metodo se llama igual, se puede ejecutar distinto segun la clase.
        System.out.println("\nInformación sobre tour de paseo lacustre:");
        System.out.println("El paseo lacustre consiste en navegar en algun tipo de embarcación.");
        System.out.println("Nombre tour: " + nombre);
        System.out.println("Duración de horas: " + duracionHoras);
        System.out.println("Tipo de embarcación: " + tipoEmbarcacion);
    }

    @Override
    public void mostrarResumen(){
        JFrame ventanaInformacion = new JFrame("Información Paseos Lacustres");
        ventanaInformacion.setSize(400, 370);
        ventanaInformacion.setLayout(null);
        ventanaInformacion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea area = new JTextArea();
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(10,50,360,260);
        ventanaInformacion.add(scroll);

        area.setText("Nombre servicio: " + nombre + " | Duración (horas): "
                + duracionHoras + " | Tipo de embarcación: " + tipoEmbarcacion);

        ventanaInformacion.setLocationRelativeTo(null);
        ventanaInformacion.setVisible(true);
        area.setEditable(false);
        area.setFocusable(false);
    }
    @Override
    public String toString(){
        return "Nombre servicio: " + nombre + " | Duración (horas): " + duracionHoras + " | Tipo de embarcación: " + tipoEmbarcacion;
    }
}
