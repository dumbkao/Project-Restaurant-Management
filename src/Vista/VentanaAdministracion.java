/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Clases.Cliente;
import Clases.ConjuntoMesas;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListModel;

/**
 *
 * @author hilla
 */
public class VentanaAdministracion extends JFrame {

    private JButton btnAgregarMeseros, btnEliminarMeseros, btnVerMeseros, btnRegresar;
    private ArrayList<Cliente> clientes;
    private ArrayList<Cliente> clientesExpress;
    private ArrayList<String> meseros;

    public VentanaAdministracion(ArrayList<Cliente> clientes, ArrayList<Cliente> clientesExpress, ArrayList<String> meseros) {
        btnAgregarMeseros = new JButton("Agregar meseros");
        btnEliminarMeseros = new JButton(" Eliminar meseros");
        btnVerMeseros = new JButton("Ver meseros");
        btnRegresar = new JButton("Regresar");
        this.clientes = clientes;
        this.clientesExpress = clientesExpress;
        this.meseros = meseros;
    }

    public void ajustarComponentes(Container c, ConjuntoMesas mesas) {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        btnAgregarMeseros.addActionListener((e) -> {
            String mesero = JOptionPane.showInputDialog(null, "Digite el nombre del mesero");
            if (mesero != null && !mesero.equals("")) {
                meseros.add(mesero);
                JOptionPane.showMessageDialog(null, "El mesero se ha agregado con exito");
            }

        });
        btnEliminarMeseros.addActionListener((e) -> {
            String mesero = JOptionPane.showInputDialog("Digite el nombre del mesero que desee eliminar");

            for (String i : meseros) {
                if (i.equals(mesero)) {
                    meseros.remove(i);
                    JOptionPane.showMessageDialog(null, "El mesero se ha eliminado con exito");
                    break;
                }
            }

        });
        btnVerMeseros.addActionListener((e) -> {
            JList listaMeseros = new JList(meseros.toArray());
            listaMeseros.setEnabled(false);
            if(!meseros.isEmpty()){
                  JOptionPane.showMessageDialog(null, listaMeseros);
            }else{
                JOptionPane.showMessageDialog(null, "No hay meseros registrados");
            }

        });
        btnRegresar.addActionListener((e) -> {
            VentanaRestaurante res = new VentanaRestaurante(clientes, clientesExpress, meseros);
            res.init(mesas);
            setVisible(false);
        });
        gbc.insets = new Insets(15, 15, 15, 15);

        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(btnAgregarMeseros, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(btnEliminarMeseros, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(btnVerMeseros, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(btnRegresar, gbc);

        c.add(mainPanel, BorderLayout.NORTH);
    }

    public void init(ConjuntoMesas mesas) {
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ajustarComponentes(getContentPane(), mesas);
        setVisible(true);
    }

}
