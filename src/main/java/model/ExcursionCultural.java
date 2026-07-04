package model;

public class ExcursionCultural extends ServicioTuristico{
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
    public String toString(){
        return "Nombre servicio: " + nombre + " | Duración (horas): " + duracionHoras + " | Lugar Historico a visitar: " + lugarHistorico;
    }
}
