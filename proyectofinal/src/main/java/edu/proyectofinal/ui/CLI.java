package edu.proyectofinal.ui;

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

        while (opciones != 5) {
            try {
                opciones = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(language.INVALID_OPTION);
                scanner.nextLine();
            }
            switch (opciones) {
                case 1:
                    System.out.println(language.IMAGINE_BOOKS);
                    break;
                case 2:
                    System.out.println(language.ACTIVE_USERS);
                    break;
                case 3:
                    System.out.println(language.ENTER_USER_NAME);
                    String usuario = scanner.nextLine();
                    System.out.println(language.ENTER_BOOK_LOAN);
                    String libro = scanner.nextLine();
                    System.out.println("\n---------------------------------------------------------");
                    System.out.println("\n" + language.BOOK_LOANED.replace("{0}", libro).replace("{1}", usuario) + "\n");
                    System.out.println("---------------------------------------------------------");

                    showMenu();
                    break;
                case 4:
                    System.out.println(language.ENTER_BOOK_NAME);
                    String nuevoLibro = scanner.nextLine();
                    System.out.println(language.ENTER_AUTHOR_NAME);
                    String autor = scanner.nextLine();
                    System.out.println(language.ENTER_BOOK_YEAR);
                    int año = scanner.nextInt();
                    System.out.println(language.BOOK_ADDED.replace("{0}", nuevoLibro));
                    break;
                case 5:
                    System.out.println(language.GOODBYE);
                    break;
                default:
                    System.out.println(language.INVALID_OPTION);
                    break;
            }
        }
    }
}