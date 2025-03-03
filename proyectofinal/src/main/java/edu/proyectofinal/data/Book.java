package edu.proyectofinal.data;
import java.util.ArrayList;
import java.util.UUID; //aquí es en donde se genera automáticamente al libro el ID, por ende, ya no debe ser agregado en CLI

/**
 * Clase Book que representa un libro en la biblioteca.
 * Contiene datos de Titulo, autor, descripción, copias disponibles y copias totales.
 * Dentro de esta clase se genera un identificador único (ID) para cada copia que se registre.
 */
public class Book {
    private String title;
    private String author;
    private String description;
    private int totalCopies;
    private ArrayList<String> copyIds;

    /**
     * Constructor que inicializa un libro y genera identificadores únicos para cada copia.
     * @param title Título del libro.
     * @param author Autor del libro.
     * @param description Descripción del libro.
     * @param totalCopies Número total de copias.
     * @param availableCopies (No se utiliza; se asume que todas las copias están disponibles inicialmente)
     */
    public Book(String title, String author, String description, int totalCopies, int availableCopies) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.totalCopies = totalCopies;
        this.copyIds = new ArrayList<>();
        for (int i = 0; i < totalCopies; i++) {
            this.copyIds.add(UUID.randomUUID().toString());
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalCopies(){
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    /**
     * Retorna el número de copias disponibles.
     * @return Número de copias disponibles.
     */
    public int getAvailabilityCopies(){
        return copyIds.size();
    }

    /**
     * Extrae y retorna el identificador único de una copia disponible.
     * @return Identificador de la copia o null si no hay disponibles.
     */
    public String lendCopy() {
        if(!copyIds.isEmpty()) {
            return copyIds.remove(0);
        }
        return null;
    }
}

