/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 503
 */
public class UserDB {
    private List<User> userList;

    public UserDB() {
        userList = new ArrayList<>();
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void removeUser(User user) {
        userList.remove(user);
    }

    public void displayUsers() {
        for (User user : userList) {
            System.out.println(user);
        }
    }
    
    public boolean userExists(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
