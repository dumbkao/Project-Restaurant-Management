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

public class VentanaLlevar extends JFrame {

    private JButton btnVerPedidos, btnAgregar, btnRegresar;
    private ArrayList<Cliente> clientes;

    public VentanaLlevar(ArrayList<Cliente> clientes) {
        super("Pedidos LLEVAR");
        this.clientes = clientes;
    }

    public void ajustarComponentes(Container c, ConjuntoMesas mesas) {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        btnVerPedidos = new JButton("Ver pedidos");
        btnAgregar = new JButton("Agregar");
        btnRegresar = new JButton("Regresar");

        btnVerPedidos.addActionListener((e) -> {
            VentanaPedidosLlevar vista = new VentanaPedidosLlevar(clientes);
            vista.init(mesas);
            setVisible(false);
        });

        btnAgregar.addActionListener((e) -> {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre");
            String telefono = JOptionPane.showInputDialog("Ingrese su telefono");
            VentanaMenuLlevar menu = new VentanaMenuLlevar(clientes);
            menu.init(nombre, telefono, mesas);
            setVisible(false);
        });

        btnRegresar.addActionListener((e) -> {
            VentanaTipoPedido vista = new VentanaTipoPedido(clientes);
            vista.init(mesas);
            setVisible(false);
        });

        mainPanel.add(btnVerPedidos);
        mainPanel.add(btnAgregar);
        mainPanel.add(btnRegresar);

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
