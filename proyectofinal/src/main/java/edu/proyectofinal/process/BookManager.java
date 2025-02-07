
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> books;

    public BookManager() {
        this.books = new ArrayList<>();
        loadPreloadedBooks();
    }

    private void loadPreloadedBooks() {
        books.add(new Book("Diario de Greg. Un renacuajo", "Jeff Kinney", "Novela de ficción-Comedia/Humor", 4));
        books.add(new Book("Habitos Atómicos", "James Clear", "Libro de autoayuda", 5));
        books.add(new Book("El Principito", "Antoine de Saint-Exupéry", "Fábula infantil de ficción y con sentido filosófico", 4));
        books.add(new Book("1984","George Orwell", "Novela política de ficción distópica", 2 ));
        books.add(new Book("El conde de Montecristo", "Alejandro Dumas y Auguste Maquet", "Novela histórica de ficción con aventura, romance y temas sociales", 3));
        books.add(new Book("Los tres mosqueteros", "Alexandre Dumas", "Novela literaria de aventura, capa y espada y ficción", 5));
    }

    public void registerBook(Book book) {
        books.add(book);
        System.out.println("Libro registrado: " + book.getTitle());
    }

    public List<Book> getBooks() {
        return books;
    }

    public void displayBooks(){
        if(books.isEmpty()) {
            System.out.println("No existen libros en el registro.");
        } else {
            System.out.println("\n--- Lista de Libros ---");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
    
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }

        System.out.println("No se encuentra libro.");
        return null;
    }
}


