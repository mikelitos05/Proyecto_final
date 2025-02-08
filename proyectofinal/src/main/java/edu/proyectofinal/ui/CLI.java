package edu.proyectofinal.ui;

import edu.proyectofinal.data.Book;
import edu.proyectofinal.data.User;
import edu.proyectofinal.process.BookManager;
import edu.proyectofinal.process.UserManager;
import java.util.InputMismatchException;
import java.util.Scanner;


public class CLI {
    static Language language = new Language();

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
     * Metodo que corre la aplicacion
     */
    public static void runApp() {
        UserManager userManager = new UserManager();
        BookManager bookManager = new BookManager();

        bookManager.registerBook("Diario de Greg. Un renacuajo", "Jeff Kinney", "Novela de ficción-Comedia/Humor", 4, 4);
        bookManager.registerBook("Hábitos Atómicos", "James Clear", "Libro de autoayuda", 5,5);
        bookManager.registerBook("El Principito", "Antoine de Saint-Exupéry", "Fábula infantil de ficción y con sentido filosófico", 4,4);
        bookManager.registerBook("1984", "George Orwell", "Novela política de ficción distópica", 2,2);
        bookManager.registerBook("El Conde de Montecristo", "Alexandre Dumas y Auguste Maquet", "Novela histórica de ficción con aventura, romance y temas sociales", 3,3);
        bookManager.registerBook("Los tres mosqueteros", "Alexandre Dumas", "Novela literaria de aventura, capa y espada y ficción", 5,5);


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
                    break;
                case 2:
                    if (userManager.getUsers().isEmpty()) {
                        System.out.println("====================================");
                        System.out.println(language.NO_USERS);
                        System.out.println("====================================");
                    }else {
                        for(User user : userManager.getUsers()){
                            System.out.println("=============================================");
                            System.out.println(language.NAMES + ": " + user.getName());
                            System.out.println(language.LOANS + ": " + user.getActiveLend());
                            System.out.println("=============================================");
                        }
                    }

                    break;
                case 3:
                    System.out.println(language.ENTER_USER_NAME);
                    String nombre = scanner.nextLine();

                    userManager.addUser(nombre,0);
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

                    bookManager.registerBook(nombreLibro,autorLibro,descripcionLibro,copiasTotales,copiasTotales);

                    break;
                case 5:
                    System.out.println(language.ENTER_USER_NAME);
                    String usuario = scanner.nextLine();
                    System.out.println(language.ENTER_BOOK_LOAN);
                    String libro = scanner.nextLine();
                    System.out.println("\n---------------------------------------------------------");
                    System.out.println("\n" + language.BOOK_LOANED.replace("{0}", libro).replace("{1}", usuario) + "\n");
                    System.out.println("---------------------------------------------------------");

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