package edu.proyectofinal.process;

import java.time.LocalDate;
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

    /**
     * Procesa el préstamo de un libro utilizando la información del usuario.
     *
     * @param bookManager Objeto BookManager para buscar libros.
     * @param bookTitle   Título del libro a prestar.
     * @param user        Usuario que solicita el préstamo.
     * @return Un objeto LoanResult con el resultado del proceso.
     */
    public LoanResult loanBook(BookManager bookManager, String bookTitle, User user) {
        Book book = bookManager.findBookByTitle(bookTitle);
        if (book == null) {
            return new LoanResult(false, "El libro no se encontró.", null);
        }
        if (book.getAvailabilityCopies() <= 0) {
            return new LoanResult(false, "No hay copias disponibles del libro: " + book.getTitle(), null);
        }
        // Validación: Si el usuario no puede pedir préstamos (por ejemplo, Jr)
        if (user.getMaxLoans() == 0) {
            return new LoanResult(false, "Error: El usuario de tipo " + user.getUserType() + " no puede sacar libros.", null);
        }
        if (user.getActiveLend() >= user.getMaxLoans()) {
            return new LoanResult(false, "Error: El usuario ya tiene el máximo de préstamos permitidos (" + user.getMaxLoans() + ").", null);
        }
        // Calcular fechas de préstamo y vencimiento
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(user.getLoanDurationDays());
        String startDateStr = startDate.toString();
        String endDateStr = endDate.toString();
        // Obtener identificador único de la copia prestada
        String copyId = book.lendCopy();
        if (copyId == null) {
            return new LoanResult(false, "Error al obtener una copia del libro.", null);
        }
        String bookWithId = book.getTitle() + " (ID: " + copyId + ")";
        Loan newLoan = new Loan(bookWithId, user.getName(), startDateStr, endDateStr, Loan.LoanStatus.ACTIVE);
        loans.add(newLoan);
        user.setActiveLend(user.getActiveLend() + 1);
        return new LoanResult(true, "Préstamo exitoso del libro '" + bookWithId + "' al usuario " + user.getName() +
                ". Fecha de devolución: " + endDateStr, newLoan);
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


