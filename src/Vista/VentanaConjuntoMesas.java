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

public class VentanaConjuntoMesas extends JFrame {

    private final ConjuntoMesas mesas;
    private final ArrayList<JButton> botones;
    private final JButton regresar;
    private final ArrayList<Cliente> clientes;
    private final ArrayList<Cliente> clientesExpress;

    public VentanaConjuntoMesas(ConjuntoMesas mesas, ArrayList<Cliente> clientes, ArrayList<Cliente> clientesExpress) {
        super("Mesas");
        this.mesas = mesas;
        botones = new ArrayList();
        regresar = new JButton("Regresar");
        this.clientes = clientes;
        this.clientesExpress = clientesExpress;
    }

    public void init() {
        setSize(550, 400);
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
                String cantidad = JOptionPane.showInputDialog(null, "Digite la cantidad de personas");
                int cant = 0;
                int contador = 0;
                for (int i = 0; i < cantidad.length(); i++) {
                    if (Character.isDigit(cantidad.charAt(i))) {
                        contador++;
                    }
                }
                if (contador == cantidad.length() && !cantidad.equals("") && (Integer.parseInt(cantidad) > 0)) {
                    cant = Integer.parseInt(cantidad);
                    mesas.getMesas().get(0).setComensales(cant);
                    VentanaMenu vista = new VentanaMenu(clientes, clientesExpress);
                    vista.setMesa(0);
                    vista.init(mesas);
                    mesas.getMesas().get(0).setDisponibilidad(false);
                    setVisible(false);
                }
            } else {
                mesas.getMesas().get(0).setNumero(0);
                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(0), "Mesa 1", clientes, clientesExpress);
                vista.init(mesas);
                setVisible(false);
            }
        });

        botones.get(1).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(1).isDisponible() == true) {
                int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cantidad de personas"));
                mesas.getMesas().get(1).setComensales(cantidad);
                VentanaMenu vista = new VentanaMenu(clientes, clientesExpress);
                vista.setMesa(1);
                vista.init(mesas);
                mesas.getMesas().get(1).setDisponibilidad(false);
            } else {
                mesas.getMesas().get(1).setNumero(1);
                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(1), "Mesa 2", clientes, clientesExpress);
                vista.init(mesas);
            }
            setVisible(false);
        });

        botones.get(2).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(2).isDisponible() == true) {
                int cantidad2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cantidad de personas"));
                mesas.getMesas().get(2).setComensales(cantidad2);
                VentanaMenu vista = new VentanaMenu(clientes, clientesExpress);
                vista.setMesa(2);
                vista.init(mesas);
                mesas.getMesas().get(2).setDisponibilidad(false);
            } else {
                mesas.getMesas().get(2).setNumero(2);
                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(2), "Mesa 3", clientes, clientesExpress);
                vista.init(mesas);
            }
            setVisible(false);
        });

        botones.get(3).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(3).isDisponible() == true) {
                int cantidad3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cantidad de personas"));
                mesas.getMesas().get(3).setComensales(cantidad3);
                VentanaMenu vista = new VentanaMenu(clientes, clientesExpress);
                vista.setMesa(3);
                vista.init(mesas);
                mesas.getMesas().get(3).setDisponibilidad(false);
            } else {
                mesas.getMesas().get(3).setNumero(3);
                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(3), "Mesa 4", clientes, clientesExpress);
                vista.init(mesas);
            }
            setVisible(false);
        });

        botones.get(4).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(4).isDisponible() == true) {
                int cantidad4 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cantidad de personas"));
                mesas.getMesas().get(4).setComensales(cantidad4);
                VentanaMenu vista = new VentanaMenu(clientes, clientesExpress);
                vista.setMesa(4);
                vista.init(mesas);
                mesas.getMesas().get(4).setDisponibilidad(false);
            } else {
                mesas.getMesas().get(4).setNumero(4);
                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(4), "Mesa 5", clientes, clientesExpress);
                vista.init(mesas);
            }
            setVisible(false);
        });

        botones.get(5).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(5).isDisponible() == true) {
                int cantidad5 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cantidad de personas"));
                mesas.getMesas().get(5).setComensales(cantidad5);
                VentanaMenu vista = new VentanaMenu(clientes, clientesExpress);
                vista.setMesa(5);
                vista.init(mesas);
                mesas.getMesas().get(5).setDisponibilidad(false);
            } else {
                mesas.getMesas().get(5).setNumero(5);
                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(5), "Mesa 6", clientes, clientesExpress);
                vista.init(mesas);
            }
            setVisible(false);
        });

        botones.get(6).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(6).isDisponible() == true) {
                int cantidad6 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cantidad de personas"));
                mesas.getMesas().get(6).setComensales(cantidad6);
                VentanaMenu vista = new VentanaMenu(clientes, clientesExpress);
                vista.setMesa(6);
                vista.init(mesas);
                mesas.getMesas().get(6).setDisponibilidad(false);
            } else {
                mesas.getMesas().get(6).setNumero(6);
                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(6), "Mesa 7", clientes, clientesExpress);
                vista.init(mesas);
            }
            setVisible(false);
        });

        botones.get(7).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(7).isDisponible() == true) {
                int cantidad7 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cantidad de personas"));
                mesas.getMesas().get(7).setComensales(cantidad7);
                VentanaMenu vista = new VentanaMenu(clientes, clientesExpress);
                vista.setMesa(7);
                vista.init(mesas);
                mesas.getMesas().get(7).setDisponibilidad(false);
            } else {
                mesas.getMesas().get(7).setNumero(7);
                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(7), "Mesa 8", clientes, clientesExpress);
                vista.init(mesas);
            }
            setVisible(false);
        });

        botones.get(8).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(8).isDisponible() == true) {
                int cantidad8 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cantidad de personas"));
                mesas.getMesas().get(8).setComensales(cantidad8);
                VentanaMenu vista = new VentanaMenu(clientes, clientesExpress);
                vista.setMesa(8);
                vista.init(mesas);
                mesas.getMesas().get(8).setDisponibilidad(false);
            } else {
                mesas.getMesas().get(8).setNumero(8);
                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(8), "Mesa 9", clientes, clientesExpress);
                vista.init(mesas);
            }
            setVisible(false);
        });

        botones.get(9).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(9).isDisponible() == true) {
                int cantidad9 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cantidad de personas"));
                mesas.getMesas().get(9).setComensales(cantidad9);
                VentanaMenu vista = new VentanaMenu(clientes, clientesExpress);
                vista.setMesa(9);
                vista.init(mesas);
                mesas.getMesas().get(9).setDisponibilidad(false);
            } else {
                mesas.getMesas().get(9).setNumero(9);
                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(9), "Mesa 10", clientes, clientesExpress);
                vista.init(mesas);
            }
            setVisible(false);
        });

        botones.get(10).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(10).isDisponible() == true) {
                int cantidad10 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cantidad de personas"));
                mesas.getMesas().get(10).setComensales(cantidad10);
                VentanaMenu vista = new VentanaMenu(clientes, clientesExpress);
                vista.setMesa(10);
                vista.init(mesas);
                mesas.getMesas().get(10).setDisponibilidad(false);
            } else {
                mesas.getMesas().get(10).setNumero(10);
                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(10), "Mesa 11", clientes, clientesExpress);
                vista.init(mesas);
            }
            setVisible(false);
        });

        botones.get(11).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(11).isDisponible() == true) {
                int cantidad11 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cantidad de personas"));
                mesas.getMesas().get(11).setComensales(cantidad11);
                VentanaMenu vista = new VentanaMenu(clientes, clientesExpress);
                vista.setMesa(11);
                vista.init(mesas);
                mesas.getMesas().get(11).setDisponibilidad(false);
            } else {
                mesas.getMesas().get(11).setNumero(11);
                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(11), "Mesa 12", clientes, clientesExpress);
                vista.init(mesas);
            }
            setVisible(false);
        });

        botones.get(12).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(12).isDisponible() == true) {
                int cantidad12 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cantidad de personas"));
                mesas.getMesas().get(12).setComensales(cantidad12);
                VentanaMenu vista = new VentanaMenu(clientes, clientesExpress);
                vista.setMesa(12);
                vista.init(mesas);
                mesas.getMesas().get(12).setDisponibilidad(false);
            } else {
                mesas.getMesas().get(12).setNumero(12);
                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(12), "Mesa 13", clientes, clientesExpress);
                vista.init(mesas);
            }
            setVisible(false);
        });

        botones.get(13).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(13).isDisponible() == true) {
                int cantidad13 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cantidad de personas"));
                mesas.getMesas().get(13).setComensales(cantidad13);
                VentanaMenu vista = new VentanaMenu(clientes, clientesExpress);
                vista.setMesa(13);
                vista.init(mesas);
                mesas.getMesas().get(13).setDisponibilidad(false);
            } else {
                mesas.getMesas().get(13).setNumero(13);
                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(13), "Mesa 14", clientes, clientesExpress);
                vista.init(mesas);
            }
            setVisible(false);
        });

        botones.get(14).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(14).isDisponible() == true) {
                int cantidad14 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cantidad de personas"));
                mesas.getMesas().get(14).setComensales(cantidad14);
                VentanaMenu vista = new VentanaMenu(clientes, clientesExpress);
                vista.setMesa(14);
                vista.init(mesas);
                mesas.getMesas().get(14).setDisponibilidad(false);
            } else {
                mesas.getMesas().get(14).setNumero(14);
                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(14), "Mesa 15", clientes, clientesExpress);
                vista.init(mesas);
            }
            setVisible(false);
        });

        botones.get(15).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(15).isDisponible() == true) {
                int cantidad15 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cantidad de personas"));
                mesas.getMesas().get(15).setComensales(cantidad15);
                VentanaMenu vista = new VentanaMenu(clientes, clientesExpress);
                vista.setMesa(15);
                vista.init(mesas);
                mesas.getMesas().get(15).setDisponibilidad(false);
            } else {
                mesas.getMesas().get(15).setNumero(15);
                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(15), "Mesa 16", clientes, clientesExpress);
                vista.init(mesas);
            }
            setVisible(false);
        });

        botones.get(16).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(16).isDisponible() == true) {
                int cantidad16 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cantidad de personas"));
                mesas.getMesas().get(16).setComensales(cantidad16);
                VentanaMenu vista = new VentanaMenu(clientes, clientesExpress);
                vista.setMesa(16);
                vista.init(mesas);
                mesas.getMesas().get(16).setDisponibilidad(false);
            } else {
                mesas.getMesas().get(16).setNumero(16);
                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(16), "Mesa 17", clientes, clientesExpress);
                vista.init(mesas);
            }
            setVisible(false);
        });

        botones.get(17).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(17).isDisponible() == true) {
                int cantidad17 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cantidad de personas"));
                mesas.getMesas().get(17).setComensales(cantidad17);
                VentanaMenu vista = new VentanaMenu(clientes, clientesExpress);
                vista.setMesa(17);
                vista.init(mesas);
                mesas.getMesas().get(17).setDisponibilidad(false);
            } else {
                mesas.getMesas().get(17).setNumero(17);
                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(17), "Mesa 18", clientes, clientesExpress);
                vista.init(mesas);
            }
            setVisible(false);
        });

        botones.get(18).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(18).isDisponible() == true) {
                int cantidad18 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cantidad de personas"));
                mesas.getMesas().get(18).setComensales(cantidad18);
                VentanaMenu vista = new VentanaMenu(clientes, clientesExpress);
                vista.setMesa(18);
                vista.init(mesas);
                mesas.getMesas().get(18).setDisponibilidad(false);
            } else {
                mesas.getMesas().get(18).setNumero(18);
                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(18), "Mesa 19", clientes, clientesExpress);
                vista.init(mesas);
            }
            setVisible(false);
        });

        botones.get(19).addActionListener((ActionEvent e) -> {
            if (mesas.getMesas().get(19).isDisponible() == true) {
                int cantidad19 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cantidad de personas"));
                mesas.getMesas().get(19).setComensales(cantidad19);
                VentanaMenu vista = new VentanaMenu(clientes, clientesExpress);
                vista.setMesa(19);
                vista.init(mesas);
                mesas.getMesas().get(19).setDisponibilidad(false);
            } else {
                mesas.getMesas().get(19).setNumero(19);
                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(19), "Mesa 20", clientes, clientesExpress);
                vista.init(mesas);
            }
            setVisible(false);
        });

        regresar.addActionListener((e) -> {
            VentanaTipoPedido vista = new VentanaTipoPedido(clientes, clientesExpress);
            vista.init(mesas);
            setVisible(false);
        });
    }
}
