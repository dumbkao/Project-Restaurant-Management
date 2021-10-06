package Vista;

import Clases.Cliente;
import Clases.ConjuntoMesas;
import Clases.Pedido;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VentanaPedidoExpress extends JFrame {

    private final ArrayList<Cliente> clientes;
    private final ArrayList<Cliente> clientesExpress;
    private final ArrayList<Pedido> pedidos;
    private ArrayList<String> meseros;
    private final JButton regresar;

    public VentanaPedidoExpress(ArrayList<Pedido> pedidos, ArrayList<Cliente> clientes, ArrayList<Cliente> clientesExpress,ArrayList<String> meseros) {
        super("Pedidos Express");
        this.pedidos = pedidos;
        this.clientes = clientes;
        this.clientesExpress = clientesExpress;
        this.meseros=meseros;
        regresar = new JButton("Regresar");
    }

    public void iniciar(String nombre, String telefono, String ventana, ConjuntoMesas mesas) {
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        ajustarComponentes(getContentPane(), nombre, telefono, ventana, mesas);
        setResizable(false);
        setVisible(true);
    }

    public void ajustarComponentes(Container container, String nombre, String telefono, String ventana, ConjuntoMesas mesas) {
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPrincipal = new GridBagConstraints();

        JPanel panel_tabla = new JPanel(new GridBagLayout());
        GridBagConstraints gbcTabla = new GridBagConstraints();

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

        gbcTabla.gridx = 0;
        gbcTabla.gridy = 0;
        panel_tabla.add(tabla.getTableHeader(), gbcTabla);
        gbcTabla.gridx = 0;
        gbcTabla.gridy = 1;
        panel_tabla.add(scroll, gbcTabla);

        panel_boton.add(regresar);

        regresar.addActionListener((e) -> {
            VentanaMenuExpress vista = new VentanaMenuExpress(clientes, clientesExpress,meseros);
            vista.setPedidos(pedidos);
            vista.iniciar(nombre, telefono, telefono, mesas);
            setVisible(false);
        });

        gbcPrincipal.gridx = 0;
        gbcPrincipal.gridy = 0;
        panelPrincipal.add(panel_tabla, gbcPrincipal);

        gbcPrincipal.gridx = 0;
        gbcPrincipal.gridy = 2;
        panelPrincipal.add(panel_boton, gbcPrincipal);

        container.add(panelPrincipal, BorderLayout.NORTH);
    }
}
