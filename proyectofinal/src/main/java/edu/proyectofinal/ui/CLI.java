package edu.proyectofinal.ui;

import edu.proyectofinal.data.Book;
import edu.proyectofinal.data.Loan;
import edu.proyectofinal.data.User;
import edu.proyectofinal.process.BookManager;
import edu.proyectofinal.process.LoanManager;
import edu.proyectofinal.process.UserManager;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CLI {
    static Language language = new Language();
    static BookManager bookManager = new BookManager();
    static UserManager userManager = new UserManager();
    /**
     *  Metodo que muestra el menu
     */
    public static void showMenu() {
        System.out.println(language.WELCOME);
        System.out.println(language.SELECT_OPTION);
        System.out.println(language.OPTION_1);
        System.out.println(language.OPTION_2);
        System.out.println(language.OPTION_3);
        System.out.println(language.OPTION_4);
        System.out.println(language.OPTION_5);
    }

    public static void showBooks(){
        int numLibro = 1;
        for (Book book : bookManager.getBooks()){

            System.out.println("=====================================================");
            System.out.println(""+language.BOOK + ": " + numLibro);
            System.out.println("=====================================================");
            System.out.println(""+language.TITTLE + ": " + book.getTitle());
            System.out.println(""+language.AUTHOR + ": " + book.getAuthor());
            System.out.println(""+language.DESCRIPTION + ": " + book.getDescription());
            System.out.println(""+language.TOTALCOPIES + ": " + book.getTotalCopies());
            System.out.println(""+language.AVAILABLECOPIES + ": " + book.getAvailabilityCopies());

            numLibro = numLibro + 1;
        }
    }


    public static void showUsers(){
        for(User user : userManager.getUsers()){
            System.out.println("=============================================");
            System.out.println(language.NAMES + ": " + user.getName());
            System.out.println("=============================================");
        }
    }


    /**
     * Metodo que corre la aplicacion
     */
    public static void runApp() {
        UserManager userManager = new UserManager();
        LoanManager loanManager = new LoanManager();




        Scanner scanner = new Scanner(System.in);
        language = new En();
        int opcIdioma = 0;
        while (opcIdioma > 4 || opcIdioma < 1) {
            System.out.println("Seleccione un idioma");
            System.out.println("1. Español");
            System.out.println("2. English");
            System.out.println("3. Русский");
            System.out.println("4. Português");
            try {
                opcIdioma = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(language.INVALID_OPTION);
                scanner.nextLine();
            }
            switch (opcIdioma) {
                case 1:
                    language = new Es();
                    break;
                case 2:
                    language = new En();
                    break;
                case 3:
                    language = new Ru();
                    break;
                case 4:
                    language = new Pr();
                default:
                    System.out.println(language.INVALID_OPTION);
                    break;
            }
        }

        showMenu();

        int opciones = 0;

        while (opciones != 6) {
            try {
                opciones = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(language.INVALID_OPTION);
                scanner.nextLine();
            }
            switch (opciones) {
                case 1:
                    showBooks();
                    break;
                case 2:
                    if (userManager.getUsers().isEmpty()) {
                        System.out.println("====================================");
                        System.out.println(language.NO_USERS);
                        System.out.println("====================================");
                    }else {
                        showUsers();
                    }

                    break;
                case 3:
                    System.out.println(language.ENTER_USER_NAME);
                    String nombre = scanner.nextLine();

                    userManager.addUser(1,nombre,15);
                    break;
                case 4:
                    System.out.println(language.ENTER_BOOK_NAME);
                    String nombreLibro = scanner.nextLine();
                    System.out.println(language.ENTER_AUTHOR_NAME);
                    String autorLibro = scanner.nextLine();
                    System.out.println("Descripcion");
                    String descripcionLibro = scanner.nextLine();
                    System.out.println("Copias totales del libro");
                    int copiasTotales = scanner.nextInt();scanner.nextLine();

                    bookManager.registerBook(bookManager.generateId(), nombreLibro,autorLibro,descripcionLibro,copiasTotales,copiasTotales);

                    break;
                case 5:
                    showUsers();
                    System.out.println(language.ENTER_USER_NAME);
                    String usuario = scanner.nextLine();
                    showBooks();
                    System.out.println(language.ENTER_BOOK_LOAN);
                    String libro = scanner.nextLine();
                    System.out.println("Ingrese la fecha en la que terminara del prestamo");
                    String fechaFin = scanner.nextLine();
                    System.out.println("Ingrese la fecha en la que inicio el prestamo");
                    String fechaInicio = scanner.nextLine();
                    if (userManager.findUserByName(usuario) == null) {
                        System.out.println("No usuario encontrado");
                    }else {
                        loanManager.addLean(libro, fechaFin, fechaInicio, true, userManager.findUserByName(usuario));

                    }


                    showMenu();
                    break;
                case 6:
                    System.out.println(language.GOODBYE);
                    break;
                default:
                    System.out.println(language.INVALID_OPTION);
                    break;
            }
            showMenu();
        }
    }
}