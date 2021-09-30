
package Clases;

import Clases.Mesa;
import Clases.Pedido;
import java.util.ArrayList;

public class Restaurante {
    private ArrayList<Mesa> mesas;
    private ArrayList<Pedido> llevar;
    private ArrayList<Pedido> express;
    private ArrayList<String> meseros;
    private Menu menu;
    
    public Restaurante(Menu menu) {
        mesas = new ArrayList();
//        llevar = new ArrayList();
//        express = new ArrayList();
        meseros = new ArrayList();
        this.menu = menu;
    }
    public void InsertarMesa(Mesa mesa) {
        mesas.add(mesa);
    }
//    public void InsertarPedidoLlevar(Pedido pedido) {
//        llevar.add(pedido);
//    }
//    public void InsertarPedidoExpress(Pedido pedido) {
//        express.add(pedido);
//    }
    public void InsertarMeseros(String mesero) {
        meseros.add(mesero);
    }
    public ArrayList<Mesa> getMesas() {
        return mesas;
    }
//    public ArrayList<Pedido> getLlevar() {
//        return llevar;
//    }
//    public ArrayList<Pedido> getExpress() {
//        return express;
//    }
    public ArrayList<String> getMeseros() {
        return meseros;
    }
    public Menu getMenu() {
        return menu;
    }
    public Mesa RetornarMesa(int id) {
        return mesas.get(id);
    }
}
