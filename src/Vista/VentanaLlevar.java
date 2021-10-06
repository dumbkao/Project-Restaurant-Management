package Vista;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Clases.Cliente;
import Clases.ConjuntoMesas;
import java.awt.Insets;

public class VentanaLlevar extends JFrame {

    private JButton btnVerPedidos, btnAgregar, btnRegresar;
    private ArrayList<Cliente> clientes;
    private ArrayList<Cliente> clientesExpress;
    private ArrayList<String> meseros;

    public VentanaLlevar(ArrayList<Cliente> clientes, ArrayList<Cliente> clientesExpress, ArrayList<String> meseros) {
        super("Pedidos LLEVAR");
        this.clientes = clientes;
        this.clientesExpress = clientesExpress;
        this.meseros=meseros;
    }

    public void ajustarComponentes(Container c, ConjuntoMesas mesas) {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        btnVerPedidos = new JButton("Ver pedidos");
        btnAgregar = new JButton("Agregar");
        btnRegresar = new JButton("Regresar");

        btnVerPedidos.addActionListener((e) -> {
            VentanaPedidosLlevar vista = new VentanaPedidosLlevar(clientes, clientesExpress,meseros);
            vista.init(mesas);
            setVisible(false);
        });

        btnAgregar.addActionListener((e) -> {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre");
            String telefono = JOptionPane.showInputDialog("Ingrese su telefono");

            if ((nombre != null && telefono != null) && (!nombre.equals("") && !telefono.equals(""))) {
                VentanaMenuLlevar menu = new VentanaMenuLlevar(clientes, clientesExpress,meseros);
                menu.init(nombre, telefono, mesas);
                setVisible(false);
            }
        });

        btnRegresar.addActionListener((e) -> {
            VentanaTipoPedido vista = new VentanaTipoPedido(clientes, clientesExpress,meseros);
            vista.init(mesas);
            setVisible(false);
        });

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(btnVerPedidos, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(btnAgregar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(btnRegresar, gbc);

        c.add(mainPanel);

    }

    public void init(ConjuntoMesas mesas) {
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ajustarComponentes(getContentPane(), mesas);
        setVisible(true);
    }

}
