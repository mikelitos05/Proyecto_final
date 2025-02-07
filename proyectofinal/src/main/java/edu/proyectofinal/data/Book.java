public class Book {
    
    private String title;
    private String author;
    private String description;
    private int totalCopies;
    private int availableCopies;

    public Book(String title, String author, String description, int totalCopies) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
    }
    
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }
    
    public int getTotalCopies(){
        return totalCopies;
    }

    public int getAvailabilityCopies(){
        return availableCopies;
    }

    public void setAvailabilityCopies(int availableCopies) {
        if (availableCopies <= totalCopies) {
            this.availableCopies = availableCopies;
        } else {
            System.out.println("ERROR: No es posible tener más copias disponibles que el total.");
        }
    }

    @Override
    public String toString() {
        return "BoOk{" + 
                "title ->"  + title + 
                ", author ->" + author + 
                "availableCopies ->" + availableCopies + 
                '}';
    }
}

