package data;

import model.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorDatos {
    private ArrayList<Tour> listaTours;
    private ArrayList<ServicioTuristico> listaServiciosTuristicos;

    public GestorDatos() {
        listaTours = new ArrayList<>();
        listaServiciosTuristicos = new ArrayList<>();

    }

    public ArrayList<Tour> getListaTours() {
        return listaTours;
    }

    public void setListaTours(ArrayList<Tour> listaTours) {
        this.listaTours = listaTours;
    }
    public ArrayList<ServicioTuristico> getListaServiciosTuristicos(){
        return listaServiciosTuristicos;
    }
    public void setListaServiciosTuristicos(ArrayList<ServicioTuristico> listaServiciosTuristicos){
        this.listaServiciosTuristicos = listaServiciosTuristicos;
    }


    public void cargarTours(){
        try{
            listaTours.clear();
            FileReader fr = new FileReader("src/main/resources/tours.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;

            while((linea = br.readLine()) != null){
                String[] datos = linea.split(";");
                String ciudad = datos[0];
                int cantidadMaxPersonas = Integer.parseInt(datos[1]);
                int precio = Integer.parseInt(datos[2]);

                Tour tour = new Tour(ciudad,cantidadMaxPersonas,precio);

                listaTours.add(tour);
            }

            br.close();

        }catch (Exception e){
            System.out.println("Error al leer la información");
        }
    }

    //A gregado para tareas semana 6
    //A continuación se muestra aplicacines de polimorfismo correspondiente a lo trabajado en la semana 6.
    public void verServicioTuristico(){
        List<ServicioTuristico> listaServiciosTuristicos = new ArrayList<>();

        //Dos objetos de la subclase RutaGastronomica
        listaServiciosTuristicos.add(new RutaGastronomica("Ruta Asiatica", 4, 3));
        listaServiciosTuristicos.add(new RutaGastronomica("Ruta Chilena", 4, 4));

        //Dos objetos de la subclase Paseo Lacustre
        listaServiciosTuristicos.add(new PaseoLacustre("Paseo en la Pinta", 2, "Carabela"));
        listaServiciosTuristicos.add(new PaseoLacustre("Paseo en la Esmeralda", 3, "Corbeta"));

        //Dos objetos de la subclase Excursión Cultural
        listaServiciosTuristicos.add(new ExcursionCultural("Excursión nocturna", 2, "Centro Cultural Casona Dubois"));
        listaServiciosTuristicos.add(new ExcursionCultural("Excursión al museo", 3, "Museo nacional de Bellas Artes"));

        for (ServicioTuristico servicios : listaServiciosTuristicos){
            System.out.println(servicios);
        }
    }

    @Override
    public String toString() {
        return "GestorDatos{" +
                "listaTours=" + listaTours +
                '}';
    }
}
