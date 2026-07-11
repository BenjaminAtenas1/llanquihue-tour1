package ui;

import data.GestorDatos;
import data.GestorServicios;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;


public class Main extends JFrame {
    //Semana 8
    ArrayList<Registrable> listaRegistrables = new ArrayList<>();

    public Main() {
        setTitle("Información registrables");
        setSize(170, 190);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 80, 15, 80));

        JButton botonRegistrar = new JButton("Registrar");
        JButton botonInformacion = new JButton("Ver informacion");
        JButton botonSalir = new JButton("Salir");

        panel.add(botonRegistrar);
        panel.add(botonInformacion);
        panel.add(botonSalir);

        add(panel, BorderLayout.CENTER);

        botonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarAlgo();
            }
        });
        botonInformacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verInformacion();
            }
        });
        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Has salido");
                System.exit(0);
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void registrarAlgo() {

        JOptionPane.showMessageDialog(null, "A continuación, ingrese su opción", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

        JFrame frame = new JFrame("Registro");
        frame.setDefaultCloseOperation((JFrame.DISPOSE_ON_CLOSE));
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        JRadioButton opcionPersona = new JRadioButton("Persona (Cliente o trabajador)");
        JRadioButton opcionServicio = new JRadioButton("Servicios");

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(opcionPersona);
        grupo.add(opcionServicio);

        JButton botonAceptar = new JButton("Confirmar");

        panel.add(opcionPersona);
        panel.add(opcionServicio);
        panel.add(botonAceptar);


        frame.add(panel);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (opcionPersona.isSelected()) {
                    JFrame ventana = new JFrame("Registro de persona");
                    ventana.setDefaultCloseOperation((JFrame.DISPOSE_ON_CLOSE));
                    ventana.setSize(300, 200);

                    JPanel panelPersona = new JPanel();
                    JRadioButton opcionCliente = new JRadioButton("Cliente");
                    JRadioButton opcionGuia = new JRadioButton("Guia turístico");
                    JRadioButton opcionJefe = new JRadioButton("Jefe");

                    ButtonGroup grupoPersona = new ButtonGroup();
                    grupoPersona.add(opcionCliente);
                    grupoPersona.add(opcionGuia);
                    grupoPersona.add(opcionJefe);

                    JButton botonAceptarPersona = new JButton("Confirmar");

                    panelPersona.add(opcionCliente);
                    panelPersona.add(opcionGuia);
                    panelPersona.add(opcionJefe);
                    panelPersona.add(botonAceptarPersona);

                    ventana.add(panelPersona);

                    ventana.setVisible(true);
                    ventana.setLocationRelativeTo(null);

                    botonAceptarPersona.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            if (opcionCliente.isSelected()) {
                                JOptionPane.showMessageDialog(null, "A continuación ingrese la información del cliente", "Registro de cliente", JOptionPane.INFORMATION_MESSAGE);
                                JFrame ventanaCliente = new JFrame("Registro de cliente.");
                                ventanaCliente.setSize(820, 120);
                                ventanaCliente.setLayout(null);
                                ventanaCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                JLabel labelNombre = new JLabel("Nombre: ");
                                JLabel labelRut = new JLabel("Rut: ");
                                JLabel labelID = new JLabel("ID: ");
                                JLabel labelTour = new JLabel("Tour elegido: ");

                                JTextField campoNombre = new JTextField();
                                JTextField campoRut = new JTextField();
                                JTextField campoID = new JTextField();
                                JTextField campoTour = new JTextField();

                                JButton botonAgregar = new JButton("Agregar Cliente");

                                labelNombre.setBounds(10, 10, 60, 25);
                                campoNombre.setBounds(61, 13, 100, 20);

                                labelRut.setBounds(165, 10, 150, 25);
                                campoRut.setBounds(200, 13, 100, 20);

                                labelID.setBounds(320, 10, 150, 25);
                                campoID.setBounds(345, 13, 100, 20);

                                labelTour.setBounds(455, 10, 150, 25);
                                campoTour.setBounds(535, 13, 100, 20);

                                botonAgregar.setBounds(340, 45, 150, 25);

                                ventanaCliente.add(labelNombre);
                                ventanaCliente.add(campoNombre);
                                ventanaCliente.add(labelRut);
                                ventanaCliente.add(campoRut);
                                ventanaCliente.add(labelID);
                                ventanaCliente.add(campoID);
                                ventanaCliente.add(labelTour);
                                ventanaCliente.add(campoTour);

                                ventanaCliente.add(botonAgregar);

                                ventanaCliente.setLocationRelativeTo(null);
                                ventanaCliente.setVisible(true);


                                botonAgregar.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        if (campoNombre.getText().trim().isEmpty() || campoRut.getText().trim().isEmpty() || campoID.getText().trim().isEmpty() || campoTour.getText().trim().isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos solicitados antes de registrar", "Error", JOptionPane.ERROR_MESSAGE);
                                            return;
                                        }
                                        String nombre = campoNombre.getText();
                                        String rut = campoRut.getText();
                                        try {
                                            int id = Integer.parseInt(campoID.getText());
                                            if (id <= 0) {
                                                JOptionPane.showMessageDialog(null, "Los valores deben ser mayores a cero", "Error", JOptionPane.ERROR_MESSAGE); //Controla que no ingresen números negativos
                                                return;
                                            }

                                            String tour = campoTour.getText();

                                            listaRegistrables.add(new Cliente(nombre, rut, id, tour));

                                        } catch (NumberFormatException ex) {
                                            JOptionPane.showMessageDialog(null, "El ID debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
                                            return;
                                        }
                                        JOptionPane.showMessageDialog(null, "Registro exitoso", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                                        ventanaCliente.dispose();
                                    }
                                });
                            } else if (opcionGuia.isSelected()) {
                                JOptionPane.showMessageDialog(null, "A continuación ingrese la información del guía turistico", "Registro de guía", JOptionPane.INFORMATION_MESSAGE);
                                JFrame ventanaGuia = new JFrame("Registro de guía.");
                                ventanaGuia.setSize(820, 120);
                                ventanaGuia.setLayout(null);
                                ventanaGuia.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                JLabel labelNombreGuia = new JLabel("Nombre: ");
                                JLabel labelRutGuia = new JLabel("Rut: ");
                                JLabel labelRegionGuia = new JLabel("Región de trabajo: ");
                                JLabel labelAñosGuia = new JLabel("Años en la empresa: ");

                                JTextField campoNombreGuia = new JTextField();
                                JTextField campoRutGuia = new JTextField();
                                JTextField campoRegionGuia = new JTextField();
                                JTextField campoAñosGuia = new JTextField();

                                JButton botonAgregarGuia = new JButton("Agregar guía");

                                labelNombreGuia.setBounds(10, 10, 60, 25);
                                campoNombreGuia.setBounds(61, 13, 100, 20);

                                labelRutGuia.setBounds(165, 10, 150, 25);
                                campoRutGuia.setBounds(215, 13, 100, 20);

                                labelRegionGuia.setBounds(320, 10, 150, 25);
                                campoRegionGuia.setBounds(455, 13, 100, 20);

                                labelAñosGuia.setBounds(560, 10, 150, 25);
                                campoAñosGuia.setBounds(680, 13, 100, 20);

                                botonAgregarGuia.setBounds(340, 45, 150, 25);

                                ventanaGuia.add(labelNombreGuia);
                                ventanaGuia.add(campoNombreGuia);
                                ventanaGuia.add(labelRutGuia);
                                ventanaGuia.add(campoRutGuia);
                                ventanaGuia.add(labelRegionGuia);
                                ventanaGuia.add(campoRegionGuia);
                                ventanaGuia.add(labelAñosGuia);
                                ventanaGuia.add(campoAñosGuia);

                                ventanaGuia.add(botonAgregarGuia);

                                ventanaGuia.setLocationRelativeTo(null);
                                ventanaGuia.setVisible(true);

                                botonAgregarGuia.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        if (campoNombreGuia.getText().trim().isEmpty() || campoRutGuia.getText().trim().isEmpty() || campoRegionGuia.getText().trim().isEmpty() || campoAñosGuia.getText().trim().isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos solicitados antes de registrar", "Error", JOptionPane.ERROR_MESSAGE);
                                            return;
                                        }
                                        String nombre = campoNombreGuia.getText();
                                        String rut = campoRutGuia.getText();
                                        String region = campoRegionGuia.getText();
                                        try {
                                            double años = Double.parseDouble(campoAñosGuia.getText());
                                            if (años <= 0) {
                                                JOptionPane.showMessageDialog(null, "Los valores deben ser mayores a cero", "Error", JOptionPane.ERROR_MESSAGE); //Controla que no ingresen números negativos
                                                return;
                                            }
                                            listaRegistrables.add(new GuiaTuristico(nombre, rut, region, años));

                                        } catch (NumberFormatException ex) {
                                            JOptionPane.showMessageDialog(null, "Los años en la empresa deben ser números.", "Error", JOptionPane.ERROR_MESSAGE);
                                            return;
                                        }

                                        JOptionPane.showMessageDialog(null, "Registro exitoso", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

                                        ventanaGuia.dispose();
                                    }
                                });
                            } else if (opcionJefe.isSelected()) {
                                JOptionPane.showMessageDialog(null, "A continuación ingrese la información del jefe", "Registro de jefe", JOptionPane.INFORMATION_MESSAGE);
                                JFrame ventanaJefe = new JFrame("Registro de jefe.");
                                ventanaJefe.setSize(820, 120);
                                ventanaJefe.setLayout(null);
                                ventanaJefe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                JLabel labelNombreJefe = new JLabel("Nombre: ");
                                JLabel labelRutJefe = new JLabel("Rut: ");
                                JLabel labelRegionJefe = new JLabel("Región a cargo: ");
                                JLabel labelAñosJefe = new JLabel("Años en la empresa: ");

                                JTextField campoNombreJefe = new JTextField();
                                JTextField campoRutJefe = new JTextField();
                                JTextField campoRegionJefe = new JTextField();
                                JTextField campoAñosJefe = new JTextField();

                                JButton botonAgregarJefe = new JButton("Agregar Jefe");

                                labelNombreJefe.setBounds(10, 10, 60, 25);
                                campoNombreJefe.setBounds(61, 13, 100, 20);

                                labelRutJefe.setBounds(165, 10, 150, 25);
                                campoRutJefe.setBounds(195, 13, 100, 20);

                                labelRegionJefe.setBounds(300, 10, 150, 25);
                                campoRegionJefe.setBounds(390, 13, 100, 20);

                                labelAñosJefe.setBounds(515, 10, 150, 25);
                                campoAñosJefe.setBounds(635, 13, 100, 20);

                                botonAgregarJefe.setBounds(340, 45, 150, 25);

                                ventanaJefe.add(labelNombreJefe);
                                ventanaJefe.add(campoNombreJefe);
                                ventanaJefe.add(labelRutJefe);
                                ventanaJefe.add(campoRutJefe);
                                ventanaJefe.add(labelRegionJefe);
                                ventanaJefe.add(campoRegionJefe);
                                ventanaJefe.add(labelAñosJefe);
                                ventanaJefe.add(campoAñosJefe);

                                ventanaJefe.add(botonAgregarJefe);

                                ventanaJefe.setLocationRelativeTo(null);
                                ventanaJefe.setVisible(true);

                                botonAgregarJefe.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        if (campoNombreJefe.getText().trim().isEmpty() || campoRutJefe.getText().trim().isEmpty() || campoRegionJefe.getText().trim().isEmpty() || campoAñosJefe.getText().trim().isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos solicitados antes de registrar", "Error", JOptionPane.ERROR_MESSAGE);
                                            return;
                                        }
                                        String nombre = campoNombreJefe.getText();
                                        String rut = campoRutJefe.getText();
                                        String region = campoRegionJefe.getText();
                                        try {
                                            double años = Double.parseDouble(campoAñosJefe.getText());
                                            if (años <= 0) {
                                                JOptionPane.showMessageDialog(null, "Los valores deben ser mayores a cero", "Error", JOptionPane.ERROR_MESSAGE); //Controla que no ingresen números negativos
                                                return;
                                            }


                                            listaRegistrables.add(new Jefe(nombre, rut, region, años));
                                        } catch (NumberFormatException ex) {
                                            JOptionPane.showMessageDialog(null, "Los años en la empresa deben ser números.", "Error", JOptionPane.ERROR_MESSAGE);
                                            return;
                                        }
                                        JOptionPane.showMessageDialog(null, "Registro exitoso", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                                        ventanaJefe.dispose();
                                    }
                                });
                            }

                        }
                    });


                } else if (opcionServicio.isSelected()) {
                    JFrame ventanaServicio = new JFrame("Registro de servicio");
                    ventanaServicio.setDefaultCloseOperation((JFrame.DISPOSE_ON_CLOSE));
                    ventanaServicio.setSize(300, 200);

                    JPanel panelServicio = new JPanel();
                    JRadioButton opcionLacustre = new JRadioButton("Paseo Lacustre");
                    JRadioButton opcionCultura = new JRadioButton("Excursión cultural");
                    JRadioButton opcionGastronomica = new JRadioButton("Ruta Gastronomica");

                    ButtonGroup grupoServicio = new ButtonGroup();
                    grupoServicio.add(opcionLacustre);
                    grupoServicio.add(opcionCultura);
                    grupoServicio.add(opcionGastronomica);

                    JButton botonAceptarServicio = new JButton("Confirmar");

                    panelServicio.add(opcionLacustre);
                    panelServicio.add(opcionCultura);
                    panelServicio.add(opcionGastronomica);
                    panelServicio.add(botonAceptarServicio);

                    ventanaServicio.add(panelServicio);

                    ventanaServicio.setVisible(true);
                    ventanaServicio.setLocationRelativeTo(null);

                    botonAceptarServicio.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            if (opcionLacustre.isSelected()) {
                                JOptionPane.showMessageDialog(null, "A continuación ingrese la información del tour lacustre", "Registro de tour", JOptionPane.INFORMATION_MESSAGE);
                                JFrame ventanaTour = new JFrame("Registro de tour lacustre.");
                                ventanaTour.setSize(820, 120);
                                ventanaTour.setLayout(null);
                                ventanaTour.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                JLabel labelTour = new JLabel("Nombre tour: ");
                                JLabel labelHoras = new JLabel("Duración de horas: ");
                                JLabel labelEmbarcacion = new JLabel("Tipo de embarcación: ");


                                JTextField campoTour = new JTextField();
                                JTextField campoHoras = new JTextField();
                                JTextField campoEmbarcacion = new JTextField();


                                JButton botonAgregarTour = new JButton("Agregar Tour");

                                labelTour.setBounds(10, 10, 85, 25);
                                campoTour.setBounds(90, 13, 100, 20);

                                labelHoras.setBounds(195, 10, 150, 25);
                                campoHoras.setBounds(310, 13, 100, 20);

                                labelEmbarcacion.setBounds(415, 10, 150, 25);
                                campoEmbarcacion.setBounds(540, 13, 100, 20);

                                botonAgregarTour.setBounds(340, 45, 150, 25);

                                ventanaTour.add(labelTour);
                                ventanaTour.add(campoTour);
                                ventanaTour.add(labelHoras);
                                ventanaTour.add(campoHoras);
                                ventanaTour.add(labelEmbarcacion);
                                ventanaTour.add(campoEmbarcacion);


                                ventanaTour.add(botonAgregarTour);

                                ventanaTour.setLocationRelativeTo(null);
                                ventanaTour.setVisible(true);

                                botonAgregarTour.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        if (campoTour.getText().trim().isEmpty() || campoHoras.getText().trim().isEmpty() || campoEmbarcacion.getText().trim().isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos solicitados antes de registrar", "Error", JOptionPane.ERROR_MESSAGE);
                                            return;
                                        }
                                        String tour = campoTour.getText();

                                        try {
                                            int horas = Integer.parseInt(campoHoras.getText());
                                            if (horas <= 0) {
                                                JOptionPane.showMessageDialog(null, "Los valores deben ser mayores a cero", "Error", JOptionPane.ERROR_MESSAGE); //Controla que no ingresen números negativos
                                                return;
                                            }

                                            String embarcacion = campoEmbarcacion.getText();

                                            listaRegistrables.add(new PaseoLacustre(tour, horas, embarcacion));

                                        } catch (NumberFormatException ex) {
                                            JOptionPane.showMessageDialog(null, "Las horas deben ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
                                            return;
                                        }
                                        JOptionPane.showMessageDialog(null, "Registro exitoso", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                                        ventanaTour.dispose();
                                    }
                                });
                            } else if (opcionCultura.isSelected()) {

                                JOptionPane.showMessageDialog(null, "A continuación ingrese la información del tour cultural", "Registro de tour", JOptionPane.INFORMATION_MESSAGE);
                                JFrame ventanaExcursion = new JFrame("Registro de tour cultural.");
                                ventanaExcursion.setSize(820, 120);
                                ventanaExcursion.setLayout(null);
                                ventanaExcursion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                JLabel labelTour = new JLabel("Nombre tour: ");
                                JLabel labelHoras = new JLabel("Duración de horas: ");
                                JLabel labelLugar = new JLabel("Tipo de lugar: ");


                                JTextField campoTour = new JTextField();
                                JTextField campoHoras = new JTextField();
                                JTextField campoLugar = new JTextField();


                                JButton botonAgregarExcursion = new JButton("Agregar Tour");

                                labelTour.setBounds(10, 10, 85, 25);
                                campoTour.setBounds(90, 13, 100, 20);

                                labelHoras.setBounds(195, 10, 150, 25);
                                campoHoras.setBounds(310, 13, 100, 20);

                                labelLugar.setBounds(415, 10, 150, 25);
                                campoLugar.setBounds(500, 13, 100, 20);

                                botonAgregarExcursion.setBounds(340, 45, 150, 25);

                                ventanaExcursion.add(labelTour);
                                ventanaExcursion.add(campoTour);
                                ventanaExcursion.add(labelHoras);
                                ventanaExcursion.add(campoHoras);
                                ventanaExcursion.add(labelLugar);
                                ventanaExcursion.add(campoLugar);


                                ventanaExcursion.add(botonAgregarExcursion);

                                ventanaExcursion.setLocationRelativeTo(null);
                                ventanaExcursion.setVisible(true);

                                botonAgregarExcursion.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        if (campoTour.getText().trim().isEmpty() || campoHoras.getText().trim().isEmpty() || campoLugar.getText().trim().isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos solicitados antes de registrar", "Error", JOptionPane.ERROR_MESSAGE);
                                            return;
                                        }
                                        String tour = campoTour.getText();

                                        try {
                                            int horas = Integer.parseInt(campoHoras.getText());
                                            if (horas <= 0) {
                                                JOptionPane.showMessageDialog(null, "Los valores deben ser mayores a cero", "Error", JOptionPane.ERROR_MESSAGE); //Controla que no ingresen números negativos
                                                return;
                                            }

                                            String lugar = campoLugar.getText();

                                            listaRegistrables.add(new ExcursionCultural(tour, horas, lugar));

                                        } catch (NumberFormatException ex) {
                                            JOptionPane.showMessageDialog(null, "Las horas deben ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
                                            return;
                                        }
                                        JOptionPane.showMessageDialog(null, "Registro exitoso", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                                        ventanaExcursion.dispose();
                                    }
                                });
                            } else if (opcionGastronomica.isSelected()) {

                                JOptionPane.showMessageDialog(null, "A continuación ingrese la información del tour gastronómico", "Registro de tour", JOptionPane.INFORMATION_MESSAGE);
                                JFrame ventanaGastronomia = new JFrame("Registro de tour gastronómico.");
                                ventanaGastronomia.setSize(820, 120);
                                ventanaGastronomia.setLayout(null);
                                ventanaGastronomia.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                JLabel labelTour = new JLabel("Nombre tour: ");
                                JLabel labelHoras = new JLabel("Duración de horas: ");
                                JLabel labelParadas = new JLabel("Nro de paradas: ");


                                JTextField campoTour = new JTextField();
                                JTextField campoHoras = new JTextField();
                                JTextField campoParadas = new JTextField();


                                JButton botonAgregarGastronomia = new JButton("Agregar Tour");

                                labelTour.setBounds(10, 10, 85, 25);
                                campoTour.setBounds(90, 13, 100, 20);

                                labelHoras.setBounds(195, 10, 150, 25);
                                campoHoras.setBounds(310, 13, 100, 20);

                                labelParadas.setBounds(415, 10, 150, 25);
                                campoParadas.setBounds(510, 13, 100, 20);

                                botonAgregarGastronomia.setBounds(340, 45, 150, 25);

                                ventanaGastronomia.add(labelTour);
                                ventanaGastronomia.add(campoTour);
                                ventanaGastronomia.add(labelHoras);
                                ventanaGastronomia.add(campoHoras);
                                ventanaGastronomia.add(labelParadas);
                                ventanaGastronomia.add(campoParadas);


                                ventanaGastronomia.add(botonAgregarGastronomia);

                                ventanaGastronomia.setLocationRelativeTo(null);
                                ventanaGastronomia.setVisible(true);

                                botonAgregarGastronomia.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        if (campoTour.getText().trim().isEmpty() || campoHoras.getText().trim().isEmpty() || campoParadas.getText().trim().isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos solicitados antes de registrar", "Error", JOptionPane.ERROR_MESSAGE);
                                            return;
                                        }
                                        String tour = campoTour.getText();

                                        try {
                                            int horas = Integer.parseInt(campoHoras.getText());
                                            if (horas <= 0) {
                                                JOptionPane.showMessageDialog(null, "Los valores deben ser mayores a cero", "Error", JOptionPane.ERROR_MESSAGE); //Controla que no ingresen números negativos
                                                return;
                                            }

                                            int paradas = Integer.parseInt(campoParadas.getText());

                                            listaRegistrables.add(new RutaGastronomica(tour, horas, paradas));

                                        } catch (NumberFormatException ex) {
                                            JOptionPane.showMessageDialog(null, "Las horas deben ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
                                            return;
                                        }
                                        JOptionPane.showMessageDialog(null, "Registro exitoso", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                                        ventanaGastronomia.dispose();
                                    }
                                });

                            }


                        }
                    });

                }
            }
        });
    }
                    public void verInformacion(){
                        String[] opciones = {"Clientes","Guías","Jefes","Paseos Lacustres","Excursiones Culturales","Rutas Gastronómicas"};

                        String opcion = (String) JOptionPane.showInputDialog(null,"¿Qué información desea visualizar?","Información",JOptionPane.PLAIN_MESSAGE,
                                null, opciones,opciones[0]);

                        if (opcion == null) {
                            return;
                        }
                        for (Registrable registrable : listaRegistrables) {

                            if (opcion.equals("Clientes") && registrable instanceof Cliente) {
                                registrable.mostrarResumen();
                            } else if (opcion.equals("Guías") && registrable instanceof GuiaTuristico) {
                                registrable.mostrarResumen();
                            } else if (opcion.equals("Jefes") && registrable instanceof Jefe) {
                                registrable.mostrarResumen();
                            } else if (opcion.equals("Paseos Lacustres") && registrable instanceof PaseoLacustre) {
                                registrable.mostrarResumen();
                            } else if (opcion.equals("Excursiones Culturales") && registrable instanceof ExcursionCultural) {
                                registrable.mostrarResumen();
                            } else if (opcion.equals("Rutas Gastronómicas") && registrable instanceof RutaGastronomica) {
                                registrable.mostrarResumen();
                            }
                        }
                    }
                    public static void main (String[]arg){
                        GestorDatos datos = new GestorDatos();
                        //Acá podemos ver que se muestra la información del archivo tours.txt con el metodo cargarTours separados por el metodo split
                        datos.cargarTours();

                        System.out.println("\n>LISTA DE TOURS<");
                        //Acá se muestra los datos del archivo tours.txt con un bucle for each
                        for (Tour tour : datos.getListaTours()) {
                            System.out.println(tour);
                        }

                        //Acá se muestra un ejemplo de que se filtra por una condicion (en este caso, si el tour es para 6 o más personas)
                        System.out.println("\n>TOURS PARA 6 O MAS PERSONAS<");

                        for (Tour tour : datos.getListaTours()) {
                            if (tour.getCantidadMaxPersonas() >= 6) {
                                System.out.println(tour);
                            }
                        }
                        //Acá se muestra otro ejemplo que se filtra por una condición (ahora por precio)
                        System.out.println("\n>TOURS SOBRE $100.000<");
                        for (Tour tour : datos.getListaTours()) {
                            if (tour.getPrecio() > 100000) {
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
                        for (Tour tour : datos.getListaTours()) {

                            if (cliente1.getTourElegido().equalsIgnoreCase(tour.getCiudad())) {
                                System.out.println(cliente1.toString());
                                System.out.println("Datos tour elegido: ");
                                System.out.println(tour);
                                encontrado = true;
                            }
                        }
                        if (!encontrado) {
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
                        for (Tour tour : datos.getListaTours()) {

                            if (cliente2.getTourElegido().equalsIgnoreCase(tour.getCiudad())) {
                                System.out.println("Datos cliente: ");
                                System.out.println(cliente2.toString());
                                System.out.println("Datos tour elegido: ");
                                System.out.println(tour);
                                encontrado2 = true;
                            }
                        }
                        if (!encontrado2) {
                            System.out.println("Datos cliente: ");
                            System.out.println(cliente2.toString());
                            System.out.println("Tour asignado al cliente no existe.");
                        }

                        //A continuación lo implementado en la semana 6
                        GestorDatos datosServicios = new GestorDatos();
                        System.out.println("\n>SERVICIOS TURISTICOS<");
                        System.out.println("A continuación se mostarán los servicios turísticos disponibles:\n");
                        datosServicios.verServicioTuristico();

                        //Semana 7
                        GestorServicios datosS7 = new GestorServicios();
                        System.out.println("\nInformación sobre los distintos servicios turísticos:");
                        datosS7.verServicioTuristico2();

                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                new Main();
                            }
                        });

                    }
                }




