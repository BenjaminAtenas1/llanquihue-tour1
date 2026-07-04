package model;
    //Clase cambiada a abstractar para ejemplificar un método mostrar informacion
public abstract class ServicioTuristico {
    //Se ha cambiado a protected tras lo aprendido en la clase de la semana 7
    protected String nombre;
    protected int duracionHoras;

    public ServicioTuristico(){
    }
    public ServicioTuristico(String nombre, int duracionHoras){
         this.nombre = nombre;
         this.duracionHoras = duracionHoras;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public int getDuracionHoras(){
        return duracionHoras;
    }
    public void setDuracionHoras(int duracionHoras){
        this.duracionHoras = duracionHoras;
    }
    public abstract void mostrarInformacion();
        //El metodo será distinto en cada clase para mostrar que cambia a pesar de llamarse igual en todas las clases

    @Override
    public String toString(){
        return "Nombre servicio: " + nombre + " | Duración (horas): " + duracionHoras;
    }

}
