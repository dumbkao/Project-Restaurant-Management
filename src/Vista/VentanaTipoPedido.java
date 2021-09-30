package Vista;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import Clases.Cliente;
import Clases.ConjuntoMesas;
import java.awt.Insets;

public class VentanaTipoPedido extends JFrame {

    private final JButton local;
    private final JButton llevar;
    private final JButton express;
    private final JButton regresar;
    private ArrayList<Cliente> clientes;

    public VentanaTipoPedido(ArrayList<Cliente> clientes) {
        super("Tipo de Pedido");
        local = new JButton("Local");
        llevar = new JButton("Llevar");
        express = new JButton("Express");
        regresar = new JButton("Regresar");
        this.clientes = clientes;
    }

    public void init(ConjuntoMesas mesas) {
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        AjustarComponentes(getContentPane(), mesas);
        setVisible(true);
    }

    public void AjustarComponentes(Container container, ConjuntoMesas mesas) {
        JPanel panel_principal = new JPanel(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();

        local.addActionListener((e) -> {
            VentanaConjuntoMesas vista = new VentanaConjuntoMesas(mesas, clientes);
            vista.init();
            setVisible(false);

        });
        llevar.addActionListener((e) -> {
            VentanaLlevar ventana = new VentanaLlevar(clientes);
            ventana.init(mesas);
            setVisible(false);
        });
        regresar.addActionListener((e) -> {
            VentanaRestaurante vista = new VentanaRestaurante(clientes);
            vista.init(mesas);
            setVisible(false);
        });

        constraint.insets = new Insets(10, 10, 10, 10);
        constraint.gridx = 0;
        constraint.gridy = 0;
        panel_principal.add(local, constraint);
        constraint.gridx = 0;
        constraint.gridy = 1;
        panel_principal.add(llevar, constraint);
        constraint.gridx = 0;
        constraint.gridy = 2;
        panel_principal.add(express, constraint);
        constraint.gridx = 0;
        constraint.gridy = 3;
        panel_principal.add(regresar, constraint);

        container.add(panel_principal);
    }
}
