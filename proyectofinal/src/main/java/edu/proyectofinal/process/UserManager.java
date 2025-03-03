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
        switch (type.toLowerCase()) {
            case "jr":
                user = new Jr(name, age, 0);
                break;
            case "teen":
                user = new Teen(name, age, 0);
                break;
            case "adult":
                user = new Adult(name, age, 0);
                break;
            case "vip":
                user = new VIP(name, age, 0);
                break;
            default:
                System.out.println("Tipo de usuario no reconocido.");
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
}


