
package Clases;

public class Platillo {
    private final String nombre;
    private final int precio;
    
    public Platillo(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    public String getNombre() {
        return nombre;
    }
    public int getPrecio() {
        return precio;
    }
}