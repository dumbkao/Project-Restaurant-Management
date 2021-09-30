/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import Clases.Factura;
import Clases.Pedido;
import Vista.VentanaFactura;
import Clases.Cliente;
import Clases.ConjuntoMesas;

/**
 *
 * @author hilla
 */
public class VentanaPedidosLlevar extends JFrame {

    private ArrayList<Cliente> clientes;
    private JButton regresar, mostrarCliente;

    public VentanaPedidosLlevar(ArrayList<Cliente> clientes) {
        super("Pedidos para llevar");
        this.clientes = clientes;

    }

    public void ajustarComponentes(Container c, ConjuntoMesas mesas) {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        String columnas[] = {"Nombre", "Telefono"};
        String datos[][] = new String[clientes.size()][columnas.length];
        for (int i = 0; i < clientes.size(); i++) {
            String detalle[] = {clientes.get(i).getNombre(), clientes.get(i).getNumero()};
            datos[i] = detalle;

        }

        regresar = new JButton("Regresar");
        regresar.addActionListener((e) -> {
            VentanaLlevar ventana = new VentanaLlevar(clientes);
            ventana.init(mesas);
            setVisible(false);
        });

        JTable tabla = new JTable(datos, columnas);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mostrarCliente = new JButton("Mostrar cliente");
        mostrarCliente.addActionListener((e) -> {
            int fila = tabla.getSelectedRow();
            Factura factura = new Factura("Juan", "Llevar", "Ventanilla", fila, "29/09/2021", clientes.get(fila).getPedidos());
            VentanaFacturaLlevar vista = new VentanaFacturaLlevar(factura);
            vista.init();
            setVisible(false);
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(scroll, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(regresar, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(mostrarCliente, gbc);

        c.add(mainPanel);
    }

    public void init(ConjuntoMesas mesas) {
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ajustarComponentes(getContentPane(), mesas);
        setVisible(true);
    }

}
