# Student Info-
- NAME: KHUSHI
- COURSE: B.TECH(CSE)(core)
- ROLL NO: 2401010089 
 
# JAVA ASSIGNMENT-4
# City Library Digital Management System
The **City Central Library** is digitizing its operations to make book management, membership services, and data tracking more efficient.  
This Java-based application uses **File Handling** and the **Java Collections Framework** to manage books, members, and transactions with persistent storage.

##  Features
The system must be capable of:
- Adding new books and members
- Issuing and returning books
- Storing and retrieving data from files for persistence
- Using collections to efficiently search, sort, and manage records
##  Project Objectives
- Apply **File Handling** concepts to store and retrieve library data from text and binary files.
- Implement **Java Collections Framework** (`List`, `Set`, `Map`, `Queue`) for dynamic record management.
- Use **Comparable** and **Comparator** for sorting books and members by different criteria.
- Practice **Buffered I/O**, **Character Streams**, and **Byte Streams** for efficient file operations.
- Apply **Generics** in collections for type-safe data handling.

### **Book Class**
- Attributes: `bookId`, `title`, `author`, `category`, `isIssued`
- Methods: `displayBookDetails()`, `markAsIssued()`, `markAsReturned()`
- Implements `Comparable<Book>` for sorting by title

### **Member Class**
- Attributes: `memberId`, `name`, `email`, `issuedBooks (List<Integer>)`
- Methods: `displayMemberDetails()`, `addIssuedBook()`, `returnIssuedBook()`

### **LibraryManager Class**
- Attributes: `Map<Integer, Book> books`, `Map<Integer, Member> members`
- Methods:  
  - `addBook()`  
  - `addMember()`  
  - `issueBook()`  
  - `returnBook()`  
  - `searchBooks()`  
  - `sortBooks()`  
  - `loadFromFile()`  
  - `saveToFile()`

##  File Handling
- Books stored in `books.txt`
- Members stored in `members.txt`
- Uses:
  - `FileReader` / `FileWriter`
  - `BufferedReader` / `BufferedWriter`
  - `FileInputStream` / `FileOutputStream` (optional for binary storage)---
##  Sample Interaction
- <img width="732" height="523" alt="image" src="https://github.com/user-attachments/assets/c017eb5c-0086-4519-aed0-1368dbcaec71" />
- <img width="702" height="482" alt="image" src="https://github.com/user-attachments/assets/3b401854-16c4-4c45-a564-6f09137a9d49" />
- <img width="1022" height="417" alt="image" src="https://github.com/user-attachments/assets/dd8b0ae8-24a9-427d-b4ff-1d4cb283464f" />



