package proyecto;

import java.util.ArrayList;
import proyecto.Platillo.*;
import proyecto.Pedido.*;
import proyecto.Restaurante.*;

public class Proyecto {

    public static void main(String[] args) {
        ArrayList<Pedido> pedidos = new ArrayList();

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
        pedidos.add(pedido5);
//        
        Factura factura = new Factura("Ramses Solano Arias", "Mesa", "Javier Cartin", 1, "29-10-2021", pedidos);
        VentanaFactura vista = new VentanaFactura(factura, "Factura");
        vista.init();

//        VentanaPedidos vista = new VentanaPedidos(pedidos, "Pedidos");
//        vista.init();
//        VentanaMenu vista = new VentanaMenu();
//        vista.init();
        /*Mesa mesa = new Mesa(0, "Juanito Mora");
        Mesa mesa1 = new Mesa(0, "Juanito Mora");
        Mesa mesa2 = new Mesa(0, "Juanito Mora");
        Mesa mesa3 = new Mesa(0, "Juanito Mora");
        Mesa mesa4 = new Mesa(1, "Juanito Mora");
        Mesa mesa5 = new Mesa(1, "Juanito Mora");
        Mesa mesa6 = new Mesa(1, "Juanito Mora");
        Mesa mesa7 = new Mesa(1, "Juanito Mora");
        Mesa mesa8 = new Mesa(1, "Juanito Mora");
        Mesa mesa9 = new Mesa(1, "Juanito Mora");
        Mesa mesa10 = new Mesa(1, "Juanito Mora");
        Mesa mesa11 = new Mesa(1, "Juanito Mora");
        Mesa mesa12 = new Mesa(1, "Juanito Mora");
        Mesa mesa13 = new Mesa(1, "Juanito Mora");
        Mesa mesa14 = new Mesa(1, "Juanito Mora");
        Mesa mesa15 = new Mesa(1, "Juanito Mora");
        Mesa mesa16 = new Mesa(1, "Juanito Mora");
        Mesa mesa17 = new Mesa(1, "Juanito Mora");
        Mesa mesa18 = new Mesa(1, "Juanito Mora");
        Mesa mesa19 = new Mesa(1, "Juanito Mora");
//
////          VentanaMesa vista = new VentanaMesa(mesa, "Mesa");
////          vista.iniciar();
        ConjuntoMesas mesas = new ConjuntoMesas();
        mesas.AgregarMesa(mesa);
        mesas.AgregarMesa(mesa1);
        mesas.AgregarMesa(mesa2);
        mesas.AgregarMesa(mesa3);
        mesas.AgregarMesa(mesa4);
        mesas.AgregarMesa(mesa5);
        mesas.AgregarMesa(mesa6);
        mesas.AgregarMesa(mesa7);
        mesas.AgregarMesa(mesa8);
        mesas.AgregarMesa(mesa9);
        mesas.AgregarMesa(mesa10);
        mesas.AgregarMesa(mesa11);
        mesas.AgregarMesa(mesa12);
        mesas.AgregarMesa(mesa13);
        mesas.AgregarMesa(mesa14);
        mesas.AgregarMesa(mesa15);
        mesas.AgregarMesa(mesa16);
        mesas.AgregarMesa(mesa17);
        mesas.AgregarMesa(mesa18);
        mesas.AgregarMesa(mesa19);
//
        VentanaConjuntoMesas vista = new VentanaConjuntoMesas("Conjunto Mesas", mesas);
        vista.init();*/
    }
}
