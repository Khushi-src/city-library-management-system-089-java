import java.io.*;
import java.util.*;

public class LibraryManager {
    private Map<Integer, Book> books = new HashMap<>();
    private Map<Integer, Member> members = new HashMap<>();
    private static final String BOOK_FILE = "books.txt";
    private static final String MEMBER_FILE = "members.txt";

    // Add Book
    public void addBook(Book book) {
        books.put(book.getBookId(), book);
        saveToFile();
        System.out.println("Book added successfully with ID: " + book.getBookId());
    }

    // Add Member
    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
        saveToFile();
        System.out.println("Member added successfully with ID: " + member.getMemberId());
    }

    // Issue Book
    public void issueBook(int bookId, int memberId) {
        Book book = books.get(bookId);
        Member member = members.get(memberId);

        if (book != null && member != null && !book.getIsIssued()) {
            book.markAsIssued();
            member.addIssuedBook(bookId);
            saveToFile();
            System.out.println("Book issued successfully!");
        } else {
            System.out.println("Issue failed. Book may already be issued or member not found.");
        }
    }

    // Return Book
    public void returnBook(int bookId, int memberId) {
        Book book = books.get(bookId);
        Member member = members.get(memberId);

        if (book != null && member != null && book.getIsIssued()) {
            book.markAsReturned();
            member.returnIssuedBook(bookId);
            saveToFile();
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Return failed. Book may not be issued.");
        }
    }

    // Search Books
    public void searchBooks(String keyword) {
        for (Book book : books.values()) {
            if (book.getTitle().contains(keyword) ||
                    book.getAuthor().contains(keyword) ||
                    book.getCategory().contains(keyword)) {
                book.displayBookDetails();
            }
        }
    }

    // Sort Books (by title using Comparable)
    public void sortBooksByTitle() {
        List<Book> bookList = new ArrayList<>(books.values());
        Collections.sort(bookList);
        bookList.forEach(Book::displayBookDetails);
    }

    // Sort Books (by author using Comparator)
    public void sortBooksByAuthor() {
        List<Book> bookList = new ArrayList<>(books.values());
        bookList.sort(Comparator.comparing(Book::getAuthor));
        bookList.forEach(Book::displayBookDetails);
    }

    // File Handling
    public void saveToFile() {
        try (ObjectOutputStream bookOut = new ObjectOutputStream(new FileOutputStream(BOOK_FILE));
             ObjectOutputStream memberOut = new ObjectOutputStream(new FileOutputStream(MEMBER_FILE))) {
            bookOut.writeObject(books);
            memberOut.writeObject(members);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile() {
        try (ObjectInputStream bookIn = new ObjectInputStream(new FileInputStream(BOOK_FILE));
             ObjectInputStream memberIn = new ObjectInputStream(new FileInputStream(MEMBER_FILE))) {
            books = (Map<Integer, Book>) bookIn.readObject();
            members = (Map<Integer, Member>) memberIn.readObject();
        } catch (Exception e) {
            System.out.println("No existing data found. Starting fresh.");
        }
    }
}