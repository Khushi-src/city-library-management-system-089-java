import java.io.Serializable;

public class Book implements Serializable, Comparable<Book> {
    private int bookId;
    private String title;
    private String author;
    private String category;
    private boolean isIssued;

    public Book(int bookId, String title, String author, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isIssued = false;
    }

    public void displayBookDetails() {
        System.out.println("ID: " + bookId + ", Title: " + title +
                ", Author: " + author + ", Category: " + category +
                ", Issued: " + isIssued);
    }

    public void markAsIssued() { isIssued = true; }
    public void markAsReturned() { isIssued = false; }

    public int getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
    public boolean getIsIssued() { return isIssued; }

    // Comparable: sort by title
    @Override
    public int compareTo(Book other) {
        return this.title.compareToIgnoreCase(other.title);
    }
}