package edu.proyectofinal.data;
public class User {

    private String name;
    private int activeLend;


    /**
     * Metodo constructor de User
     * @param name nombre del usuario
     * @param activeLend prestamos activos
     */
    public User(String name, int activeLend) {
        this.name = name;
        this.activeLend = activeLend;
    }

    public int getActiveLend() {
        return activeLend;
    }

    public void setActiveLend(int activeLend) {
        if (activeLend < 0 || activeLend > 2) {
            throw new IllegalArgumentException("Numero incorrecto de prestamos");
        }
        else{
            this.activeLend = activeLend;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        else {
            this.name = name;
        }
    }









}
