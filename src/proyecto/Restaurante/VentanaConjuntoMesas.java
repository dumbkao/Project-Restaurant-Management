
package proyecto.Restaurante;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import proyecto.Pedido.VentanaMesa;

public class VentanaConjuntoMesas extends JFrame {
    private final ConjuntoMesas mesas;
    private ArrayList<JButton> botones;
    
    public VentanaConjuntoMesas(String titulo, ConjuntoMesas mesas) {
        super(titulo);
        this.mesas = mesas;
        botones = new ArrayList();
    }
    public void init() {
        setSize(550, 370);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        AdjustComponents(getContentPane());
        AgregarEventos();
        setResizable(false);
        setVisible(true);
    }
    public void AdjustComponents(Container container) {
        JPanel panel_principal = new JPanel(new FlowLayout());
        ImageIcon icono = new ImageIcon("src/images/mesa d.png");
        for (int i = 0; i < mesas.getCantidad_de_mesas(); i++) {
            JButton boton = new JButton();
            boton.setIcon(icono);
            botones.add(boton);
            panel_principal.add(boton);
        }
        container.add(panel_principal);
        
    }
    public void AgregarEventos() {
        botones.get(0).addActionListener((ActionEvent e) -> {
            mesas.getMesas().get(0).setDisponibilidad(false);
            botones.get(0).setIcon(new ImageIcon("src/images/mesa o.png"));
            botones.get(0).updateUI();
            VentanaMesa vista = new VentanaMesa(mesas.getMesas().get(0), "Mesa 1");
            vista.iniciar();
        });
        botones.get(1).addActionListener((ActionEvent e) -> {
            mesas.getMesas().get(1).setDisponibilidad(false);
            botones.get(1).setIcon(new ImageIcon("src/images/mesa o.png"));
            botones.get(1).updateUI();
        });
        botones.get(2).addActionListener((ActionEvent e) -> {
            mesas.getMesas().get(2).setDisponibilidad(false);
            botones.get(2).setIcon(new ImageIcon("src/images/mesa o.png"));
            botones.get(2).updateUI();
        });
        botones.get(3).addActionListener((ActionEvent e) -> {
            mesas.getMesas().get(3).setDisponibilidad(false);
            botones.get(3).setIcon(new ImageIcon("src/images/mesa o.png"));
            botones.get(3).updateUI();
        });
        botones.get(4).addActionListener((ActionEvent e) -> {
            mesas.getMesas().get(4).setDisponibilidad(false);
            botones.get(4).setIcon(new ImageIcon("src/images/mesa o.png"));
            botones.get(4).updateUI();
        });
        botones.get(5).addActionListener((ActionEvent e) -> {
            mesas.getMesas().get(5).setDisponibilidad(false);
            botones.get(5).setIcon(new ImageIcon("src/images/mesa o.png"));
            botones.get(5).updateUI();
        });
        botones.get(6).addActionListener((ActionEvent e) -> {
            mesas.getMesas().get(6).setDisponibilidad(false);
            botones.get(6).setIcon(new ImageIcon("src/images/mesa o.png"));
            botones.get(6).updateUI();
        });
        botones.get(7).addActionListener((ActionEvent e) -> {
            mesas.getMesas().get(7).setDisponibilidad(false);
            botones.get(7).setIcon(new ImageIcon("src/images/mesa o.png"));
            botones.get(7).updateUI();
        });
        botones.get(8).addActionListener((ActionEvent e) -> {
            mesas.getMesas().get(8).setDisponibilidad(false);
            botones.get(8).setIcon(new ImageIcon("src/images/mesa o.png"));
            botones.get(8).updateUI();
        });
        botones.get(9).addActionListener((ActionEvent e) -> {
            mesas.getMesas().get(9).setDisponibilidad(false);
            botones.get(9).setIcon(new ImageIcon("src/images/mesa o.png"));
            botones.get(9).updateUI();
        });
        botones.get(10).addActionListener((ActionEvent e) -> {
            mesas.getMesas().get(10).setDisponibilidad(false);
            botones.get(10).setIcon(new ImageIcon("src/images/mesa o.png"));
            botones.get(10).updateUI();
        });
        botones.get(11).addActionListener((ActionEvent e) -> {
            mesas.getMesas().get(11).setDisponibilidad(false);
            botones.get(11).setIcon(new ImageIcon("src/images/mesa o.png"));
            botones.get(11).updateUI();
        });
        botones.get(12).addActionListener((ActionEvent e) -> {
            mesas.getMesas().get(12).setDisponibilidad(false);
            botones.get(12).setIcon(new ImageIcon("src/images/mesa o.png"));
            botones.get(12).updateUI();
        });
        botones.get(13).addActionListener((ActionEvent e) -> {
            mesas.getMesas().get(13).setDisponibilidad(false);
            botones.get(13).setIcon(new ImageIcon("src/images/mesa o.png"));
            botones.get(13).updateUI();
        });
        botones.get(14).addActionListener((ActionEvent e) -> {
            mesas.getMesas().get(14).setDisponibilidad(false);
            botones.get(14).setIcon(new ImageIcon("src/images/mesa o.png"));
            botones.get(14).updateUI();
        });
        botones.get(15).addActionListener((ActionEvent e) -> {
            mesas.getMesas().get(15).setDisponibilidad(false);
            botones.get(15).setIcon(new ImageIcon("src/images/mesa o.png"));
            botones.get(15).updateUI();
        });
        botones.get(16).addActionListener((ActionEvent e) -> {
            mesas.getMesas().get(16).setDisponibilidad(false);
            botones.get(16).setIcon(new ImageIcon("src/images/mesa o.png"));
            botones.get(16).updateUI();
        });
        botones.get(17).addActionListener((ActionEvent e) -> {
            mesas.getMesas().get(17).setDisponibilidad(false);
            botones.get(17).setIcon(new ImageIcon("src/images/mesa o.png"));
            botones.get(17).updateUI();
        });
        botones.get(18).addActionListener((ActionEvent e) -> {
            mesas.getMesas().get(18).setDisponibilidad(false);
            botones.get(18).setIcon(new ImageIcon("src/images/mesa o.png"));
            botones.get(18).updateUI();
        });
        botones.get(19).addActionListener((ActionEvent e) -> {
            mesas.getMesas().get(19).setDisponibilidad(false);
            botones.get(19).setIcon(new ImageIcon("src/images/mesa o.png"));
            botones.get(19).updateUI();
        });   
    }
}
