import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> books;

    //Es un constructor que inicializa la lista puesta de libros ya precargados en el codigo
    public BookManager() {
        this.books = new ArrayList<>();
        loadPreloadedBooks();   
    }

    //Método que carga ya los libros puestos
    private void loadPreloadedBooks() {
        books.add(new Book("Diario de Greg. Un renacuajo", "Jeff Kinney", "Novela de ficción-Comedia/Humor", 4));
        books.add(new Book("Habitos Atómicos", "James Clear", "Libro de autoayuda", 5));
        books.add(new Book("El Principito", "Antoine de Saint-Exupéry", "Fábula infantil de ficción y con sentido filosófico", 4));
        books.add(new Book("1984","George Orwell", "Novela política de ficción distópica", 2 ));
        books.add(new Book("El conde de Montecristo", "Alejandro Dumas y Auguste Maquet", "Novela histórica de ficción con aventura, romance y temas sociales", 3));
        books.add(new Book("Los tres mosqueteros", "Alexandre Dumas", "Novela literaria de aventura, capa y espada y ficción", 5));
    }

    //Registrar un nuevo libro
    public void registerBook(Book book) {
        books.add(book);
    }

    //Obtener las listas ya registradas
    public List<Book> getBooks() {
        return books;
    }

    //Buscar libro por el titulo 
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    


}




   