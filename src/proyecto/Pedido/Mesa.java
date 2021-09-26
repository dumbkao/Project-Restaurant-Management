package proyecto.Pedido;

import java.util.ArrayList;

public class Mesa {

    private ArrayList<Pedido> pedidos; //pedidos dentro de la mesa
    private int comensales; //cantidad de personas en la mesa
    private boolean disponible; //si la mesa está ocupada o no
    private String mesero;

    public Mesa(int n, String m) {
        pedidos = new ArrayList();
        comensales = n;
        disponible = true;
        mesero = m;
    }

    public void InsertarPedido(Pedido p) {
        pedidos.add(p);
    }

    public int getComensales() {
        return comensales;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setComensales(int n) {
        this.comensales = n;
    }

    public void setDisponibilidad(boolean n) {
        this.disponible = n;
    }
}
