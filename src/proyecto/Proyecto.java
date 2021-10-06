package proyecto;

import Clases.ConjuntoMesas;
import Clases.Cliente;
import Clases.Mesa;
import Vista.VentanaRestaurante;
import java.util.ArrayList;

public class Proyecto {

    public static void main(String[] args) {
        Mesa mesa = new Mesa();
        Mesa mesa1 = new Mesa();
        Mesa mesa2 = new Mesa();
        Mesa mesa3 = new Mesa();
        Mesa mesa4 = new Mesa();
        Mesa mesa5 = new Mesa();
        Mesa mesa6 = new Mesa();
        Mesa mesa7 = new Mesa();
        Mesa mesa8 = new Mesa();
        Mesa mesa9 = new Mesa();
        Mesa mesa10 = new Mesa();
        Mesa mesa11 = new Mesa();
        Mesa mesa12 = new Mesa();
        Mesa mesa13 = new Mesa();
        Mesa mesa14 = new Mesa();
        Mesa mesa15 = new Mesa();
        Mesa mesa16 = new Mesa();
        Mesa mesa17 = new Mesa();
        Mesa mesa18 = new Mesa();
        Mesa mesa19 = new Mesa();
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
        for(int i=0; i<20;i++){
            mesas.getMesas().get(i).setNumero(i);
        }
        ArrayList<Cliente> clientes = new ArrayList();
        ArrayList<Cliente> clientesExpress = new ArrayList();
        ArrayList<String> meseros = new ArrayList();
        meseros.add("Andres");
        meseros.add("Ramses");
        meseros.add("Hillary");
        VentanaRestaurante vista = new VentanaRestaurante(clientes, clientesExpress,meseros);
        vista.init(mesas);
    }
}
