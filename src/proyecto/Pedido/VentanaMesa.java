package proyecto.Pedido;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class VentanaMesa extends JFrame {
    
    private ArrayList<Pedido> pedidos;
    private Mesa mesa;
    private JButton btnVerPedidos;
    private JButton btnCambiarDispo;
    private JButton btnVerFactura;
    
    public VentanaMesa(Mesa mesa, String titulo) {
        super(titulo);
        this.mesa = mesa;
        pedidos = mesa.getPedidos();
    }
    
    public void iniciar() {
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        ajustarComponentes(getContentPane());
        setVisible(true);
    }
    
    public void ajustarComponentes(Container container) {
        JPanel pnlPrincipal = new JPanel(new GridLayout(2, 0));
        
        JPanel pnl1 = new JPanel(new FlowLayout());
        JPanel pnl2 = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        JLabel comensales = new JLabel("Cantidad de personas: " + mesa.getComensales());
        JLabel disponible = new JLabel("La mesa está");
        JLabel ocupada = new JLabel("");
        JLabel btnMesa = new JLabel();
        
        btnVerPedidos = new JButton("Ver pedidos");
        btnCambiarDispo = new JButton("Cambiar disponibilidad");
        btnVerFactura = new JButton("Ver factura");
        
        btnCambiarDispo.addActionListener((ActionEvent e) -> {
            if (mesa.isDisponible() == true) {
                mesa.setDisponibilidad(false);
            } else {
                mesa.setDisponibilidad(true);
            }
            if (mesa.isDisponible() == true) {
                ocupada.setText("disponible");
                ImageIcon icnMesa = new ImageIcon("src/images/mesa d.png");
                btnMesa.setIcon(icnMesa);
                pnlPrincipal.remove(pnl2);
                pnlPrincipal.updateUI();
            } else {
                ocupada.setText("ocupada");
                ImageIcon icnMesa = new ImageIcon("src/images/mesa o.png");
                btnMesa.setIcon(icnMesa);
                pnl1.add(comensales);
                c.insets = new Insets(5, 5, 5, 5);
                c.gridx = 0;
                c.gridy = 0;
                pnl2.add(btnVerPedidos, c);
                c.gridx = 0;
                c.gridy = 1;
                pnl2.add(btnCambiarDispo, c);
                c.gridx = 0;
                c.gridy = 2;
                pnl2.add(btnVerFactura, c);
            }
            btnCambiarDispo.updateUI();
        });
        
        pnl1.add(btnMesa);
        pnl1.add(disponible);
        pnl1.add(ocupada);
        
        if (mesa.isDisponible() == true) {
            ocupada.setText("disponible");
            ImageIcon icnMesa = new ImageIcon("src/images/mesa d.png");
            btnMesa.setIcon(icnMesa);
        } else {
            ocupada.setText("ocupada");
            ImageIcon icnMesa = new ImageIcon("src/images/mesa o.png");
            btnMesa.setIcon(icnMesa);
            pnl1.add(comensales);
            c.insets = new Insets(5, 5, 5, 5);
            c.gridx = 0;
            c.gridy = 0;
            pnl2.add(btnVerPedidos, c);
            c.gridx = 0;
            c.gridy = 1;
            pnl2.add(btnCambiarDispo, c);
            c.gridx = 0;
            c.gridy = 2;
            pnl2.add(btnVerFactura, c);
        }
        
        pnlPrincipal.add(pnl1);
        pnlPrincipal.add(pnl2);
        container.add(pnlPrincipal);
    }
}
