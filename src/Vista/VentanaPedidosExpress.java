package Vista;

import Clases.Cliente;
import Clases.ConjuntoMesas;
import Clases.Factura;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VentanaPedidosExpress extends JFrame {

    private ArrayList<Cliente> clientes;
    private ArrayList<Cliente> clientesExpress;
    private ArrayList<String> meseros;
    private JButton btnRegresar, btnMostrarCliente;

    public VentanaPedidosExpress(ArrayList<Cliente> clientes, ArrayList<Cliente> clientesExpress,ArrayList<String> meseros) {
        super("Pedidos Express");
        this.clientes = clientes;
        this.clientesExpress = clientesExpress;
        this.meseros=meseros;
    }

    public void iniciar(ConjuntoMesas mesas) {
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ajustarComponentes(getContentPane(), mesas);
        setVisible(true);
    }

    public void ajustarComponentes(Container container, ConjuntoMesas mesas) {
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        btnRegresar = new JButton("Regresar");
        btnMostrarCliente = new JButton("Ver cliente");

        String columnas[] = {"Nombre", "Direccion", "Telefono"};
        String datos[][] = new String[clientesExpress.size()][columnas.length];
        for (int i = 0; i < clientesExpress.size(); i++) {
            String detalle[] = {clientesExpress.get(i).getNombre(), clientesExpress.get(i).getNumero(), clientesExpress.get(i).getDireccion()};
            datos[i] = detalle;
        }

        JTable tabla = new JTable(datos, columnas);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        btnRegresar.addActionListener((e) -> {
            VentanaExpress ventana = new VentanaExpress(clientes, clientesExpress,meseros);
            ventana.iniciar(mesas);
            setVisible(false);
        });

        btnMostrarCliente.addActionListener((e) -> {
            if (tabla.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "NO HAY CLIENTES");
            } else {
                String fecha = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
                int fila = tabla.getSelectedRow();
                if (fila != -1) {
                    Factura factura = new Factura(clientesExpress.get(fila).getNombre(), "Express", "Motorizado", fila, fecha, clientesExpress.get(fila).getPedidos());
                    VentanaFacturaExpress ventana = new VentanaFacturaExpress(factura, clientes, clientesExpress,meseros);
                    ventana.iniciar(mesas);
                    setVisible(false);
                }
            }
        });

        panelPrincipal.add(scroll, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panelPrincipal.add(btnRegresar, gbc);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelPrincipal.add(btnMostrarCliente, gbc);

        container.add(panelPrincipal);
    }
}
