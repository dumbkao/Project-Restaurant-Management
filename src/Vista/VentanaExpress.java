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
    private JButton btnVerPedidos, btnAgregar, btnRegresar;

    public VentanaExpress(ArrayList<Cliente> clientes, ArrayList<Cliente> clientesExpress) {
        super("Ventana Express");
        this.clientes = clientes;
        this.clientesExpress = clientesExpress;
    }

    public void iniciar(ConjuntoMesas mesas) {
        setSize(600, 600);
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
            VentanaPedidosExpress vista = new VentanaPedidosExpress(clientes, clientesExpress);
            vista.iniciar(mesas);
            setVisible(false);
        });

        btnAgregar.addActionListener((e) -> {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre");
            String telefono = JOptionPane.showInputDialog("Ingrese el telefono");

            if (!nombre.equals("") && !telefono.equals("")) {
                VentanaMenuExpress menu = new VentanaMenuExpress(clientes, clientesExpress);
                menu.iniciar(nombre, "Direccion", telefono, mesas);
                setVisible(false);
            }
        });

        btnRegresar.addActionListener((e) -> {
            VentanaTipoPedido vista = new VentanaTipoPedido(clientes, clientesExpress);
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
