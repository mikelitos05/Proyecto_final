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
     * Registra un nuevo libro en la lista de libros
     * Si ya existe un libro, también lo registra
     * Es acumulativo la cantidad en el total de libros.
     *
     */
    public void registerBook(String title, String author, String genrer, int totalCopies) {
        if(findBookByTitle(title) == null) {
            Book book = new Book(title, author, genrer, totalCopies);
            books.add(book);
        }else{
            Book bookToModify = findBookByTitle(title);
            bookToModify.setTotalCopies(bookToModify.getTotalCopies()+ 1);
            Book book = new Book(title, author, genrer, bookToModify.getTotalCopies() + 1);

        }
    }

    /**
     * Obtiene la lista completa de libros registrados.
     * @return Una lista de objetos {@link Book}.
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * Busca un libro por su título.
     * Utilización de programación funcional.
     * @param title El título del libro que se desea buscar.
     * @return El objeto {@link Book} si se encuentra, o {@code null} si no existe.
     */
    public Book findBookByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
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
