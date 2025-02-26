package edu.proyectofinal.data;

/**
* Clase que representa como es un libro en el sistema de gestion de libros.
* Contiene información sobre el título, autor, una descripción y el número de copias existentes como totales.
 */
public class Book {


    private int id;
    private String title;
    private String author;
    private String description;
    private int totalCopies;
    private int availableCopies;

    /**
     * Constructor que inicializa un objeto con los valores proporcionados.
     *
     * @param title
     * @param author
     * @param description
     * @param totalCopies
     */

    public Book(int id,String title, String author, String description, int totalCopies, int availableCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies; //Desde el comienzo como ya tenemos libros precargados, se van a mostrar las que ya existen.
    }

    /**
     * Obtiene el título del libro.
     *
     * @return El título del libro.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Establece un nuevo título para el libro.
     *
     * @param title El nuevo título del libro.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Obtiene el autor del libro.
     *
     * @return El autor del libro.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Establece un nuevo autor para el libro.
     *
     * @param author El nuevo autor del libro.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Obtiene la descripción del libro.
     *
     * @return La descripción del libro.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Establece una nueva descripción para el libro.
     *
     * @param description La nueva descripción del libro.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtiene el número total de copias del libro.
     *
     * @return El número total de copias.
     */
    public int getTotalCopies(){
        return totalCopies;
    }

    /**
     * Establece el número total de copias del libro.
     *
     * @param totalCopies El nuevo número total de copias.
     */
    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    /**
     * Obtiene el número de copias disponibles del libro.
     *
     * @return El número de copias disponibles.
     */
    public int getAvailabilityCopies(){
        return availableCopies;
    }

    /**
     * Establece el número de copias disponibles del libro.
     * Si el número de copias disponibles es mayor que el número total de copias,
     * se muestra un mensaje de error y no se realiza la asignación.
     *
     * @param availableCopies El nuevo número de copias disponibles.
     */
    public void setAvailabilityCopies(int availableCopies) {
        if (availableCopies <= totalCopies) {
            this.availableCopies = availableCopies;
        } else {
            System.out.println("ERROR: No es posible tener más copias disponibles que el total.");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

}

