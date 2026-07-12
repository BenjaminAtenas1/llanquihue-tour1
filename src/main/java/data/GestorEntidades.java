package data;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class GestorEntidades {
    List<Registrable> listaRegistrables;

    public GestorEntidades(){
    }
    public GestorEntidades(List<Registrable> listaRegistrables){
        listaRegistrables = new ArrayList<>();
    }
    public List<Registrable> getListaRegistrables() {
        return listaRegistrables;
    }
    public void setListaRegistrables(List<Registrable> listaRegistrables) {
        this.listaRegistrables = listaRegistrables;
    }
    public void registrarCliente(){
        List<Registrable> listaRegistrables = new ArrayList<>();

        //Dos objetos de la subclase RutaGastronomica
        //listaRegistrables.add(new RutaGastronomica("Ruta Peruana", 4, 3));
        //listaRegistrables.add(new RutaGastronomica("Ruta China", 4, 4));

        //Dos objetos de la subclase Paseo Lacustre
        //listaRegistrables.add(new PaseoLacustre("Paseo en lancha", 2, "Lancha"));
        //listaRegistrables.add(new PaseoLacustre("Paseo en la moto acuática", 3, "Moto acuática"));

        //Dos objetos de la subclase Excursión Cultural
        //listaRegistrables.add(new ExcursionCultural("Excursión de terror", 2, "Cementerio general"));
        //listaRegistrables.add(new ExcursionCultural("Excursión al persa", 3, "Persa Victor Manuel"));

        //3 Objetos que heredan de persona
        //listaRegistrables.add(new GuiaTuristico("Ramon Valdes", "16.252.135-5", "Puerto Montt", 3));
        //listaRegistrables.add(new Cliente("Florinda Meza", "65.134.816-5", 654321, "Ruta China"));
        //listaRegistrables.add(new Jefe("Roberto Gomez Bolaños", "52.457.643-5", "Metropolitana", 9));

    }
}
