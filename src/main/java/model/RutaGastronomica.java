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
    public String toString(){
        return "Nombre servicio: " + getNombre() + " | Duración (horas): " + getDuracionHoras() + " | Paradas: " + numeroDeParadas;
    }
}
