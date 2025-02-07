package edu.proyectofinal.ui;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class CLI {
    private static ResourceBundle messages; // Variable para los mensajes

    // Método para establecer el idioma
    public static void setLanguage(String languageCode) {
        @SuppressWarnings("deprecation")
        Locale locale = new Locale(languageCode);
        messages = ResourceBundle.getBundle("messages", locale);
    }

    // Método para mostrar el menú en el idioma seleccionado
    public static void showMenu() {
        System.out.println(messages.getString("welcome"));
        System.out.println(messages.getString("select_option"));
        System.out.println(messages.getString("option_1"));
        System.out.println(messages.getString("option_2"));
        System.out.println(messages.getString("option_3"));
        System.out.println(messages.getString("option_4"));
        System.out.println(messages.getString("option_5"));
    }

    /**
     * Metodo que corre la aplicacion
     */

    public static void runApp() {
        Scanner scanner = new Scanner(System.in);
        showMenu();

        int opciones = 0;

        while (opciones != 5) {
            try {
                opciones = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(messages.getString("invalid_option"));
                scanner.nextLine();
            }
            switch (opciones) {
                case 1:
                    //placeholder \/\/\/
                    System.out.println(messages.getString("imagine_books"));
                    //  if (libros.iseEmpty())
                    ///System.out.println("No hay libros disponibles");
                    break;

                case 2:
                    System.out.println(messages.getString("active_users"));
                    break;
                //hace falta poder agregar varios usuarios
                case 3:
                    System.out.println(messages.getString("enter_user_name"));
                    String usuario = scanner.nextLine();
                    System.out.println(messages.getString("enter_book_loan"));
                    String libro = scanner.nextLine();
                    System.out.println("\n---------------------------------------------------------");
                    System.out.println("\n" + messages.getString("book_loaned").replace("{0}", libro).replace("{1}", usuario) + "\n");
                    System.out.println("---------------------------------------------------------");
                    showMenu();
                    break;

                //igual q el anterior, hace falta poder agregar varios libros
                case 4:
                    System.out.println(messages.getString("enter_book_name"));
                    String nuevoLibro = scanner.nextLine();
                    System.out.println(messages.getString("enter_author_name"));
                    String autor = scanner.nextLine();
                    System.out.println(messages.getString("enter_book_year"));
                    int año = scanner.nextInt();
                    System.out.println(messages.getString("book_added").replace("{0}", nuevoLibro));
                    break;

                case 5:
                    System.out.println(messages.getString("goodbye"));
                    break;
                default:
                    System.out.println(messages.getString("invalid_option"));
                    break;
            }
        }
    }

    public static void main(String[] args){
        // Seleccionar idioma (español, inglés, portugués o ruso)
        setLanguage("ru");

        // Mostrar el menú en el idioma seleccionado
        showMenu();
    }
}