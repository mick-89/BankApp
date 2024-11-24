/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package core.models.storage;

import core.models.IdStorable;

public class StorageWriter {
    private IdStorage storage;
    
    public StorageWriter(IdStorage s) {
        storage = s;
    }
    
    // sigh
    public boolean add(IdStorable newObj) {
        for (IdStorable obj : storage.getList()) {
            if (obj.compareId(newObj.getId())) {
                return false;
            }
        }
        storage.getList().add(newObj);
        return true;
    }
}
