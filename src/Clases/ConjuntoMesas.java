
package Clases;

import Clases.Mesa;
import java.util.ArrayList;

public class ConjuntoMesas {
    private ArrayList<Mesa> mesas;
    private int cantidad_de_mesas;
    private final int max_cantidad_mesas;
    
    public ConjuntoMesas() {
        mesas = new ArrayList();
        cantidad_de_mesas = 0;
        max_cantidad_mesas = 20;
    }
    public void AgregarMesa(Mesa mesa) {
        if (cantidad_de_mesas < max_cantidad_mesas) {
            mesas.add(mesa);
            cantidad_de_mesas++;
        }
    }
    public void EliminarMesa(int index) {
        mesas.remove(index);
    }
    public Mesa ObtenerMesa(int index) {
        return mesas.get(index);
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    public int getCantidad_de_mesas() {
        return cantidad_de_mesas;
    }

    public int getMax_cantidad_mesas() {
        return max_cantidad_mesas;
    }

    public void setMesas(ArrayList<Mesa> mesas) {
        this.mesas = mesas;
    }

    public void setCantidad_de_mesas(int cantidad_de_mesas) {
        this.cantidad_de_mesas = cantidad_de_mesas;
    }
    
}