package Vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import Clases.Factura;
import Clases.Pedido;
import Clases.Cliente;
import Clases.ConjuntoMesas;

public class VentanaFactura extends JFrame {

    private ArrayList<Pedido> pedidos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Cliente> clientesExpress;
    private ArrayList<String> meseros;
    private final Factura factura;
    private final int numero_mesa;

    public VentanaFactura(Factura factura, int numero_mesa, ArrayList<Cliente> clientes, ArrayList<Cliente> clientesExpress,ArrayList<String> meseros) {
        super("Factura Mesa " + (numero_mesa+1));
        this.factura = factura;
        this.numero_mesa = numero_mesa;
        this.clientes = clientes;
        this.clientesExpress = clientesExpress;
        this.meseros=meseros;
    }

    public void init(ConjuntoMesas mesas, String ventana) {
        setSize(570, 680);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        ajustarComponentes(getContentPane(), mesas, ventana);
        setVisible(true);
    }

    public void ajustarComponentes(Container container, ConjuntoMesas mesas, String ventana) {
        String espacios = "         ";
        JPanel panel_principal = new JPanel(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();

        JPanel subpanel1 = new JPanel(new BorderLayout());
        JPanel subpanel1A = new JPanel(new GridLayout(3, 1));
        JPanel subpanel1B = new JPanel(new GridLayout(2, 1));

        JPanel subpanel2 = new JPanel(new GridBagLayout());
        GridBagConstraints constraint2 = new GridBagConstraints();

        JPanel subpanel3 = new JPanel(new GridLayout(3, 1));

        JPanel panel_boton = new JPanel(new FlowLayout());

        Font calibri = new Font("Calibri", 3, 15);

        JLabel nombre = new JLabel("Nombre: " + factura.getNombre() + espacios);
        JLabel servicio = new JLabel("Servicio: " + factura.getServicio());
        JLabel mesero = new JLabel("Mesero: " + factura.getMesero());
        JLabel numero = new JLabel(espacios + "Fac. Nro: " + factura.getNumero());
        JLabel fecha = new JLabel(espacios + "Fecha: " + factura.getFecha());
        JLabel total = new JLabel("Total: " + factura.Total());
        JLabel iva = new JLabel("IVA: " + factura.Iva(factura.Total()));
        JLabel total_iva = new JLabel("Total IVA: " + (factura.Total() + factura.Iva(factura.Total())));

        JButton regresar = new JButton("Regresar");

        nombre.setFont(calibri);
        servicio.setFont(calibri);
        mesero.setFont(calibri);
        numero.setFont(calibri);
        fecha.setFont(calibri);
        total.setFont(calibri);
        iva.setFont(calibri);
        total_iva.setFont(calibri);

        String columnas[] = {"Cantidad", "Nombre", "Precio"};
        pedidos = factura.getPedidos();
        String datos[][] = new String[pedidos.size()][columnas.length];
        for (int i = 0; i < pedidos.size(); i++) {
            String data[] = {pedidos.get(i).getCantidad() + "", pedidos.get(i).getDetalle().getNombre(), pedidos.get(i).getDetalle().getPrecio() + ""};
            datos[i] = data;
        }
        JTable tabla = new JTable(datos, columnas);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(200);

        tabla.setFont(calibri);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JLabel imagen = new JLabel();
        ImageIcon imagen_icono = new ImageIcon("src/images/restaurante.png");
        imagen.setIcon(imagen_icono);

        regresar.addActionListener((e) -> {
            if (ventana.equals("Mesa")) {
                VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(numero_mesa), "Mesa " + (numero_mesa + 1), clientes, clientesExpress,meseros);
                vista.init(mesas);
            }
            setVisible(false);
        });

        subpanel1A.add(nombre);
        subpanel1A.add(servicio);
        subpanel1A.add(mesero);
        subpanel1B.add(numero);
        subpanel1B.add(fecha);

        subpanel1.add(subpanel1A, BorderLayout.WEST);
        subpanel1.add(imagen, BorderLayout.CENTER);
        subpanel1.add(subpanel1B, BorderLayout.EAST);

        constraint2.gridx = 0;
        constraint2.gridy = 0;
        subpanel2.add(tabla.getTableHeader(), constraint2);
        constraint2.gridx = 0;
        constraint2.gridy = 1;
        subpanel2.add(scroll, constraint2);

        subpanel3.add(total);
        subpanel3.add(iva);
        subpanel3.add(total_iva);

        panel_boton.add(regresar);

        constraint.gridx = 0;
        constraint.gridy = 0;
        constraint.insets = new Insets(5, 5, 5, 5);
        panel_principal.add(subpanel1, constraint);
        constraint.gridx = 0;
        constraint.gridy = 1;
        panel_principal.add(subpanel2, constraint);
        constraint.gridx = 0;
        constraint.gridy = 2;
        panel_principal.add(subpanel3, constraint);
        constraint.gridx = 0;
        constraint.gridy = 3;
        panel_principal.add(panel_boton, constraint);

        container.add(panel_principal, BorderLayout.NORTH);
    }

}
