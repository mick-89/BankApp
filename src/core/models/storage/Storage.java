/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package core.models.storage;

import core.models.Storable;
import java.util.ArrayList;

public class Storage {
    
    // Instancia Singleton
    private static Storage instance;
    
    // Atributos del Storage
    private ArrayList<Storable> list;
    
    private Storage() {
        this.list = new ArrayList<>();
    }
    
    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }
    
    public ArrayList<Storable> getList(){
        return this.list;
    }
    
    
}
