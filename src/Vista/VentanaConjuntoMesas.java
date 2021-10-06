package Vista;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Vista.VentanaMesa;
import Clases.Cliente;
import Clases.ConjuntoMesas;
import javax.swing.JList;

public class VentanaConjuntoMesas extends JFrame {

    private final ConjuntoMesas mesas;
    private final ArrayList<JButton> botones;
    private final JButton regresar;
    private final ArrayList<Cliente> clientes;
    private final ArrayList<Cliente> clientesExpress;
    private ArrayList<String> meseros;

    public VentanaConjuntoMesas(ConjuntoMesas mesas, ArrayList<Cliente> clientes, ArrayList<Cliente> clientesExpress, ArrayList<String> meseros) {
        super("Mesas");
        this.mesas = mesas;
        botones = new ArrayList();
        regresar = new JButton("Regresar");
        this.clientes = clientes;
        this.clientesExpress = clientesExpress;
        this.meseros = meseros;
    }

    public void init() {
        setSize(600, 410);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        AdjustComponents(getContentPane());
        AgregarEventos();
        setResizable(false);
        setVisible(true);
    }

    public void AdjustComponents(Container container) {
        JPanel panel_principal = new JPanel(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();
        JPanel panel_botones = new JPanel(new GridLayout(4, 5));
        ImageIcon icono_disponible = new ImageIcon("src/images/mesa d.png");
        ImageIcon icono_ocupado = new ImageIcon("src/images/mesa o.png");

        for (int i = 0; i < mesas.getCantidad_de_mesas(); i++) {
            JButton boton = new JButton();
            boton.setText((i+1)+"");
            if (mesas.getMesas().get(i).isDisponible() == true) {
                boton.setIcon(icono_disponible);
                
            } else {
                boton.setIcon(icono_ocupado);
            }
            botones.add(boton);
            panel_botones.add(boton);
        }

        constraint.insets = new Insets(10, 10, 10, 10);
        constraint.gridx = 0;
        constraint.gridy = 0;
        panel_principal.add(panel_botones, constraint);
        constraint.gridx = 0;
        constraint.gridy = 1;
        panel_principal.add(regresar, constraint);
        container.add(panel_principal);
    }

    public void AgregarEventos() {
        botones.get(0).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(0).isDisponible() == true) {
                String cantidad = JOptionPane.showInputDialog(null, "Digite la cantidad de personas (debe ser entre 1 - 4)");
                if (cantidad != null) {

                    JList listaMeseros = new JList(meseros.toArray());
                    listaMeseros.setEnabled(false);
                    String mesero = JOptionPane.showInputDialog(null, listaMeseros);
                    int cant = 0;
                    int contador = 0;
                    for (int i = 0; i < cantidad.length(); i++) {
                        if (Character.isDigit(cantidad.charAt(i))) {
                            contador++;
                        }
                    }

                    boolean meseroValido = false;
                    if (mesero != null) {
                        for (int i = 0; i < meseros.size(); i++) {
                            if (meseros.get(i).toLowerCase().equals(mesero.toLowerCase())) {
                                meseroValido = true;
                                break;
                            }
                        }
                    }
                    if (contador == cantidad.length() && !cantidad.equals("") && (Integer.parseInt(cantidad) > 0) && (Integer.parseInt(cantidad) < 5) && meseroValido == true) {
                        cant = Integer.parseInt(cantidad);
                        mesas.getMesas().get(0).setComensales(cant);
                        mesero = mesero.toUpperCase();
                        mesas.getMesas().get(0).setMesero(mesero);
                        VentanaMenu vista = new VentanaMenu(clientes, clientesExpress, meseros);
                        vista.setMesa(0);
                        vista.init(mesas);
                        mesas.getMesas().get(0).setDisponibilidad(false);
                        setVisible(false);
                    }
                }
            } else {

                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(0), "Mesa 1", clientes, clientesExpress, meseros);
                vista.init(mesas);
                setVisible(false);
            }
        });

        botones.get(1).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(1).isDisponible() == true) {
                String cantidad = JOptionPane.showInputDialog(null, "Digite la cantidad de personas (debe ser entre 1 - 4)");
                if (cantidad != null) {

                    JList listaMeseros = new JList(meseros.toArray());
                    listaMeseros.setEnabled(false);
                    String mesero = JOptionPane.showInputDialog(null, listaMeseros);
                    int cant = 0;
                    int contador = 0;
                    for (int i = 0; i < cantidad.length(); i++) {
                        if (Character.isDigit(cantidad.charAt(i))) {
                            contador++;
                        }
                    }
                    boolean meseroValido = false;
                   if (mesero != null) {
                        for (int i = 0; i < meseros.size(); i++) {
                            if (meseros.get(i).toLowerCase().equals(mesero.toLowerCase())) {
                                meseroValido = true;
                                break;
                            }
                        }
                    }
                    if (contador == cantidad.length() && !cantidad.equals("") && (Integer.parseInt(cantidad) > 0) && (Integer.parseInt(cantidad) < 5) && meseroValido == true) {
                        cant = Integer.parseInt(cantidad);
                        mesas.getMesas().get(1).setComensales(cant);
                        mesero = mesero.toUpperCase();
                        mesas.getMesas().get(1).setMesero(mesero);
                        VentanaMenu vista = new VentanaMenu(clientes, clientesExpress, meseros);
                        vista.setMesa(1);
                        vista.init(mesas);
                        mesas.getMesas().get(1).setDisponibilidad(false);
                        setVisible(false);
                    }
                }
            } else {

                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(1), "Mesa 2", clientes, clientesExpress, meseros);
                vista.init(mesas);
                setVisible(false);
            }
        });

        botones.get(2).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(2).isDisponible() == true) {
                String cantidad = JOptionPane.showInputDialog(null, "Digite la cantidad de personas (debe ser entre 1 - 4)");
                if (cantidad != null) {

                    JList listaMeseros = new JList(meseros.toArray());
                    listaMeseros.setEnabled(false);
                    String mesero = JOptionPane.showInputDialog(null, listaMeseros);
                    int cant = 0;
                    int contador = 0;
                    for (int i = 0; i < cantidad.length(); i++) {
                        if (Character.isDigit(cantidad.charAt(i))) {
                            contador++;
                        }
                    }
                    boolean meseroValido = false;
                   if (mesero != null) {
                        for (int i = 0; i < meseros.size(); i++) {
                            if (meseros.get(i).toLowerCase().equals(mesero.toLowerCase())) {
                                meseroValido = true;
                                break;
                            }
                        }
                    }
                    if (contador == cantidad.length() && !cantidad.equals("") && (Integer.parseInt(cantidad) > 0) && (Integer.parseInt(cantidad) < 5) && meseroValido == true) {
                        cant = Integer.parseInt(cantidad);
                        mesas.getMesas().get(2).setComensales(cant);
                        mesero = mesero.toUpperCase();
                        mesas.getMesas().get(2).setMesero(mesero);
                        VentanaMenu vista = new VentanaMenu(clientes, clientesExpress, meseros);
                        vista.setMesa(2);
                        vista.init(mesas);
                        mesas.getMesas().get(2).setDisponibilidad(false);
                        setVisible(false);
                    }
                }
            } else {

                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(2), "Mesa 3", clientes, clientesExpress, meseros);
                vista.init(mesas);
                setVisible(false);
            }
        });

        botones.get(3).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(3).isDisponible() == true) {
                String cantidad = JOptionPane.showInputDialog(null, "Digite la cantidad de personas (debe ser entre 1 - 4)");
                if (cantidad != null) {

                    JList listaMeseros = new JList(meseros.toArray());
                    listaMeseros.setEnabled(false);
                    String mesero = JOptionPane.showInputDialog(null, listaMeseros);
                    int cant = 0;
                    int contador = 0;
                    for (int i = 0; i < cantidad.length(); i++) {
                        if (Character.isDigit(cantidad.charAt(i))) {
                            contador++;
                        }
                    }
                    boolean meseroValido = false;
                    if (mesero != null) {
                        for (int i = 0; i < meseros.size(); i++) {
                            if (meseros.get(i).toLowerCase().equals(mesero.toLowerCase())) {
                                meseroValido = true;
                                break;
                            }
                        }
                    }
                    if (contador == cantidad.length() && !cantidad.equals("") && (Integer.parseInt(cantidad) > 0) && (Integer.parseInt(cantidad) < 5) && meseroValido == true) {
                        cant = Integer.parseInt(cantidad);
                        mesas.getMesas().get(3).setComensales(cant);
                        mesero = mesero.toUpperCase();
                        mesas.getMesas().get(3).setMesero(mesero);
                        VentanaMenu vista = new VentanaMenu(clientes, clientesExpress, meseros);
                        vista.setMesa(3);
                        vista.init(mesas);
                        mesas.getMesas().get(3).setDisponibilidad(false);
                        setVisible(false);
                    }
                }
            } else {

                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(3), "Mesa 4", clientes, clientesExpress, meseros);
                vista.init(mesas);
                setVisible(false);
            }
        });

        botones.get(4).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(4).isDisponible() == true) {
                String cantidad = JOptionPane.showInputDialog(null, "Digite la cantidad de personas (debe ser entre 1 - 4)");
                if (cantidad != null) {

                    JList listaMeseros = new JList(meseros.toArray());
                    listaMeseros.setEnabled(false);
                    String mesero = JOptionPane.showInputDialog(null, listaMeseros);
                    int cant = 0;
                    int contador = 0;
                    for (int i = 0; i < cantidad.length(); i++) {
                        if (Character.isDigit(cantidad.charAt(i))) {
                            contador++;
                        }
                    }
                    boolean meseroValido = false;
                    if (mesero != null) {
                        for (int i = 0; i < meseros.size(); i++) {
                            if (meseros.get(i).toLowerCase().equals(mesero.toLowerCase())) {
                                meseroValido = true;
                                break;
                            }
                        }
                    }
                    if (contador == cantidad.length() && !cantidad.equals("") && (Integer.parseInt(cantidad) > 0) && (Integer.parseInt(cantidad) < 5) && meseroValido == true) {
                        cant = Integer.parseInt(cantidad);
                        mesas.getMesas().get(4).setComensales(cant);
                        mesero = mesero.toUpperCase();
                        mesas.getMesas().get(4).setMesero(mesero);
                        VentanaMenu vista = new VentanaMenu(clientes, clientesExpress, meseros);
                        vista.setMesa(4);
                        vista.init(mesas);
                        mesas.getMesas().get(4).setDisponibilidad(false);
                        setVisible(false);
                    }
                }
            } else {

                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(4), "Mesa 5", clientes, clientesExpress, meseros);
                vista.init(mesas);
                setVisible(false);
            }
        });

        botones.get(5).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(5).isDisponible() == true) {
                String cantidad = JOptionPane.showInputDialog(null, "Digite la cantidad de personas (debe ser entre 1 - 4)");
                if (cantidad != null) {

                    JList listaMeseros = new JList(meseros.toArray());
                    listaMeseros.setEnabled(false);
                    String mesero = JOptionPane.showInputDialog(null, listaMeseros);
                    int cant = 0;
                    int contador = 0;
                    for (int i = 0; i < cantidad.length(); i++) {
                        if (Character.isDigit(cantidad.charAt(i))) {
                            contador++;
                        }
                    }
                    boolean meseroValido = false;
                   if (mesero != null) {
                        for (int i = 0; i < meseros.size(); i++) {
                            if (meseros.get(i).toLowerCase().equals(mesero.toLowerCase())) {
                                meseroValido = true;
                                break;
                            }
                        }
                    }
                    if (contador == cantidad.length() && !cantidad.equals("") && (Integer.parseInt(cantidad) > 0) && (Integer.parseInt(cantidad) < 5) && meseroValido == true) {
                        cant = Integer.parseInt(cantidad);
                        mesas.getMesas().get(5).setComensales(cant);
                        mesero = mesero.toUpperCase();
                        mesas.getMesas().get(5).setMesero(mesero);
                        VentanaMenu vista = new VentanaMenu(clientes, clientesExpress, meseros);
                        vista.setMesa(5);
                        vista.init(mesas);
                        mesas.getMesas().get(5).setDisponibilidad(false);
                        setVisible(false);
                    }
                }
            } else {

                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(5), "Mesa 5", clientes, clientesExpress, meseros);
                vista.init(mesas);
                setVisible(false);
            }
        });

        botones.get(6).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(6).isDisponible() == true) {
                String cantidad = JOptionPane.showInputDialog(null, "Digite la cantidad de personas (debe ser entre 1 - 4)");
                if (cantidad != null) {

                    JList listaMeseros = new JList(meseros.toArray());
                    listaMeseros.setEnabled(false);
                    String mesero = JOptionPane.showInputDialog(null, listaMeseros);
                    int cant = 0;
                    int contador = 0;
                    for (int i = 0; i < cantidad.length(); i++) {
                        if (Character.isDigit(cantidad.charAt(i))) {
                            contador++;
                        }
                    }
                    boolean meseroValido = false;
                    if (mesero != null) {
                        for (int i = 0; i < meseros.size(); i++) {
                            if (meseros.get(i).toLowerCase().equals(mesero.toLowerCase())) {
                                meseroValido = true;
                                break;
                            }
                        }
                    }
                    if (contador == cantidad.length() && !cantidad.equals("") && (Integer.parseInt(cantidad) > 0) && (Integer.parseInt(cantidad) < 5) && meseroValido == true) {
                        cant = Integer.parseInt(cantidad);
                        mesas.getMesas().get(6).setComensales(cant);
                        mesero = mesero.toUpperCase();
                        mesas.getMesas().get(6).setMesero(mesero);
                        VentanaMenu vista = new VentanaMenu(clientes, clientesExpress, meseros);
                        vista.setMesa(6);
                        vista.init(mesas);
                        mesas.getMesas().get(6).setDisponibilidad(false);
                        setVisible(false);
                    }
                }
            } else {

                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(6), "Mesa 7", clientes, clientesExpress, meseros);
                vista.init(mesas);
                setVisible(false);
            }
        });

        botones.get(7).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(7).isDisponible() == true) {
                String cantidad = JOptionPane.showInputDialog(null, "Digite la cantidad de personas (debe ser entre 1 - 4)");
                if (cantidad != null) {

                    JList listaMeseros = new JList(meseros.toArray());
                    listaMeseros.setEnabled(false);
                    String mesero = JOptionPane.showInputDialog(null, listaMeseros);
                    int cant = 0;
                    int contador = 0;
                    for (int i = 0; i < cantidad.length(); i++) {
                        if (Character.isDigit(cantidad.charAt(i))) {
                            contador++;
                        }
                    }
                    boolean meseroValido = false;
                    if (mesero != null) {
                        for (int i = 0; i < meseros.size(); i++) {
                            if (meseros.get(i).toLowerCase().equals(mesero.toLowerCase())) {
                                meseroValido = true;
                                break;
                            }
                        }
                    }
                    if (contador == cantidad.length() && !cantidad.equals("") && (Integer.parseInt(cantidad) > 0) && (Integer.parseInt(cantidad) < 5) && meseroValido == true) {
                        cant = Integer.parseInt(cantidad);
                        mesas.getMesas().get(7).setComensales(cant);
                        mesero = mesero.toUpperCase();
                        mesas.getMesas().get(7).setMesero(mesero);
                        VentanaMenu vista = new VentanaMenu(clientes, clientesExpress, meseros);
                        vista.setMesa(7);
                        vista.init(mesas);
                        mesas.getMesas().get(7).setDisponibilidad(false);
                        setVisible(false);
                    }
                }
            } else {

                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(7), "Mesa 8", clientes, clientesExpress, meseros);
                vista.init(mesas);
                setVisible(false);
            }
        });

        botones.get(8).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(8).isDisponible() == true) {
                String cantidad = JOptionPane.showInputDialog(null, "Digite la cantidad de personas (debe ser entre 1 - 4)");
                if (cantidad != null) {

                    JList listaMeseros = new JList(meseros.toArray());
                    listaMeseros.setEnabled(false);
                    String mesero = JOptionPane.showInputDialog(null, listaMeseros);
                    int cant = 0;
                    int contador = 0;
                    for (int i = 0; i < cantidad.length(); i++) {
                        if (Character.isDigit(cantidad.charAt(i))) {
                            contador++;
                        }
                    }
                    boolean meseroValido = false;
                 if (mesero != null) {
                        for (int i = 0; i < meseros.size(); i++) {
                            if (meseros.get(i).toLowerCase().equals(mesero.toLowerCase())) {
                                meseroValido = true;
                                break;
                            }
                        }
                    }
                    if (contador == cantidad.length() && !cantidad.equals("") && (Integer.parseInt(cantidad) > 0) && (Integer.parseInt(cantidad) < 5) && meseroValido == true) {
                        cant = Integer.parseInt(cantidad);
                        mesas.getMesas().get(8).setComensales(cant);
                        mesero = mesero.toUpperCase();
                        mesas.getMesas().get(8).setMesero(mesero);
                        VentanaMenu vista = new VentanaMenu(clientes, clientesExpress, meseros);
                        vista.setMesa(8);
                        vista.init(mesas);
                        mesas.getMesas().get(8).setDisponibilidad(false);
                        setVisible(false);
                    }
                }
            } else {

                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(8), "Mesa 9", clientes, clientesExpress, meseros);
                vista.init(mesas);
                setVisible(false);
            }
        });

        botones.get(9).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(9).isDisponible() == true) {
                String cantidad = JOptionPane.showInputDialog(null, "Digite la cantidad de personas (debe ser entre 1 - 4)");
                if (cantidad != null) {

                    JList listaMeseros = new JList(meseros.toArray());
                    listaMeseros.setEnabled(false);
                    String mesero = JOptionPane.showInputDialog(null, listaMeseros);
                    int cant = 0;
                    int contador = 0;
                    for (int i = 0; i < cantidad.length(); i++) {
                        if (Character.isDigit(cantidad.charAt(i))) {
                            contador++;
                        }
                    }
                    boolean meseroValido = false;
                  if (mesero != null) {
                        for (int i = 0; i < meseros.size(); i++) {
                            if (meseros.get(i).toLowerCase().equals(mesero.toLowerCase())) {
                                meseroValido = true;
                                break;
                            }
                        }
                    }
                    if (contador == cantidad.length() && !cantidad.equals("") && (Integer.parseInt(cantidad) > 0) && (Integer.parseInt(cantidad) < 5) && meseroValido == true) {
                        cant = Integer.parseInt(cantidad);
                        mesas.getMesas().get(9).setComensales(cant);
                        mesero = mesero.toUpperCase();
                        mesas.getMesas().get(9).setMesero(mesero);
                        VentanaMenu vista = new VentanaMenu(clientes, clientesExpress, meseros);
                        vista.setMesa(9);
                        vista.init(mesas);
                        mesas.getMesas().get(9).setDisponibilidad(false);
                        setVisible(false);
                    }
                }
            } else {

                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(9), "Mesa 10", clientes, clientesExpress, meseros);
                vista.init(mesas);
                setVisible(false);
            }
        });

        botones.get(10).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(10).isDisponible() == true) {
                String cantidad = JOptionPane.showInputDialog(null, "Digite la cantidad de personas (debe ser entre 1 - 4)");
                if (cantidad != null) {

                    JList listaMeseros = new JList(meseros.toArray());
                    listaMeseros.setEnabled(false);
                    String mesero = JOptionPane.showInputDialog(null, listaMeseros);
                    int cant = 0;
                    int contador = 0;
                    for (int i = 0; i < cantidad.length(); i++) {
                        if (Character.isDigit(cantidad.charAt(i))) {
                            contador++;
                        }
                    }
                    boolean meseroValido = false;
                  if (mesero != null) {
                        for (int i = 0; i < meseros.size(); i++) {
                            if (meseros.get(i).toLowerCase().equals(mesero.toLowerCase())) {
                                meseroValido = true;
                                break;
                            }
                        }
                    }
                    if (contador == cantidad.length() && !cantidad.equals("") && (Integer.parseInt(cantidad) > 0) && (Integer.parseInt(cantidad) < 5) && meseroValido == true) {
                        cant = Integer.parseInt(cantidad);
                        mesas.getMesas().get(10).setComensales(cant);
                        mesero = mesero.toUpperCase();
                        mesas.getMesas().get(10).setMesero(mesero);
                        VentanaMenu vista = new VentanaMenu(clientes, clientesExpress, meseros);
                        vista.setMesa(10);
                        vista.init(mesas);
                        mesas.getMesas().get(10).setDisponibilidad(false);
                        setVisible(false);
                    }
                }
            } else {

                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(10), "Mesa 11", clientes, clientesExpress, meseros);
                vista.init(mesas);
                setVisible(false);
            }
        });

        botones.get(11).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(11).isDisponible() == true) {
                String cantidad = JOptionPane.showInputDialog(null, "Digite la cantidad de personas (debe ser entre 1 - 4)");
                if (cantidad != null) {

                    JList listaMeseros = new JList(meseros.toArray());
                    listaMeseros.setEnabled(false);
                    String mesero = JOptionPane.showInputDialog(null, listaMeseros);
                    int cant = 0;
                    int contador = 0;
                    for (int i = 0; i < cantidad.length(); i++) {
                        if (Character.isDigit(cantidad.charAt(i))) {
                            contador++;
                        }
                    }
                    boolean meseroValido = false;
                   if (mesero != null) {
                        for (int i = 0; i < meseros.size(); i++) {
                            if (meseros.get(i).toLowerCase().equals(mesero.toLowerCase())) {
                                meseroValido = true;
                                break;
                            }
                        }
                    }
                    if (contador == cantidad.length() && !cantidad.equals("") && (Integer.parseInt(cantidad) > 0) && (Integer.parseInt(cantidad) < 5) && meseroValido == true) {
                        cant = Integer.parseInt(cantidad);
                        mesas.getMesas().get(11).setComensales(cant);
                        mesero = mesero.toUpperCase();
                        mesas.getMesas().get(11).setMesero(mesero);
                        VentanaMenu vista = new VentanaMenu(clientes, clientesExpress, meseros);
                        vista.setMesa(11);
                        vista.init(mesas);
                        mesas.getMesas().get(11).setDisponibilidad(false);
                        setVisible(false);
                    }
                }
            } else {

                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(11), "Mesa 12", clientes, clientesExpress, meseros);
                vista.init(mesas);
                setVisible(false);
            }
        });

        botones.get(12).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(12).isDisponible() == true) {
                String cantidad = JOptionPane.showInputDialog(null, "Digite la cantidad de personas (debe ser entre 1 - 4)");
                if (cantidad != null) {

                    JList listaMeseros = new JList(meseros.toArray());
                    listaMeseros.setEnabled(false);
                    String mesero = JOptionPane.showInputDialog(null, listaMeseros);
                    int cant = 0;
                    int contador = 0;
                    for (int i = 0; i < cantidad.length(); i++) {
                        if (Character.isDigit(cantidad.charAt(i))) {
                            contador++;
                        }
                    }
                    boolean meseroValido = false;
                    if (mesero != null) {
                        for (int i = 0; i < meseros.size(); i++) {
                            if (meseros.get(i).toLowerCase().equals(mesero.toLowerCase())) {
                                meseroValido = true;
                                break;
                            }
                        }
                    }
                    if (contador == cantidad.length() && !cantidad.equals("") && (Integer.parseInt(cantidad) > 0) && (Integer.parseInt(cantidad) < 5) && meseroValido == true) {
                        cant = Integer.parseInt(cantidad);
                        mesas.getMesas().get(12).setComensales(cant);
                        mesero = mesero.toUpperCase();
                        mesas.getMesas().get(12).setMesero(mesero);
                        VentanaMenu vista = new VentanaMenu(clientes, clientesExpress, meseros);
                        vista.setMesa(12);
                        vista.init(mesas);
                        mesas.getMesas().get(12).setDisponibilidad(false);
                        setVisible(false);
                    }
                }
            } else {

                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(12), "Mesa 13", clientes, clientesExpress, meseros);
                vista.init(mesas);
                setVisible(false);
            }
        });

        botones.get(13).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(13).isDisponible() == true) {
                String cantidad = JOptionPane.showInputDialog(null, "Digite la cantidad de personas (debe ser entre 1 - 4)");
                if (cantidad != null) {

                    JList listaMeseros = new JList(meseros.toArray());
                    listaMeseros.setEnabled(false);
                    String mesero = JOptionPane.showInputDialog(null, listaMeseros);
                    int cant = 0;
                    int contador = 0;
                    for (int i = 0; i < cantidad.length(); i++) {
                        if (Character.isDigit(cantidad.charAt(i))) {
                            contador++;
                        }
                    }
                    boolean meseroValido = false;
                 if (mesero != null) {
                        for (int i = 0; i < meseros.size(); i++) {
                            if (meseros.get(i).toLowerCase().equals(mesero.toLowerCase())) {
                                meseroValido = true;
                                break;
                            }
                        }
                    }
                    if (contador == cantidad.length() && !cantidad.equals("") && (Integer.parseInt(cantidad) > 0) && (Integer.parseInt(cantidad) < 5) && meseroValido == true) {
                        cant = Integer.parseInt(cantidad);
                        mesas.getMesas().get(13).setComensales(cant);
                        mesero = mesero.toUpperCase();
                        mesas.getMesas().get(13).setMesero(mesero);
                        VentanaMenu vista = new VentanaMenu(clientes, clientesExpress, meseros);
                        vista.setMesa(13);
                        vista.init(mesas);
                        mesas.getMesas().get(13).setDisponibilidad(false);
                        setVisible(false);
                    }
                }
            } else {

                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(13), "Mesa 14", clientes, clientesExpress, meseros);
                vista.init(mesas);
                setVisible(false);
            }
        });

        botones.get(14).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(14).isDisponible() == true) {
                String cantidad = JOptionPane.showInputDialog(null, "Digite la cantidad de personas (debe ser entre 1 - 4)");
                if (cantidad != null) {

                    JList listaMeseros = new JList(meseros.toArray());
                    listaMeseros.setEnabled(false);
                    String mesero = JOptionPane.showInputDialog(null, listaMeseros);
                    int cant = 0;
                    int contador = 0;
                    for (int i = 0; i < cantidad.length(); i++) {
                        if (Character.isDigit(cantidad.charAt(i))) {
                            contador++;
                        }
                    }
                    boolean meseroValido = false;
                 if (mesero != null) {
                        for (int i = 0; i < meseros.size(); i++) {
                            if (meseros.get(i).toLowerCase().equals(mesero.toLowerCase())) {
                                meseroValido = true;
                                break;
                            }
                        }
                    }
                    if (contador == cantidad.length() && !cantidad.equals("") && (Integer.parseInt(cantidad) > 0) && (Integer.parseInt(cantidad) < 5) && meseroValido == true) {
                        cant = Integer.parseInt(cantidad);
                        mesas.getMesas().get(14).setComensales(cant);
                        mesero = mesero.toUpperCase();
                        mesas.getMesas().get(14).setMesero(mesero);
                        VentanaMenu vista = new VentanaMenu(clientes, clientesExpress, meseros);
                        vista.setMesa(14);
                        vista.init(mesas);
                        mesas.getMesas().get(14).setDisponibilidad(false);
                        setVisible(false);
                    }
                }
            } else {

                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(14), "Mesa 15", clientes, clientesExpress, meseros);
                vista.init(mesas);
                setVisible(false);
            }
        });

        botones.get(15).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(15).isDisponible() == true) {
                String cantidad = JOptionPane.showInputDialog(null, "Digite la cantidad de personas (debe ser entre 1 - 4)");
                if (cantidad != null) {

                    JList listaMeseros = new JList(meseros.toArray());
                    listaMeseros.setEnabled(false);
                    String mesero = JOptionPane.showInputDialog(null, listaMeseros);
                    int cant = 0;
                    int contador = 0;
                    for (int i = 0; i < cantidad.length(); i++) {
                        if (Character.isDigit(cantidad.charAt(i))) {
                            contador++;
                        }
                    }
                    boolean meseroValido = false;
                    if (mesero != null) {
                        for (int i = 0; i < meseros.size(); i++) {
                            if (meseros.get(i).toLowerCase().equals(mesero.toLowerCase())) {
                                meseroValido = true;
                                break;
                            }
                        }
                    }
                    if (contador == cantidad.length() && !cantidad.equals("") && (Integer.parseInt(cantidad) > 0) && (Integer.parseInt(cantidad) < 5) && meseroValido == true) {
                        cant = Integer.parseInt(cantidad);
                        mesas.getMesas().get(15).setComensales(cant);
                        mesero = mesero.toUpperCase();
                        mesas.getMesas().get(15).setMesero(mesero);
                        VentanaMenu vista = new VentanaMenu(clientes, clientesExpress, meseros);
                        vista.setMesa(15);
                        vista.init(mesas);
                        mesas.getMesas().get(15).setDisponibilidad(false);
                        setVisible(false);
                    }
                }
            } else {

                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(15), "Mesa 16", clientes, clientesExpress, meseros);
                vista.init(mesas);
                setVisible(false);
            }
        });

        botones.get(16).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(16).isDisponible() == true) {
                String cantidad = JOptionPane.showInputDialog(null, "Digite la cantidad de personas (debe ser entre 1 - 4)");
                if (cantidad != null) {

                    JList listaMeseros = new JList(meseros.toArray());
                    listaMeseros.setEnabled(false);
                    String mesero = JOptionPane.showInputDialog(null, listaMeseros);
                    int cant = 0;
                    int contador = 0;
                    for (int i = 0; i < cantidad.length(); i++) {
                        if (Character.isDigit(cantidad.charAt(i))) {
                            contador++;
                        }
                    }
                    boolean meseroValido = false;
                  if (mesero != null) {
                        for (int i = 0; i < meseros.size(); i++) {
                            if (meseros.get(i).toLowerCase().equals(mesero.toLowerCase())) {
                                meseroValido = true;
                                break;
                            }
                        }
                    }
                    if (contador == cantidad.length() && !cantidad.equals("") && (Integer.parseInt(cantidad) > 0) && (Integer.parseInt(cantidad) < 5) && meseroValido == true) {
                        cant = Integer.parseInt(cantidad);
                        mesas.getMesas().get(16).setComensales(cant);
                        mesero = mesero.toUpperCase();
                        mesas.getMesas().get(16).setMesero(mesero);
                        VentanaMenu vista = new VentanaMenu(clientes, clientesExpress, meseros);
                        vista.setMesa(16);
                        vista.init(mesas);
                        mesas.getMesas().get(16).setDisponibilidad(false);
                        setVisible(false);
                    }
                }
            } else {

                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(16), "Mesa 17", clientes, clientesExpress, meseros);
                vista.init(mesas);
                setVisible(false);
            }
        });

        botones.get(17).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(17).isDisponible() == true) {
                String cantidad = JOptionPane.showInputDialog(null, "Digite la cantidad de personas (debe ser entre 1 - 4)");
                if (cantidad != null) {

                    JList listaMeseros = new JList(meseros.toArray());
                    listaMeseros.setEnabled(false);
                    String mesero = JOptionPane.showInputDialog(null, listaMeseros);
                    int cant = 0;
                    int contador = 0;
                    for (int i = 0; i < cantidad.length(); i++) {
                        if (Character.isDigit(cantidad.charAt(i))) {
                            contador++;
                        }
                    }
                    boolean meseroValido = false;
                   if (mesero != null) {
                        for (int i = 0; i < meseros.size(); i++) {
                            if (meseros.get(i).toLowerCase().equals(mesero.toLowerCase())) {
                                meseroValido = true;
                                break;
                            }
                        }
                    }
                    if (contador == cantidad.length() && !cantidad.equals("") && (Integer.parseInt(cantidad) > 0) && (Integer.parseInt(cantidad) < 5) && meseroValido == true) {
                        cant = Integer.parseInt(cantidad);
                        mesas.getMesas().get(17).setComensales(cant);
                        mesero = mesero.toUpperCase();
                        mesas.getMesas().get(17).setMesero(mesero);
                        VentanaMenu vista = new VentanaMenu(clientes, clientesExpress, meseros);
                        vista.setMesa(17);
                        vista.init(mesas);
                        mesas.getMesas().get(17).setDisponibilidad(false);
                        setVisible(false);
                    }
                }
            } else {

                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(17), "Mesa 18", clientes, clientesExpress, meseros);
                vista.init(mesas);
                setVisible(false);
            }
        });

        botones.get(18).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(18).isDisponible() == true) {
                String cantidad = JOptionPane.showInputDialog(null, "Digite la cantidad de personas (debe ser entre 1 - 4)");
                if (cantidad != null) {

                    JList listaMeseros = new JList(meseros.toArray());
                    listaMeseros.setEnabled(false);
                    String mesero = JOptionPane.showInputDialog(null, listaMeseros);
                    int cant = 0;
                    int contador = 0;
                    for (int i = 0; i < cantidad.length(); i++) {
                        if (Character.isDigit(cantidad.charAt(i))) {
                            contador++;
                        }
                    }
                    boolean meseroValido = false;
                  if (mesero != null) {
                        for (int i = 0; i < meseros.size(); i++) {
                            if (meseros.get(i).toLowerCase().equals(mesero.toLowerCase())) {
                                meseroValido = true;
                                break;
                            }
                        }
                    }
                    if (contador == cantidad.length() && !cantidad.equals("") && (Integer.parseInt(cantidad) > 0) && (Integer.parseInt(cantidad) < 5) && meseroValido == true) {
                        cant = Integer.parseInt(cantidad);
                        mesas.getMesas().get(18).setComensales(cant);
                        mesero = mesero.toUpperCase();
                        mesas.getMesas().get(18).setMesero(mesero);
                        VentanaMenu vista = new VentanaMenu(clientes, clientesExpress, meseros);
                        vista.setMesa(18);
                        vista.init(mesas);
                        mesas.getMesas().get(18).setDisponibilidad(false);
                        setVisible(false);
                    }
                }
            } else {

                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(18), "Mesa 19", clientes, clientesExpress, meseros);
                vista.init(mesas);
                setVisible(false);
            }
        });

        botones.get(19).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(19).isDisponible() == true) {
                String cantidad = JOptionPane.showInputDialog(null, "Digite la cantidad de personas (debe ser entre 1 - 4)");
                if (cantidad != null) {

                    JList listaMeseros = new JList(meseros.toArray());
                    listaMeseros.setEnabled(false);
                    String mesero = JOptionPane.showInputDialog(null, listaMeseros);
                    int cant = 0;
                    int contador = 0;
                    for (int i = 0; i < cantidad.length(); i++) {
                        if (Character.isDigit(cantidad.charAt(i))) {
                            contador++;
                        }
                    }
                    boolean meseroValido = false;
                   if (mesero != null) {
                        for (int i = 0; i < meseros.size(); i++) {
                            if (meseros.get(i).toLowerCase().equals(mesero.toLowerCase())) {
                                meseroValido = true;
                                break;
                            }
                        }
                    }
                    if (contador == cantidad.length() && !cantidad.equals("") && (Integer.parseInt(cantidad) > 0) && (Integer.parseInt(cantidad) < 5) && meseroValido == true) {
                        cant = Integer.parseInt(cantidad);
                        mesas.getMesas().get(19).setComensales(cant);
                        mesero = mesero.toUpperCase();
                        mesas.getMesas().get(19).setMesero(mesero);
                        VentanaMenu vista = new VentanaMenu(clientes, clientesExpress, meseros);
                        vista.setMesa(19);
                        vista.init(mesas);
                        mesas.getMesas().get(19).setDisponibilidad(false);
                        setVisible(false);
                    }
                }
            } else {

                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(19), "Mesa 20", clientes, clientesExpress, meseros);
                vista.init(mesas);
                setVisible(false);
            }
        });

        regresar.addActionListener((e) -> {
            VentanaTipoPedido vista = new VentanaTipoPedido(clientes, clientesExpress, meseros);
            vista.init(mesas);
            setVisible(false);
        });
    }
}
