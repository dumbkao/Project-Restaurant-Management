/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.Restaurante;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author hilla
 */
public class VentanaRestaurante extends JFrame {

    private JButton btnAdmi, btnMesero;
    private JLabel nombreRestaurante;
    JPanel pnlPrincipal;

    public VentanaRestaurante() {
        super("Restaurante uwu");
        btnAdmi = new JButton("Módulo administrador");
        btnMesero = new JButton("Módulo mesero");
        nombreRestaurante = new JLabel("Restaurante uwu");
        ajustarComponentes(getContentPane());
    }

    public void ajustarComponentes(Container c) {
        pnlPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.gridx = 0;
        constraints.gridy = 0;
        pnlPrincipal.add(nombreRestaurante, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        pnlPrincipal.add(btnAdmi, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        pnlPrincipal.add(btnMesero, constraints);

        c.add(pnlPrincipal);

        btnAdmi.addActionListener((e) -> {
            c.remove(pnlPrincipal);
            JPanel plnAdmi = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            JButton ingresarMesero = new JButton("Ingresar mesero");
            JButton cambiarMenu = new JButton("Cambiar menu");
            gbc.gridx = 0;
            gbc.gridy = 0;
            plnAdmi.add(ingresarMesero, gbc);
            gbc.gridx = 0;
            gbc.gridy = 1;
            plnAdmi.add(cambiarMenu, gbc);
            c.add(plnAdmi);
            c.repaint();
        });

        btnMesero.addActionListener((e) -> {

        });

    }

    public void init() {
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

}
