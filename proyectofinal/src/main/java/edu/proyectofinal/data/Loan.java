package edu.proyectofinal.data;

/**
 * Loan, Clase en donde se hacen los préstamos.
 */

public class Loan {
    private String book;
    private String user;
    private String startDate;
    private String endDate;
    private LoanStatus status;

    /**
     * Uso de Enum para representar el estado del préstamo.
     */
    public enum LoanStatus {
        ACTIVE, //Préstamo del cual está aún vigente.
        LIQUIDATED, //Préstamo completado con libro devuelto.
        DELAYED, //Retraso en el préstamo.
    }

    /**
     * Metodo constructor de Loan.
     * @param book
     * @param user
     * @param startDate
     * @param endDate
     * @param status Estado del préstamo.
     */
    public Loan(String book, String user, String startDate, String endDate, LoanStatus status) {
        if (book == null || user == null || startDate == null || endDate == null || status == null) {
            throw new IllegalArgumentException("No hay información disponible. Ningún parámetro puede estar nulo.");
        }
        this.book = book;
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        if (book == null) {
            throw new IllegalArgumentException("Book is null");
        }
        else{
            this.book = book;
        }
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        if (user == null) {
            throw new IllegalArgumentException("User is null");
        }
        else{
            this.user = user;
        }
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        if (startDate == null) {
            throw new IllegalArgumentException("Start date is null");
        }
        else{
            this.startDate = startDate;
        }
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        if (endDate == null) {
            throw new IllegalArgumentException("End date is null");
        }
        else{
            this.endDate = endDate;
        }
    }

    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }


}

