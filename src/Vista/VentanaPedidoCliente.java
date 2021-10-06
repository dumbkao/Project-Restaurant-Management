package Vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import Clases.Pedido;
import Clases.Cliente;
import Clases.ConjuntoMesas;
import Vista.VentanaMenu;
import Vista.VentanaMenuLlevar;

public class VentanaPedidoCliente extends JFrame {

    private final ArrayList<Cliente> clientes;
    private final ArrayList<Cliente> clientesExpress;
    private final ArrayList<Pedido> pedidos;
    private ArrayList<String> meseros;
    private final JButton regresar;

    public VentanaPedidoCliente(ArrayList<Pedido> pedidos, ArrayList<Cliente> clientes, ArrayList<Cliente> clientesExpress, ArrayList<String> meseros) {
        super("Pedidos cliente ");
        this.pedidos = pedidos;
        this.clientes = clientes;
        this.clientesExpress = clientesExpress;
        this.meseros = meseros;
        regresar = new JButton("Regresar");
    }

    public void ajustarComponentes(Container container, String nombre, String telefono, String ventana, ConjuntoMesas mesas) {
        JPanel panel_principal = new JPanel(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();

        JPanel panel_tabla = new JPanel(new GridBagLayout());
        GridBagConstraints constraint2 = new GridBagConstraints();

        JPanel panel_boton = new JPanel(new FlowLayout());

        String columnas[] = {"Cantidad", "Nombre", "Precio"};
        String datos[][] = new String[pedidos.size()][3];
        for (int i = 0; i < pedidos.size(); i++) {
            String data[] = {pedidos.get(i).getCantidad() + "", pedidos.get(i).getDetalle().getNombre(), pedidos.get(i).getDetalle().getPrecio() + ""};
            datos[i] = data;
        }
        JTable tabla = new JTable(datos, columnas);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabla.setFont(new Font("Calibri", 3, 15));
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        constraint2.gridx = 0;
        constraint2.gridy = 0;
        panel_tabla.add(tabla.getTableHeader(), constraint2);
        constraint2.gridx = 0;
        constraint2.gridy = 1;
        panel_tabla.add(scroll, constraint2);
        panel_boton.add(regresar);

        regresar.addActionListener((e) -> {
            VentanaMenuLlevar vista = new VentanaMenuLlevar(clientes, clientesExpress,meseros);
            vista.setPedidos(pedidos);
            vista.init(nombre, telefono, mesas);

            setVisible(false);
        });

        constraint.gridx = 0;
        constraint.gridy = 0;
        panel_principal.add(panel_tabla, constraint);
        constraint.gridx = 0;
        constraint.gridy = 2;
        panel_principal.add(panel_boton, constraint);
        container.add(panel_principal, BorderLayout.NORTH);
    }

    public void init(String nombre, String telefono, String ventana, ConjuntoMesas mesas) {
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        ajustarComponentes(getContentPane(), nombre, telefono, ventana, mesas);
        setResizable(false);
        setVisible(true);
    }
}
