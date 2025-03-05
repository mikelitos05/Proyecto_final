package edu.proyectofinal.process;

import edu.proyectofinal.data.*;

import java.util.ArrayList;

/**
 * Clase UserManager que gestiona los usuarios de la biblioteca.
 */

public class UserManager {
    private ArrayList<User> users;

    /**
     * Metodo constructor de UserManager
     */
    public UserManager() {
        this.users = new ArrayList<>();
    }

    /**
     * Metodo que se encarga de añadir un usuario a la lista.
     * La adición es según el tipo especificado.
     *
     * @param name nombre del usuario a añadir.
     * @param age  Edad del usuario.
     * @param type Tipo en el que el usuario es catogorizado (Jr, Teen, Adulto, VIP).
     */
    public void addUser(String name, int age, String type) {
        User user = null;
        if (age > 5 && age < 13) {
            user = new Jr(name, age, 0,users.size() + 1);
        } else if (age > 12 && age < 18) {
            user = new Teen(name, age, 0, users.size() + 1);
        } else if (age > 17) {
            user = new Adult(name, age, 0, users.size() + 1);
        } else if (type.equalsIgnoreCase("VIP")) {
            user = new VIP(name, age, 0, users.size() + 1);
        }
        users.add(user);

    }

    /**
     * @return Lista de usuarios.
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Metodo que se encarga de buscar un usuario por su nombre
     *
     * @param name Nombre del usuario a buscar.
     * @return El usuario si se encuentra, o null si no existe.
     */
    public User findUserByName(String name) {
        return users.stream()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    /**
     * Metodo que se encarga de encontrar al usuario mediante su id
     * @param id
     * @return
     */
    public User findUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}


