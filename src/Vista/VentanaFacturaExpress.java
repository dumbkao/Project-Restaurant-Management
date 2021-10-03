package Vista;

import Clases.Cliente;
import Clases.ConjuntoMesas;
import Clases.Factura;
import Clases.Pedido;
import java.util.ArrayList;
import javax.swing.JFrame;
import Clases.Factura;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VentanaFacturaExpress extends JFrame {

    private ArrayList<Cliente> clientes;
    private ArrayList<Cliente> clientesExpress;
    private ArrayList<Pedido> pedidos;
    private final Factura factura;
    private JButton btnRegresar;

    public VentanaFacturaExpress(Factura factura, ArrayList<Cliente> clientes, ArrayList<Cliente> clientesExpress) {
        super("Factura Express ");
        this.factura = factura;
        this.clientes = clientes;
        this.clientesExpress = clientesExpress;
    }

    public void iniciar(ConjuntoMesas mesas) {
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        ajustarComponentes(getContentPane(), mesas);
        setVisible(true);
    }

    /*public void ajustarComponentes(Container container, ConjuntoMesas mesas) {
        pedidos = factura.getPedidos();

        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPrincipal = new GridBagConstraints();
        GridBagConstraints gbc2 = new GridBagConstraints();

        JPanel panel1 = new JPanel();
        JPanel subPanel1 = new JPanel(new GridLayout());
        JPanel subPanel2 = new JPanel(new GridLayout());
        JPanel panel2 = new JPanel(new GridBagLayout());
        JPanel panel3 = new JPanel(new GridLayout());
        JPanel panel4 = new JPanel(new FlowLayout());

        btnRegresar = new JButton("Regresar");

        String espacios = "         ";

        JLabel nombre = new JLabel("Nombre: " + factura.getNombre() + espacios);
        JLabel servicio = new JLabel("Servicio: " + factura.getServicio());
        JLabel mesero = new JLabel("Mesero: " + factura.getMesero());
        JLabel numero = new JLabel(espacios + "Fac. Nro: " + factura.getNumero());
        JLabel fecha = new JLabel(espacios + "Fecha: " + factura.getFecha());

        Font calibri = new Font("Calibri", 3, 15);
        nombre.setFont(calibri);
        servicio.setFont(calibri);
        mesero.setFont(calibri);
        numero.setFont(calibri);
        fecha.setFont(calibri);

        subPanel1.add(nombre);
        subPanel1.add(servicio);
        subPanel1.add(mesero);
        subPanel1.add(numero);
        subPanel1.add(fecha);

        String columnas[] = {"Cantidad", "Nombre", "Precio"};

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

        panel1.add(subPanel1);
        panel1.add(imagen);
        panel1.add(subPanel2);

        gbc2.gridx = 0;
        gbc2.gridy = 0;
        panel2.add(tabla.getTableHeader(), gbc2);
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        panel2.add(scroll, gbc2);

        JLabel total = new JLabel("Total: " + factura.Total());
        JLabel iva = new JLabel("IVA: " + factura.Iva(factura.Total()));
        JLabel total_iva = new JLabel("Total IVA: " + (factura.Total() + factura.Iva(factura.Total())));

        total.setFont(calibri);
        iva.setFont(calibri);
        total_iva.setFont(calibri);

        panel3.add(total);
        panel3.add(iva);
        panel3.add(total_iva);

        panel4.add(btnRegresar);

        gbcPrincipal.insets = new Insets(5, 5, 5, 5);
        panelPrincipal.add(panel1, gbcPrincipal);

        gbcPrincipal.gridx = 0;
        gbcPrincipal.gridy = 1;
        panelPrincipal.add(panel2, gbcPrincipal);

        gbcPrincipal.gridx = 0;
        gbcPrincipal.gridy = 2;
        panelPrincipal.add(panel3, gbcPrincipal);

        gbcPrincipal.gridx = 0;
        gbcPrincipal.gridy = 3;
        panelPrincipal.add(panel4, gbcPrincipal);
        container.add(panelPrincipal, BorderLayout.NORTH);
    }*/
    public void ajustarComponentes(Container container, ConjuntoMesas mesas) {
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
            VentanaPedidosExpress vista = new VentanaPedidosExpress(clientes, clientesExpress);
            vista.iniciar(mesas);
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
