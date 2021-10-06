package Vista;

import Clases.Cliente;
import Clases.ConjuntoMesas;
import Clases.Pedido;
import Clases.Platillo;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaMenuExpress extends JFrame {

    private ArrayList<Cliente> clientes;
    private ArrayList<Cliente> clientesExpress;
    private ArrayList<Pedido> pedidos;
    private ArrayList<String> meseros;
    private Platillo platillo_seleccionado;
    private boolean aceptado;

    public VentanaMenuExpress(ArrayList<Cliente> clientes, ArrayList<Cliente> clientesExpress,ArrayList<String> meseros) {
        super("Ventana Menu Express");
        this.clientes = clientes;
        this.clientesExpress = clientesExpress;
        pedidos = new ArrayList();
        aceptado = false;
        this.meseros=meseros;
    }

    public void iniciar(String nombre, String telefono, String direccion, ConjuntoMesas mesas) {
        setSize(450, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        ajustarComponentes(getContentPane(), nombre, telefono, direccion, mesas);
        setVisible(true);
    }

    public void ajustarComponentes(Container container, String nombre, String telefono, String direccion, ConjuntoMesas mesas) {
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        JPanel panel1 = new JPanel(new GridLayout(2, 4));
        JPanel panel2 = new JPanel(new GridLayout(2, 2));
        GridBagConstraints gbc = new GridBagConstraints();

        JButton btn1 = new JButton();
        JButton btn2 = new JButton();
        JButton btn3 = new JButton();
        JButton btn4 = new JButton();
        JButton btn5 = new JButton();
        JButton btn6 = new JButton();
        JButton btn7 = new JButton();
        JButton btn8 = new JButton();
        JButton btnAgregar = new JButton("Añadir");
        JButton regresar = new JButton("Regresar");
        JButton btn_aceptar = new JButton("Aceptar Pedido");
        JButton btn_ver_pedidos = new JButton("Ver Pedidos");
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

        JLabel lab1 = new JLabel("Cantidad: ");
        JTextField txt1 = new JTextField(5);

        panel2.add(lab1);
        panel2.add(txt1);

        btn1.addActionListener((e) -> {
            Platillo cola_cola = new Platillo("Coca Cola", 1000);
            setPlatillo(cola_cola);
        });
        btn2.addActionListener((e) -> {
            Platillo jugo_naranja = new Platillo("Jugo de Naranja", 800);
            setPlatillo(jugo_naranja);
        });
        btn3.addActionListener((e) -> {
            Platillo agua = new Platillo("Botella con Agua", 1500);
            setPlatillo(agua);
        });
        btn4.addActionListener((e) -> {
            Platillo cerveza = new Platillo("Cerveza", 2000);
            setPlatillo(cerveza);
        });
        btn5.addActionListener((e) -> {
            Platillo hamburguesa = new Platillo("Hamburguesa", 2200);
            setPlatillo(hamburguesa);
        });
        btn6.addActionListener((e) -> {
            Platillo pizza = new Platillo("1 Slice de Pizza", 1000);
            setPlatillo(pizza);
        });
        btn7.addActionListener((e) -> {
            Platillo pollo = new Platillo("Porcion de Muslo y Cadera", 2000);
            setPlatillo(pollo);
        });
        btn8.addActionListener((e) -> {
            Platillo sandwich = new Platillo("Sandwich de Jamon y Queso", 1500);
            setPlatillo(sandwich);
        });

        btnAgregar.addActionListener((e) -> {
            int contador = 0;
            for (int i = 0; i < txt1.getText().length(); i++) {
                if (Character.isDigit(txt1.getText().charAt(i))) {
                    contador++;
                }
            }
            if (contador == txt1.getText().length()) {
                if (platillo_seleccionado == null || txt1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar un platillo y digitar una cantidad");
                } else {
                    Pedido pedido = new Pedido(Integer.parseInt(txt1.getText()), platillo_seleccionado);
                    pedidos.add(pedido);
                    JOptionPane.showMessageDialog(null, "Recuerde darle click en 'aceptar pedido'");
                }
            }
        });

        btn_ver_pedidos.addActionListener((e) -> {
            if (aceptado == false) {
                JOptionPane.showMessageDialog(null, "No hay pedidos", "No ha agregado ninguna orden", JOptionPane.ERROR_MESSAGE);
            }
            for (int i = 0; i < clientesExpress.size(); i++) {
                if (clientesExpress.get(i).getNombre().equals(nombre)) {
                    VentanaPedidoExpress vista = new VentanaPedidoExpress(clientesExpress.get(i).getPedidos(), clientes, clientesExpress,meseros);
                    vista.iniciar(nombre, telefono, "express", mesas);
                    setVisible(false);
                }
            }
        });

        btn_aceptar.addActionListener((e) -> {
            if (pedidos.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay pedidos", "No ha agregado ninguna orden", JOptionPane.ERROR_MESSAGE);
            } else {
                Cliente cliente = new Cliente(nombre, direccion, telefono, pedidos);
                clientesExpress.add(cliente);
                aceptado = true;
            }
        });

        regresar.addActionListener((e) -> {
            VentanaExpress ventana = new VentanaExpress(clientes, clientesExpress,meseros);
            ventana.iniciar(mesas);
            setVisible(false);
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 20, 5);
        panelPrincipal.add(panel1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelPrincipal.add(panel2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelPrincipal.add(btnAgregar, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelPrincipal.add(btn_ver_pedidos, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panelPrincipal.add(btn_aceptar, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        panelPrincipal.add(regresar, gbc);

        container.add(panelPrincipal, BorderLayout.NORTH);
    }

    public void setPlatillo(Platillo platillo) {
        this.platillo_seleccionado = platillo;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
