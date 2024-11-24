/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package core.models;

public interface IdStorable extends Storable {
    boolean compareId(Object id);
    
    Object getId();
}
