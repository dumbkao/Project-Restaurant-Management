package proyecto.Pedido;

import proyecto.Platillo.Platillo;

public class Pedido {

    private String tipo;
    private int cantidad;
    private Platillo detalle;

    public Pedido(String tipo, int cantidad, Platillo detalle) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.detalle = detalle;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Platillo getDetalle() {
        return detalle;
    }

}
