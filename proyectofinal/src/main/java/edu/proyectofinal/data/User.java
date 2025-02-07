package edu.proyectofinal.data;
public class User {

    private String name;
    private int activeLend;


    public User(String name, int activeLend) {
        this.name = name;
        this.activeLend = activeLend;
    }

    public int getActiveLend() {
        return activeLend;
    }

    public void setActiveLend(int activeLend) {
        if (activeLend < 0 || activeLend > 3) {
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
        if (name == null) {
            throw new IllegalArgumentException("Nombre es null");
        }
        else {
            this.name = name;
        }
    }









}
