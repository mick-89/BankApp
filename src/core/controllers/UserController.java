/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.User;

public class UserController {
    public static Response registerUser(String id, String firstname, String lastname, String age) {
        try {
            int idInt, ageInt;
            
            try {
                idInt = Integer.parseInt(id);
                if (idInt < 0) {
                    return new Response("ID must be positive", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException e) {
                return new Response("Id must be numeric", Status.BAD_REQUEST);
            }
            
            if (firstname.equals("")) {
                return new Response("firstname can't be blank", Status.BAD_REQUEST);
            }
            
            if (lastname.equals("")) {
                return new Response("lastname can't be blank", Status.BAD_REQUEST);
            }
            
            try {
                ageInt = Integer.parseInt(age);
                if (ageInt < 18) {
                    return new Response("user must be over 18", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException e) {
                return new Response("age must be numeric", Status.BAD_REQUEST);
            }
            
            // something something get storage reference
            // if (!storage.addUser(...)
            // return new Response([condición que tuvo que fallar], Status.BAD_REQUEST)
            UserStorage storage = UserStorage.getInstance();
            if (!storage.addUser(new User(idInt, firstname, lastname, ageInt))) {
                return new Response("A user with that id already exists", Status.BAD_REQUEST);
            }
            return new Response("user created successfully", Status.CREATED);
            
        
        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
        
    }
    
    public static Response getUsers() { // para la tabla
        try {
            UserStorage storage = UserStorage.getInstance();
            ArrayList<User> users = storage.getUsers();
            return new Response("User list found", Status.OK, users);
        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);            
        }
        //return new Response("cálmate ve", Status.NOT_IMPLEMENTED);
    }
}
