package model;

public class RutaGastronomica extends ServicioTuristico{
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
    public String toString(){
        return "Nombre servicio: " + nombre + " | Duración (horas): " + duracionHoras + " | Paradas: " + numeroDeParadas;
    }
}
