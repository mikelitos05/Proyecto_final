package edu.proyectofinal.process;

import edu.proyectofinal.data.User;
import edu.proyectofinal.data.UserJunior;
import edu.proyectofinal.data.UserTeen;
import edu.proyectofinal.data.UserVip;

import java.util.ArrayList;

public class UserManager {
    ArrayList<User> users;
    ArrayList<UserJunior> usersJunior;
    ArrayList<UserTeen> usersTeen;
    ArrayList<UserVip> usersVip;


    /**
     * Metodo constructor de UserManager
     */
    public UserManager() {
        this.users = new ArrayList<>();
        this.usersJunior = new ArrayList<>();
        this.usersTeen = new ArrayList<>();
        this.usersVip = new ArrayList<>();
    }

    /**
     * Metodo que se encarga de añadir un usuario
     * @param name nombre del usuario a añadir
     */
    public void addUser(int id,String name,int age){
        if(age > 18){
            User user = new User(id,name,age);
            users.add(user);    
        } else if (age > 12 && age < 18) {
            UserTeen userTeen = new UserTeen(id,name,age);
            usersTeen.add(userTeen);
        } else if (age < 12) {
            UserJunior userJunior = new UserJunior(id,name,age);
            usersJunior.add(userJunior);
        }
        
    }
    public void addUserVip(int id,String name,int age){
        UserVip userVip = new UserVip(id,name,age);
        usersVip.add(userVip);
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
