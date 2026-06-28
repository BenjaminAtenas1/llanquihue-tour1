package ui;

import data.GestorDatos;
import model.Cliente;
import model.Tour;

public class Main {
    public static void main (String[] arg){
        GestorDatos datos = new GestorDatos();
        //Acá podemos ver que se muestra la información del archivo tours.txt con el metodo cargarTours separados por el metodo split
        datos.cargarTours();

        System.out.println("\n>LISTA DE TOURS<");
        //Acá se muestra los datos del archivo tours.txt con un bucle for each
        for (Tour tour : datos.getListaTours()){
            System.out.println(tour);
        }

        //Acá se muestra un ejemplo de que se filtra por una condicion (en este caso, si el tour es para 6 o más personas)
        System.out.println("\n>TOURS PARA 6 O MAS PERSONAS<");

        for (Tour tour : datos.getListaTours()){
            if (tour.getCantidadMaxPersonas() >= 6){
                System.out.println(tour);
            }
        }
        //Acá se muestra otro ejemplo que se filtra por una condición (ahora por precio)
        System.out.println("\n>TOURS SOBRE $100.000<");
        for(Tour tour :datos.getListaTours()){
            if(tour.getPrecio() > 100000){
                System.out.println(tour);
            }
        }
        System.out.println(" ");

        //A continuación crearemos un cliente al cual podremos revisar los datos del tour que eligió
        Cliente cliente1 = new Cliente();
        cliente1.setNombreCompleto("Sheldon Cooper");
        cliente1.setRut("12.124.124-1");
        cliente1.setIdCliente(142536);
        cliente1.setTourElegido("Puerto Montt");
        boolean encontrado = false;
        for(Tour tour : datos.getListaTours()){

            if(cliente1.getTourElegido().equalsIgnoreCase(tour.getCiudad())){
                System.out.println(cliente1.toString());
                System.out.println("Datos tour elegido: ");
                System.out.println(tour);
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println("Tour asignado al cliente no existe.");
        }

        System.out.println(" ");

        //A continuación crearemos un cliente al cual podremos revisar los datos del tour que eligió
        Cliente cliente2 = new Cliente();
        cliente2.setNombreCompleto("Howard Wolowitz");
        cliente2.setRut("21.212.212-1");
        cliente2.setIdCliente(654321);
        cliente2.setTourElegido("Raccon city");
        boolean encontrado2 = false;
        for(Tour tour : datos.getListaTours()){

            if(cliente2.getTourElegido().equalsIgnoreCase(tour.getCiudad())){
                System.out.println("Datos cliente: ");
                System.out.println(cliente2.toString());
                System.out.println("Datos tour elegido: ");
                System.out.println(tour);
                encontrado2 = true;
            }
        }
        if(!encontrado2){
            System.out.println("Datos cliente: ");
            System.out.println(cliente2.toString());
            System.out.println("Tour asignado al cliente no existe.");
        }

        //A continuación lo implementado en la semana 6
        GestorDatos datosServicios = new GestorDatos();
        System.out.println("\n>SERVICIOS TURISTICOS<");
        System.out.println("A continuación se mostarán los servicios turísticos disponibles:\n");
        datosServicios.verServicioTuristico();

    }
}
