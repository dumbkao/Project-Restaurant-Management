package Clases;

import java.util.ArrayList;

public class Mesa {

    private ArrayList<Pedido> pedidos; //pedidos dentro de la mesa
    private int comensales; //cantidad de personas en la mesa
    private boolean disponible; //si la mesa está ocupada o no
    private int numero;
    private String mesero;

    public Mesa() {
        pedidos = new ArrayList();
        comensales = 0;
        disponible = true;
        mesero = "";
        numero = 0;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
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

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getMesero() {
        return mesero;
    }

    public void setMesero(String mesero) {
        this.mesero = mesero;
    }
}
