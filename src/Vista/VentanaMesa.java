package Vista;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Clases.Factura;
import Clases.Mesa;
import Clases.Pedido;
import Clases.Cliente;
import Clases.ConjuntoMesas;
import Vista.VentanaConjuntoMesas;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class VentanaMesa extends JFrame {

    private final ArrayList<Cliente> clientes;
    private final ArrayList<Cliente> clientesExpress;
    private final ArrayList<Pedido> pedidos;
    private ArrayList<String> meseros;
    private ArrayList<Integer> mesasDisponibles;
    private final Mesa mesa;
    private JButton btnVerPedidos;
    private JButton btnPagar;
    private JButton btnVerFactura;
    private JButton btnRegresar;
    private JButton btnCambiarMesa;

    public VentanaMesa(Mesa mesa, String titulo, ArrayList<Cliente> clientes, ArrayList<Cliente> clientesExpress, ArrayList<String> meseros) {
        super(titulo);
        this.mesa = mesa;
        pedidos = mesa.getPedidos();
        this.clientes = clientes;
        this.clientesExpress = clientesExpress;
        this.meseros = meseros;
    }

    public void init(ConjuntoMesas mesas) {
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ajustarComponentes(getContentPane(), mesas);
        setResizable(false);
        setVisible(true);
    }

    public void ajustarComponentes(Container container, ConjuntoMesas mesas) {
        JPanel pnlPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();

        JPanel pnl1 = new JPanel(new FlowLayout());
        JPanel pnl2 = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel comensales = new JLabel("Cantidad de personas: " + mesa.getComensales());
        JLabel disponible = new JLabel("La mesa está");
        JLabel ocupada = new JLabel("");
        JLabel btnMesa = new JLabel();

        btnVerPedidos = new JButton("Ver pedidos");
        btnPagar = new JButton("Pagar");
        btnVerFactura = new JButton("Ver factura");
        btnRegresar = new JButton("Regresar");
        btnCambiarMesa = new JButton("Cambiar de mesa");

        btnVerPedidos.addActionListener((e) -> {
            VentanaPedidos vista = new VentanaPedidos(pedidos, mesa.getNumero(), clientes, clientesExpress, meseros);
            vista.init(mesas, "Mesa");
            setVisible(false);
        });

        btnVerFactura.addActionListener((e) -> {
            Factura factura = new Factura("Mesa", "Local", mesa.getMesero(), (mesa.getNumero() + 1), "29/09/2021", pedidos);
            VentanaFactura vista = new VentanaFactura(factura, mesa.getNumero(), clientes, clientesExpress, meseros);
            vista.init(mesas, "Mesa");
            setVisible(false);
        });
        btnPagar.addActionListener((ActionEvent e) -> {
            mesa.setComensales(0);
            mesa.setDisponibilidad(true);
            mesa.setMesero("");
            JOptionPane.showMessageDialog(null, "Se ha pagado con exito :)");
            VentanaConjuntoMesas vista = new VentanaConjuntoMesas(mesas, clientes, clientesExpress, meseros);
            vista.init();
            setVisible(false);
        });
        btnCambiarMesa.addActionListener((e) -> {
            mesasDisponibles = new ArrayList();
            for (int i = 0; i < 20; i++) {
                if (mesas.getMesas().get(i).isDisponible()) {
                    mesasDisponibles.add(mesas.getMesas().get(i).getNumero() + 1);

                }
            }
            JList numeroMesa = new JList(mesasDisponibles.toArray());
            String txtnumMesa = (JOptionPane.showInputDialog(numeroMesa));
            if (txtnumMesa != null && !txtnumMesa.equals("")) {

                int contador = 0;
                for (int i = 0; i < txtnumMesa.length(); i++) {
                    if (Character.isDigit(txtnumMesa.charAt(i))) {
                        contador++;

                    }
                }
                if (contador == txtnumMesa.length()) {

                    int numMesa = Integer.parseInt(txtnumMesa);

                    if (numMesa > 0 && numMesa < 21) {
                        numMesa = numMesa - 1;
                        if (mesas.getMesas().get(numMesa).isDisponible()) {
                            mesas.getMesas().get(numMesa).setDisponibilidad(false);
                            mesas.getMesas().get(numMesa).setPedidos(pedidos);
                            mesas.getMesas().get(numMesa).setComensales(mesa.getComensales());
                            mesas.getMesas().get(numMesa).setMesero(mesa.getMesero());

                            mesa.setDisponibilidad(true);
                            mesa.setPedidos(null);
                            mesa.setComensales(0);
                            mesa.setMesero(null);

                            JOptionPane.showMessageDialog(null, "Usted ha cambiado de mesa con exito", "CAMBIO EXITOSO", JOptionPane.INFORMATION_MESSAGE);

                            VentanaConjuntoMesas vista = new VentanaConjuntoMesas(mesas, clientes, clientesExpress, meseros);
                            vista.init();
                            setVisible(false);

                        }
                    }
                }
            }

        });

        btnRegresar.addActionListener((e) -> {
            VentanaConjuntoMesas vista = new VentanaConjuntoMesas(mesas, clientes, clientesExpress, meseros);
            vista.init();
            setVisible(false);
        });

        pnl1.add(btnMesa);
        pnl1.add(disponible);
        pnl1.add(ocupada);

        if (mesa.isDisponible() == true) {
            ocupada.setText("disponible");
            ImageIcon icnMesa = new ImageIcon("src/images/mesa d.png");
            btnMesa.setIcon(icnMesa);
        } else {
            ocupada.setText("ocupada");
            ImageIcon icnMesa = new ImageIcon("src/images/mesa o.png");
            btnMesa.setIcon(icnMesa);
            pnl1.add(comensales);
            c.insets = new Insets(5, 5, 5, 5);
            c.gridx = 0;
            c.gridy = 0;
            pnl2.add(btnVerPedidos, c);
            c.gridx = 0;
            c.gridy = 1;
            pnl2.add(btnVerFactura, c);
            c.gridx = 0;
            c.gridy = 2;
            pnl2.add(btnPagar, c);
        }
        constraint.insets = new Insets(10, 10, 10, 10);
        constraint.gridx = 0;
        constraint.gridy = 0;
        pnlPrincipal.add(pnl1, constraint);
        constraint.gridx = 0;
        constraint.gridy = 1;
        pnlPrincipal.add(pnl2, constraint);
        constraint.gridx = 0;
        constraint.gridy = 2;
        pnlPrincipal.add(btnCambiarMesa, constraint);
        constraint.gridx = 0;
        constraint.gridy = 3;
        pnlPrincipal.add(btnRegresar, constraint);
        container.add(pnlPrincipal);
    }
}
