package edu.proyectofinal.ui;

import edu.proyectofinal.data.Book;
import edu.proyectofinal.data.Loan;
import edu.proyectofinal.data.User;
import edu.proyectofinal.process.BookManager;
import edu.proyectofinal.process.Config;
import edu.proyectofinal.process.LoanManager;
import edu.proyectofinal.process.UserManager;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase CLI en la que representa la interfaz de línea de comandos de la biblioteca.
 * Se encarga de interactuar con el usuario, mostrar el menú, recibir entradas y llamar a
 * los metodos correspondientes de los gestores (BookManager, UserManager, LoanManager).
 */

public class CLI {
    static Language language = new Language();
    static BookManager bookManager = new BookManager(); //llegar a checar si es que se debe modificar o quitar
    static UserManager userManager = new UserManager(); //llegar a checar si es que se debe modificar o quitar

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

    /**
     * Metodo para mostrar la lista de libros.
     * Utiliza programación funcional.
     *
     * @param bookManager Objeto BookManager que contiene la lista de libros.
     */
    private static void showBooks(BookManager bookManager) {
        System.out.println("\nLibros registrados:");
        bookManager.getBooks().forEach(book -> {
            System.out.println("=====================================");
            System.out.println(language.BOOK + ": " + book.getTitle());
            System.out.println(language.TITLE + ": " + book.getTitle());
            System.out.println(language.AUTHOR + ": " + book.getAuthor());
            System.out.println(language.DESCRIPTION + ": " + book.getDescription());
            System.out.println(language.TOTALCOPIES + ": " + book.getTotalCopies());
            System.out.println(language.AVAILABLECOPIES + ": " + book.getAvailabilityCopies());
            System.out.println("=====================================");
        });
    }

    /**
     * Metodo auxiliar para mostrar la lista de usuarios.
     * Utiliza programación funcional (forEach con lambda) para iterar y mostrar cada usuario.
     *
     * @param userManager Objeto UserManager que contiene la lista de usuarios.
     */
    private static void showUsers(UserManager userManager) {
        if (userManager.getUsers().isEmpty()) {
            System.out.println("====================================");
            System.out.println(language.NO_USERS);
            System.out.println("====================================");
        } else {
            System.out.println("\nUsuarios registrados:");
            userManager.getUsers().forEach(user -> {
                System.out.println("=====================================");
                System.out.println(user);
                System.out.println("=====================================");
            });
        }
    }


    /**
     * Metodo que corre la aplicación.
     */
    public static void runApp() {
        UserManager userManager = new UserManager();
        LoanManager loanManager = new LoanManager();
        BookManager bookManager = new BookManager(); //checar si tiene de donde ser llamado

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

        int option = 0;

        while (option != 6) {
            try {
                option = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(language.INVALID_OPTION);
                scanner.nextLine();
                continue;
            }
            switch (option) {
                case 1:
                    showBooks(bookManager); //también llegué a agregar
                case 2:
                    if (userManager.getUsers().isEmpty()) {
                        System.out.println("====================================");
                        System.out.println(language.NO_USERS);
                        System.out.println("====================================");
                    }else {
                        showUsers(userManager); //lo que también agrego

                    }

                    break;
                case 3:
                    System.out.println(language.ENTER_USER_NAME);
                    String name = scanner.nextLine();
                    System.out.println("Ingrese la edad del usuario: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Seleccione el tipo de usuario que es:");
                    System.out.println("1. " + Config.get("Jr") + " (6-12 años)");
                    System.out.println("2. " + Config.get("Teens") + " (13-17 años)");
                    System.out.println("3. " + Config.get("Adult") + " (Adultos)");
                    System.out.println("4. " + Config.get("VIP") + " (Adultos VIP)");
                    int typeOption = scanner.nextInt();
                    scanner.nextLine();
                    String type;
                    switch(typeOption) {
                        case 1:
                            type = "jr";
                            break;
                        case 2:
                            type = "teen";
                            break;
                        case 3:
                            type = "adult";
                            break;
                        case 4:
                            type = "vip";
                            break;
                        default:
                            System.out.println("Opción inválida. Se creará como Adult por defecto.");
                            type = "adult";
                    }
                    userManager.addUser(name, age, type);
                    System.out.println("Usuario agregado exitosamente.");
                    break;

                case 4:
                    System.out.println(language.ENTER_BOOK_NAME);
                    String bookName = scanner.nextLine(); //cambiar nombre del español hacia el ingles
                    System.out.println(language.ENTER_AUTHOR_NAME);
                    String authorName = scanner.nextLine(); //cambiar nombre del español hacia el ingles
                    System.out.println("Descripción");
                    String description = scanner.nextLine(); //cambiar nombre del español hacia el ingles
                    System.out.println("Copias totales del libro");
                    int totalCopies = scanner.nextInt(); //cambiar nombre del español hacia el ingles
                    scanner.nextLine();

                    bookManager.registerBook(bookName, authorName, description, totalCopies, totalCopies);
                    System.out.println(language.BOOK_ADDED);
                    break;

                case 5:  //prestar libro modificación
                    System.out.println(language.ENTER_USER_NAME);
                    String userName = scanner.nextLine();
                    User selectedUser = userManager.findUserByName(userName);
                    if (selectedUser == null) {
                        System.out.println("Usuario no encontrado.");
                        break;
                    }
                    System.out.println(language.ENTER_BOOK_LOAN);
                    String bookTitle = scanner.nextLine();

                    // Se obtiene el resultado del préstamo y se muestra el mensaje
                    LoanManager.LoanResult result = loanManager.loanBook(bookManager, bookTitle, selectedUser);
                    System.out.println(result.getMessage());
                    break;

            }


        }
        showMenu();
    }
    //scanner.close();
}
