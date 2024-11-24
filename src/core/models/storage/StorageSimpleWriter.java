/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package core.models.storage;

import core.models.Storable;

public class StorageSimpleWriter {
    private Storage storage;
    
    public StorageSimpleWriter(Storage s) {
        storage = s;
    }
    
    // sigh
    public boolean add(Storable newObj) {
        storage.getList().add(newObj);
        return true;
    }
}
