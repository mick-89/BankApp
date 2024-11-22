package core.models.storage;

import core.models.User;
import java.util.ArrayList;

/*@author Juan Drive  desde de de dedede de dedeman*/
public class UserStorage {
    
    // Instancia Singleton
    private static UserStorage instance;
    
    // Atributos del Storage
    private ArrayList<User> users;
    
    private UserStorage() {
        this.users = new ArrayList<>();
    }
    
    public static UserStorage getInstance() {
        if (instance == null) {
            instance = new UserStorage();
        }
        return instance;
    }
    
    public boolean addUser(User user) {
        for (User u : this.users) {
            if (u.getId() == user.getId()) {
                return false;
            }
        }
        this.users.add(user);
        return true;
    }
    
    public User getUser(int id) {
        for (User user : this.users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
    public ArrayList<User> getUsers(){
        return this.users;
    }
    
    public boolean delUser(int id) {
        for (User user : this.users) {
            if (user.getId() == id) {
                this.users.remove(user);
                return true;
            }
        }
        return false;
    }
    

}
