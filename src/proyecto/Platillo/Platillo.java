package proyecto.Platillo;

public class Platillo {

    private String nombre;
    private int precio;

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
