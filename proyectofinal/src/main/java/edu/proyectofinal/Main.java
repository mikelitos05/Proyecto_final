package edu.proyectofinal;

import edu.proyectofinal.data.Book;
import edu.proyectofinal.process.BookManager;
import edu.proyectofinal.process.UserManager;
import edu.proyectofinal.ui.AddBook;
import edu.proyectofinal.ui.Menu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Cargar la base de datos
        Path file = Paths.get("C:\\Users\\Mike\\IdeaProjects\\Proyecto_final\\proyectofinal\\src\\main\\java\\edu\\proyectofinal/DataBase.txt");
        BookManager bookManager = new BookManager();
        UserManager userManager = new UserManager();
        List<String> lines = null;
        try {
            lines = Files.readAllLines(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(String line : lines){
            String[] tokens = line.split(":");
            if(tokens[0].equals("Libro")){
                bookManager.registerBook(Integer.valueOf(tokens[1]),tokens[2],tokens[3],tokens[4],Integer.valueOf(tokens[5]),Integer.valueOf(tokens[6]));
            }
            if (tokens[0].equals("Usuario")){
                userManager.addUser(Integer.valueOf(tokens[1]),tokens[2],Integer.valueOf(tokens[3]));
            }
        }


        //Iniciar el programa
        Menu menu = new Menu(bookManager,userManager);
        menu.setVisible(true);

    }
}