/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package core.models.storage;

import core.models.IdStorable;
import java.util.ArrayList;

public class IdStorage<T extends IdStorable> {
    // Atributos del Storage
    private ArrayList<T> list;
    
    public IdStorage() {
        this.list = new ArrayList<>();
    }
    
    public boolean add(T newItem) {
        for (T item : this.list) {
            if (item.hasMatchingId(newItem.getId())) {
                return false;
            }
        }
        this.list.add(newItem);
        return true;
    }
    
    public T get(Object id) {
        for (T item : this.list) {
            if (item.hasMatchingId(id)){
                return item;
            }
        }
        return null;
    }

    public ArrayList<T> getList(){
        return this.list;
    }
}
