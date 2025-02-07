package edu.proyectofinal.data;

public class Loan {
    private String book;
    private String user;
    private String startDate;
    private String endDate;
    private boolean status;

    /**
     * Metodo constructor de loan
     * @param book
     * @param endDate
     * @param startDate
     * @param status
     * @param user
     */
    public Loan(String book, String endDate, String startDate, boolean status, String user) {
        setBook(book);
        setEndDate(endDate);
        setStartDate(startDate);
        setStatus(status);
        setUser(user);
    }

    public String getBook() {
        return this.book;
    }

    public void setBook(String book) {
        if (this.book == null) {
            throw new IllegalArgumentException("Book is null");
        }
        else{
            this.book = book;
        }
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        if (this.user == null) {
            throw new IllegalArgumentException("User is null");
        }
        else{
            this.user = user;
        }
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        if (this.startDate == null) {
            throw new IllegalArgumentException("Start date is null");
        }
        else{
            this.startDate = startDate;
        }
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        if (this.endDate == null) {
            throw new IllegalArgumentException("End date is null");
        }
        else{
            this.endDate = endDate;
        }
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
