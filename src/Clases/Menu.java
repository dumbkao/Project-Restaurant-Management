
package Clases;

import java.util.ArrayList;
import Clases.Platillo;

public class Menu {
    private ArrayList<Platillo> platillos;
    
    public Menu() {
        platillos = new ArrayList();
    }
    public void InsertarPlatillo(Platillo p) {
        platillos.add(p);
    }
    public Platillo RetornarPlatillo(int id) {
        return platillos.get(id);
    }
    public ArrayList<Platillo> getPlatillos() {
        return platillos;
    }
}
