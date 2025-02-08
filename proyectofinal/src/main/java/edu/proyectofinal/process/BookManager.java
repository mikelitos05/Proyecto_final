package edu.proyectofinal.process;

import java.util.List;
import java.util.ArrayList;
import edu.proyectofinal.data.Book;


/**
 * Clase que gestiona una colección de libros. Permite registrar, buscar y
 * obtener información de los libros almacenados.
 */
public class BookManager {
    private final List<Book> books;

    /**
     * Constructor que inicializa la lista de libros y carga los libros precargados.
     */
    public BookManager() {
        this.books = new ArrayList<>();
        loadPreloadedBooks();
    }

    /**
     * Metodo que carga libros precargados en la lista.
     */
    private void loadPreloadedBooks() {
        books.add(new Book("Diario de Greg. Un renacuajo", "Jeff Kinney", "Novela de ficción-Comedia/Humor", 4));
        books.add(new Book("Hábitos Atómicos", "James Clear", "Libro de autoayuda", 5));
        books.add(new Book("El Principito", "Antoine de Saint-Exupéry", "Fábula infantil de ficción y con sentido filosófico", 4));
        books.add(new Book("1984", "George Orwell", "Novela política de ficción distópica", 2));
        books.add(new Book("El Conde de Montecristo", "Alexandre Dumas y Auguste Maquet", "Novela histórica de ficción con aventura, romance y temas sociales", 3));
        books.add(new Book("Los tres mosqueteros", "Alexandre Dumas", "Novela literaria de aventura, capa y espada y ficción", 5));
    }

    /**
     * Registra un nuevo libro en la lista de libros.
     *
     * @param book El libro que se desea registrar.
     */
    public void registerBook(Book book) {
        books.add(book);
    }

    /**
     * Obtiene la lista completa de libros registrados.
     *
     * @return Una lista de objetos {@link Book}.
     */
    public List<Book> getBooks() {
        return books;
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





   