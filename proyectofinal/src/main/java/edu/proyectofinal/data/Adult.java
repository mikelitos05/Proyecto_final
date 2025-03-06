package edu.proyectofinal.data;

/**
 * Clase con nombre Adult que representa a usuarios mayores de los 18 años (solo Adulto y no VIP).
 * Pueden tomar hasta 2 préstamos por 7 días.
 */
public class Adult extends User {

    /**
     * Constructor de Adult.
     * @param name Nombre del usuario.
     * @param age Edad del usuario.
     * @param activeLend Número préstamos activos.
     */
    public Adult(String name, int age, int activeLend, int id) {
        super(name, age, activeLend, id);
    }

    @Override
    public int getMaxLoans() {
        return 2;
    }

    @Override
    public int getLoanDurationDays() {
        return 7;
    }

    @Override
    public String getUserType() {
        return "Adult";
    }
}



