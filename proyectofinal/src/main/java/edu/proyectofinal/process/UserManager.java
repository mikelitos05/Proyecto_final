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
     */
    public void addUser(int id,String name,int age){
        User user = new User(id,name,age);
        users.add(user);
    }

    /**
     * Metodo que se encarga de buscar un usuario por su nombre
     * @param name nombre del usuario a buscar
     * @return el usuario si se encuentra, o null si no existe
     */
    public User findUserByName(String name){
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Metodo que se encarga de devolver los usuarios
     */
    public ArrayList<User> getUsers(){
        return this.users;
    }

    public int generateId(){
        return users.size() + 1;
    }

}
