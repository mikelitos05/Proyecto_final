package edu.proyectofinal.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CLI {
    static Language language = new Language();

    /**
     *  Metodo que muestra el menu
     */
    public static void showMenu() {
        System.out.println(language.welcome);
        System.out.println(language.select_option);
        System.out.println(language.option_1);
        System.out.println(language.option_2);
        System.out.println(language.option_3);
        System.out.println(language.option_4);
        System.out.println(language.option_5);
    }

    /**
     * Metodo que corre la aplicacion
     */
    public static void runApp() {
        Scanner scanner = new Scanner(System.in);
        showMenu();

        language = new Es();

        int opciones = 0;

        while (opciones != 5) {
            try {
                opciones = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(language.invalid_option);
                scanner.nextLine();
            }
            switch (opciones) {
                case 1:
                    System.out.println(language.imagine_books);
                    break;
                case 2:
                    System.out.println(language.active_users);
                    break;
                case 3:
                    System.out.println(language.enter_user_name);
                    String usuario = scanner.nextLine();
                    System.out.println(language.enter_book_loan);
                    String libro = scanner.nextLine();
                    System.out.println("\n---------------------------------------------------------");
                    System.out.println("\n" + language.book_loaned.replace("{0}", libro).replace("{1}", usuario) + "\n");
                    System.out.println("---------------------------------------------------------");
                    showMenu();
                    break;
                case 4:
                    System.out.println(language.enter_book_name);
                    String nuevoLibro = scanner.nextLine();
                    System.out.println(language.enter_author_name);
                    String autor = scanner.nextLine();
                    System.out.println(language.enter_book_year);
                    int año = scanner.nextInt();
                    System.out.println(language.book_added.replace("{0}", nuevoLibro));
                    break;
                case 5:
                    System.out.println(language.goodbye);
                    break;
                default:
                    System.out.println(language.invalid_option);
                    break;
            }
        }
    }
}