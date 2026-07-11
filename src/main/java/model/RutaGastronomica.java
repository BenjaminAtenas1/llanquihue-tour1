package model;

import javax.swing.*;

public class RutaGastronomica extends ServicioTuristico implements Registrable{
    private int numeroDeParadas;

    public RutaGastronomica(){
    }
    public RutaGastronomica(String nombre, int duracionHoras, int numeroDeParadas){
        super (nombre, duracionHoras);
        this.numeroDeParadas = numeroDeParadas;
    }
    public int getNumeroDeParadas(){
        return numeroDeParadas;
    }
    public void setNumeroDeParadas(int numeroDeParadas){
        this.numeroDeParadas = numeroDeParadas;
    }
    @Override
    public void mostrarInformacion(){
        //Se pone un mensaje distinto para mostrar que a pesar de que el metodo se llama igual, se puede ejecutar distinto segun la clase.
        System.out.println("\nInformación sobre tour de ruta gastronómica:");
        System.out.println("El tour gastronómico consiste en probar comidas de todo el mundo.");
        System.out.println("Nombre tour: " + nombre);
        System.out.println("Duración de horas: " + duracionHoras);
        System.out.println("Número de paradas: " + numeroDeParadas);
    }

    @Override
    public void mostrarResumen(){
        JFrame ventanaInformacion = new JFrame("Información Ruta Gastronómica");
        ventanaInformacion.setSize(400, 370);
        ventanaInformacion.setLayout(null);
        ventanaInformacion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea area = new JTextArea();
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(10,50,360,260);
        ventanaInformacion.add(scroll);

        area.setText("Nombre servicio: " + nombre + " | Duración (horas): "
                + duracionHoras + " | Paradas: " + numeroDeParadas);

        ventanaInformacion.setLocationRelativeTo(null);
        ventanaInformacion.setVisible(true);
        area.setEditable(false);
        area.setFocusable(false);
    }


    @Override
    public String toString(){
        return "Nombre servicio: " + nombre + " | Duración (horas): " + duracionHoras + " | Paradas: " + numeroDeParadas;
    }
}
