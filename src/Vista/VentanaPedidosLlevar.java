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
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class VentanaPedidosLlevar extends JFrame {

    private ArrayList<Cliente> clientes;
    private ArrayList<Cliente> clientesExpress;
    private ArrayList<String> meseros;
    private JButton regresar, mostrarCliente;

    public VentanaPedidosLlevar(ArrayList<Cliente> clientes, ArrayList<Cliente> clientesExpress, ArrayList<String> meseros) {
        super("Pedidos para llevar");
        this.clientes = clientes;
        this.clientesExpress = clientesExpress;
        this.meseros=meseros;
    }

    public void init(ConjuntoMesas mesas) {
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ajustarComponentes(getContentPane(), mesas);
        setVisible(true);
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
            VentanaLlevar ventana = new VentanaLlevar(clientes, clientesExpress,meseros);
            ventana.init(mesas);
            setVisible(false);
        });

        JTable tabla = new JTable(datos, columnas);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mostrarCliente = new JButton("Ver cliente");

        mostrarCliente.addActionListener((e) -> {
            if (tabla.getRowCount() != 0) {
                String fecha = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
                int fila = tabla.getSelectedRow();
                if (fila != -1) {
                    Factura factura = new Factura(clientes.get(fila).getNombre(), "Llevar", "Ventanilla", fila, fecha, clientes.get(fila).getPedidos());
                    VentanaFacturaLlevar vista = new VentanaFacturaLlevar(factura, clientes, clientesExpress,meseros);
                    vista.init(mesas);
                    setVisible(false);
                }
            } else {
                JOptionPane.showMessageDialog(null, "NO HAY CLIENTES");
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(scroll, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(regresar, gbc);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(mostrarCliente, gbc);

        c.add(mainPanel);
    }

}
