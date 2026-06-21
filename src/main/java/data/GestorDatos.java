package data;

import model.Tour;
import model.Cliente;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GestorDatos {
    private ArrayList<Tour> listaTours;


    public GestorDatos() {
        listaTours = new ArrayList<>();
    }

    public ArrayList<Tour> getListaTours() {
        return listaTours;
    }

    public void setListaTours(ArrayList<Tour> listaTours) {
        this.listaTours = listaTours;
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

    @Override
    public String toString() {
        return "GestorDatos{" +
                "listaTours=" + listaTours +
                '}';
    }
}
