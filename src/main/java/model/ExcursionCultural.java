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
    public String toString(){
        return "Nombre servicio: " + getNombre() + " | Duración (horas): " + getDuracionHoras() + " | Lugar Historico a visitar: " + lugarHistorico;
    }
}
