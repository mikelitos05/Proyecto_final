package edu.proyectofinal.process;

import java.util.List;
import java.util.ArrayList;
import edu.proyectofinal.data.Book;


/**
 * Clase que gestiona una colección de libros. Permite registrar, buscar y
 * obtener información de los libros almacenados.
 */
public class BookManager {
    ArrayList<Book> books;

    /**
     * Constructor que inicializa la lista de libros y carga los libros precargados.
     */
    public BookManager() {
        this.books = new ArrayList<>();
    }

    /**
     * Metodo que carga libros precargados en la lista.
     */


    /**
     * Registra un nuevo libro en la lista de libros.
     *
     */
    public void registerBook(String title, String author,String description,int totalCopies,int availableCopies) {
        Book book = new Book(title,author,description,totalCopies,availableCopies);
        books.add(book);
    }

    /**
     * Obtiene la lista completa de libros registrados.
     *
     * @return Una lista de objetos {@link Book}.
     */
    public List<Book> getBooks() {
        return this.books;
    }

    /**
     * Busca un libro por su título.
     *
     * @param title El título del libro que se desea buscar.
     * @return El objeto {@link Book} si se encuentra, o {@code null} si no existe.
     */
    public Book findBookByTitle(String title) {
        if (title == null) return null;

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    /**
     * Obtiene el número total de libros registrados en la lista.
     *
     * @return El número total de libros.
     */
    public int getTotalBooks() {
        return books.size();
    }

    /**
     * Verifica si la lista de libros está vacía.
     *
     * @return {@code true} si no hay libros registrados, {@code false} en caso contrario.
     */
    public boolean isEmpty() {
        return books.isEmpty();
    }
}





   