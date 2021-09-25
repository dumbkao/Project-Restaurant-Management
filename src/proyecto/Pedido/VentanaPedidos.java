
package proyecto.Pedido;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VentanaPedidos extends JFrame {
    private ArrayList<Pedido> pedidos;
    
    public VentanaPedidos(ArrayList<Pedido> pedidos, String titulo) {
        super(titulo);
        this.pedidos = pedidos;
    }
    public void ajustarComponentes(Container container) {
        JPanel panel_principal = new JPanel(new GridLayout(2, 2));
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
        panel_principal.add(tabla.getTableHeader());
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel_principal.add(scroll);
        container.add(panel_principal, BorderLayout.NORTH);
    }
    public void init() {
        setSize(600, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        ajustarComponentes(getContentPane());
        setVisible(true);
    }
}
