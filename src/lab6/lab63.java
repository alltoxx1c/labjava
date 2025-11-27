package lab6;

import java.util.ArrayList;
import java.util.List;

class BookAlreadyBorrowedException extends Exception {
    public BookAlreadyBorrowedException(String message) { super(message); }
}

class BookNotBorrowedException extends Exception {
    public BookNotBorrowedException(String message) { super(message); }
}

class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) { super(message); }
}

class BookNotFoundException extends Exception {
    public BookNotFoundException(String message) { super(message); }
}

class MaxBooksLimitException extends Exception {
    public MaxBooksLimitException(String message) { super(message); }
}

class Book {
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getTitle() { return title; }
    public boolean isBorrowed() { return isBorrowed; }

    public void borrow() throws BookAlreadyBorrowedException {
        if (isBorrowed) throw new BookAlreadyBorrowedException("Книга '" + title + "' уже взята.");
        isBorrowed = true;
    }

    public void returnBook() throws BookNotBorrowedException {
        if (!isBorrowed) throw new BookNotBorrowedException("Книга '" + title + "' не была взята.");
        isBorrowed = false;
    }
}

class User {
    private String name;
    private List<Book> borrowedBooks;

    public User(String name) {
        this.name = name;
        borrowedBooks = new ArrayList<>();
    }

    public String getName() { return name; }

    public void borrowBook(Book book) throws BookAlreadyBorrowedException, MaxBooksLimitException {
        if (borrowedBooks.size() >= 5) throw new MaxBooksLimitException("Пользователь '" + name + "' не может брать больше 5 книг.");
        book.borrow();
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) throws BookNotBorrowedException {
        book.returnBook();
        borrowedBooks.remove(book);
    }
}

class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) { books.add(book); }

    public void registerUser(User user) { users.add(user); }

    public void lendBook(String bookTitle, String userName) throws UserNotFoundException, BookNotFoundException, BookAlreadyBorrowedException, MaxBooksLimitException {
        User user = findUser(userName);
        Book book = findBook(bookTitle);
        user.borrowBook(book);
    }

    public void returnBook(String bookTitle, String userName) throws UserNotFoundException, BookNotFoundException, BookNotBorrowedException {
        User user = findUser(userName);
        Book book = findBook(bookTitle);
        user.returnBook(book);
    }

    private User findUser(String name) throws UserNotFoundException {
        for (User user : users) {
            if (user.getName().equals(name)) return user;
        }
        throw new UserNotFoundException("Пользователь '" + name + "' не найден.");
    }

    private Book findBook(String title) throws BookNotFoundException {
        for (Book book : books) {
            if (book.getTitle().equals(title)) return book;
        }
        throw new BookNotFoundException("Книга '" + title + "' не найдена.");
    }
}

public class lab63 {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("Война и мир", "Толстой"));
        library.addBook(new Book("Преступление и наказание", "Достоевский"));
        library.registerUser(new User("Иван"));
        library.registerUser(new User("Пётр"));

        try {
            library.lendBook("Война и мир", "Иван");
            library.lendBook("Преступление и наказание", "Иван");
            library.lendBook("Война и мир", "Пётр");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            library.returnBook("Война и мир", "Иван");
            library.returnBook("Война и мир", "Иван");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            library.lendBook("Неизвестная книга", "Иван");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            library.lendBook("Преступление и наказание", "Неизвестный пользователь");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
