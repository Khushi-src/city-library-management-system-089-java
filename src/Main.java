import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        manager.loadFromFile();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to City Library Digital Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Books");
            System.out.println("6. Sort Books by Title");
            System.out.println("7. Sort Books by Author");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();
                    manager.addBook(new Book(bookId, title, author, category));
                    break;

                case 2:
                    System.out.print("Enter Member ID: ");
                    int memberId = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    manager.addMember(new Member(memberId, name, email));
                    break;

                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    int issueBookId = sc.nextInt();
                    System.out.print("Enter Member ID: ");
                    int issueMemberId = sc.nextInt();
                    manager.issueBook(issueBookId, issueMemberId);
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    int returnBookId = sc.nextInt();
                    System.out.print("Enter Member ID: ");
                    int returnMemberId = sc.nextInt();
                    manager.returnBook(returnBookId, returnMemberId);
                    break;

                case 5:
                    System.out.print("Enter keyword to search: ");
                    String keyword = sc.nextLine();
                    manager.searchBooks(keyword);
                    break;

                case 6:
                    manager.sortBooksByTitle();
                    break;

                case 7:
                    manager.sortBooksByAuthor();
                    break;

                case 8:
                    manager.saveToFile();
                    System.out.println("Exiting... Data saved.");
                    return;
            }
        }
    }
}
