package edu.proyectofinal.data;

/**
 * Clase con nombre Teen que representa a usuarios que están en el rango de 13 a 17 años.
 * Tienen manera de tomar 1 préstamo por 7 días.
 */
public class Teen extends User {

    /**
     * Constructor de Teen.
     * @param name Nombre del usuario.
     * @param age Edad del usuario.
     * @param activeLend Número préstamos activos.
     */
    public Teen(String name, int age, int activeLend, int id) {
        super(name, age, activeLend, id);
    }

    @Override
    public int getMaxLoans() {
        return 1;
    }

    @Override
    public int getLoanDurationDays() {
        return 7;
    }

    @Override
    public String getUserType() {
        return "Teen";
    }
}



