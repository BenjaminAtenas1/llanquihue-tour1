package model;

public class PaseoLacustre extends ServicioTuristico{
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
    public String toString(){
        return "Nombre servicio: " + nombre + " | Duración (horas): " + duracionHoras + " | Tipo de embarcación: " + tipoEmbarcacion;
    }
}
