package proyecto;

import proyecto.Restaurante.VentanaRestaurante;
import java.util.ArrayList;
import proyecto.Pedido.Factura;
import proyecto.Platillo.Platillo;
import proyecto.Pedido.Pedido;
import proyecto.Pedido.VentanaFactura;
import proyecto.Pedido.VentanaPedidos;
import proyecto.Restaurante.VentanaMenu;

import proyecto.Pedido.Mesa;
import proyecto.Pedido.VentanaMesa;

public class Proyecto {

    public static void main(String[] args) {
        /*ArrayList<Pedido> pedidos = new ArrayList();

        Platillo platillo1 = new Platillo("Hamburguesa con Papas", 2400);
        Platillo platillo2 = new Platillo("Pollo 2 Piezas con Papas", 2600);
        Platillo platillo3 = new Platillo("Taco al Pastor", 500);

        Pedido pedido1 = new Pedido("Mesa", 3, platillo1);
        Pedido pedido2 = new Pedido("Llevar", 2, platillo2);
        Pedido pedido3 = new Pedido("Mesa", 7, platillo3);
        Pedido pedido4 = new Pedido("Express", 1, platillo1);
        Pedido pedido5 = new Pedido("Mesa", 4, platillo3);
        pedidos.add(pedido1);
        pedidos.add(pedido2);
        pedidos.add(pedido3);
        pedidos.add(pedido4);
        pedidos.add(pedido5);*/

 /*Factura factura = new Factura("Ramses Solano Arias", "Mesa", "Javier Cartin", 1, "29-10-2021", pedidos);
        VentanaFactura vista = new VentanaFactura(factura, "Factura");
        vista.init();*/
        // VentanaPedidos vista = new VentanaPedidos(pedidos, "Pedidos");
        // vista.init();
        /*VentanaMenu vista = new VentanaMenu();
       vista.init();*/
        Mesa mesa = new Mesa(0, "Pedro");
        mesa.setDisponibilidad(false);
        VentanaMesa vntMesa = new VentanaMesa(mesa, "Mesa");
        vntMesa.iniciar();

//        VentanaRestaurante ventanaRestaurante = new VentanaRestaurante();
//        ventanaRestaurante.init();
    }
}
