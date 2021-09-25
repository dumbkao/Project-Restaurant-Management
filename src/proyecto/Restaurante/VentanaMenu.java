package proyecto.Restaurante;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Insets;

public class VentanaMenu extends JFrame {
    public VentanaMenu() {
    }
    
    public void AjustarComponentes(Container container) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel panel1 = new JPanel(new GridLayout(2, 4));
        JPanel panel2 = new JPanel(new GridLayout(2, 2));
        JButton btn1 = new JButton();
        JButton btn2 = new JButton();
        JButton btn3 = new JButton();
        JButton btn4 = new JButton();
        JButton btn5 = new JButton();
        JButton btn6 = new JButton();
        JButton btn7 = new JButton();
        JButton btn8 = new JButton();
        JButton btn9 = new JButton("Añadir");
        ImageIcon icono = new ImageIcon("src/images/cola.png");
        ImageIcon icono1 = new ImageIcon("src/images/naranja.png");
        ImageIcon icono2 = new ImageIcon("src/images/agua.png");
        ImageIcon icono3 = new ImageIcon("src/images/cerveza.png");
        ImageIcon icono4 = new ImageIcon("src/images/hamburguesa.png");
        ImageIcon icono5 = new ImageIcon("src/images/pizza.png");
        ImageIcon icono6 = new ImageIcon("src/images/pollo.png");
        ImageIcon icono7 = new ImageIcon("src/images/sandwich.png");
        btn1.setIcon(icono);
        btn2.setIcon(icono1);
        btn3.setIcon(icono2);
        btn4.setIcon(icono3);
        btn5.setIcon(icono4);
        btn6.setIcon(icono5);
        btn7.setIcon(icono6);
        btn8.setIcon(icono7);

        panel1.add(btn1);
        panel1.add(btn2);
        panel1.add(btn3);
        panel1.add(btn4);
        panel1.add(btn5);
        panel1.add(btn6);
        panel1.add(btn7);
        panel1.add(btn8);

        JLabel lab1 = new JLabel("Cantidad");
        JTextField txt1 = new JTextField(5);
        JLabel lab2 = new JLabel("Numero de mesa   ");
        JComboBox box1 = new JComboBox();

        box1.addItem(1);
        box1.addItem(2);
        box1.addItem(3);
        box1.addItem(4);
        box1.addItem(5);
        box1.addItem(6);
        box1.addItem(7);
        box1.addItem(8);
        box1.addItem(9);
        box1.addItem(10);
        box1.addItem(11);
        box1.addItem(12);
        box1.addItem(13);
        box1.addItem(14);
        box1.addItem(15);
        box1.addItem(16);
        box1.addItem(17);
        box1.addItem(18);
        box1.addItem(19);
        box1.addItem(20);
        
        panel2.add(lab1);
        panel2.add(txt1);
        panel2.add(lab2);
        panel2.add(box1);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets= new Insets(5,5,20,5);
        panel.add(panel1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(panel2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(btn9,gbc);
        
        container.add(panel, BorderLayout.NORTH);
    }
    public void init() {
        setSize(450, 310);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        AjustarComponentes(getContentPane());
        setVisible(true);
    }
}