package model;

import javax.swing.*;

public class ExcursionCultural extends ServicioTuristico implements Registrable{
    private String lugarHistorico;

    public ExcursionCultural(){
    }
    public ExcursionCultural(String nombre, int cantidadHoras, String lugarHistorico){
        super(nombre, cantidadHoras);
        this.lugarHistorico = lugarHistorico;
    }
    public String getLugarHistorico(){
        return lugarHistorico;
    }
    public void setLugarHistorico(String lugarHistorico){
        this.lugarHistorico = lugarHistorico;
    }
    @Override
    public void mostrarInformacion(){
        //Se pone un mensaje distinto para mostrar que a pesar de que el metodo se llama igual, se puede ejecutar distinto segun la clase.
        System.out.println("\nInformación sobre tour de excursión cultural:");
        System.out.println("La excursión cultural consiste en visitar lugares históricos del país.");
        System.out.println("Nombre tour: " + nombre);
        System.out.println("Duración de horas: " + duracionHoras);
        System.out.println("Lugar histórico: " + lugarHistorico);
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

        area.setText("Nombre servicio: " + nombre + " | Duración (horas): "
                + duracionHoras + " | Lugar historico: " + lugarHistorico);

        ventanaInformacion.setLocationRelativeTo(null);
        ventanaInformacion.setVisible(true);
        area.setEditable(false);
        area.setFocusable(false);
    }
    @Override
    public String toString(){
        return "Nombre servicio: " + nombre + " | Duración (horas): " + duracionHoras + " | Lugar Historico a visitar: " + lugarHistorico;
    }
}
