package edu.proyectofinal.process;

import edu.proyectofinal.data.User;

import java.util.ArrayList;

public class UserManager {
    ArrayList<User> users;

    public UserManager() {
        this.users = new ArrayList<>();
    }

    public void addUser(String name, int activeLend){
        User user = new User(name, activeLend);
        users.add(user);
    }

    public ArrayList<User> getUsers(){
        return this.users;
    }







}
