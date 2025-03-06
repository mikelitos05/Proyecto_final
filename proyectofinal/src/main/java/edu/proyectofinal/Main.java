package edu.proyectofinal;

import edu.proyectofinal.data.Loan;
import edu.proyectofinal.data.User;
import edu.proyectofinal.process.BookManager;
import edu.proyectofinal.process.LoanManager;
import edu.proyectofinal.process.UserManager;
import edu.proyectofinal.gui.Menu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Cargar la base de datos
        //Try
        Path file = Paths.get("database/DataBase.txt");
        BookManager bookManager = new BookManager();
        UserManager userManager = new UserManager();
        LoanManager loanManager = new LoanManager();

        List<String> lines = null;
        try {
            lines = Files.readAllLines(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(String line : lines){
            String[] tokens = line.split(":");
            if(tokens[0].equals("Libro")){
                bookManager.registerBook(tokens[1],tokens[2],tokens[3],Integer.valueOf(tokens[4]));
            }
            if (tokens[0].equals("Usuario")){
                userManager.addUser(tokens[1],Integer.valueOf(tokens[2]),null);
            }
            if (tokens[0].equals("Loan")) {

                int userId = Integer.parseInt(tokens[1]);
                String bookTitle = tokens[2];
                String userName = tokens[3];
                String startDate = tokens[4];
                String endDate = tokens[5];
                Loan.LoanStatus status = Loan.LoanStatus.valueOf(tokens[6]);
                int id = Integer.valueOf(tokens[7]);
                User user = userManager.findUserById(userId);




                loanManager.preloadedLoan(bookManager.findBookByTitle(bookTitle), user, startDate,endDate, status, id);


            }
        }

        System.out.println(loanManager.getLoans().size());
        //Iniciar el programa
        Menu menu = new Menu(bookManager,userManager,loanManager);
        menu.setVisible(true);

    }
}