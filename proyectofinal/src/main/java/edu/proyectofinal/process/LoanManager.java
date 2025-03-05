package edu.proyectofinal.process;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import edu.proyectofinal.data.Book;
import edu.proyectofinal.data.Loan;
import edu.proyectofinal.data.User;

public class LoanManager {

    private ArrayList<Loan> loans;

    /**
     * Metodo constructor que se encarga de inicializar la lista de préstamos.
     */
    public LoanManager() {
        this.loans = new ArrayList<>();
    }

    /**
     * Metodo que se encarga de devolver los préstamos.
     *
     * @return Lista de préstamos.
     */
    public List<Loan> getLoans() {
        return loans;
    }


    public long calculateDaysBetween(String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);
        return ChronoUnit.DAYS.between(start, end);
    }

    public Loan.LoanStatus calculateStatus(String startDate, String endDate){
        if (calculateDaysBetween(startDate,endDate) < 0){
            return Loan.LoanStatus.DELAYED;
        }else{
            return Loan.LoanStatus.ACTIVE;
        }
    }

    public void preloadedLoan(Book book, User user, String startDate, String endDate, Loan.LoanStatus status, int id){
        Loan loan = new Loan(book,user,startDate,endDate,status,id);
        loans.add(loan);
    }

    public String addLoan(Book book, User user, String startDate, Loan.LoanStatus status){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate endDate = LocalDate.parse(startDate, formatter);
        String stringUser = user.getUserType();

        endDate = endDate.plusDays(user.getLoanDurationDays());
        String stringEndDate = endDate.format(formatter);

        if (user.getActiveLend() == user.getMaxLoans() && book.getAvailabilityCopies() > 1) {
            return "No se pueden tener mas"+user.getUserType() +"prestamos siendo usuario VIP";
        } else {
            Loan loan = new Loan(book, user, startDate, stringEndDate, calculateStatus(startDate, stringEndDate), loans.size() + 1);
            user.setActiveLend(user.getActiveLend() + 1);
            loans.add(loan);
        }
        return "Usuario no disponible";
    }



    /**
     * Clase anidada LoanResult que encapsula el resultado de un intento de préstamo.
     */
    public static class LoanResult {
        private boolean success;
        private String message;
        private Loan loan; // Puede ser null si no se creó el préstamo.

        /**
         * Constructor para LoanResult.
         *
         * @param success Indica si el préstamo fue exitoso.
         * @param message Mensaje explicativo.
         * @param loan    Objeto Loan creado, o null.
         */
        public LoanResult(boolean success, String message, Loan loan) {
            this.success = success;
            this.message = message;
            this.loan = loan;
        }

        /**
         * Indica si el préstamo fue exitoso.
         *
         * @return true si fue exitoso.
         */
        public boolean isSuccess() {
            return success;
        }

        /**
         * Obtiene el mensaje del resultado.
         *
         * @return Mensaje explicativo.
         */
        public String getMessage() {
            return message;
        }

        /**
         * Obtiene el préstamo creado.
         *
         * @return Objeto Loan o null.
         */
        public Loan getLoan() {
            return loan;
        }
    }
}


