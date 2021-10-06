package Vista;

import Clases.Cliente;
import Clases.ConjuntoMesas;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VentanaExpress extends JFrame {

    private ArrayList<Cliente> clientes;
    private ArrayList<Cliente> clientesExpress;
    private final ArrayList<String> meseros;
    private JButton btnVerPedidos, btnAgregar, btnRegresar;

    public VentanaExpress(ArrayList<Cliente> clientes, ArrayList<Cliente> clientesExpress,ArrayList<String> meseros) {
        super("Ventana Express");
        this.clientes = clientes;
        this.clientesExpress = clientesExpress;
        this.meseros=meseros;
    }

    public void iniciar(ConjuntoMesas mesas) {
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ajustarComponentes(getContentPane(), mesas);
        setVisible(true);
    }

    public void ajustarComponentes(Container container, ConjuntoMesas mesas) {
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        btnVerPedidos = new JButton("Ver pedidos Express");
        btnAgregar = new JButton("Agregar pedido");
        btnRegresar = new JButton("Regresar");

        btnVerPedidos.addActionListener((e) -> {
            VentanaPedidosExpress vista = new VentanaPedidosExpress(clientes, clientesExpress,meseros);
            vista.iniciar(mesas);
            setVisible(false);
        });

        btnAgregar.addActionListener((e) -> {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre");
            String direccion = JOptionPane.showInputDialog("Ingrese la direccion");
            String telefono = JOptionPane.showInputDialog("Ingrese el telefono");

            if ((nombre != null && telefono != null && direccion != null) && (!nombre.equals("") && !telefono.equals("") && !direccion.equals(""))) {
                VentanaMenuExpress menu = new VentanaMenuExpress(clientes, clientesExpress,meseros);
                menu.iniciar(nombre, direccion, telefono, mesas);
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
        panelPrincipal.add(btnVerPedidos, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panelPrincipal.add(btnAgregar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panelPrincipal.add(btnRegresar, gbc);

        container.add(panelPrincipal);
    }
}
