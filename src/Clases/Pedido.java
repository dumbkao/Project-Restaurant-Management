
package Clases;

import Clases.Platillo;

public class Pedido {
    private int cantidad;
    private Platillo detalle;
    
    public Pedido(int cantidad, Platillo detalle) {
        this.cantidad = cantidad;
        this.detalle = detalle;
    }
    public int getCantidad() {
        return cantidad;
    }
    public Platillo getDetalle() {
        return detalle;
    }
    
}
