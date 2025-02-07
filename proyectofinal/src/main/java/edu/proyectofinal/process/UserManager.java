package edu.proyectofinal.process;

import edu.proyectofinal.data.User;

import java.util.ArrayList;

public class UserManager {
    ArrayList<User> users;

    /**
     * Metodo constructor de UserManager
     */
    public UserManager() {
        this.users = new ArrayList<>();
    }

    /**
     * Metodo que se encarga de añadir un usuario
     * @param name nombre del usuario a añadir
     * @param activeLend prestamos activos
     */
    public void addUser(String name, int activeLend){
        User user = new User(name, activeLend);
        users.add(user);
    }

    /**
     * Metodo que se encarga de devolver los usuarios
     */
    public ArrayList<User> getUsers(){
        return this.users;
    }







}
