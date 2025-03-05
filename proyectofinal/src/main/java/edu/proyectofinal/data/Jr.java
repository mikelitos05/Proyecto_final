package edu.proyectofinal.data;

/**
 * Clase con nombre Jr que representa a usuarios de 6 a 12 años.
 * No se permite que realicen préstamos.
 */
public class Jr extends User {

    /**
     * Constructor de Jr.
     * @param name Nombre del usuario.
     * @param age Edad del usuario.
     * @param activeLend Número préstamos activos (siempre será en 0).
     */
    public Jr(String name, int age, int activeLend, int id) {
        super(name, age, activeLend, id);
    }

    @Override
    public int getMaxLoans() {
        return 0;
    }

    @Override
    public int getLoanDurationDays() {
        return 0; // No aplicable
    }

    @Override
    public String getUserType() {
        return "Jr";
    }
}

