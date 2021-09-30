
package Clases;

import java.util.ArrayList;

public class Factura {
    private final String nombre;
    private final String servicio;
    private final String mesero;
    private final int numero;
    private final String fecha;
    private final ArrayList<Pedido> pedidos;
    
    public Factura(String nombre, String servicio, String mesero, int numero, String fecha, ArrayList<Pedido> pedidos) {
        this.nombre = nombre;
        this.servicio = servicio;
        this.mesero = mesero;
        this.numero = numero;
        this.fecha = fecha;
        this.pedidos = pedidos;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
    public String getNombre() {
        return nombre;
    }
    public String getServicio() {
        return servicio;
    }
    public String getMesero() {
        return mesero;
    }
    public int getNumero() {
        return numero;
    }
    public String getFecha() {
        return fecha;
    }
    public int Total() {
        int total = 0;
        for (int i = 0; i < pedidos.size(); i++) {
            total = total + (pedidos.get(i).getCantidad() * pedidos.get(i).getDetalle().getPrecio());
        }
        return total;
    }
    public int Iva(int total) {
        return (int) (total * 0.13);
    }
}