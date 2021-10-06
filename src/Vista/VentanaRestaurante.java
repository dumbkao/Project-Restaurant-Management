package Vista;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Clases.Cliente;
import Clases.ConjuntoMesas;

public class VentanaRestaurante extends JFrame {

    private final JButton btnAdmi;
    private final JButton btnMesero;
    private final JLabel nombreRestaurante;
    private ArrayList<Cliente> clientes;
    private ArrayList<Cliente> clientesExpress;
    private ArrayList<String> meseros;
    JPanel pnlPrincipal;

    public VentanaRestaurante(ArrayList<Cliente> clientes, ArrayList<Cliente> clientesExpress, ArrayList<String> meseros) {
        super("Restaurante uwu");
        btnAdmi = new JButton("Módulo administrador");
        btnMesero = new JButton("Módulo mesero");
        nombreRestaurante = new JLabel("Restaurante uwu");
        this.clientes = clientes;
        this.clientesExpress = clientesExpress;
        this.meseros=meseros;
    }

    public void ajustarComponentes(Container c, ConjuntoMesas mesas) {
        pnlPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.gridx = 0;
        constraints.gridy = 0;
        pnlPrincipal.add(nombreRestaurante, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        pnlPrincipal.add(btnAdmi, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        pnlPrincipal.add(btnMesero, constraints);

        c.add(pnlPrincipal);

        btnMesero.addActionListener((e) -> {
            VentanaTipoPedido vista = new VentanaTipoPedido(clientes, clientesExpress,meseros);
            vista.init(mesas);
            setVisible(false);
        });
        btnAdmi.addActionListener((e) -> {
            VentanaAdministracion admi=new VentanaAdministracion(clientes,clientesExpress,meseros);
            admi.init(mesas);
            setVisible(false);
        });
    }

    public void init(ConjuntoMesas mesas) {
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ajustarComponentes(getContentPane(), mesas);
        setResizable(false);
        setVisible(true);
    }

}
