package edu.proyectofinal.process;

import java.util.ArrayList;
import java.util.List;

import edu.proyectofinal.data.Loan;

public class LoanManager {

    ArrayList<Loan> loans;
    /**
     * Metodo que se encarga de crear el array de los prestamos
     */
    public LoanManager(ArrayList<Loan> loans) {
        this.loans = new ArrayList<>();
    }

    /**
     * Metodo que se encarga de añadir un prestamo
     * @param book prestado
     * @param endDate fecha de entrega
     * @param startDate fecha de inicio
     * @param status estado del prestamo
     * @param user usuario que lo pide
     */
    public void addLean(String book, String endDate, String startDate, boolean status, String user){
        Loan loan = new Loan(book, endDate, startDate, status, user);
        loans.add(loan);
    }

    /**
     * Metodo que se encarga de devolver los prestamos
     */
    public List<Loan>getLoans(){
        return this.loans;
    }





}
