/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package core.models;

public interface IdStorable {
    
    boolean hasMatchingId(Object id);
    
    Object getId();
}
