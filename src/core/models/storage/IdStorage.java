/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package core.models.storage;

import core.models.IdStorable;
import java.util.ArrayList;


// deberían los Storage también pertenecer a una interfaz Storage  más genérica?
public class IdStorage {
    
    // Instancia Singleton
    private static IdStorage instance;
    
    // Atributos del Storage
    private ArrayList<IdStorable> list;
    
    private IdStorage() {
        this.list = new ArrayList<>();
    }
    
    public static IdStorage getInstance() {
        if (instance == null) {
            instance = new IdStorage();
        }
        return instance;
    }

    public ArrayList<IdStorable> getList(){
        return this.list;
    }
    
    
}
