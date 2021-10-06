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

public class VentanaPedidos extends JFrame {

    private final ArrayList<Pedido> pedidos;
    private final ArrayList<Cliente> clientes;
    private final ArrayList<Cliente> clientesExpress;
    private ArrayList<String> meseros;
    private final int numero_mesa;
    private final JButton regresar;

    public VentanaPedidos(ArrayList<Pedido> pedidos, int numero_mesa, ArrayList<Cliente> clientes, ArrayList<Cliente> clientesExpress, ArrayList<String> meseros) {
        super("Pedidos Mesa " + (numero_mesa + 1));
        this.pedidos = pedidos;
        this.numero_mesa = numero_mesa;
        regresar = new JButton("Regresar");
        this.clientes = clientes;
        this.clientesExpress = clientesExpress;
        this.meseros=meseros;
    }

    public void init(ConjuntoMesas mesas, String ventana) {
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        ajustarComponentes(getContentPane(), mesas, ventana);
        setResizable(false);
        setVisible(true);
    }

    public void ajustarComponentes(Container container, ConjuntoMesas mesas, String ventana) {
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
            if (ventana.equals("Menu")) {
                VentanaMenu vista = new VentanaMenu(clientes, clientesExpress,meseros);
                vista.setPedidos(pedidos);
                vista.setMesa(numero_mesa);
                vista.init(mesas);
            } else if (ventana.equals("Mesa")) {
                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(numero_mesa), "Mesa " + (numero_mesa + 1), clientes, clientesExpress,meseros);
                vista.init(mesas);
            }
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
}
