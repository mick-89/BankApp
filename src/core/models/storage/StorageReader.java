/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package core.models.storage;

import core.models.IdStorable;

public class StorageReader {
    private IdStorage storage;
    
    public StorageReader(IdStorage s) {
        storage = s;
    }
    
    // sigh
    public IdStorable get(Object id) {
        for (IdStorable obj : storage.getList()) {
            if (obj.compareId(id)) {
                return obj;
            }
        }
        return null;
    }
}
