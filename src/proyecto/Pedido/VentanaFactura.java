
package proyecto.Pedido;

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
import javax.swing.JScrollPane;

public class VentanaFactura extends JFrame {
    private ArrayList<Pedido> pedidos;
    private final Factura factura;
    
    public VentanaFactura(Factura factura, String titulo) {
        super(titulo);
        this.factura = factura;
    }
    public void ajustarComponentes(Container container) {
        String espacios = "         ";
        JPanel panel_principal = new JPanel(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();
        
        JPanel subpanel1 = new JPanel(new BorderLayout());
        JPanel subpanel1A = new JPanel(new GridLayout(3, 1));
        JPanel subpanel1B = new JPanel(new GridLayout(2, 1));
        
        JPanel subpanel2 = new JPanel(new GridBagLayout());
        GridBagConstraints constraint2 = new GridBagConstraints();
        
        JPanel subpanel3 = new JPanel(new GridLayout(3, 1));
        
        Font calibri = new Font("Calibri", 3, 15);
        
        JLabel nombre = new JLabel("Nombre: " + factura.getNombre() + espacios);
        JLabel servicio = new JLabel("Servicio: " + factura.getServicio());
        JLabel mesero = new JLabel("Mesero: " + factura.getMesero());
        JLabel numero = new JLabel(espacios + "Fac. Nro: " + factura.getNumero());
        JLabel fecha = new JLabel(espacios + "Fecha: " + factura.getFecha());
        JLabel total = new JLabel("Total: " + factura.Total());
        JLabel iva = new JLabel("IVA: " + factura.Iva(factura.Total()));
        JLabel total_iva = new JLabel("Total IVA: " + (factura.Total() + factura.Iva(factura.Total())));
        
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
        
        container.add(panel_principal, BorderLayout.NORTH);
    }
    public void init() {
        setSize(570, 610);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        ajustarComponentes(getContentPane());
        setVisible(true);
    }
}
