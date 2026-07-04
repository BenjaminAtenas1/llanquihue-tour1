package data;

import model.ExcursionCultural;
import model.PaseoLacustre;
import model.RutaGastronomica;
import model.ServicioTuristico;

import java.util.ArrayList;
import java.util.List;

public class GestorServicios {
    List<ServicioTuristico> listaServiciosTuristicos2;

    public GestorServicios(){
    }
    public GestorServicios(List<ServicioTuristico> listaServiciosTuristicos2){
        listaServiciosTuristicos2 = new ArrayList<>();
    }
    public List<ServicioTuristico> getListaServiciosTuristicos2() {
        return listaServiciosTuristicos2;
    }
    public void setListaServiciosTuristicos2(ArrayList<ServicioTuristico> listaServiciosTuristico2s) {
        this.listaServiciosTuristicos2 = listaServiciosTuristicos2;
    }
    public void verServicioTuristico2(){
        List<ServicioTuristico> listaServiciosTuristicos2 = new ArrayList<>();

        //Dos objetos de la subclase RutaGastronomica
        listaServiciosTuristicos2.add(new RutaGastronomica("Ruta Peruana", 4, 3));
        listaServiciosTuristicos2.add(new RutaGastronomica("Ruta China", 4, 4));

        //Dos objetos de la subclase Paseo Lacustre
        listaServiciosTuristicos2.add(new PaseoLacustre("Paseo en lancha", 2, "Lancha"));
        listaServiciosTuristicos2.add(new PaseoLacustre("Paseo en la moto acuática", 3, "Moto acuática"));

        //Dos objetos de la subclase Excursión Cultural
        listaServiciosTuristicos2.add(new ExcursionCultural("Excursión de terror", 2, "Cementerio general"));
        listaServiciosTuristicos2.add(new ExcursionCultural("Excursión al persa", 3, "Persa Victor Manuel"));

        for (ServicioTuristico servicios : listaServiciosTuristicos2){
            //Acá es donde se implementa el metodo "mostrarInformación"
            if (servicios instanceof RutaGastronomica) {
                servicios.mostrarInformacion();
            }else if (servicios instanceof PaseoLacustre){
                servicios.mostrarInformacion();
            }else if (servicios instanceof ExcursionCultural) {
                servicios.mostrarInformacion();
            //Si bien la tarea especifica que no es necesario usar instanceof, lo uso para que la información se muestre de forma más ordenada
            }
        }
    }
}
