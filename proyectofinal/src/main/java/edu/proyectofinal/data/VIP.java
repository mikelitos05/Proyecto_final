package edu.proyectofinal.data;

/**
 * Clase VIP que representa a usuarios mayores de los 18 años que cuentan además con el término de ser miembro VIP.
 * Pueden tomar hasta 5 préstamos por 14 días.
 */
public class VIP extends User {

    /**
     * Constructor de VIP.
     * @param name Nombre del usuario.
     * @param age Edad del usuario.
     * @param activeLend Número préstamos activos.
     */
    public VIP(String name, int age, int activeLend, int id) {
        super(name, age, activeLend, id);
    }

    @Override
    public int getMaxLoans() {
        return 5;
    }

    @Override
    public int getLoanDurationDays() {
        return 14;
    }

    @Override
    public String getUserType() {
        return "VIP";
    }
}


