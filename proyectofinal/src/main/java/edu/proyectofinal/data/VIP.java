package edu.proyectofinal.data;

import edu.proyectofinal.process.Config;

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
    public VIP(String name, int age, int activeLend) {
        super(name, age, activeLend);
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


